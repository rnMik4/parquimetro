package com.techchallege.parquimetro.services.Impl;

import com.techchallege.parquimetro.DTOs.VeiculoDTO;
import com.techchallege.parquimetro.entities.Veiculo;
import com.techchallege.parquimetro.exceptions.ResourceNotFoundException;
import com.techchallege.parquimetro.repositories.VeiculoRepository;
import com.techchallege.parquimetro.services.VeiculoService;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;


    @Override
    public Veiculo getVeiculoByPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa);
    }

    @Override
    public Veiculo getVeiculoById(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veículo não encontrado"));
    }

    @Override
    public Veiculo createVeiculo(VeiculoDTO veiculo) {

        Veiculo veiculoEntity = getVeiculoByPlaca(veiculo.placa());
        if (veiculoEntity != null) {
            throw new ResourceNotFoundException("Veículo já cadastrado");

        }
        Veiculo veiculoSalvar = new Veiculo();
        BeanUtils.copyProperties(veiculo, veiculoSalvar);
        veiculoSalvar = veiculoRepository.save(veiculoSalvar);
        return veiculoSalvar;
    }

    @Override
    public Veiculo updateVeiculo(VeiculoDTO veiculo, Long id) {
        Veiculo veiculoEntity = getVeiculoById(id);
        BeanUtils.copyProperties(veiculo, veiculoEntity);
        veiculoEntity = veiculoRepository.save(veiculoEntity);
        return veiculoEntity;
    }

    @Override
    public void deleteVeiculo(Long id) {
        veiculoRepository.deleteById(id);
    }

    @Override
    public List<Veiculo> getVeiculosByIdCondutor(Long id) {
        return veiculoRepository.findByIdCondutor(id);
    }

    @Override
    public List<Veiculo> getVeiculos() {
        return veiculoRepository.findAll();
    }
}
