package com.clinica.models;

public class Responsavel {
    private String nome;
    private String documentoIdentificacao;

    public Responsavel(String nome, String documentoIdentificacao) {
        this.nome = nome;
        this.documentoIdentificacao = documentoIdentificacao;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public String getResponsavelInfo() {
        return "Nome: " + nome + ", Documento: " + documentoIdentificacao;
    }
}
