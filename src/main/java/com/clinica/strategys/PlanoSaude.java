package com.clinica.strategys;

import java.util.HashMap;
import java.util.Map;

import com.clinica.models.Procedimento;

public abstract class PlanoSaude {
    protected String nome;
    private final Map<String, Procedimento> procedimentos;

    public PlanoSaude(String nome) {
        this.nome = nome;
        this.procedimentos = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarProcedimento(Procedimento procedimento) {
        procedimentos.put(procedimento.getNome(), procedimento);
    }

    public double calcularCobranca(Procedimento solicitacaoProcedimento) {
        Procedimento coberturaProcedimento = this.procedimentos.get(solicitacaoProcedimento.getNome());
        return (solicitacaoProcedimento.getValor() - coberturaProcedimento.getValor());
    };

    public boolean validarCobertura(Procedimento solicitacaoProcedimento) {
        Procedimento coberturaProcedimento = this.procedimentos.get(solicitacaoProcedimento.getNome());
        if (this.getNome().toLowerCase() == "particular") {
            return true;
        } else if (coberturaProcedimento == null) {
            System.out.println("\nProcedimento não encontrado: " + solicitacaoProcedimento.getNome());
            return false;
        } else {
            System.out.println("\nProcedimento Coberto Pelo Plano: " + solicitacaoProcedimento.getNome());
            return true;
        }
    };

}
