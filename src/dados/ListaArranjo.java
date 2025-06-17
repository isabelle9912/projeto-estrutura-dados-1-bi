package dados;


/**
 * Implementação de uma Lista usando um arranjo (array) de Objects.
 * Esta classe é generalista e possui capacidade de alocação dinâmica.
 */
public class ListaArranjo implements Lista {

    // O arranjo que armazena os elementos. Começa com 20 posições.
    private Object[] elementos;
    // Atributo que controla o número de elementos realmente na lista.
    private int tamanho;

    /**
     * Construtor padrão. Inicializa a lista com uma capacidade inicial.
     */
    public ListaArranjo() {
        this.elementos = new Object[20]; // Capacidade inicial de 20 posições
        this.tamanho = 0;
    }

    /**
     * Método privado que dobra a capacidade do arranjo quando ele está cheio.
     * Este método garante a alocação dinâmica de espaço.
     */
    private void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] novosElementos = new Object[this.elementos.length * 2];
            // Copia os elementos do arranjo antigo para o novo.
            for (int i = 0; i < this.tamanho; i++) {
                novosElementos[i] = this.elementos[i];
            }
            this.elementos = novosElementos;
        }
    }

    @Override
    public void adiciona(Object elemento) {
        this.aumentaCapacidade(); // Garante que há espaço antes de adicionar
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    @Override
    public void adiciona(int posicao, Object elemento) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }

        this.aumentaCapacidade();

        // Desloca os elementos para a direita para abrir espaço
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }

        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    @Override
    public Object pega(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }
        return this.elementos[posicao];
    }

    @Override
    public void remove(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida.");
        }

        // Desloca os elementos para a esquerda para cobrir a posição removida
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }

        this.tamanho--;
        this.elementos[this.tamanho] = null; // Limpa a última posição
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public int busca(Object elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            // Usa .equals() para comparar os objetos
            if (this.elementos[i] != null && this.elementos[i].equals(elemento)) {
                return i; // Retorna o índice se encontrar
            }
        }
        return -1; // Retorna -1 se não encontrar
    }

    @Override
    public void limpa() {
        // Opcional: remover referências para ajudar o Garbage Collector
        for (int i = 0; i < this.tamanho; i++) {
            this.elementos[i] = null;
        }
        this.tamanho = 0; // Apenas resetar o tamanho já é suficiente funcionalmente
    }

    @Override
    public void inverte() {
        // Usa a abordagem de dois ponteiros para inverter a lista no lugar
        for (int i = 0; i < this.tamanho / 2; i++) {
            int j = this.tamanho - 1 - i;
            Object temp = this.elementos[i];
            this.elementos[i] = this.elementos[j];
            this.elementos[j] = temp;
        }
    }

    @Override
    public void adicionaTodos(Lista outra) {
        for (int i = 0; i < outra.tamanho(); i++) {
            this.adiciona(outra.pega(i));
        }
    }

    /**
     * Representação em String da lista (útil para depuração).
     */
    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            sb.append(this.elementos[i]);
            sb.append(", ");
        }
        sb.append(this.elementos[this.tamanho - 1]);
        sb.append("]");

        return sb.toString();
    }
}