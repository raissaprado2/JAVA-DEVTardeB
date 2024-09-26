package com.example;


public class ArraysasListExemplo {
    private String[] nomes = {"Maria", "João", "Pedro"};
    private List<String> nomesList;

    public ArraysasListExemplo() {
        nomesList = new ArrayList<>(Arrays.asList(nomes));
    }

    //adicionar no Array
    public void addArray(String nome){
        try {
            nomes[3] = nome;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
 }
