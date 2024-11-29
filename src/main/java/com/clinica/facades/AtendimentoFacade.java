package com.clinica.facades;

import com.clinica.adapter.PlanoSaudeAdapter;
import com.clinica.factories.PlanoSaudeAdapterFactory;

public class AtendimentoFacade {

    public double processarAtendimento(String nomePaciente, String nomePlano, double valorConsulta) {
        System.out.println("Iniciando atendimento para o paciente: " + nomePaciente);

        // Obter o adaptador do plano de saúde
        PlanoSaudeAdapter planoAdapter = PlanoSaudeAdapterFactory.criarPlanoSaudeAdapter(nomePlano);

        // Validar cobertura
        if (!planoAdapter.validarCobertura()) {
            throw new RuntimeException("Cobertura inválida para o plano: " + nomePlano);
        }

        // Calcular o valor final da consulta
        double desconto = planoAdapter.calcularValorConsulta(valorConsulta);
        return valorConsulta - desconto;
    }
}
