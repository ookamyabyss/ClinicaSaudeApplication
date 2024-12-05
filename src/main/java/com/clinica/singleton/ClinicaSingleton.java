package com.clinica.singleton;

import java.util.HashMap;
import java.util.Map;

import com.clinica.models.Procedimento;
import com.clinica.factories.ProcedimentoFactory;
import com.clinica.models.Especialidade;

public class ClinicaSingleton {
    private static ClinicaSingleton instancia;
    private String nome;
    private String endereco;
    private final Map<String, Procedimento> procedimentos;
    private final Map<String, Integer> disponibilidadeDias;
    private static final int LIMITE_AGENDAMENTOS = 3;

    private ClinicaSingleton() {
        this.nome = "Clínica Pesky Blinders";
        this.endereco = "Rua Barão do Triunfo";
        procedimentos = new HashMap<>();
        disponibilidadeDias = new HashMap<>();

        inicializarProcedimentos();
        inicializarDisponibilidadeDias();
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
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
    }

    public Map<String, Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void exibirProcedimentos() {
        System.out.println("Lista de Procedimentos:");
        for (Procedimento procedimento : procedimentos.values()) {
            System.out.println("- " + procedimento.getNome() + " (" + procedimento.getEspecialidade() + "): R$"
                    + procedimento.getValor());
        }
    }

    public void exibirDisponibilidade() {
        System.out.println("Disponibilidade por Dia:");
        for (Map.Entry<String, Integer> entrada : disponibilidadeDias.entrySet()) {
            String status = entrada.getValue() >= LIMITE_AGENDAMENTOS ? "Indisponível" : "Disponível";
            System.out.println("- " + entrada.getKey() + ": " + status + " (" + entrada.getValue() + " agendamentos)");
        }
    }

    public boolean agendarProcedimento(String procedimentoNome, String dia) {
        Procedimento procedimento = procedimentos.get(procedimentoNome);
        if (procedimento == null) {
            System.out.println("Procedimento não encontrado: " + procedimentoNome);
            return false;
        }

        if (!disponibilidadeDias.containsKey(dia)) {
            System.out.println("Dia inválido: " + dia);
            return false;
        }

        int agendamentos = disponibilidadeDias.get(dia);
        if (agendamentos >= LIMITE_AGENDAMENTOS) {
            System.out.println("Dia indisponível para agendamentos: " + dia);
            return false;
        }

        disponibilidadeDias.put(dia, agendamentos + 1);
        System.out.println("Agendamento realizado com sucesso!");
        System.out.println("Procedimento: " + procedimento.getNome());
        System.out.println("Especialidade: " + procedimento.getEspecialidade());
        System.out.println("Valor: R$" + procedimento.getValor());
        System.out.println("Dia: " + dia);
        return true;
    }
}
