import java.io.IOException;
import java.util.Scanner;

public class CardBasicOp {
    static int montoValidoMax = 1000;
    public static void main(String args[]) {
        int op;
        System.out.println("*** CardBasicOp - operaciones básicas con tarjeta ***");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la operación a realizar");
        System.out.println("1. Información de tarjeta.");
        System.out.println("2. Consultar validez de operación.");
        System.out.println("3. Consultar validez tarjeta.");
        System.out.println("4. Identificar si 2 tarjetas son distintas.");
        System.out.println("5. Tasa de operación.");
        do {
            System.out.print("Ingrese opción (1-5): ");
            op = scanner.nextInt();
            if(op<1 || 5<op)
                System.out.println("La opción debe estar entre 1 y 5.");
        } while(op<1 || 5<op);
        System.out.println("OPCIÓN: " + op);
    }
}
