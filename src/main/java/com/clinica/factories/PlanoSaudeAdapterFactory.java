package com.clinica.factories;

import com.clinica.adapter.*;

public class PlanoSaudeAdapterFactory {

    private static PlanoSaudeAdapterFactory instance;

    private PlanoSaudeAdapterFactory() {}

    public static PlanoSaudeAdapterFactory getInstance() {
        if (instance == null) {
            instance = new PlanoSaudeAdapterFactory();
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
            default:
                throw new IllegalArgumentException("Plano de saúde desconhecido: " + nomePlano);
        }
    }
}
