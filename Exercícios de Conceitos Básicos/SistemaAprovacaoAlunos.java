import java.util.Scanner;

public class SistemaAprovacaoAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double somaNotas = 0;
        boolean todosNotasAltas = true;

        // Captura das notas
        for (int i = 0; i < notas.length; i++) {
            while (true) {
                System.out.print("Digite a nota da disciplina " + (i + 1) + " (entre 0 e 10): ");
                if (scanner.hasNextDouble()) {
                    double nota = scanner.nextDouble();
                    if (nota >= 0 && nota <= 10) {
                        notas[i] = nota;
                        somaNotas += nota;
                        if (nota <= 9) {
                            todosNotasAltas = false;
                        }
                        break;
                    } else {
                        System.out.println("Nota inválida! Deve estar entre 0 e 10.");
                    }
                } else {
                    System.out.println("Entrada inválida! Digite um número.");
                    scanner.next(); // Limpar a entrada inválida
                }
            }
        }

        // Calcular a média
        double media = somaNotas / notas.length;

        // Aplicar bônus se necessário
        if (todosNotasAltas) {
            media *= 1.10; // Aplicar bônus de 10%
        }

        // Determinar o status do aluno
        String status;
        if (media >= 7) {
            status = "Aprovado";
        } else if (media >= 5) {
            status = "Recuperação";
        } else {
            status = "Reprovado";
        }

        // Exibir resultado
        System.out.printf("Média final: %.2f%n", media);
        System.out.println("Status: " + status);

        scanner.close();
    }
}
