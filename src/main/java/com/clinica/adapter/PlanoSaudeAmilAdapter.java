package com.clinica.adapter;

import com.clinica.plano.PlanoSaudeAmil;

public class PlanoSaudeAmilAdapter implements PlanoSaudeAdapter {

    private PlanoSaudeAmil planoSaudeAmil;

    public PlanoSaudeAmilAdapter(PlanoSaudeAmil planoSaudeAmil) {
        this.planoSaudeAmil = planoSaudeAmil;
    }

    @Override
    public String getNomePlano() {
        return planoSaudeAmil.getNomePlano();
    }

    @Override
    public boolean validarCobertura() {
        return planoSaudeAmil.isCoberturaValida();
    }

    @Override
    public double calcularValorConsulta(double valorConsulta) {
        return planoSaudeAmil.calcularDesconto(valorConsulta);
    }
}
