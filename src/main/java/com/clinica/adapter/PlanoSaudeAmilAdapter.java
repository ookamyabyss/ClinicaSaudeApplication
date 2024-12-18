package com.clinica.adapter;

import com.clinica.models.Procedimento;

public class PlanoSaudeAmilAdapter implements PlanoSaudeAdapter {

    @Override
    public boolean autorizarProcedimento(Procedimento procedimento) {
        // Lógica de autorização para o plano Amil
        System.out.println("Autorizando procedimento no Amil: " + procedimento.getNome());
        return true; // Simula autorização
    }

    @Override
    public double calcularCoparticipacao(Procedimento procedimento) {
        // Calcula a coparticipação com base na lógica do plano Amil
        return procedimento.getValor() * 0.15; // Exemplo: coparticipação de 15%
    }

    @Override
    public double calcularCobranca(Procedimento procedimento) {
        // Cálculo da cobrança no plano Amil, considerando a coparticipação
        double coparticipacao = calcularCoparticipacao(procedimento);
        System.out.println("Cálculo de cobrança no Amil: " + coparticipacao);
        return coparticipacao; // Retorna o valor da coparticipação
    }

    @Override
    public boolean validarCobertura(Procedimento procedimento) {
        // Lógica de validação de cobertura para o plano Amil
        // Exemplo: Considera que procedimentos com valor superior a 500 não são cobertos
        if (procedimento.getValor() > 500) {
            System.out.println("Procedimento não coberto pelo plano Amil.");
            return false;
        }
        System.out.println("Procedimento coberto pelo plano Amil.");
        return true; // Caso contrário, considera que o procedimento é coberto
    }
}

