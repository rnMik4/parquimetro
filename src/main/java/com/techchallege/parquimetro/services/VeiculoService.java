package com.techchallege.parquimetro.services;

import com.techchallege.parquimetro.DTOs.VeiculoDTO;
import com.techchallege.parquimetro.entities.Veiculo;

import java.util.List;

public interface VeiculoService {
    Veiculo getVeiculoByPlaca(String placa);
    Veiculo getVeiculoById(Long id);
    Veiculo createVeiculo(VeiculoDTO veiculo);
    Veiculo updateVeiculo(VeiculoDTO veiculo, Long id);
    void deleteVeiculo(Long id);
    List<Veiculo> getVeiculosByIdCondutor(Long id);
    List<Veiculo> getVeiculos();

}
