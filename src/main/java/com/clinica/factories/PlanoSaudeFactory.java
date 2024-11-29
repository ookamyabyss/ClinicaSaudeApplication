package com.clinica.factories;

import com.clinica.adapter.*;
import com.clinica.plano.*;

public class PlanoSaudeFactory {

    public static PlanoSaudeAdapter criarPlanoSaudeAdapter(String nomePlano) {
        switch (nomePlano.toLowerCase()) {
            case "bradesco":
                return new PlanoSaudeBradescoAdapter(new PlanoSaudeBradesco());
            case "unimed":
                return new PlanoSaudeUnimedAdapter(new PlanoSaudeUnimed());
            case "amil":
                return new PlanoSaudeAmilAdapter(new PlanoSaudeAmil());
            case "particular":
                return new ParticularAdapter(new Particular());
            default:
                throw new IllegalArgumentException("Plano de saúde desconhecido: " + nomePlano);
        }
    }
}
