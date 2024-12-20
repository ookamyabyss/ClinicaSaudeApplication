package com.clinica.singleton;

import java.util.HashMap;
import java.util.Map;

import com.clinica.models.Procedimento;
import com.clinica.strategys.PlanoSaude;
import com.clinica.factories.PlanoSaudeSingletonFactory;
import com.clinica.factories.ProcedimentoFactory;
import com.clinica.models.Especialidade;

public class ClinicaSingleton {
    private static ClinicaSingleton instancia;
    private String nome;
    private String endereco;
    private boolean aceitaParticular;
    private final Map<String, Procedimento> procedimentos;
    private final Map<String, PlanoSaude> planosClinica;
    private final Map<String, Integer> disponibilidadeDias;
    private static final int limiteAgendamentos = 3;

    private ClinicaSingleton() {
        this.nome = "Clínica Pesky Blinders";
        this.endereco = "Rua Barão do Triunfo";
        this.aceitaParticular = true;
        procedimentos = new HashMap<>();
        disponibilidadeDias = new HashMap<>();
        planosClinica = new HashMap<>();

        inicializarProcedimentos();
        inicializarDisponibilidadeDias();
        inicializarPlanos();
    }

    // Método estático para obter a instância única
    public static ClinicaSingleton getInstancia() {
        if (instancia == null) {
            synchronized (ClinicaSingleton.class) {
                if (instancia == null) {
                    instancia = new ClinicaSingleton();
                }
            }
        }
        return instancia;
    }

    private void inicializarPlanos() {
        adicionarPlano(PlanoSaudeSingletonFactory.getInstance().cadastrarPlanoSaude("bradesco"));
        adicionarPlano(PlanoSaudeSingletonFactory.getInstance().cadastrarPlanoSaude("hapvida"));
        if (aceitaParticular) {
            adicionarPlano(PlanoSaudeSingletonFactory.getInstance().cadastrarPlanoSaude("particular"));
        }
    }

    public void adicionarPlano(PlanoSaude plano) {
        planosClinica.put(plano.getNome(), plano);
    }

    private void inicializarProcedimentos() {
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Consulta Pediatria", 150.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Vacinação Infantil", 200.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Consulta Dermatologia", 180.00));
        adicionarProcedimento(
                ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Biópsia de Pele", 250.00));
        adicionarProcedimento(ProcedimentoFactory.criarProcedimento(Especialidade.ENDOCRINOLOGIA,
                "Consulta Endocrinologista", 220.00));

        if (aceitaParticular) {
            adicionarProcedimento(
                    ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Consulta Particular Pediatria",
                            300.00));
            adicionarProcedimento(
                    ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA,
                            "Consulta Particular Dermatologia", 350.00));
            adicionarProcedimento(
                    ProcedimentoFactory.criarProcedimento(Especialidade.ENDOCRINOLOGIA,
                            "Consulta Particular Endocrinologista", 400.00));
        }
    }

    public void adicionarProcedimento(Procedimento procedimento) {
        procedimentos.put(procedimento.getNome(), procedimento);
    }

    private void inicializarDisponibilidadeDias() {
        disponibilidadeDias.put("Segunda-feira", 0);
        disponibilidadeDias.put("Terça-feira", 0);
        disponibilidadeDias.put("Quarta-feira", 0);
        disponibilidadeDias.put("Quinta-feira", 0);
        disponibilidadeDias.put("Sexta-feira", 0);
        disponibilidadeDias.put("Sábado", 0);
        disponibilidadeDias.put("Domingo", 0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void exibirInformacoes() {
        System.out.println("\nNome: " + nome);
        System.out.println("\nEndereço: " + endereco);
    }

    public Map<String, Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public Map<String, Integer> getDisponibilidadeDias() {
        return disponibilidadeDias;
    }

    public Map<String, PlanoSaude> getPlanosClinica() {
        return planosClinica;
    }

    public int getLimiteAgendamentos() {
        return limiteAgendamentos;
    }

}
