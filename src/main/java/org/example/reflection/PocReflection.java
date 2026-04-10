package org.example.reflection;

import java.lang.reflect.*;

public class PocReflection {

    static void main() throws Exception {

        Class<?> clazz = Class.forName("org.example.reflection.Pessoa");
        System.out.println("Classe carregada: " + clazz.getName());

        Pessoa pessoa = new Pessoa("João Silva", 30);
        System.out.println("Antes: " + pessoa);

        Field[] campos = clazz.getDeclaredFields();
        for (Field campo : campos) {
            campo.setAccessible(true);
            Object valor = campo.get(pessoa);
            System.out.printf("Campo: %s | Valor: %s | Tipo: %s%n",
                    campo.getName(), valor, campo.getType().getSimpleName());
        }


        Method[] metodos = clazz.getDeclaredMethods();
        System.out.println("\nMétodos declarados:");
        for (Method m : metodos) {
            System.out.println("→ " + m.getName() + " (" + m.getParameterCount() + " params)");
        }


        Method fazerAniversario = clazz.getDeclaredMethod("fazerAniversario");
        fazerAniversario.invoke(pessoa);

         Method metodoPrivado = clazz.getDeclaredMethod("metodoPrivado", String.class);
        metodoPrivado.setAccessible(true);
        metodoPrivado.invoke(pessoa, "Reflection!");


        Field campoNome = clazz.getDeclaredField("nome");
        campoNome.setAccessible(true);
        campoNome.set(pessoa, "Maria Santos");

        Field campoEmpresa = clazz.getDeclaredField("empresa");
        campoEmpresa.setAccessible(true);
        campoEmpresa.set(null, "xAI Research");

        System.out.println("Depois da modificação: " + pessoa);


        Constructor<?> construtor = clazz.getDeclaredConstructor(String.class, int.class);
        Pessoa novaPessoa = (Pessoa) construtor.newInstance("Pedro Costa", 25);
        System.out.println("pessoa criada via Reflection: " + novaPessoa);
    }
}