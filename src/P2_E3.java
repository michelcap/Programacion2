import TAD.Stack.MyStack;
import TAD.Stack.MyStackImpl;

import java.util.Scanner;

public class P2_E3<T> {
    MyStack<Character> stack = new MyStackImpl<>();

    // leer
    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un valor: ");
        String valorIngresado = sc.nextLine();

        for (int i = 0; i < valorIngresado.length(); i++) {

            if (valorIngresado.charAt(i) == '(' || valorIngresado.charAt(i) == '{' || valorIngresado.charAt(i) == '['
               || valorIngresado.charAt(i) == ')' || valorIngresado.charAt(i) == '}' || valorIngresado.charAt(i) == ']') {

                char simboloIngresado = valorIngresado.charAt(i);

                if (simboloIngresado == '(' || simboloIngresado == '{' || simboloIngresado == '[') {
                    stack.push(simboloIngresado);
                } else if (stack.isEmpty()) {
                    System.out.println("La exprecion ingresada no esta equilibrada");
                    break;
                } else if ((simboloIngresado == ')' && (char) stack.top().getValue() == '(')
                            || (simboloIngresado == '}' && (char) stack.top().getValue() == '{')
                            || (simboloIngresado == ']' && (char) stack.top().getValue() == '[')) {
                    stack.pop();
                } else {
                    System.out.println("La exprecion ingresada no esta equilibrada");
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("La exprecion ingresada esta equilibrada");
        } else {
            System.out.println("La exprecion ingresada no esta equilibrada");
        }
    }

}
