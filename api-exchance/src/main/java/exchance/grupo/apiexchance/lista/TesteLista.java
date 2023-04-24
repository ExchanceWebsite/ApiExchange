package exchance.grupo.apiexchance.lista;

import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteLista {
    public static void selectionSortOtimizado(EstudanteDTO[] vetor){
        EstudanteDTO auxiliar = new EstudanteDTO("Bia", 18,"Estudiosa e inteligente","ana@gmail.com","12345",
                "011954337632","46949092822");
        Integer contador = 0;
         int indMenor = 0;
        for ( int i=0; i< vetor.length-1; i++){
            indMenor = auxiliar.getIdade();
            for (int j=i + 1; j < vetor.length; j++){
                if (vetor[j] == vetor[indMenor]){
                    indMenor = j;
                    contador++;
                }
            }
            auxiliar = vetor[i];
            vetor[i] = vetor[indMenor];
            vetor[indMenor] = auxiliar;
        }
        for (int i=0; i < vetor.length; i++){
            System.out.print(vetor[i]);
        }
        System.out.print( "\n Ele trocou: " + contador + " vezes");
    }

    public static void main(String[] args) {

        ListaObj<EstudanteDTO> estudantes = new ListaObj<>(5);

        EstudanteDTO estudante1 = new EstudanteDTO("Ana", 25,"Estudiosa e inteligente","ana@gmail.com","12345",
                "011954337632","46949092822");

        EstudanteDTO estudante2 = new EstudanteDTO("Jose", 30,"Estudiosa e inteligente","ana@gmail.com","12345",
                "011954337632","46949092822");

        estudantes.adiciona(estudante1);

        estudantes.adiciona(estudante2);

        estudantes.exibe();

        estudantes.getTamanho();

        System.out.println("------------------------------------------------------------------");

      //  selectionSortOtimizado(new EstudanteDTO[]{estudantes});




    }

}
