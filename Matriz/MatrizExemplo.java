package Matriz;

import java.util.Random;
import java.util.Scanner;

public class MatrizExemplo {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void exemplo1() {
        // criar preencher e manipular a matriz
        // declarar a matriz
        int matriz[][]= new int[10][9];//2 dimensões
        //preencher a minha matriz 
        for (int i=0; i<10;i++){//1° dimensão
            for(int j=0;j<9;j++){//2° dimensão
                System.out.println("matriz["+i+"]["+j+"]=");
                matriz[i][j]=rd.nextInt(bound:9);//usando random

            }

        }
        //impressão dos elementos da matriz individual 
        for(int j=0;j<matriz[0].length;j++){//2° dimensão
            System.out.println("matriz["+i+"]["+j+"]="
            +matriz[i][j]);

        }
        //imprimir em formato de matriz10x9
        for (int i = 0 ; i<matriz.length;i++){
            System.out.println(s:"|");
            for(int j=0;j< matriz[0].length;j++){
                System.out.println(matriz[i][j]+"");
            }
            System.out.println("|");
        }
        //somar todos os elementos da 4° linha
        int somaLinha = 0;
        for(int i = 0; i < matriz[3].length;i++){
            somaLinha += matriz[3][i];
        }
        System.out.println("a soma da linha é"+somaLinha);

        //somar todos os elementos da 4° coluna
        int somaColuna = 0;
        for (int i = 0;i< matriz.length;i++){
            somaColuna += matriz [i][3];
        }
        System.out.println(" a soma da 4° coluna é"+somaColuna);
    }
    public void exercicio1(){
        //declarar uma matriz 5x5 
        int matriz
    }
    public void exercicio2() {
        
    }
}

    