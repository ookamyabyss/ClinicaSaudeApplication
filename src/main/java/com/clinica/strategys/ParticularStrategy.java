package com.clinica.strategys;

import com.clinica.models.Procedimento;

public class ParticularStrategy extends PlanoSaude {

    public ParticularStrategy(String nome) {
        super(nome);
    }

    @Override
    public boolean validarCobertura(Procedimento solicitacaoProcedimento) {
        return true;
    }

    @Override
    public double calcularCobranca(Procedimento solicitacaoProcedimento) {
        return solicitacaoProcedimento.getValor();
    };
}
