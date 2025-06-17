import dados.Lista;
import dados.ListaArranjo;
import modelo.Aluno;
import modelo.Turma;

/**
 * Classe de testes manuais para validar o funcionamento das classes ListaArranjo e Turma.
 * Execute o método main para rodar todos os testes.
 */
public class TestesUnitarios {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO BATERIA DE TESTES ---\n");
        testarListaArranjo();
        System.out.println("\n---------------------------------------\n");
        testarTurma();
        System.out.println("\n--- FIM DA BATERIA DE TESTES ---");
    }

    /**
     * Valida todas as operações da nossa estrutura de dados ListaArranjo.
     */
    public static void testarListaArranjo() {
        System.out.println(">>> INICIANDO TESTES DA CLASSE ListaArranjo <<<");

        // Objetos de teste
        Aluno a1 = new Aluno("Levi", "111");
        Aluno a2 = new Aluno("Ana", "222");
        Aluno a3 = new Aluno("Bia", "333");

        // Teste 1: Inicialização e tamanho
        Lista lista = new ListaArranjo();
        System.out.println("1.1 - Tamanho inicial da lista: " + status(lista.tamanho() == 0));

        // Teste 2: Adicionar elementos e verificar tamanho
        lista.adiciona(a1);
        lista.adiciona(a2);
        System.out.println("2.1 - Tamanho após adicionar 2 elementos: " + status(lista.tamanho() == 2));

        // Teste 3: Recuperar elementos com pega()
        System.out.println("3.1 - Pega elemento da posição 0: " + status(lista.pega(0).equals(a1)));
        System.out.println("3.2 - Pega elemento da posição 1: " + status(lista.pega(1).equals(a2)));

        // Teste 4: Adicionar em posição específica
        lista.adiciona(0, a3); // Adiciona "Bia" no início
        System.out.println("4.1 - Tamanho após adicionar na posição 0: " + status(lista.tamanho() == 3));
        System.out.println("4.2 - Verifica se o novo elemento está na posição 0: " + status(lista.pega(0).equals(a3)));
        System.out.println("4.3 - Verifica se o elemento antigo foi deslocado: " + status(lista.pega(1).equals(a1)));

        // Teste 5: Remover de posição específica
        lista.remove(1); // Remove "Levi"
        System.out.println("5.1 - Tamanho após remover elemento da posição 1: " + status(lista.tamanho() == 2));
        System.out.println("5.2 - Verifica se o elemento correto foi removido: " + status(lista.pega(1).equals(a2)));

        // Teste 6: Busca de elemento
        lista.adiciona(a1); // Adiciona "Levi" de volta no final. Lista agora é [Bia, Ana, Levi]
        System.out.println("6.1 - Busca por 'Ana' (a2): " + status(lista.busca(a2) == 1));
        System.out.println("6.2 - Busca por elemento inexistente: " + status(lista.busca(new Aluno("Zoe", "999")) == -1));

        // Teste 7: Alocação dinâmica (capacidade inicial é 20)
        for (int i = 0; i < 20; i++) {
            lista.adiciona(new Aluno("Aluno " + i, "mat" + i));
        }
        System.out.println("7.1 - Alocação dinâmica (deve rodar sem erro): " + status(lista.tamanho() == 23));

        // Teste 8: Limpar a lista
        lista.limpa();
        System.out.println("8.1 - Limpar a lista: " + status(lista.tamanho() == 0));

        // Teste 9: Inverter lista
        lista.adiciona(a1);
        lista.adiciona(a2);
        lista.adiciona(a3); // Lista: [Levi, Ana, Bia]
        lista.inverte();
        System.out.println("9.1 - Inverter lista: " + status(lista.pega(0).equals(a3) && lista.pega(2).equals(a1)));

        // Teste 10: Adicionar todos
        Lista outraLista = new ListaArranjo();
        outraLista.adiciona(new Aluno("Carlos", "444"));
        lista.adicionaTodos(outraLista); // Lista agora é [Bia, Ana, Levi, Carlos]
        System.out.println("10.1 - Adicionar todos: " + status(lista.tamanho() == 4 && lista.pega(3).toString().contains("Carlos")));
    }

    /**
     * Valida as operações da classe Turma, que encapsula a lógica de negócio.
     */
    public static void testarTurma() {
        System.out.println(">>> INICIANDO TESTES DA CLASSE Turma <<<");

        Turma turma = new Turma();
        Aluno a1 = new Aluno("João", "joao123");
        Aluno a2 = new Aluno("Maria", "maria456");

        // Teste 1: Adicionar e buscar aluno
        turma.adicionarAluno(a1);
        turma.adicionarAluno(a2);
        System.out.println("1.1 - Buscar aluno existente: " + status(turma.buscarAluno("joao123").getNome().equals("João")));
        System.out.println("1.2 - Buscar aluno inexistente: " + status(turma.buscarAluno("xyz789") == null));

        // Teste 2: Marcar presença
        turma.marcarPresenca("maria456");
        System.out.println("2.1 - Marcar presença: " + status(turma.buscarAluno("maria456").isPresente()));
        System.out.println("2.2 - Verificar se o outro aluno continua ausente: " + status(!turma.buscarAluno("joao123").isPresente()));

        // Teste 3: Listar presentes
        Lista presentes = turma.listarPresentes();
        System.out.println("3.1 - Listar presentes (tamanho): " + status(presentes.tamanho() == 1));
        System.out.println("3.2 - Listar presentes (conteúdo): " + status(presentes.pega(0).equals(a2)));

        // Teste 4: Remover aluno
        turma.removerAluno("joao123");
        System.out.println("4.1 - Remover aluno: " + status(turma.buscarAluno("joao123") == null));

        // Teste 5: Transferir turma
        Turma turmaB = new Turma();
        turmaB.adicionarAluno(new Aluno("Pedro", "pedro789"));
        turma.transferirTurma(turmaB);
        System.out.println("5.1 - Transferir turma (aluno transferido existe na turma principal): " + status(turma.buscarAluno("pedro789") != null));
        System.out.println("5.2 - Transferir turma (turma de origem ficou vazia): " + status(turmaB.toString().contains("vazia")));
    }

    /**
     * Helper para formatar o resultado do teste.
     * @param condicao a condição de sucesso do teste.
     * @return "OK" se a condição for verdadeira, "FALHOU" caso contrário.
     */
    private static String status(boolean condicao) {
        return condicao ? "OK" : "FALHOU";
    }
}
