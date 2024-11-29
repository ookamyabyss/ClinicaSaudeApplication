package com.clinica.facades;

import com.clinica.adapter.PlanoSaudeAdapter;
import com.clinica.factories.PlanoSaudeFactory;
import com.clinica.models.Paciente;

public class AtendimentoFacade {

    public double processarAtendimento(Paciente paciente) {
        //Implementar
        ClinicaSingleton clinica = new ClinicaSingleton();
        
        System.out.println("Iniciando atendimento para o paciente: " + paciente.getNome());
        
        // Obter o adaptador do plano de saúde
        PlanoSaudeAdapter planoAdapter = paciente.getPlanoSaude();

        if (paciente.getIdade() < 18 & paciente.getResponsavel() == null) {
            throw new RuntimeException("Responsável necessário para atendimento.");

        }
        
        //adicionar lógica de verificação do agendamento
        if (!clinica.validarAgendamento()) {
            throw new RuntimeException("Dia para agendamento não disponivel.");
        }

        // Mover validação da cobertura para classe da clinica
        // Validar cobertura planoo
        if (!clinica.validarCoberturaPlano()) {
            throw new RuntimeException("Cobertura inválida para o plano: " + planoAdapter.getNomePlano());
        }

        if (!clinica.validarCoberturaProcedimento()) {
            throw new RuntimeException("Cobertura inválida para o procedimento: " + );
        }

        // Enviar procedimento e paciente para método da clinica realizar verificação do
        // procedimento
        // Mover calculo para objeto da clinica
        // Calcular o valor final da consulta
        double valorConsulta = clinica.calcularValorConsulta();
        return valorConsulta;
    }
}
