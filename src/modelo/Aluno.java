package modelo;
// Responsabilidade: Representar um único aluno.
public class Aluno {
    private String nome;
    private String matricula;
    private Boolean presente;

    public Aluno(String nome, String matricula, Boolean presente) {
        setNome(nome);
        setMatricula(matricula);
        setPresente(presente);
    }

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

    public Boolean getPresente() {
        return presente;
    }

    public void setPresente(Boolean presente) {
        this.presente = presente;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + '\'' +
                ", Matrícula: " + getMatricula() + '\'' +
                ", Presente: " + (getPresente() ? "Presente" : "Ausente");
    }
}
