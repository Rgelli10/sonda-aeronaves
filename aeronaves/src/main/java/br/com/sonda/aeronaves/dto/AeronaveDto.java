package br.com.sonda.aeronaves.dto;

import br.com.sonda.aeronaves.model.Aeronave;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AeronaveDto {

    private Long id;
    private String nome;
    private Integer ano;
    private String marca;
    private String descricao;
    private boolean vendido;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated = LocalDateTime.now();

    public AeronaveDto(Aeronave aeronave) {
        this.id = aeronave.getId();
        this.nome = aeronave.getNome();
        this.ano = aeronave.getAno();
        this.marca = aeronave.getMarca();
        this.descricao = aeronave.getDescricao();
        this.vendido = aeronave.isVendido();
        this.created = aeronave.getCreated();
        this.updated = aeronave.getUpdated();
    }

    public static List<AeronaveDto> converter(List<Aeronave> aeronaves) {
        return aeronaves.stream().map(AeronaveDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isVendido() {
        return vendido;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
