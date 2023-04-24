package exchance.grupo.apiexchance.lista;

import java.util.List;

public class ListaObj <Estudantes> {

    private Estudantes[] vetor;
    private int nroElem;

    public ListaObj(int tamanho) {
        vetor = (Estudantes[]) new Object[tamanho];
        nroElem = 0;
    }

    public void adiciona(Estudantes elemento) {
        if (nroElem >= vetor.length) {
            System.out.println("Lista cheia!");;
        }
        else {
            vetor[nroElem++] = elemento;
        }
    }

    public int busca(Estudantes elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removePeloIndice (int indice) {
        if (indice < 0 || indice >= nroElem) {
            System.out.println("\nÍndice inválido!");
            return false;
        }

        for (int i = indice; i < nroElem-1; i++) {
            vetor[i] = vetor[i+1];
        }

        nroElem--;
        return true;
    }

    public boolean removeElemento(Estudantes elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    public int getTamanho() {
        return nroElem;
    }

    public Estudantes getElemento(int indice) {
        if (indice < 0 || indice >= nroElem) {
            return null;
        }
        else {
            return vetor[indice];
        }
    }

    public void limpa() {
        nroElem = 0;
    }

    public void exibe() {
        if (nroElem == 0) {
            System.out.println("\nA lista está vazia.");
        }
        else {
            System.out.println("\nElementos da lista:");
            for (int i = 0; i < nroElem; i++) {
                System.out.println(vetor[i]);
            }
        }
    }

}
