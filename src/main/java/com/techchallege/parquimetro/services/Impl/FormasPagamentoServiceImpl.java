package com.techchallege.parquimetro.services.Impl;

import com.techchallege.parquimetro.DTOs.FormasPagamentoDTO;
import com.techchallege.parquimetro.entities.FormasPagamento;
import com.techchallege.parquimetro.exceptions.ResourceNotFoundException;
import com.techchallege.parquimetro.repositories.FormasPagamentoRepository;
import com.techchallege.parquimetro.services.FormasPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormasPagamentoServiceImpl implements FormasPagamentoService {
    @Autowired
    private FormasPagamentoRepository formasPagamentoRepository;

    @Override
    public FormasPagamento create(FormasPagamentoDTO formasPagamentoDTO) {
        FormasPagamento formasPagamento = new FormasPagamento();
        formasPagamento = getByFormaPagamento(formasPagamentoDTO.formaPagamento());
        if (formasPagamento != null) {
            throw new ResourceNotFoundException("Forma de pagamento já cadastrada");
        }
        FormasPagamento save = new FormasPagamento();
        BeanUtils.copyProperties(formasPagamentoDTO, save);
        return formasPagamentoRepository.save(save);
    }

    @Override
    public FormasPagamento update(FormasPagamentoDTO formasPagamentoDTO, Long id) {
        FormasPagamento formasPagamento = getById(id);
        BeanUtils.copyProperties(formasPagamentoDTO, formasPagamento);
        return formasPagamentoRepository.save(formasPagamento);
    }

    @Override
    public void delete(Long id) {
        formasPagamentoRepository.deleteById(id);
    }

    @Override
    public FormasPagamento getById(Long id) {
        return formasPagamentoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Forma de pagamento não encontrada"));
    }

    @Override
    public List<FormasPagamento> getAll() {
        return formasPagamentoRepository.findAll();
    }

    @Override
    public FormasPagamento getByFormaPagamento(String formaPagamento) {
        return formasPagamentoRepository.findByFormaPagamento(formaPagamento);
    }
}
