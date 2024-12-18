package com.clinica.factories;

import com.clinica.models.Especialidade;
import com.clinica.models.Procedimento;

public class ProcedimentoFactory {

    public static Procedimento criarProcedimento(Especialidade especialidade, String nome, double valor) {
        return new Procedimento(especialidade, nome, valor);
    }
}