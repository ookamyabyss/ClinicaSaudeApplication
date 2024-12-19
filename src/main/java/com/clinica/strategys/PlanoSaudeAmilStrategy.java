package com.clinica.strategys;

import com.clinica.factories.ProcedimentoFactory;
import com.clinica.models.Especialidade;

public class PlanoSaudeAmilStrategy extends PlanoSaude {

    public PlanoSaudeAmilStrategy(String nome) {
        super(nome);
        inicializarProcedimentos();
    }

    private void inicializarProcedimentos() {
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Consulta Pediatria", 75.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Vacinação Infantil", 120.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Consulta Dermatologia", 80.00));
    }
}
