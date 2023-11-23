package AtividadeFormativa;

import java.util.Random;
import java.util.Scanner;

public class AtividadeFormativa {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    public void atividade1() {
        
        System.out.println("Por favor dígite o número de colunas desejadas:");
        int col= sc.nextInt();
        System.out.println("Por favor dígite o número de Linhas desejadas");
        int row= sc.nextInt();
        
        int tab[][] = new int[col][row];

        for(int i = 0; i<col; i++){
            for (int j = 0; j < row; j++){
                tab[i][j] = rd.nextInt(9);
            }
        }
        for (int i = 0; i < col; i++){
            System.out.print(" |  ");
            for (int j = 0; j < row; j++) {
                System.out.print(+tab[i][j] + " ");
            }
            System.out.println(" | ");
        }
        System.out.println("==================");
        for (int i = 0; i < col; i++){
        for (int j = 0; j < row; j++){
            tab[i][j] = rd.nextInt(9);
            if(i > j) {
                tab[i][j] = 1;
            }
            if(i == j) {
                tab[i][j] = 0;
            }
            if(i < j) {
                tab[i][j] = 2;
            }
            
        }
        }
        for (int i = 0; i < col; i++){
            System.out.print(" | ");
            for (int j = 0; j < row; j++){
                System.out.print(+tab[i][j]+" ");
            }
            System.out.println(" | ");

        }
    
    
}
    public void atividade2() {
        Random rd = new Random();
        int cont = 1;
        int valorSorteado = rd.nextInt(1000);
        boolean tenteNovamente = true;
        while (tenteNovamente) {
            System.out.println("Digite um Nº");
            int nDigitado = sc.nextInt();
            if (nDigitado == valorSorteado) {
                System.out.println("Acertouuuuuuuuuuuuu!!!!!!");
                System.out.println("Números de tentativas: " + cont);
                tenteNovamente = false;
            } else if (nDigitado > valorSorteado) {
                System.out.println("O valor sorteado é menor do que o número digitado");
                cont++; 
            } else if (nDigitado < valorSorteado) {
                System.out.println("O valor sorteado é maior que o número digitado");
                cont++;
            }
        }
    }

    public void atividade3(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int tamanho = random.nextInt(900) + 100; // Sorteia o tamanho entre 100 e 1000
        int[] vetor = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetor[i] = random.nextInt(100) + 1; // Gera um número entre 1 e 100
        }

        System.out.println("Vetor gerado:");
        listarVetor(vetor);

        System.out.println("\nNúmeros pares do vetor:");
        exibirNumerosPares(vetor);

        System.out.println("\nNúmeros ímpares do vetor:");
        exibirNumerosImpares(vetor);

        System.out.println("\nQuantidade de números pares nas posições ímpares do vetor:");
        int paresNasPosicoesImpares = contarParesNasPosicoesImpares(vetor);
        System.out.println(paresNasPosicoesImpares);

        System.out.println("\nQuantidade de números ímpares nas posições pares do vetor:");
        int imparesNasPosicoesPares = contarImparesNasPosicoesPares(vetor);
        System.out.println(imparesNasPosicoesPares);
        
        scanner.close();
    }

    public static void listarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
    }

    public static void exibirNumerosPares(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                System.out.print(vetor[i] + " ");
            }
        }
    }

    public static void exibirNumerosImpares(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 != 0) {
                System.out.print(vetor[i] + " ");
            }
        }
    }

    public static int contarParesNasPosicoesImpares(int[] vetor) {
        int contador = 0;
        for (int i = 1; i < vetor.length; i += 2) {
            if (vetor[i] % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }

    public static int contarImparesNasPosicoesPares(int[] vetor) {
        int contador = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            if (vetor[i] % 2 != 0) {
                contador++;
            }
        }
        return contador;
    }
}