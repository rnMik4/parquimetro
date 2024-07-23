package com.techchallege.parquimetro.controllers;

import com.techchallege.parquimetro.DTOs.FormasPagamentoPeriodoResponseDTO;
import com.techchallege.parquimetro.DTOs.FormasPagamentoResponseDTO;
import com.techchallege.parquimetro.DTOs.PeriodoFormasPagamentoDTO;
import com.techchallege.parquimetro.DTOs.PeriodoFormasPagamentoResponseDTO;
import com.techchallege.parquimetro.entities.PeriodoFormasPagamento;
import com.techchallege.parquimetro.services.GenericMapper;
import com.techchallege.parquimetro.services.PeriodoFormasPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodoformaspagamento")
public class PeriodoFormasPagamentoController {
    @Autowired
    private PeriodoFormasPagamentoService service;

    @Autowired
    private GenericMapper mapper;

    @PostMapping
    public ResponseEntity<PeriodoFormasPagamentoResponseDTO> vincularPeriodoFormaPagamento(@RequestBody PeriodoFormasPagamentoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.entidadeParaDTO(service.cadastrarPeriodoFormasPagamento(dto), PeriodoFormasPagamentoResponseDTO.class));
    }

    @GetMapping("/formaspagamentobyperiodo/{idPeriodo}")
    public ResponseEntity<FormasPagamentoPeriodoResponseDTO> listarFormasPagamentoByPeriodo(@PathVariable("idPeriodo") Long idPeriodo){
        return ResponseEntity.ok().body(service.listarFormasPagamentoByPeriodo(idPeriodo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeriodoFormasPagamentoResponseDTO> update(@RequestBody PeriodoFormasPagamentoDTO dto, @PathVariable("id") Long id){
        return ResponseEntity.ok().body(mapper.entidadeParaDTO(service.atualizarPeriodoFormasPagamento(dto, id), PeriodoFormasPagamentoResponseDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.excluirPeriodoFormasPagamento(id);
        return ResponseEntity.ok().body("{status: \"Periodo Forma Pagamento Deletado\"}");
    }

}
