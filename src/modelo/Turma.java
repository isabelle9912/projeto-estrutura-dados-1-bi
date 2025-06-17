package modelo;

import dados.Lista;
import dados.ListaArranjo;

/**
 * Classe que gerencia uma turma de alunos, utilizando uma ListaArranjo para armazenamento.
 */
public class Turma {

    private Lista alunos;

    public Turma() {
        // A Turma usa a implementação ListaArranjo para guardar seus alunos
        this.alunos = new ListaArranjo();
    }

    /**
     * Adiciona um aluno à turma.
     */
    public void adicionarAluno(Aluno aluno) {
        // Validação simples para não adicionar alunos com mesma matrícula
        if (this.buscarAluno(aluno.getMatricula()) == null) {
            this.alunos.adiciona(aluno);
            System.out.println("Aluno " + aluno.getNome() + " cadastrado com sucesso.");
        } else {
            System.out.println("Erro: Já existe um aluno com a matrícula " + aluno.getMatricula());
        }
    }

    /**
     * Remove um aluno da turma pela matrícula.
     * @return true se o aluno foi removido, false caso contrário.
     */
    public boolean removerAluno(String matricula) {
        for (int i = 0; i < this.alunos.tamanho(); i++) {
            Aluno aluno = (Aluno) this.alunos.pega(i);
            if (aluno.getMatricula().equals(matricula)) {
                this.alunos.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Busca e retorna um aluno pela matrícula.
     * @return O objeto Aluno se encontrado, ou null se não existir.
     */
    public Aluno buscarAluno(String matricula) {
        for (int i = 0; i < this.alunos.tamanho(); i++) {
            Aluno aluno = (Aluno) this.alunos.pega(i);
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    /**
     * Marca a presença de um aluno.
     * @return true se a presença foi marcada, false se o aluno não foi encontrado.
     */
    public boolean marcarPresenca(String matricula) {
        Aluno aluno = this.buscarAluno(matricula);
        if (aluno != null) {
            aluno.setPresente(true);
            return true;
        }
        return false;
    }

    /**
     * Retorna uma nova lista contendo apenas os alunos presentes.
     */
    public Lista listarPresentes() {
        Lista presentes = new ListaArranjo();
        for (int i = 0; i < this.alunos.tamanho(); i++) {
            Aluno aluno = (Aluno) this.alunos.pega(i);
            if (aluno.isPresente()) {
                presentes.adiciona(aluno);
            }
        }
        return presentes;
    }

    /**
     * Remove todos os alunos da turma.
     */
    public void limparTurma() {
        this.alunos.limpa();
    }

    /**
     * Transfere todos os alunos de uma outra turma para esta.
     * A outra turma ficará vazia após a operação.
     */
    public void transferirTurma(Turma outra) {
        // O método adicionaTodos da nossa ListaArranjo faz o trabalho pesado
        this.alunos.adicionaTodos(outra.alunos);
        outra.limparTurma();
    }

    /**
     * Retorna uma String formatada com a lista de todos os alunos da turma.
     */
    @Override
    public String toString() {
        if (this.alunos.tamanho() == 0) {
            return "A turma está vazia.";
        }

        StringBuilder sb = new StringBuilder("--- Lista de Alunos da Turma ---\n");
        for (int i = 0; i < this.alunos.tamanho(); i++) {
            sb.append(this.alunos.pega(i).toString()).append("\n");
        }
        return sb.toString();
    }
}