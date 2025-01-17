package com.techchallege.parquimetro.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "condutor")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Condutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_registro", insertable = false)
    private LocalDateTime dataRegistro;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "ddd")
    private Integer ddd;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "rua")
    private String rua;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "uf")
    private String uf;

    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy = "idCondutor")
    private List<Veiculo> veiculos;

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Condutor condutor = (Condutor) o;
        return Objects.equals(id, condutor.id) && Objects.equals(dataRegistro, condutor.dataRegistro) && Objects.equals(nomeCompleto, condutor.nomeCompleto) && Objects.equals(ddd, condutor.ddd) && Objects.equals(telefone, condutor.telefone) && Objects.equals(rua, condutor.rua) && Objects.equals(numero, condutor.numero) && Objects.equals(bairro, condutor.bairro) && Objects.equals(cidade, condutor.cidade) && Objects.equals(uf, condutor.uf) && Objects.equals(email, condutor.email) && Objects.equals(cpf, condutor.cpf) && Objects.equals(veiculos, condutor.veiculos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataRegistro, nomeCompleto, ddd, telefone, rua, numero, bairro, cidade, uf, email, cpf, veiculos);
    }
}
