package exchance.grupo.apiexchance.lista;

import jakarta.xml.bind.SchemaOutputResolver;

public class PesquisaBinaria {

    public static Integer buscar() {
        int[] vetor = {35, 18, 20, 01, 50, 23};
        int x = 18;

        int inicio = 0;
        int fim = vetor.length - 1;
        do {
            int meio = (inicio + fim) / 2;
            if (x == vetor[meio]) {
                return meio;
            } else {
                if (x < vetor[meio]) {
                    fim = meio - 1;
                } else {
                    inicio = meio + 1;
                }
            }
        }
        while (inicio <= fim);
        return -1;
    }


    public static int main(String[] args) {

        int resultados = buscar();

        System.out.println(resultados);

        return resultados;
    }

}