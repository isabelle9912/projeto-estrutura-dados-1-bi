import modelo.Aluno;
import modelo.Turma;
import java.util.Scanner;

/**
 * Classe principal que executa o programa de controle de presença.
 * Exibe um menu e processa as opções do usuário.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Usa a classe Scanner para entrada de dados
        Turma turma = new Turma();
        int opcao = 0;

        System.out.println("Bem-vindo ao Sistema de Controle de Presença!");

        while (opcao != 9) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha pendente

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner, turma);
                    break;
                case 2:
                    marcarPresenca(scanner, turma);
                    break;
                case 3:
                    removerAluno(scanner, turma);
                    break;
                case 4:
                    consultarAluno(scanner, turma);
                    break;
                case 5:
                    System.out.println(turma.listarPresentes().toString());
                    break;
                case 6:
                    System.out.println(turma.toString());
                    break;
                case 7:
                    turma.limparTurma();
                    System.out.println("Todos os alunos foram removidos da turma.");
                    break;
                case 8:
                    transferirAlunos(turma);
                    break;
                case 9:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println(); // Linha em branco para espaçamento
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("--- MENU ---");
        System.out.println("1. Cadastrar aluno");
        System.out.println("2. Marcar presença de aluno");
        System.out.println("3. Remover aluno da lista");
        System.out.println("4. Consultar aluno por matrícula");
        System.out.println("5. Listar todos os alunos presentes");
        System.out.println("6. Listar todos os alunos da turma");
        System.out.println("7. Limpar a turma");
        System.out.println("8. Transferir alunos (Exemplo)");
        System.out.println("9. Sair");
    }

    private static void cadastrarAluno(Scanner scanner, Turma turma) {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do aluno: ");
        String matricula = scanner.nextLine();
        turma.adicionarAluno(new Aluno(nome, matricula));
    }

    private static void marcarPresenca(Scanner scanner, Turma turma) {
        System.out.print("Digite a matrícula do aluno para marcar presença: ");
        String matricula = scanner.nextLine();
        if (turma.marcarPresenca(matricula)) {
            System.out.println("Presença marcada com sucesso.");
        } else {
            System.out.println("Erro: Aluno não encontrado.");
        }
    }

    private static void removerAluno(Scanner scanner, Turma turma) {
        System.out.print("Digite a matrícula do aluno a ser removido: ");
        String matricula = scanner.nextLine();
        if (turma.removerAluno(matricula)) {
            System.out.println("Aluno removido com sucesso.");
        } else {
            System.out.println("Erro: Aluno não encontrado.");
        }
    }

    private static void consultarAluno(Scanner scanner, Turma turma) {
        System.out.print("Digite a matrícula do aluno a ser consultado: ");
        String matricula = scanner.nextLine();
        Aluno aluno = turma.buscarAluno(matricula);
        if (aluno != null) {
            System.out.println("Aluno encontrado: " + aluno.toString());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void transferirAlunos(Turma turmaPrincipal) {
        System.out.println("--- Demonstração de Transferência ---");
        // Cria uma segunda turma temporária para a demonstração
        Turma turmaB = new Turma();
        turmaB.adicionarAluno(new Aluno("Carlos", "789"));
        turmaB.adicionarAluno(new Aluno("Daniela", "101"));

        System.out.println("Turma B (antes da transferência):");
        System.out.println(turmaB.toString());

        turmaPrincipal.transferirTurma(turmaB);

        System.out.println("\nTransferência realizada!");
        System.out.println("\nTurma B agora está vazia: " + turmaB.toString());
        System.out.println("\nTurma Principal (após receber os alunos):");
        System.out.println(turmaPrincipal.toString());
    }
}