package com.clinica.controllers;

import com.clinica.models.Paciente;

public class PacienteController {

    public Paciente cadastrarPaciente(String nome, String documentoIdentificacao, String cpf, int idade, String sexo) {
        Paciente paciente = new Paciente(nome, documentoIdentificacao, cpf, idade, sexo);
        System.out.println("Paciente cadastrado com sucesso!");
        System.out.println("Nome: " + paciente.getNome());
        System.out.println("Idade: " + paciente.getIdade());

        return paciente;
    }
}
