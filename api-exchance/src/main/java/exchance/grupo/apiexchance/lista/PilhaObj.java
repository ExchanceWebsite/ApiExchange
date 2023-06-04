package exchance.grupo.apiexchance.lista;

import exchance.grupo.apiexchance.entidade.Reserva;
import org.springframework.stereotype.Component;

@Component
public class PilhaObj<T> {

    private static final int capacidade = 50;
    private T[] pilha;
    private int topo;

    public PilhaObj() {
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

    public T  pop() {
        if (isEmpty()){
            throw new RuntimeException("A pilha está vazia!");
        }
        T elemento = pilha[topo];
        topo--;
        return elemento;

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
