package com.clinica.adapter;

import com.clinica.models.Procedimento;

public class PlanoSaudeUnimedAdapter implements PlanoSaudeAdapter {

    @Override
    public boolean autorizarProcedimento(Procedimento procedimento) {
        System.out.println("Autorizando procedimento na Unimed: " + procedimento.getNome());
        return true; // Simula autorização
    }

    @Override
    public double calcularCoparticipacao(Procedimento procedimento) {
        return procedimento.getValor() * 0.15; // Coparticipação de 15%
    }

    @Override
    public double calcularCobranca(Procedimento procedimento) {
        double coparticipacao = calcularCoparticipacao(procedimento);
        System.out.println("Cálculo de cobrança na Unimed: " + coparticipacao);
        return coparticipacao; // Retorna o valor da coparticipação
    }

    @Override
    public boolean validarCobertura(Procedimento procedimento) {
        // Lógica de validação de cobertura para o plano Unimed
        // Exemplo: Procedimentos com valor superior a 2000 não são cobertos
        if (procedimento.getValor() > 2000) {
            System.out.println("Procedimento não coberto pelo plano Unimed.");
            return false;
        }
        System.out.println("Procedimento coberto pelo plano Unimed.");
        return true; // Caso contrário, considera que o procedimento é coberto
    }
}
