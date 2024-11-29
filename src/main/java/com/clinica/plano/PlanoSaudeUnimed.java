package com.clinica.plano;

public class PlanoSaudeUnimed {

    public double calcularDesconto(double valorConsulta) {
        return valorConsulta * 0.80; // 80% de desconto
    }

    public String getNomePlano() {
        return "Plano Saúde Unimed";
    }

    public boolean isCoberturaValida() {
        return true; // Simulação de validação
    }
}
