import java.util.Stack;

public class PosParaInfixa {
    public static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    // Converte a expressão pós-fixa para infixa
    public static String posFixaParaInfixa(String posfixa) {
        Stack<String> stack = new Stack<>();

        // Percorre cada caractere da expressão pós-fixa
        for (int i = 0; i < posfixa.length(); i++) {
            char c = posfixa.charAt(i);

            // Se o caractere for um operando, empilhe
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            // Se o caractere for um operador, pop dois operandos e combine-os
            else if (isOperator(c)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                // Forma a expressão infixa com parênteses para garantir a ordem correta
                String infixExpr = "(" + operand1 + " " + c + " " + operand2 + ")";
                stack.push(infixExpr);
            }
        }

        // O último item da pilha será a expressão infixa
        return stack.pop();
    }
}
