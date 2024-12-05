package com.clinica.facades;

import com.clinica.adapter.PlanoSaudeAdapter;
import com.clinica.factories.PlanoSaudeFactory;
import com.clinica.models.Paciente;
import com.clinica.singleton.ClinicaSingleton;

public class AtendimentoFacade {

    public void processarAtendimento(Paciente paciente) {
        // Implementar
        ClinicaSingleton clinica = ClinicaSingleton.getInstancia();
        PlanoSaudeAdapter planoAdapter = paciente.getPlanoSaude();

        System.out.println("Iniciando atendimento para o paciente: " + paciente.getNome());

        if (paciente.getIdade() < 18 & paciente.getResponsavel() == null) {
            throw new RuntimeException("Responsável necessário para atendimento.");
        }

        clinica.exibirProcedimentos();

        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        clinica.agendarProcedimento("Consulta Pediatria", "Segunda-feira"); // Deve falhar

        clinica.exibirDisponibilidade();

        // Mover validação da cobertura para classe da clinica
        // Validar cobertura planoo
        // if (!clinica.validarCoberturaPlano()) {
        // throw new RuntimeException("Cobertura inválida para o plano: " +
        // planoAdapter.getNomePlano());
        // }

        // Enviar procedimento e paciente para método da clinica realizar verificação do
        // procedimento
        // Mover calculo para objeto da clinica
        // Calcular o valor final da consulta
        // double valorConsulta = clinica.calcularValorConsulta();
        // return valorConsulta;
    }
}
