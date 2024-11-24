package com.clinica.models;

public class Consultorio {
    private int numero;
    private Especialidade especialidade;

    public Consultorio(int numero, Especialidade especialidade) {
        this.numero = numero;
        this.especialidade = especialidade;
    }

    // Getters e setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public boolean agendarAtendimento(Paciente paciente, String data) {
        // Implementação específica
        return true;
    }
}
