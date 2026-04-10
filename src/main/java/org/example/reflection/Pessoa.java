package org.example.reflection;

public class Pessoa {
    private String nome;
    private int idade;
    private static String empresa = "xAI";

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    private void metodoPrivado(String mensagem) {
        System.out.println("Método privado chamado: " + mensagem);
    }

    public void fazerAniversario() {
        this.idade++;
        System.out.println(nome + " fez aniversário! Idade agora: " + idade);
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + ", empresa='" + empresa + "'}";
    }
}