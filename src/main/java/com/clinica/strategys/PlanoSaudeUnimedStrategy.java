package com.clinica.strategys;

import com.clinica.factories.ProcedimentoFactory;
import com.clinica.models.Especialidade;

public class PlanoSaudeUnimedStrategy extends PlanoSaude {

    public PlanoSaudeUnimedStrategy(String nome) {
        super(nome);
        inicializarProcedimentos();
    }

    private void inicializarProcedimentos() {
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Consulta Dermatologia", 50.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Biópsia de Pele", 150.00));
    }
}
