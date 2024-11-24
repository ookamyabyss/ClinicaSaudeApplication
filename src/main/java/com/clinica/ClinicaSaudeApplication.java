package com.clinica;

import com.clinica.controllers.AtendimentoController;
import com.clinica.controllers.PacienteController;

public class ClinicaSaudeApplication {
    public static void main(String[] args) {
        // Controladores
        PacienteController pacienteController = new PacienteController();
        AtendimentoController atendimentoController = new AtendimentoController();

        // Cadastro de paciente
        pacienteController.cadastrarPaciente("Pedro Victor Benevides", 80);

        // Realizar atendimento
        atendimentoController.realizarAtendimento("Pedro Victor Benevides", "Unimed", 1000.00);
    }
}
