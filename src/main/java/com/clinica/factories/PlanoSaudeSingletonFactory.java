package com.clinica.factories;

import com.clinica.adapter.*;

public class PlanoSaudeSingletonFactory {

    private static PlanoSaudeSingletonFactory instance;

    private PlanoSaudeSingletonFactory() {}

    public static PlanoSaudeSingletonFactory getInstance() {
        if (instance == null) {
            instance = new PlanoSaudeSingletonFactory();
        }
        return instance;
    }

    public PlanoSaudeAdapter getPlanoSaudeAdapter(String nomePlano) {
        switch (nomePlano.toLowerCase()) {
            case "bradesco":
                return new PlanoSaudeBradescoAdapter();
            case "unimed":
                return new PlanoSaudeUnimedAdapter();
            case "amil":
                return new PlanoSaudeAmilAdapter();
            case "particular":
                return new ParticularAdapter();
            case "hapvida":
                return new PlanoSaudeHapvidaAdapter();
            default:
                throw new IllegalArgumentException("Plano de saúde desconhecido: " + nomePlano);
        }
    }
}
