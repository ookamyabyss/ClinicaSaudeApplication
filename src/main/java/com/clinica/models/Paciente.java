package com.clinica.models;

import com.clinica.strategys.PlanoSaude;

public class Paciente {
    private String nome;
    private String documentoIdentificacao;
    private String cpf;
    private int idade;
    private char sexo;
    private Responsavel responsavel;
    private PlanoSaude planoSaude;

    public Paciente(String nome, String documentoIdentificacao, String cpf, int idade, char sexo,
            PlanoSaude planoSaude) {
        this.nome = nome;
        this.documentoIdentificacao = documentoIdentificacao;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.planoSaude = planoSaude;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public PlanoSaude getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(PlanoSaude planoSaude) {
        this.planoSaude = planoSaude;
    }

    public boolean informarProcedimento(Procedimento procedimento) {
        // Implementação específica
        return true;
    }

    public double calcularValorCoparticipacao() {
        // Implementação específica
        return 0.0;
    }
}
