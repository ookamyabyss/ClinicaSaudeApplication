package com.clinica.factories;

import com.clinica.strategys.*;

public class PlanoSaudeSingletonFactory {

    private static PlanoSaudeSingletonFactory instance;

    private PlanoSaudeSingletonFactory() {
    }

    public static PlanoSaudeSingletonFactory getInstance() {
        if (instance == null) {
            instance = new PlanoSaudeSingletonFactory();
        }
        return instance;
    }

    public PlanoSaude cadastrarPlanoSaude(String nomePlano) {
        switch (nomePlano.toLowerCase()) {
            case "bradesco":
                return new PlanoSaudeBradescoStrategy("bradesco");
            case "unimed":
                return new PlanoSaudeUnimedStrategy("unimed");
            case "amil":
                return new PlanoSaudeAmilStrategy("amil");
            case "particular":
                return new ParticularStrategy("particular");
            case "hapvida":
                return new PlanoSaudeHapvidaStrategy("hapvida");
            default:
                throw new IllegalArgumentException("Plano de saúde desconhecido: " + nomePlano);
        }
    }
}
