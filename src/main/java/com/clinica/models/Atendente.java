package com.clinica.models;

import java.util.Map;

import com.clinica.singleton.ClinicaSingleton;
import com.clinica.strategys.PlanoSaude;

public class Atendente {
    private final ClinicaSingleton clinica;
    private final Paciente paciente;

    public Atendente(ClinicaSingleton clinicaSingleton, Paciente paciente) {
        this.clinica = clinicaSingleton;
        this.paciente = paciente;
    }

    public void iniciarAtendimento() {
        System.out.println("\nIniciando atendimento para o paciente: " + paciente.getNome());

        if (paciente.getIdade() < 18 & paciente.getResponsavel() == null) {
            throw new RuntimeException("\nResponsável necessário para atendimento.");
        }
    }

    public void exibirProcedimentos() {
        System.out.println("\nLista de Procedimentos:");
        for (Procedimento procedimento : this.clinica.getProcedimentos().values()) {
            System.out.println("\n- " + procedimento.getNome() + " (" + procedimento.getEspecialidade() + "): R$"
                    + procedimento.getValor());
        }
    }

    public void exibirDisponibilidade() {
        System.out.println("\nDisponibilidade por Dia:");
        for (Map.Entry<String, Integer> entrada : this.clinica.getDisponibilidadeDias().entrySet()) {
            String status = entrada.getValue() >= this.clinica.getLimiteAgendamentos() ? "Indisponível" : "Disponível";
            System.out.println("\n- " + entrada.getKey() + ": " + status + " (" + entrada.getValue() + " agendamentos)");
        }
    }

    private boolean validarCoberturaPlano(PlanoSaude solicitacaoPlanoSaude, Procedimento solicitacaoProcedimento) {
        if (solicitacaoPlanoSaude == null) {
            throw new IllegalArgumentException("\nPlano de saúde não pode ser nulo.");
        }

        boolean coberturaProcedimento = solicitacaoPlanoSaude.validarCobertura(solicitacaoProcedimento);

        boolean coberturaPlano = this.clinica.getPlanosClinica().get(solicitacaoPlanoSaude.getNome()) != null ? true
                : false;

        if (!coberturaProcedimento) {
            throw new IllegalArgumentException("\nPlano de saúde não cobre o procedimento");

        } else if (!coberturaPlano) {
            throw new IllegalArgumentException("\nClinica nao aceita o plano de saúde");

        }

        return (coberturaProcedimento && coberturaPlano);

    }

    public boolean agendarProcedimento(String solicitacaoProcedimentoNome, String dia) {
        Procedimento solicitacaoProcedimento = this.clinica.getProcedimentos().get(solicitacaoProcedimentoNome);
        int agendamentos = this.clinica.getDisponibilidadeDias().get(dia);

        if (solicitacaoProcedimento == null) {
            System.out.println("\nProcedimento não encontrado: " + solicitacaoProcedimentoNome);
            return false;
        } else if (!this.clinica.getDisponibilidadeDias().containsKey(dia)) {
            System.out.println("\nDia inválido: " + dia);
            return false;
        } else if (agendamentos >= this.clinica.getLimiteAgendamentos()) {
            System.out.println("\nDia indisponível para agendamentos: " + dia);
            return false;
        } else {

            boolean validacaoPlano = this.validarCoberturaPlano(this.paciente.getPlanoSaude(), solicitacaoProcedimento);

            if (validacaoPlano) {
                this.clinica.getDisponibilidadeDias().put(dia, agendamentos + 1);
                double valorFinal = this.paciente.getPlanoSaude().calcularCobranca(solicitacaoProcedimento);

                System.out.printf(
                        "\nAgendamento realizado com sucesso!%nProcedimento: %s%nEspecialidade: %s%nValor: R$%.2f%nDia: %s%n",
                        solicitacaoProcedimento.getNome(), solicitacaoProcedimento.getEspecialidade(),
                        valorFinal, dia);
                return true;
            } else {
                System.out.println("\nHouve um problema ao realizar o agendamento, tente novamente");
                return false;
            }

        }

    }
}
