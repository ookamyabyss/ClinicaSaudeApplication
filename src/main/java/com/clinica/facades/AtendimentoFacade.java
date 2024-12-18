package com.clinica.facades;

import com.clinica.adapter.PlanoSaudeAdapter;
import com.clinica.models.Especialidade;
import com.clinica.models.Paciente;
import com.clinica.models.Procedimento;
import com.clinica.singleton.ClinicaSingleton;

public class AtendimentoFacade {

    public void processarAtendimento(Paciente paciente) {
        // Obter instância única da clínica
        ClinicaSingleton clinica = ClinicaSingleton.getInstancia();
        PlanoSaudeAdapter planoAdapter = paciente.getPlanoSaude();

        // Início do atendimento
        System.out.println("Iniciando atendimento para o paciente: " + paciente.getNome());

        // Verificar se o paciente menor de idade possui responsável
        if (paciente.getIdade() < 18 && paciente.getResponsavel() == null) {
            throw new RuntimeException("Responsável necessário para atendimento.");
        }

        // Exibir procedimentos disponíveis na clínica
        clinica.exibirProcedimentos();

        // Agendar procedimento
        try {
            Procedimento procedimento = new Procedimento(Especialidade.PEDIATRIA, "Consulta Pediatria", 200.0);

            if (!planoAdapter.autorizarProcedimento(procedimento)) {
                throw new RuntimeException("Procedimento não autorizado pelo plano de saúde.");
            }

            clinica.agendarProcedimento(procedimento.getNome(), "Segunda-feira");
            System.out.println("Procedimento agendado com sucesso!");

        } catch (RuntimeException e) {
            System.err.println("Erro ao agendar procedimento: " + e.getMessage());
        }

        // Exibir disponibilidade após tentativa de agendamento
        clinica.exibirDisponibilidade();

        // Validar cobertura do plano de saúde
        if (!clinica.validarCoberturaPlano(planoAdapter)) {
            throw new RuntimeException("Cobertura inválida para o plano: " + planoAdapter.getClass().getSimpleName());
        }

        // Calcular e exibir o valor final do atendimento
        double valorConsulta = clinica.calcularValorConsulta(paciente);
        System.out.println("Valor final da consulta: R$ " + valorConsulta);
    }
}
