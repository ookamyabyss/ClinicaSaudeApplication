package com.clinica;

import com.clinica.facades.AtendimentoFacade;
import com.clinica.factories.PacienteFactory;
import com.clinica.models.Paciente;
import com.clinica.singleton.ClinicaSingleton;

public class ClinicaSaudeApplication {
    public static void main(String[] args) {
        // AtendimentoFacade atendimentoFacade = new AtendimentoFacade();

        // // Cadastro de paciente
        // Paciente paciente = PacienteFactory.cadastrarPaciente("Pedro Victor
        // Benevides", "1234567889", "12345678998", 80,
        // 'M');

        // double valorFinal = atendimentoFacade.processarAtendimento(paciente);
        // System.out.println("Atendimento realizado com sucesso!");
        // System.out.println("Valor final da consulta: R$ " + valorFinal);

        ClinicaSingleton clinica = ClinicaSingleton.getInstancia();

        clinica.exibirProcedimentos();

        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira"); // Deve falhar

        clinica.exibirDisponibilidade();
    }
}
