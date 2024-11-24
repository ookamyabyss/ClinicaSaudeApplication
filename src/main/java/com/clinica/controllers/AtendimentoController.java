package com.clinica.controllers;

import com.clinica.facades.AtendimentoFacade;

public class AtendimentoController {
    private AtendimentoFacade atendimentoFacade;

    public AtendimentoController() {
        this.atendimentoFacade = new AtendimentoFacade();
    }

    public void realizarAtendimento(String nomePaciente, String nomePlano, double valorConsulta) {
        double valorFinal = atendimentoFacade.processarAtendimento(nomePaciente, nomePlano, valorConsulta);
        System.out.println("Atendimento realizado com sucesso!");
        System.out.println("Valor final da consulta: R$ " + valorFinal);
    }
}
