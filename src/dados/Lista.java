package dados;

// Responsabilidade: Definir o "contrato" que uma lista deve seguir.
public interface Lista {
    void adiciona(Object elemento);
    void adiciona(int pos, Object elemento);
    Object pega(int posicao);
    void remove(int posicao);
    int tamanho();
    int busca(Object elemento);
    void limpa();
    void inverte();
    void adicionaTodos(Lista outra);
}
