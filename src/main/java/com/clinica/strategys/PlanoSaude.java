package com.clinica.strategys;

import java.util.HashMap;
import java.util.Map;

import com.clinica.models.Procedimento;

public abstract class PlanoSaude {
    protected String nome;
    private final Map<String, Procedimento> procedimentos;
    protected double percentualCoparticipacao; 

    public PlanoSaude(String nome, double percentualCoparticipacao) {
        this.nome = nome;
        this.percentualCoparticipacao = percentualCoparticipacao; 
        this.procedimentos = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarProcedimento(Procedimento procedimento) {
        procedimentos.put(procedimento.getNome(), procedimento);
    }

    public double calcularCobranca(Procedimento solicitacaoProcedimento) {
        return solicitacaoProcedimento.getValor() * percentualCoparticipacao;
    }


    public boolean validarCobertura(Procedimento solicitacaoProcedimento) {
        Procedimento coberturaProcedimento = this.procedimentos.get(solicitacaoProcedimento.getNome());
        if (this.getNome().toLowerCase().equals("particular")) {
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
