package com.clinica.plano;

public class PlanoSaudeAmil {

    public double calcularDesconto(double valorConsulta) {
        return valorConsulta * 0.75; // 25% de desconto
    }

    public String getNomePlano() {
        return "Plano Saúde Amil";
    }

    public boolean isCoberturaValida() {
        return true; // Simulação de validação
    }

    public double getValorCobertura() {
        return 600.00; // Valor fictício
    }
}
