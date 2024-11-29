package com.clinica.adapter;

public interface PlanoSaudeAdapter {
    String obterNomePlano();
    boolean validarCobertura();
    double calcularValorConsulta(double valorConsulta);
}
