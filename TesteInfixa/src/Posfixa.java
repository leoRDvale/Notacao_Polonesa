import java.util.Stack;

public class Posfixa {

    public static int prioridade(char elemento) {
        int prioridade;
        switch (elemento) {
            case '+':
            case '-':
                prioridade = 1;
                break;

            case '*':
            case '/':
                prioridade = 2;
                break;

            default:
                prioridade = 0;
                break;
        }

        return prioridade;

    }

    public static String conversao(String infixa) {
        String posfixa = "";
        Stack<Integer> pilha = new Stack<Integer>();
        int i = 0;
        char c;

        while (i < infixa.length()) {
            c = infixa.charAt(i);
            switch (c) {
                case '*':
                case '/':
                case '+':
                case '-':
                    while ((!pilha.empty()) && prioridade(c) <= prioridade((char) ((int) pilha.peek())))
                        posfixa += (char) ((int) pilha.pop());

                    pilha.add((int) c);
                    break;

                case '(':
                    pilha.add((int) c);
                    break;

                case ')':
                    while ((char) ((int) pilha.peek()) != '(')
                        posfixa += (char) ((int) pilha.pop());

                    if ((char) ((int) pilha.peek()) == '(')
                        pilha.pop();
                    break;

                default:
                    posfixa += infixa.charAt(i);
                    break;
            }
            i++;
        }
        while (!pilha.isEmpty())
            if ((char) ((int) pilha.peek()) != '(')
                posfixa += (char) ((int) pilha.pop());
            else
                pilha.pop();

        return posfixa;
    }



}
