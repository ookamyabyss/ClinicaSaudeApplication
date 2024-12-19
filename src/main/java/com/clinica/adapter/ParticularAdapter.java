package com.clinica.adapter;

import com.clinica.models.Procedimento;

public class ParticularAdapter implements PlanoSaudeAdapter {

    @Override
    public boolean autorizarProcedimento(Procedimento procedimento) {
        return true;
    }

    @Override
    public double calcularCobranca(Procedimento procedimento) {
        return procedimento.getValor();
    }

    @Override
    public boolean validarCobertura(Procedimento procedimento) {
        return true; 
    }
}
