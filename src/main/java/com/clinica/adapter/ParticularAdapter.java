package com.clinica.adapter;

import com.clinica.plano.Particular;

public class ParticularAdapter implements PlanoSaudeAdapter {

    private Particular particular;

    public ParticularAdapter(Particular particular) {
        this.particular = particular;
    }

    @Override
    public String obterNomePlano() {
        return particular.getNomePlano();
    }

    @Override
    public boolean validarCobertura() {
        return particular.isCoberturaValida();
    }

    @Override
    public double calcularValorConsulta(double valorConsulta) {
        return particular.calcularDesconto(valorConsulta);
    }
}
