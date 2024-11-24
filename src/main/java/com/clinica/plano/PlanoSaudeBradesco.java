package com.clinica.plano;

public class PlanoSaudeBradesco {

    // Método para calcular desconto
    public double calcularDesconto(double valorConsulta) {
        return valorConsulta * 0.85; // 15% de desconto
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

    // Método para obter o valor da cobertura
    public double getValorCobertura() {
        // Retorna um valor fictício como exemplo
        return 500.00;
    }
}
