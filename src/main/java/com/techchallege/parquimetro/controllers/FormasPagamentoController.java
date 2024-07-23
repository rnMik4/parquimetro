package com.techchallege.parquimetro.controllers;

import com.techchallege.parquimetro.DTOs.FormasPagamentoDTO;
import com.techchallege.parquimetro.DTOs.FormasPagamentoResponseDTO;
import com.techchallege.parquimetro.services.FormasPagamentoService;
import com.techchallege.parquimetro.services.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formaspagamento")
public class FormasPagamentoController {
    @Autowired
    private FormasPagamentoService formasPagamentoService;

    @Autowired
    private GenericMapper mapper;

    @PostMapping
    public ResponseEntity<FormasPagamentoResponseDTO> cadastrarFormasPagamento(@RequestBody FormasPagamentoDTO formasPagamentoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entidadeParaDTO(formasPagamentoService.create(formasPagamentoDTO), FormasPagamentoResponseDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<FormasPagamentoResponseDTO>> listarFormasPagamento() {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(formasPagamentoService.getAll(), FormasPagamentoResponseDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FormasPagamentoResponseDTO> buscarFormasPagamento(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(formasPagamentoService.getById(id), FormasPagamentoResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FormasPagamentoResponseDTO> atualizarFormasPagamento(@PathVariable("id") Long id, @RequestBody FormasPagamentoDTO formasPagamentoDTO) {
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(formasPagamentoService.update(formasPagamentoDTO, id), FormasPagamentoResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarFormasPagamento(@PathVariable("id") Long id) {
        formasPagamentoService.delete(id);
        return ResponseEntity.ok().body("{status: \"Forma de pagamento deletada\"}");
    }
}
