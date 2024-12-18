package com.clinica.models;

public class Procedimento {
    private Especialidade especialidade;
    private String nome;
    private double valor;

    // Construtor principal
    public Procedimento(Especialidade especialidade, String nome, double valor) {
        if (especialidade == null) {
            throw new IllegalArgumentException("Especialidade não pode ser nula.");
        }
        this.especialidade = especialidade;
        this.nome = nome;
        setValor(valor); // Valida o valor ao inicializar
    }
    
    // Construtor padrão (opcional, caso seja necessário)
    public Procedimento() {
        // Inicializa com valores padrão
        this.especialidade = Especialidade.OUTRA; // Exemplo, ajustar conforme necessário
        this.nome = "Nome do Procedimento";
        this.valor = 0.0;
    }

    // Getters e setters
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        // Validação para garantir que o valor é positivo
        if (valor > 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("O valor do procedimento deve ser maior que zero.");
        }
    }

    @Override
    public String toString() {
        // Representação textual do objeto, com formatação de valor
        return String.format("Procedimento [Especialidade: %s, Nome: %s, Valor: R$%.2f]",
                especialidade, nome, valor);
    }
}
