package com.clinica.adapter;

public interface PlanoSaudeAdapter {
    String getNomePlano();
    boolean validarCobertura();
    double calcularValorConsulta(double valorConsulta);
}
