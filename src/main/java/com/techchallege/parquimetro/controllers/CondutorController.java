package com.techchallege.parquimetro.controllers;
import com.techchallege.parquimetro.DTOs.CondutorDTO;
import com.techchallege.parquimetro.DTOs.CondutorResponseDTO;
import com.techchallege.parquimetro.entities.Condutor;
import com.techchallege.parquimetro.services.CondutorService;
import com.techchallege.parquimetro.services.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condutor")
public class CondutorController {

    @Autowired
    private GenericMapper mapper;

    @Autowired
    private CondutorService condutorService;

    @GetMapping("/testapi")
    public ResponseEntity<String> getstatusApp() {
        return ResponseEntity.ok().body("{status: \"OK\"}");
    }

    @PostMapping
    public ResponseEntity<CondutorResponseDTO> postcondutor(@RequestBody CondutorDTO condutor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entidadeParaDTO(condutorService.create(condutor), CondutorResponseDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondutorResponseDTO> getcondutor(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(condutorService.getCondutorById(id), CondutorResponseDTO.class));
    }

    @GetMapping("/emailcondutor/{email}")
    public ResponseEntity<CondutorResponseDTO> getcondutoremail(@PathVariable("email") String email) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(condutorService.getCondutorDTOByEmail(email), CondutorResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondutorResponseDTO> atualizarcondutor(@PathVariable("id") Long id, @RequestBody CondutorDTO condutor) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(condutorService.updateCondutorById(condutor, id), CondutorResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletecondutor(@PathVariable("id") Long id) {
        condutorService.deleteCondutorById(id);
        return ResponseEntity.ok().body("{status: \"Condutor Deletado\"}");
    }
}
