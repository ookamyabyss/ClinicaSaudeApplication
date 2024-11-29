package com.clinica;

import com.clinica.controllers.AtendimentoController;
import com.clinica.controllers.PacienteController;
import com.clinica.models.Paciente;

public class ClinicaSaudeApplication {
    public static void main(String[] args) {
        // Controladores
        PacienteController pacienteController = new PacienteController();
        AtendimentoController atendimentoController = new AtendimentoController();

        // Cadastro de paciente
        Paciente paciente = pacienteController.cadastrarPaciente("Pedro Victor Benevides", 80);

        // Realizar atendimento
        atendimentoController.realizarAtendimento(paciente);
    }
}
