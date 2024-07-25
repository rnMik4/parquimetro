package com.techchallege.parquimetro.controllers;

import com.techchallege.parquimetro.DTOs.CalculoTempoResponseDTO;
import com.techchallege.parquimetro.DTOs.EstacionamentosDTO;
import com.techchallege.parquimetro.entities.Estacionamentos;
import com.techchallege.parquimetro.services.EstacionamentosService;
import com.techchallege.parquimetro.services.GenericMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentosController {
    @Autowired
    private GenericMapper mapper;

    @Autowired
    private EstacionamentosService service;

    @PostMapping
    public ResponseEntity<Estacionamentos> post(@RequestBody EstacionamentosDTO estacionamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarEstacionamento(estacionamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estacionamentos> getEstacionamentoId(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.buscarEstacionamentoPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estacionamentos> atualizarEstacionamentoId(@PathVariable("id") Long id, @RequestBody EstacionamentosDTO estacionamento) {
        return ResponseEntity.ok().body(service.atualizarEstacionamento(estacionamento, id));
    }

    @PutMapping("/encerrarestacionamento/{id}")
    public ResponseEntity<Estacionamentos> encerrarestacionamento(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.encerrarEstacionamentoVariavel(id));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEstacionamento(@PathVariable("id") Long id) {
        service.excluirEstacionamento(id);
        return ResponseEntity.ok().body("{status: \"Forma de pagamento deletada\"}");
    }

    @GetMapping("/tempoestacionamento/{id}")
    public ResponseEntity<CalculoTempoResponseDTO> tempoEstacionamento(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.calcularTempo(id));
    }
}
