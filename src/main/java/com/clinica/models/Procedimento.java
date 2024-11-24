package com.clinica.models;

public class Procedimento {
    private Especialidade especialidade;
    private String nome;
    private double valor;

    public Procedimento(Especialidade especialidade, String nome, double valor) {
        this.especialidade = especialidade;
        this.nome = nome;
        this.valor = valor;
    }

    // Getters e setters
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
