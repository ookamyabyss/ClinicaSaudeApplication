package com.clinica.factories;

import com.clinica.models.Paciente;
import com.clinica.strategys.PlanoSaude;

public class PacienteFactory {

    public static Paciente cadastrarPaciente(String nome, String documentoIdentificacao, String cpf, int idade,
            char sexo, PlanoSaude planoSaude) {
        return new Paciente(nome, documentoIdentificacao, cpf, idade, sexo, planoSaude);
    }
}
