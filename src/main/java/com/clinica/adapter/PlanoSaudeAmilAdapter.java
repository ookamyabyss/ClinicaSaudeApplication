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
    public double calcularCobranca(Procedimento procedimento) {
        return procedimento.getValor() * 0.45;
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

