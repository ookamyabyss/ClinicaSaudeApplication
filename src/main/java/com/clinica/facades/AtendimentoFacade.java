package com.clinica.facades;

import com.clinica.models.Atendente;
import com.clinica.models.Paciente;
import com.clinica.singleton.ClinicaSingleton;

public class AtendimentoFacade {

    public void processarAtendimento(Paciente paciente) {
        // Implementar
        ClinicaSingleton clinica = ClinicaSingleton.getInstancia();
        Atendente atendente = new Atendente(clinica, paciente);

        atendente.iniciarAtendimento();

        atendente.exibirProcedimentos();

        // atendente.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        atendente.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        // atendente.agendarProcedimento("Consulta Pediatria", "Segunda-feira");
        // atendente.agendarProcedimento("Consulta Pediatria", "Segunda-feira"); // Deve

        atendente.exibirDisponibilidade();
    }
}
