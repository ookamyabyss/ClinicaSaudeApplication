package com.clinica.controllers;

import com.clinica.facades.AtendimentoFacade;
import com.clinica.models.Paciente;

public class AtendimentoController {
    private AtendimentoFacade atendimentoFacade;

    public AtendimentoController() {
        this.atendimentoFacade = new AtendimentoFacade();
    }

    public void realizarAtendimento(Paciente paciente) {
        double valorFinal = atendimentoFacade.processarAtendimento(paciente);
        System.out.println("Atendimento realizado com sucesso!");
        System.out.println("Valor final da consulta: R$ " + valorFinal);
    }
}
