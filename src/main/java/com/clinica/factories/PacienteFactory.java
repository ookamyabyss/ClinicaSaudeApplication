package com.clinica.factories;

import com.clinica.models.Paciente;

public class PacienteFactory {

    public static Paciente cadastrarPaciente(String nome, String documentoIdentificacao, String cpf, int idade,
            char sexo) {
        return new Paciente(nome, documentoIdentificacao, cpf, idade, sexo);
    }
}
