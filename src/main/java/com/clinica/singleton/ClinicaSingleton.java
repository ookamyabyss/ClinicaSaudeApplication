package com.clinica.singleton;

import java.util.HashMap;
import java.util.Map;

import com.clinica.models.Procedimento;
import com.clinica.adapter.PlanoSaudeAdapter;
import com.clinica.factories.ProcedimentoFactory;
import com.clinica.models.Especialidade;
import com.clinica.models.Paciente;

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
        this.procedimentos = new HashMap<>();
        this.disponibilidadeDias = new HashMap<>();

        inicializarProcedimentos();
        inicializarDisponibilidadeDias();
    }

    // Método para obter a instância única (padrão Singleton com Double-Checked Locking)
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

    // Inicializa a lista de procedimentos
    private void inicializarProcedimentos() {
        adicionarProcedimento(ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Consulta Pediatria", 150.00));
        adicionarProcedimento(ProcedimentoFactory.criarProcedimento(Especialidade.PEDIATRIA, "Vacinação Infantil", 200.00));
        adicionarProcedimento(ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Consulta Dermatologia", 180.00));
        adicionarProcedimento(ProcedimentoFactory.criarProcedimento(Especialidade.DERMATOLOGIA, "Biópsia de Pele", 250.00));
        adicionarProcedimento(ProcedimentoFactory.criarProcedimento(Especialidade.ENDOCRINOLOGIA, "Consulta Endocrinologista", 220.00));
    }

    // Adiciona um procedimento à lista
    public void adicionarProcedimento(Procedimento procedimento) {
        if (procedimento == null || procedimento.getNome() == null || procedimento.getNome().isEmpty()) {
            throw new IllegalArgumentException("Procedimento inválido.");
        }
        procedimentos.put(procedimento.getNome(), procedimento);
    }

    // Inicializa a disponibilidade de dias
    private void inicializarDisponibilidadeDias() {
        String[] dias = { "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado", "Domingo" };
        for (String dia : dias) {
            disponibilidadeDias.put(dia, 0);
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido.");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço inválido.");
        }
        this.endereco = endereco;
    }

    // Exibe informações da clínica
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
    }

    // Retorna os procedimentos
    public Map<String, Procedimento> getProcedimentos() {
        return new HashMap<>(procedimentos); // Retorna uma cópia para preservar encapsulamento
    }

    // Exibe a lista de procedimentos
    public void exibirProcedimentos() {
        System.out.println("Lista de Procedimentos:");
        for (Procedimento procedimento : procedimentos.values()) {
            System.out.printf("- %s (%s): R$%.2f%n", procedimento.getNome(), procedimento.getEspecialidade(), procedimento.getValor());
        }
    }

    // Exibe a disponibilidade de agendamentos por dia
    public void exibirDisponibilidade() {
        System.out.println("Disponibilidade por Dia:");
        for (Map.Entry<String, Integer> entrada : disponibilidadeDias.entrySet()) {
            String status = entrada.getValue() >= LIMITE_AGENDAMENTOS ? "Indisponível" : "Disponível";
            System.out.printf("- %s: %s (%d agendamentos)%n", entrada.getKey(), status, entrada.getValue());
        }
    }

    // Agenda um procedimento para um dia específico
    public boolean agendarProcedimento(String procedimentoNome, String dia) {
        if (procedimentoNome == null || dia == null || procedimentoNome.trim().isEmpty() || dia.trim().isEmpty()) {
            System.out.println("Nome do procedimento ou dia inválido.");
            return false;
        }

        Procedimento procedimento = procedimentos.get(procedimentoNome);
        if (procedimento == null) {
            System.out.println("Procedimento não encontrado: " + procedimentoNome);
            return false;
        }

        Integer agendamentos = disponibilidadeDias.get(dia);
        if (agendamentos == null) {
            System.out.println("Dia inválido: " + dia);
            return false;
        }

        if (agendamentos >= LIMITE_AGENDAMENTOS) {
            System.out.println("Dia indisponível para agendamentos: " + dia);
            return false;
        }

        disponibilidadeDias.put(dia, agendamentos + 1);
        System.out.printf("Agendamento realizado com sucesso!%nProcedimento: %s%nEspecialidade: %s%nValor: R$%.2f%nDia: %s%n",
                procedimento.getNome(), procedimento.getEspecialidade(), procedimento.getValor(), dia);
        return true;
    }

    // Valida a cobertura do plano de saúde
    public boolean validarCoberturaPlano(PlanoSaudeAdapter planoAdapter) {
        if (planoAdapter == null) {
            throw new IllegalArgumentException("Plano de saúde não pode ser nulo.");
        }
        return planoAdapter.validarCobertura(null); // Método assumido como implementado no adapter
    }

    // Calcula o valor da consulta com base em regras de negócio
    public double calcularValorConsulta(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("Paciente inválido.");
        }
        // Simulação de cálculo de valor final com possíveis descontos
        return procedimentos.values().stream().mapToDouble(Procedimento::getValor).sum();
    }
}
