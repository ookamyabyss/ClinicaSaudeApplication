package com.clinica.adapter;

import com.clinica.models.Procedimento;

public class ParticularAdapter implements PlanoSaudeAdapter {

    @Override
    public boolean autorizarProcedimento(Procedimento procedimento) {
        System.out.println("Autorizando procedimento no Particular: " + procedimento.getNome());
        return true; // Simula autorização
    }

    @Override
    public double calcularCoparticipacao(Procedimento procedimento) {
        return procedimento.getValor() * 0.1; // Coparticipação de 10%
    }

    @Override
    public double calcularCobranca(Procedimento procedimento) {
        double coparticipacao = calcularCoparticipacao(procedimento);
        System.out.println("Cálculo de cobrança no Particular: " + coparticipacao);
        return coparticipacao; // Retorna o valor da coparticipação
    }

    @Override
    public boolean validarCobertura(Procedimento procedimento) {
        // Suponha que validamos se o procedimento é coberto pelo plano.
        // Exemplo: Se o valor do procedimento for maior que um limite, retorna falso, caso contrário, verdadeiro.
        if (procedimento.getValor() > 1000) {
            System.out.println("Procedimento não coberto pelo plano");
            return false;
        }
        System.out.println("Procedimento coberto pelo plano");
        return true; // Validado como coberto
    }
}
