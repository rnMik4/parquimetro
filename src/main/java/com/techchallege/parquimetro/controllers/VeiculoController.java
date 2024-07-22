package com.techchallege.parquimetro.controllers;

import com.techchallege.parquimetro.DTOs.VeiculoDTO;
import com.techchallege.parquimetro.DTOs.VeiculoResponseDTO;
import com.techchallege.parquimetro.services.GenericMapper;
import com.techchallege.parquimetro.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private GenericMapper mapper;

    @Autowired
    private VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> create(@RequestBody VeiculoDTO veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entidadeParaDTO(service.createVeiculo(veiculo), VeiculoResponseDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> findAll() {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(service.getVeiculos(), VeiculoResponseDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> findById(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(service.getVeiculoById(id), VeiculoResponseDTO.class));
    }

    @GetMapping("/placaveiculo/{placa}")
    public ResponseEntity<VeiculoResponseDTO> findByPlaca(@PathVariable("placa") String placa) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(service.getVeiculoByPlaca(placa), VeiculoResponseDTO.class));
    }

    @GetMapping("/condutorveiculos/{id}")
    public ResponseEntity<List<VeiculoResponseDTO>> findByCondutor(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(service.getVeiculosByIdCondutor(id), VeiculoResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> update(@PathVariable("id") Long id, @RequestBody VeiculoDTO veiculo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entidadeParaDTO(service.updateVeiculo(veiculo, id), VeiculoResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.deleteVeiculo(id);
        return ResponseEntity.ok().body("{status: \"Veículo Deletado\"}");
    }



}
