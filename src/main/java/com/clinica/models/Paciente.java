package com.clinica.models;

import java.time.LocalDate;

import com.clinica.adapter.PlanoSaudeAdapter;

public class Paciente {
    private String nome;
    private String documentoIdentificacao;
    private String cpf;
    private LocalDate dataNascimento; // Alterado para LocalDate
    private String sexo;
    private Responsavel responsavel;
    private PlanoSaudeAdapter planoSaude;

    public Paciente(String nome, String documentoIdentificacao, String cpf, LocalDate dataNascimento, String sexo) {
        this.nome = nome;
        this.documentoIdentificacao = documentoIdentificacao;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
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

    public LocalDate getDataNascimento() { // Alterado para LocalDate
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) { // Alterado para LocalDate
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public PlanoSaudeAdapter getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(PlanoSaudeAdapter planoSaude) {
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
