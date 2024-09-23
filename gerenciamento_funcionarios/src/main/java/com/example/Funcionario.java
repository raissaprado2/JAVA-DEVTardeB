package com.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class Funcionario {
    //atributos
    private String nome;
    private int idade;
    private double salario;

    //método
    @Override
    public String toString() {
        return "nome "+nome +", Idade "+idade +", salario "+salario;
    }
}
