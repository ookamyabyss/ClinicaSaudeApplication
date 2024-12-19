package com.clinica.strategys;

import com.clinica.factories.ProcedimentoFactory;
import com.clinica.models.Especialidade;

public class PlanoSaudeHapvidaStrategy extends PlanoSaude {

    public PlanoSaudeHapvidaStrategy(String nome) {
        super(nome, 0.5);
        inicializarProcedimentos();
    }

    private void inicializarProcedimentos() {
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Consulta Pediatria", 125.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Vacinação Infantil", 100.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Consulta Dermatologia", 80.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Biópsia de Pele", 200.00));
        adicionarProcedimento(ProcedimentoFactory.criarProcedimento(Especialidade.ENDOCRINOLOGIA,
                "Consulta Endocrinologista", 180.00));
    }
}
