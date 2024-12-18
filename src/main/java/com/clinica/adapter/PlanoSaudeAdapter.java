package com.clinica.adapter;

import com.clinica.models.Procedimento;

public interface PlanoSaudeAdapter {
    
    boolean autorizarProcedimento(Procedimento procedimento);
    double calcularCoparticipacao(Procedimento procedimento);
    double calcularCobranca(Procedimento procedimento);
    boolean validarCobertura(Procedimento procedimento);  // Exemplo de método adicional
    
}
