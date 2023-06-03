package exchance.grupo.apiexchance.lista;

public class PilhaObj<T> {

    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        this.topo = -1;
        this.pilha = (T[]) new Object[capacidade];

    }

    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        return topo == pilha.length -1;
    }

    public void push(T info) {
        if (topo +1 == pilha.length){
            throw new IllegalStateException("Pilha cheia!");
        }
        pilha[++topo] = info;

    }

    public T pop() {
        if (isEmpty()){
            System.out.println("Pilha vazia!");
        }
        return pilha[topo--];

    }

    public T peek() {
        if (isEmpty()){
            System.out.println("Pilha vazia!");
        }
        return pilha[topo];
    }

    public void exibe() {
        for (int i=0; i< pilha.length; i++){
            System.out.println(pilha[i]);
        }
    }

}
