package com.clinica.adapter;

import com.clinica.plano.PlanoSaudeUnimed;

public class PlanoSaudeUnimedAdapter implements PlanoSaudeAdapter {

    private PlanoSaudeUnimed planoSaudeUnimed;

    public PlanoSaudeUnimedAdapter(PlanoSaudeUnimed planoSaudeUnimed) {
        this.planoSaudeUnimed = planoSaudeUnimed;
    }

    @Override
    public String obterNomePlano() {
        return planoSaudeUnimed.getNomePlano();
    }

    @Override
    public boolean validarCobertura() {
        return planoSaudeUnimed.isCoberturaValida();
    }

    @Override
    public double calcularValorCobertura() {
        return planoSaudeUnimed.getValorCobertura();
    }
}
