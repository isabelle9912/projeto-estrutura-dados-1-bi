package dados;

// Responsabilidade: Implementar a interface Lista usando um array.
public class ListaArranjo implements Lista {
    private Object[] elementos;
    private int tamanho;

    public ListaArranjo(int tamanho) {
        elementos = new Object[tamanho];
        this.tamanho = tamanho;
    }

    private void aumentaCapacidade(){

    }

    @Override
    public void adiciona(Object elemento) {

    }

    @Override
    public void adiciona(int pos, Object elemento) {

    }

    @Override
    public Object pega(int posicao) {
        return null;
    }

    @Override
    public void remove(int posicao) {

    }

    @Override
    public int tamanho() {
        return 0;
    }

    @Override
    public int busca(Object elemento) {
        return 0;
    }

    @Override
    public void limpa() {

    }

    @Override
    public void inverte() {

    }

    @Override
    public void adicionaTodos(Lista outra) {

    }
}
