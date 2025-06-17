package dados;

/**
 * Interface que define as operações essenciais de uma estrutura de dados do tipo Lista.
 *
 */
public interface Lista {

    /**
     * Adiciona um elemento ao final da lista.
     * @param elemento O objeto a ser adicionado.
     */
    void adiciona(Object elemento);

    /**
     * Adiciona um elemento em uma posição específica da lista.
     * @param posicao A posição onde o elemento será inserido.
     * @param elemento O objeto a ser adicionado.
     */
    void adiciona(int posicao, Object elemento);

    /**
     * Retorna o elemento em uma determinada posição.
     * @param posicao A posição do elemento a ser recuperado.
     * @return O elemento encontrado.
     */
    Object pega(int posicao);

    /**
     * Remove o elemento de uma determinada posição.
     * @param posicao A posição do elemento a ser removido.
     */
    void remove(int posicao);

    /**
     * Retorna o número de elementos presentes na lista.
     * @return O tamanho da lista.
     */
    int tamanho();

    /**
     * Busca por um elemento na lista.
     * @param elemento O elemento a ser buscado.
     * @return O índice da primeira ocorrência do elemento, ou -1 se não for encontrado.
     */
    int busca(Object elemento);

    /**
     * Remove todos os elementos da lista.
     */
    void limpa();

    /**
     * Inverte a ordem dos elementos na lista.
     */
    void inverte();

    /**
     * Adiciona todos os elementos de outra lista a esta lista.
     * @param outra A lista cujos elementos serão adicionados.
     */
    void adicionaTodos(Lista outra);
}