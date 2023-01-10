import java.util.Scanner;

public class EstudanteDBApp {
    public static void main(String[] args) {
        // Pergunta quantos estudantes quer-se adicionar
        System.out.println("Insira o número de novos estudantes a serem matrículados: ");
        Scanner em = new Scanner(System.in);
        int numEstudantes = em.nextInt();
        Estudante[] estudantes = new Estudante[numEstudantes];

        // Cria n número de novos estudantes
        for(int i = 0; i<numEstudantes; i++) {
            estudantes[i] = new Estudante();
            estudantes[i].matricula();
            estudantes[i].pagamentoMensalidade();
        }

        for(int n = 0; n<numEstudantes; n++) {
            System.out.println(estudantes[n].mostraInfo());
        }
    }
}