import java.util.Scanner;

public class Estudante {
    private String primeiroNome;
    private String ultimoNome;
    private int anoEscolar;
    private String estudanteID;
    private String cursos = "";
    private int saldoMensalidade = 0;
    private int troco = 0;
    private static int custoCurso = 600;
    private static int id = 1000;

    // Construtor: incita o usuário a inserir o nome e o ano do Estudante
    public Estudante() {
        Scanner em = new Scanner(System.in);
        System.out.println("\nInsira o primeiro nome do estudante: ");
        this.primeiroNome = em.nextLine();

        System.out.println("\nInsira o último nome do estudante: ");
        this.ultimoNome = em.nextLine();

        System.out.println("\nNÍVEL ESTUDANTIL:\n 1 - Calouro\n 2 - Segundo ano\n 3 - Júnior\n 4 - Veterano\nInsira a classe do estudante: ");
        this.anoEscolar = em.nextInt();

        ajustaEstudanteID();

        System.out.println("\n" + primeiroNome + " " + ultimoNome + " - " + anoEscolar + "° ano - " + estudanteID);
    }

    // Gerar ID

    private void ajustaEstudanteID() {
        // Grau estudantil + ID
        id++;
        this.estudanteID = anoEscolar + "" + id;
    }

    public void matricula() {
        while (true) {
            System.out.println("\nInsira o curso para se matricular (ou pressione 'S' para sair): ");
            Scanner em = new Scanner(System.in);
            String curso = em.nextLine();
            if (!curso.equals("S")) {
                cursos = cursos + "\n  " + curso;
                saldoMensalidade = saldoMensalidade + custoCurso;
            }
            else {
                break;
            }
        }
    }

    // Ver saldo
    public void verSaldo() {
        System.out.println("\nTotal a pagar: R$" + saldoMensalidade + "\n");
    }

    public void verTroco() {
        System.out.println("Seu troco de R$" + troco + " foi extornado.");
    }

    // Pagamento de Mensalidade
    public void pagamentoMensalidade() {
        verSaldo();
        System.out.println("Insira seu pagamento: R$");
        Scanner em = new Scanner(System.in);
        int pagamento = em.nextInt();
        saldoMensalidade = saldoMensalidade - pagamento;
        System.out.println("\nObrigado pelo seu pagamento de R$" + pagamento);
        if (saldoMensalidade<0) {
            troco = saldoMensalidade * -1;
            saldoMensalidade = 0;
            verTroco();
        }
        else verSaldo();
    }

    // Mostra o status
    public String mostraInfo() {
        return "\nNome: " + primeiroNome + " " + ultimoNome +
                "\nGrade escolar: " + anoEscolar +
                "\nCursos matriculados: " + cursos +
                "\nID do(a) Estudante: " + estudanteID +
                "\nValor restante a se pagar: R$" + saldoMensalidade;
    }

}
