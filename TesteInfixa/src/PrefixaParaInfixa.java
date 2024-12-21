import java.util.Stack;

public class PrefixaParaInfixa {

    public static String convertePrefixaEmInfixa(String prefixa) {

        Stack<String> stack = new Stack<>();

        // Iterar da direita para a esquerda
        for (int i = prefixa.length() - 1; i >= 0; i--) {
            char c = prefixa.charAt(i);

            // empilha operandos
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            }
            // Se for um operador
            else {
                // Desempilha os dois operandos mais recentes
                String operando1 = stack.pop();
                String operando2 = stack.pop();

                // Cria uma expressão infixa com parênteses
                String infix = "(" + operando1 + " " + c + " " + operando2 + ")";

                // Empilha a nova expressão infixa
                stack.push(infix);
            }
        }

        // O topo da pilha será a expressão infixa
        return stack.pop();
    }
}
