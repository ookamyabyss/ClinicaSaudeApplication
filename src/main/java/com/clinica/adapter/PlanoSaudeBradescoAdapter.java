package com.clinica.adapter;

import com.clinica.plano.PlanoSaudeBradesco;

public class PlanoSaudeBradescoAdapter implements PlanoSaudeAdapter {

    private PlanoSaudeBradesco planoSaudeBradesco;

    // Construtor
    public PlanoSaudeBradescoAdapter(PlanoSaudeBradesco planoSaudeBradesco) {
        this.planoSaudeBradesco = planoSaudeBradesco;
    }

    @Override
    public String getNomePlano() {
        // Retorna o nome do plano de saúde específico
        return planoSaudeBradesco.getNomePlano();
    }

    @Override
    public boolean validarCobertura() {
        // Verifica se a cobertura é válida
        return planoSaudeBradesco.isCoberturaValida();
    }

    @Override
    public double calcularValorConsulta(double valorConsulta) {
        // Retorna o valor da cobertura
        return planoSaudeBradesco.calcularDesconto(valorConsulta);
    }
}
