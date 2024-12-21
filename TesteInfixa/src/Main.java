import java.util.Scanner;

public class Main {

    /*
    Construir um programa de uma calculadora funcional com as 4 operações básicas.
    Realizar o cálculo e após o cálculo apresentar a expressão nas três notações.
     */

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Scanner op = new Scanner(System.in);
        String expressao;
        int opcao;

        System.out.println("Selecione o tipo da operação:\n1 - Infixa\n2 - Pós-fixa\n3 - Pré-fixa");
        opcao = op.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Informe a expressão infixa: ");
                expressao = ler.nextLine().replace(" ", "");

                int resultado = Calculadora.calcular(Posfixa.conversao(expressao));

                System.out.println("\n--- Resultado ---\n* Infixa: " + expressao + "\n* Pós-fixa-fixa (notação polonesa reversa): " + Posfixa.conversao(expressao) + "\n* Pre-fixa (notação polonesa): " + Prefixa.posfixaParaPrefixa(Posfixa.conversao(expressao)) + "\n* Resultado do cálculo: " + resultado);
                break;

            case 2:

                System.out.println("Informe a expressão Pós-fixa: ");
                expressao = ler.nextLine().replace(" ", "");

                int resultado2 = Calculadora.calcular(expressao);

                System.out.println("\n--- Resultado ---\n* Infixa: " + PosParaInfixa.posFixaParaInfixa(expressao) + "\n* Pós-Fixa (notação polonesa reversa): " + expressao + "\n* Pre-fixa (notação polonesa): " + Prefixa.posfixaParaPrefixa(expressao) + "\n* Resultado do cálculo: " + resultado2);
                break;

            case 3:

                System.out.println("Informe a expressão Pré-fixa: ");
                expressao = ler.nextLine().replace(" ", "");

                int resultado3 = Calculadora.calcular(Posfixa.conversao(PrefixaParaInfixa.convertePrefixaEmInfixa(expressao)));


                System.out.println("\n--- Resultado ---\n* Infixa: " + PrefixaParaInfixa.convertePrefixaEmInfixa(expressao) + "\n* Pós-Fixa (notação polonesa reversa): " + Posfixa.conversao(PrefixaParaInfixa.convertePrefixaEmInfixa(expressao)) + "\n* Pre-fixa (notação polonesa): " + expressao + "\n* Resultado do cálculo: " + resultado3);

                break;

            default:
                System.out.println("Operação Inválida");
                break;
        }


    }
}
