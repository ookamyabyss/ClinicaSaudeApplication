package com.clinica;

import com.clinica.facades.AtendimentoFacade;
import com.clinica.factories.PacienteFactory;
import com.clinica.factories.PlanoSaudeSingletonFactory;
import com.clinica.models.Paciente;

public class ClinicaSaudeApplication {
    public static void main(String[] args) {
        AtendimentoFacade atendimentoFacade = new AtendimentoFacade();

        // Cadastro de paciente
        Paciente paciente = PacienteFactory.cadastrarPaciente("Pedro Victor Benevides",
                "1234567889", "12345678998", 80,
                'M', PlanoSaudeSingletonFactory.getInstance().cadastrarPlanoSaude("hapvida"));

        atendimentoFacade.processarAtendimento(paciente);

    }
}
