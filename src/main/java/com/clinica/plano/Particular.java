package com.clinica.plano;

public class Particular {

    public double calcularDesconto(double valorConsulta) {
        return valorConsulta; // Nenhum desconto para pagamento particular
    }

    public String getNomePlano() {
        return "Particular";
    }

    public boolean isCoberturaValida() {
        return true; // Sempre válido para particular
    }
}
