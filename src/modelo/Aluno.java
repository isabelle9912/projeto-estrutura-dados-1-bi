package modelo;

import java.util.Objects;

/**
 * Classe que representa um Aluno.
 * Contém atributos para nome, matrícula e status de presença.
 */
public class Aluno {

    private String nome;
    private String matricula;
    private boolean presente;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.presente = false; // Aluno começa como ausente por padrão
    }

    // --- Getters e Setters ---

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    // --- Métodos sobrescritos ---

    /**
     * Compara dois objetos Aluno com base na matrícula, que é o identificador único.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(matricula, aluno.matricula);
    }

    /**
     * Gera um código hash com base na matrícula. Essencial para consistência com o equals().
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", matricula='" + matricula + '\'' +
                ", presente=" + (presente ? "sim" : "não") +
                '}';
    }
}
