import java.util.Stack;

public class Prefixa {


        // verifica se é um operado

        public static boolean eOperador(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }

        // converte a expressão posfixa para prefixa

        public static String posfixaParaPrefixa(String expressaoPosfixa) {
            Stack<String> pilha = new Stack<>();

            // Itera sobre cada caractere da expressão posfixa
            for (int i = 0; i < expressaoPosfixa.length(); i++) {
                char simbolo = expressaoPosfixa.charAt(i);

                // Se for operando, empilha
                if (!eOperador(simbolo)) {
                    pilha.push(String.valueOf(simbolo));
                } else {
                    // Se for operador, desempilha dois operandos e empilha a expressão prefixa
                    String operando2 = pilha.pop();
                    String operando1 = pilha.pop();
                    String expressaoPrefixa = simbolo + operando1 + operando2;
                    pilha.push(expressaoPrefixa);
                }
            }

            // O resultado vai para topo da pilha

            return pilha.pop();

        }
    }


