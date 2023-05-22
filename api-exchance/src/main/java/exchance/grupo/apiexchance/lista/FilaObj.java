package exchance.grupo.apiexchance.lista;

public class FilaObj<T> {
    // Atributos
    private int tamanho;
    private T[] fila;

    // Construtor
    public FilaObj(int capacidade) {
        this.fila = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        return tamanho == 0;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return tamanho == fila.length;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Lançar IllegalStateException caso a fila esteja cheia
     */
    public void insert(T info) {
        if (isFull()){
            throw new IllegalStateException("Fila cheia!");
        }

        fila[tamanho++] = info;
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public T peek() {
        if (isEmpty()){
            return null;
        }
        return fila[0];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
       Depois que a fila andar, "limpar" o ex-último elemento da fila, atribuindo null
     */
    public T poll() {
        if (isEmpty()){
            return null;
        }

        T inicio = fila[0];

        for (int i = 0; i < tamanho - 1; i++){

            fila[i] = fila[i + 1];
        }

        tamanho--;
        fila[tamanho] = null;

        return inicio;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {

        for (int i = 0; i < tamanho; i++){
            System.out.print(fila[i]+" | ");
        }

    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho(){
        return this.tamanho;
    }
}

