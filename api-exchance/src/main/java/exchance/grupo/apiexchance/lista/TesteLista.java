package exchance.grupo.apiexchance.lista;

import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;

public class TesteLista {
    public static void selectionSort(ListaObj<EstudanteDTO> vetor) {

        EstudanteDTO aux;

        for (int i=0; i < vetor.getTamanho() -1; i++){
            int indMenor = i;
            for (int j=i +1; j< vetor.getTamanho(); j++){
                if (vetor.getElemento(j).getIdade() < vetor.getElemento(indMenor).getIdade()){
                    indMenor = j;
                }
            }
            aux = vetor.getElemento(i);
            vetor.setElemento(i, vetor.getElemento(indMenor));
            vetor.setElemento(indMenor,aux);
        }
        for (int i=0; i < vetor.getTamanho(); i++){
            System.out.println(vetor.getElemento(i));
        }

    }

    public static void main(String[] args) {

        ListaObj<EstudanteDTO> estudantes = new ListaObj<>(5);

        EstudanteDTO estudante1 = new EstudanteDTO("Ana", 25,"Estudiosa e inteligente","ana@gmail.com","12345",
                "011954337632","46949092822");

        EstudanteDTO estudante2 = new EstudanteDTO("Jose", 30,"Estudioso e inteligente","ana@gmail.com","12345",
                "011954337632","46949092822");

        EstudanteDTO estudante3 = new EstudanteDTO("Lana", 18,"Estudiosa","ana@gmail.com","12345",
                "011954337632","46949092822");

        estudantes.adiciona(estudante1);

        estudantes.adiciona(estudante2);

        estudantes.adiciona(estudante3);

        estudantes.exibe();

       // estudantes.getTamanho();

        System.out.println("------------------------------------------------------------------");

       selectionSort(estudantes);




    }

}
