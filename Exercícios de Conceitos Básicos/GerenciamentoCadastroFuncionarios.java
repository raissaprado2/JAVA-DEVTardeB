import java.util.ArrayList;
import java.util.Scanner;

class Funcionario {
    String nome;
    int idade;
    double salario;

    Funcionario(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Salário: " + salario;
    }
}

public class GerenciamentoCadastroFuncionarios {
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nGerenciamento de Cadastro de Funcionários");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Listar Funcionários");
            System.out.println("4. Calcular Média Salarial");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após o número

            switch (opcao) {
                case 1:
                    adicionarFuncionario(scanner);
                    break;
                case 2:
                    removerFuncionario(scanner);
                    break;
                case 3:
                    listarFuncionarios();
                    break;
                case 4:
                    calcularMediaSalarial();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void adicionarFuncionario(Scanner scanner) {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a idade do funcionário: ");
        int idade = scanner.nextInt();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha após o número

        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado com sucesso.");
    }

    private static void removerFuncionario(Scanner scanner) {
        System.out.print("Digite o nome do funcionário a ser removido: ");
        String nome = scanner.nextLine();
        
        boolean encontrado = false;
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).nome.equalsIgnoreCase(nome)) {
                funcionarios.remove(i);
                System.out.println("Funcionário removido com sucesso.");
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private static void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    private static void calcularMediaSalarial() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        double somaSalarios = 0;
        for (Funcionario f : funcionarios) {
            somaSalarios += f.salario;
        }
        double mediaSalarial = somaSalarios / funcionarios.size();
        System.out.printf("Média Salarial: %.2f%n", mediaSalarial);
    }
}
