package com.clinica.models;

import java.util.Map;

import com.clinica.adapter.PlanoSaudeAdapter;
import com.clinica.singleton.ClinicaSingleton;

public class Atendente {
    private final ClinicaSingleton clinica;
    private final Paciente paciente;

    public Atendente(ClinicaSingleton clinicaSingleton, Paciente paciente) {
        this.clinica = clinicaSingleton;
        this.paciente = paciente;
    }

    public void iniciarAtendimento() {
        System.out.println("Iniciando atendimento para o paciente: " + paciente.getNome());

        if (paciente.getIdade() < 18 & paciente.getResponsavel() == null) {
            throw new RuntimeException("Responsável necessário para atendimento.");
        }
    }

    public void exibirProcedimentos() {
        System.out.println("Lista de Procedimentos:");
        for (Procedimento procedimento : this.clinica.getProcedimentos().values()) {
            System.out.println("- " + procedimento.getNome() + " (" + procedimento.getEspecialidade() + "): R$"
                    + procedimento.getValor());
        }
    }

    public void exibirDisponibilidade() {
        System.out.println("Disponibilidade por Dia:");
        for (Map.Entry<String, Integer> entrada : this.clinica.getDisponibilidadeDias().entrySet()) {
            String status = entrada.getValue() >= this.clinica.getLimiteAgendamentos() ? "Indisponível" : "Disponível";
            System.out.println("- " + entrada.getKey() + ": " + status + " (" + entrada.getValue() + " agendamentos)");
        }
    }

    public boolean agendarProcedimento(String procedimentoNome, String dia) {
        Procedimento procedimento = this.clinica.getProcedimentos().get(procedimentoNome);
        if (procedimento == null) {
            System.out.println("Procedimento não encontrado: " + procedimentoNome);
            return false;
        }

        if (!this.clinica.getDisponibilidadeDias().containsKey(dia)) {
            System.out.println("Dia inválido: " + dia);
            return false;
        }

        int agendamentos = this.clinica.getDisponibilidadeDias().get(dia);
        if (agendamentos >= this.clinica.getLimiteAgendamentos()) {
            System.out.println("Dia indisponível para agendamentos: " + dia);
            return false;
        }

        this.clinica.getDisponibilidadeDias().put(dia, agendamentos + 1);
        System.out.printf(
                "Agendamento realizado com sucesso!%nProcedimento: %s%nEspecialidade: %s%nValor: R$%.2f%nDia: %s%n",
                procedimento.getNome(), procedimento.getEspecialidade(), procedimento.getValor(), dia);
        return true;
    }

    // Valida a cobertura do plano de saúde
    public boolean validarCoberturaPlano(PlanoSaudeAdapter planoAdapter) {
        if (planoAdapter == null) {
            throw new IllegalArgumentException("Plano de saúde não pode ser nulo.");
        }
        return planoAdapter.validarCobertura(null); // Método assumido como implementado no adapter
    }

    // Calcula o valor da consulta com base em regras de negócio
    public double calcularValorConsulta(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente inválido.");
        }
        // Simulação de cálculo de valor final com possíveis descontos
        return this.clinica.getProcedimentos().values().stream().mapToDouble(Procedimento::getValor).sum();
    }
}
