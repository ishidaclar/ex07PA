package com.clara.ex07.models;

import jakarta.persistence.*;

@Entity
@Table(name="tb_fornecedor")

public class FornecedorModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaFantasia;
    @Column(name="Cnpj")
    private String cnpj;
    @Column(name="Contato")
    private String contato;

    public FornecedorModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDaFantasia() {
        return nomeDaFantasia;
    }

    public void setNomeDaFantasia(String nomeDaFantasia) {
        this.nomeDaFantasia = nomeDaFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
