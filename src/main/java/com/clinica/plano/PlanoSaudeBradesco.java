package com.clinica.plano;

public class PlanoSaudeBradesco {

    // Método para calcular desconto
    public double calcularDesconto(double valorConsulta) {
        return valorConsulta * 1; // 100% de desconto
    }

    // Método para obter o nome do plano
    public String getNomePlano() {
        return "Plano Saúde Bradesco";
    }

    // Método para validar cobertura
    public boolean isCoberturaValida() {
        // Simulação de validação
        return true; // Aqui você pode implementar a lógica real
    }
}
