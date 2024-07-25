package com.techchallege.parquimetro.services.Impl;

import com.techchallege.parquimetro.DTOs.CalculoTempoResponseDTO;
import com.techchallege.parquimetro.DTOs.EstacionamentosDTO;
import com.techchallege.parquimetro.DTOs.ReciboResponseDTO;
import com.techchallege.parquimetro.entities.Estacionamentos;
import com.techchallege.parquimetro.entities.FormasPagamento;
import com.techchallege.parquimetro.entities.Periodo;
import com.techchallege.parquimetro.entities.Veiculo;
import com.techchallege.parquimetro.exceptions.ResourceNotFoundException;
import com.techchallege.parquimetro.repositories.EstacionamentosRepository;
import com.techchallege.parquimetro.services.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class EstacionamentosServiceImpl implements EstacionamentosService {
    @Autowired
    EstacionamentosRepository estacionamentosRepository;

    @Autowired
    PeriodoService periodoService;

    @Autowired
    CondutorService condutorService;

    @Autowired
    FormasPagamentoService formasPagamentoService;

    @Autowired
    VeiculoService veiculoService;

    @Override
    public Estacionamentos salvarEstacionamento(EstacionamentosDTO estacionamento) {
        Estacionamentos save = new Estacionamentos();
        //verificar se ja existe um estacionamento em andamento
        if(estacionamento.idPeriodo() == 1L){
            if(estacionamento.dataHoraFim() == null){
                throw new ResourceNotFoundException("Estacionamento de Período Fixo exige uma data de Fim");
            }
            //calcula o valor do período
            Duration d = Duration.between(estacionamento.dataHoraInicio(), estacionamento.dataHoraFim());
            Long tempo = d.toMinutes();
            Periodo periodo = periodoService.findById(estacionamento.idPeriodo());
            save.setValorTotal((tempo / 60) * periodo.getValor());
        }
        if(!estacionamentoAtivo(estacionamento.idVeiculo())){

            BeanUtils.copyProperties(estacionamento, save);

        }else{
            throw new ResourceNotFoundException("Já existe um estacionamento em andamento para o Veículo");
        }

        return estacionamentosRepository.save(save);
    }

    @Override
    public Estacionamentos buscarEstacionamentoPorId(Long id) {
        return estacionamentosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estacionamento não encontrado"));
    }

    @Override
    public Estacionamentos atualizarEstacionamento(EstacionamentosDTO dto, Long id) {
        Estacionamentos estacionamento = new Estacionamentos();
        estacionamento = buscarEstacionamentoPorId(id);
        BeanUtils.copyProperties(dto, estacionamento);
        return estacionamentosRepository.save(estacionamento);
    }

    @Override
    public void excluirEstacionamento(Long id) {
        estacionamentosRepository.deleteById(id);
    }

    @Override
    public CalculoTempoResponseDTO calcularTempo(Long idEstacionamento) {
        Estacionamentos estacionamento = buscarEstacionamentoPorId(idEstacionamento);
        CalculoTempoResponseDTO retorno = new CalculoTempoResponseDTO();
        LocalDateTime lt = LocalDateTime.now();

        if(estacionamento.getIdPeriodo().equals(1L)){
            //estacionamento Fixo
            Duration dFixo = Duration.between(lt, estacionamento.getDataHoraFim());
            Long tempo = dFixo.toMinutes();
            if(tempo < 0){
                retorno.setCalculoTempo(tempo);
                retorno.setMsg("Este estacionamento encerrou à " + tempo *-1 + " minutos");
            }else{
                retorno.setCalculoTempo(tempo);
                retorno.setMsg("Este estacionamento ainda possui " + tempo + " minutos");
            }

        }else{
            //estacionamento Variável
            Duration dVariavel = Duration.between(estacionamento.getDataHoraInicio(), lt);
            Long tempoVariavel = dVariavel.toMinutes();
            if(tempoVariavel < 0){
                retorno.setCalculoTempo(tempoVariavel);
                retorno.setMsg("Este estacionamento se encerrou à " + tempoVariavel *-1 + " minutos");
            }else{
                retorno.setCalculoTempo(tempoVariavel);
                retorno.setMsg("Você está estacionado à " + tempoVariavel + " minutos");
            }
        }

        return retorno;
    }

    @Override
    public Estacionamentos encerrarEstacionamentoVariavel(Long idEstacionamento) {
        Estacionamentos estacionamento = buscarEstacionamentoPorId(idEstacionamento);
        estacionamento.setDataHoraFim(LocalDateTime.now());
        //Calcular o valor total a ser pago
        //Consulta o valor do Periodo
        Periodo periodo = periodoService.findById(estacionamento.getIdPeriodo());
        //Calcula o tempo estacionado
        CalculoTempoResponseDTO tempoEstacionado = calcularTempo(idEstacionamento);
        //Caso o tempo estacionado seja menor de 1h, considerar 1h
        double tempo = (double) (tempoEstacionado.getCalculoTempo() / 60);
        if(tempo < 1){
            tempo = 1.0;
        }
        estacionamento.setValorTotal(tempo * periodo.getValor());

        return estacionamentosRepository.save(estacionamento);
    }

    @Override
    public ReciboResponseDTO gerarRecibo(Long idEstacionamento) {
        Estacionamentos estacionamento = buscarEstacionamentoPorId(idEstacionamento);
        if(estacionamento.getDataHoraFim() == null){
            throw new ResourceNotFoundException("Este estacionamento não foi encerrado");
        }

        ReciboResponseDTO recibo = new ReciboResponseDTO();
        recibo.setDataInicio(estacionamento.getDataHoraInicio());
        recibo.setDataFim(estacionamento.getDataHoraFim());
        recibo.setValorTotal(estacionamento.getValorTotal());
        Duration d = Duration.between(estacionamento.getDataHoraInicio(), estacionamento.getDataHoraFim());
        Long tempo = d.toMinutes();
        recibo.setTempoEstacionado(tempo);
        recibo.setPeriodo(periodoService.findById(estacionamento.getIdPeriodo()));
        Veiculo veiculo = veiculoService.getVeiculoById(estacionamento.getIdVeiculo());
        recibo.setVeiculo(veiculo);
        recibo.setCondutor(condutorService.getCondutorById(veiculo.getIdCondutor()));
        recibo.setFormaPagamento(formasPagamentoService.getById(estacionamento.getIdFormasPagamento()));
        return recibo;
    }


    private Boolean estacionamentoAtivo(Long idVeiculo){
        Estacionamentos estacionamento = new Estacionamentos();
        LocalDateTime lt = LocalDateTime.now();
        estacionamento = estacionamentosRepository.findFirstByIdVeiculoOrderByDataRegistroDesc(idVeiculo);
        if(estacionamento == null){
            return false;
        } else if (estacionamento.getIdPeriodo().equals(2L) && estacionamento.getDataHoraFim() == null) {
            return true;
        } else if (estacionamento.getIdPeriodo().equals(1L)) {
            Duration d = Duration.between(lt, estacionamento.getDataHoraFim());
//            Long tempo = d.toMinutes();
            return d.toMinutes() > 0;
        }

        return false;
    }

}
