import java.util.Stack;

public class Calculadora {

    //Calcula valores Posfixos!!!!

    public static int calcular(String expressao) {
        // cria pilha para armazenar operandos

        Stack<Integer> pilha = new Stack<>();

        // Percorrer cada caractere da expressão pós-fixa

        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            // Se o caractere for um número, empilhamos ele
            if (Character.isDigit(c)) {
                pilha.push(c - '0');  // Converte o caractere para o número inteiro
            }
            // Se o caractere for um operador
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                // Desempilha dois operandos
                int b = pilha.pop();
                int a = pilha.pop();

                // Realiza a operação e empilha o resultado
                switch (c) {
                    case '+':
                        pilha.push(a + b);
                        break;
                    case '-':
                        pilha.push(a - b);
                        break;
                    case '*':
                        pilha.push(a * b);
                        break;
                    case '/':
                        pilha.push(a / b);
                        break;
                }
            }
        }

        // O que restar na pilha é o resultado da expressão

        return pilha.pop();

    }
}
