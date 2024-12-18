package com.clinica;

import com.clinica.adapter.PlanoSaudeAdapter;
import com.clinica.factories.PlanoSaudeAdapterFactory;
import com.clinica.models.Especialidade;
import com.clinica.models.Paciente;
import com.clinica.models.Procedimento;

public class ClinicaSaudeApplication {
    public static void main(String[] args) {
        // Testando a criação do Adapter do Plano de Saúde
        PlanoSaudeAdapterFactory factory = PlanoSaudeAdapterFactory.getInstance();

        // Criar um paciente
        Paciente paciente = new Paciente("Pedro Victor Benevides", "1234567889", "12345678998", 80, 'M');
        
        // Definir o plano de saúde
        String tipoPlano = "bradesco"; // Pode ser "unimed", "amil", etc.
        PlanoSaudeAdapter planoSaude = factory.getPlanoSaudeAdapter(tipoPlano);
        
        // Associar o plano de saúde ao paciente
        paciente.setPlanoSaude(planoSaude);

        // Criar um procedimento com a especialidade usando o enum
        Especialidade especialidade = Especialidade.PEDIATRIA; // Escolha uma especialidade do enum

        // Criar o procedimento com especialidade, nome e valor
        Procedimento procedimento = new Procedimento(especialidade, "Consulta Pediatria", 100.0);

        // Testar os métodos do plano de saúde
        System.out.println("Autorizando procedimento...");
        planoSaude.autorizarProcedimento(procedimento);

        double coparticipacao = planoSaude.calcularCoparticipacao(procedimento);
        System.out.println("Valor da coparticipação: R$ " + coparticipacao);

        double cobranca = planoSaude.calcularCobranca(procedimento);
        System.out.println("Cálculo da cobrança: R$ " + cobranca);
    }
}
