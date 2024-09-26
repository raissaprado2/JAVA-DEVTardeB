package com.example;

import lombok.Setter;

@AllArgsConstructor


public class Pessoa {
    private String nome;
    private String cpf;

    //exibirinformações
    public String exibirInfo(){
        return "Nome "+nome+" cpf "+cpf;
    }
}
