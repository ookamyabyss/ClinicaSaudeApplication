package com.clinica.adapter;

import com.clinica.models.Procedimento;

public class PlanoSaudeBradescoAdapter implements PlanoSaudeAdapter {

    @Override
    public boolean autorizarProcedimento(Procedimento procedimento) {
        System.out.println("Autorizando procedimento no Bradesco: " + procedimento.getNome());
        return true; // Simula autorização
    }

    @Override
    public double calcularCoparticipacao(Procedimento procedimento) {
        return procedimento.getValor() * 0.2; // Coparticipação de 20%
    }

    @Override
    public double calcularCobranca(Procedimento procedimento) {
        double coparticipacao = calcularCoparticipacao(procedimento);
        System.out.println("Cálculo de cobrança no Bradesco: " + coparticipacao);
        return coparticipacao; // Retorna o valor da coparticipação
    }

    @Override
    public boolean validarCobertura(Procedimento procedimento) {
        // Lógica de validação de cobertura para o plano Bradesco
        // Exemplo: Procedimentos com valor acima de 1000 não são cobertos
        if (procedimento.getValor() > 1000) {
            System.out.println("Procedimento não coberto pelo plano Bradesco.");
            return false;
        }
        System.out.println("Procedimento coberto pelo plano Bradesco.");
        return true; // Caso contrário, considera que o procedimento é coberto
    }
}

