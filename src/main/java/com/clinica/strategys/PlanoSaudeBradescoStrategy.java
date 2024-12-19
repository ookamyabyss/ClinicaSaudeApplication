package com.clinica.strategys;

import com.clinica.factories.ProcedimentoFactory;
import com.clinica.models.Especialidade;

public class PlanoSaudeBradescoStrategy extends PlanoSaude {

    public PlanoSaudeBradescoStrategy(String nome) {
        super(nome, 0.20);
        inicializarProcedimentos();
    }

    private void inicializarProcedimentos() {
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Consulta Pediatria", 150.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Vacinação Infantil", 200.00));
    }

}
