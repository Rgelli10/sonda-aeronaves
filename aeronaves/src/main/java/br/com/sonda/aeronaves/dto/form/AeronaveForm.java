package br.com.sonda.aeronaves.dto.form;

import br.com.sonda.aeronaves.model.Aeronave;
import br.com.sonda.aeronaves.repository.AeronaveRepository;

public class AeronaveForm {

    private String nome;
    private Integer ano;
    private String marca;
    private String descricao;
    private boolean vendido;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public Aeronave converter(AeronaveRepository aeronaveRepository) {
        return new Aeronave(nome, ano, marca, descricao, vendido);
    }
}
