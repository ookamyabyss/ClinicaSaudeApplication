package com.clinica.adapter;

import com.clinica.models.Procedimento;

public class PlanoSaudeHapvidaAdapter implements PlanoSaudeAdapter {

    @Override
    public boolean autorizarProcedimento(Procedimento procedimento) {
        // Lógica de autorização para o plano Hapvida
        System.out.println("Autorizando procedimento no Hapvida: " + procedimento.getNome());
        return true; // Simula autorização
    }

    @Override
    public double calcularCobranca(Procedimento procedimento) {
        return procedimento.getValor() * 0.35;
    }

    @Override
    public boolean validarCobertura(Procedimento procedimento) {
        // Lógica de validação de cobertura para o plano Hapvida
        // Exemplo: Considera que procedimentos com valor superior a 500 não são cobertos
        if (procedimento.getValor() > 500) {
            System.out.println("Procedimento não coberto pelo plano Hapvida.");
            return false;
        }
        System.out.println("Procedimento coberto pelo plano Hapvida.");
        return true; // Caso contrário, considera que o procedimento é coberto
    }
}

