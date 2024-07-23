package com.techchallege.parquimetro.controllers;

import com.techchallege.parquimetro.DTOs.PeriodoDTO;
import com.techchallege.parquimetro.DTOs.PeriodoResponseDTO;
import com.techchallege.parquimetro.services.GenericMapper;
import com.techchallege.parquimetro.services.PeriodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {
    @Autowired
    private GenericMapper mapper;

    @Autowired
    private PeriodoService periodoService;

    @PostMapping
    public ResponseEntity<PeriodoResponseDTO> cadastrarPeriodo(@RequestBody PeriodoDTO periodo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entidadeParaDTO(periodoService.create(periodo), PeriodoResponseDTO.class));
    }

    @GetMapping("/list")
    public ResponseEntity<List<PeriodoResponseDTO>> list() {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(periodoService.findAll(), PeriodoResponseDTO.class));
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<PeriodoResponseDTO> getByPeriodoDescricao(@RequestParam("descricao") String descricao) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(periodoService.findByDescricao(descricao), PeriodoResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoResponseDTO> atualizarPeriodo(@PathVariable("id") Long id, @RequestBody PeriodoDTO periodo) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(periodoService.update(periodo, id), PeriodoResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPeriodo(@PathVariable("id") Long id) {
        periodoService.delete(id);
        return ResponseEntity.ok().body("{status: \"Periodo Deletado\"}");
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeriodoResponseDTO> getPeriodoById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(periodoService.findById(id), PeriodoResponseDTO.class));
    }
}
