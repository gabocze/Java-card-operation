package tarjetaOp;

import java.time.LocalDateTime;
import java.util.Scanner;

// Consigna #0: Clase ejecutable
public class CardBasicOp {
    static final int montoValidoMax = 1000;
    private Scanner scanner = new Scanner(System.in);
    private final ConsumoService consumoService;

    public CardBasicOp(ConsumoService consumoService) {
        this.consumoService = consumoService;
    }

    public static void main(String args[]) {
        new CardBasicOp(new ConsumoService()).mainLoop();
    }

    public void mainLoop() {
        // Consigna #1: Invocar un método que devuelva toda la información de una tarjeta
        Consumo consumo = consumoService.getConsumo();
        Consumo consumoSiguiente = consumoService.getConsumo();
        while(consumo!=null) {
            Tarjeta tarjeta = consumo.getTarjeta();
            // Consigna #2: Informar si una operación es válida
            if(consumo.getMonto()>=montoValidoMax) {
                System.err.printf("Rechazado: Consumo mayor a %.2f\\$. %s %d %s %5$tm/%5$ty. Monto: %.2f\\$; PDV: %d; %8$td/%8$tm/%8$y %8$tT%n", montoValidoMax, tarjeta.getMarca(), tarjeta.getNumero(), tarjeta.getCardholder(), tarjeta.getVencimiento(), consumo.getMonto(), consumo.getPdv(), consumo.getFechaHora());
                continue;
            }
            // Consigna #3: Informar si una tarjeta es válida
            if(tarjeta.getVencimiento().isBefore(LocalDateTime.now())) {
                System.err.printf("Rechazado: Tarjeta no válida: %s %d %s %5$tm/%5$ty", tarjeta.getMarca(), tarjeta.getNumero(), tarjeta.getCardholder(), tarjeta.getVencimiento());
            }
            // Consigna #4: Identificar si una tarjeta es distinta a otra
            if(consumoSiguiente!=null && !consumo.getTarjeta().equals(consumoSiguiente.getTarjeta()))
                System.out.printf("Tarjetas distintas %s %d %s %5$tm/%5$ty %s %d %s %5$tm/%5$ty%n");
            // Consigna #5: Obtener por medio de un método la tasa de una operación
            consumo = consumoSiguiente;
            consumoSiguiente = consumoService.getConsumo();
        }
    }
    
    private int getOp() {
        int op;
        System.out.println("Seleccione la operación a realizar");
        System.out.println("1. Información de tarjeta.");
        System.out.println("2. Consultar validez de operación.");
        System.out.println("3. Consultar validez tarjeta.");
        System.out.println("4. Identificar si 2 tarjetas son distintas.");
        System.out.println("5. Tasa de operación.");
        System.out.println("6. Salir.");
        do {
            System.out.print("Ingrese opción (1-5): ");
            op = scanner.nextInt();
            if(op<1 || 5<op)
                System.out.println("La opción debe estar entre 1 y 5.");
        } while(op<1 || 5<op);
        return op;
    }
    
    void validaParaOperar() {
        System.out.println("Para informar si una tarjeta es válida para operar se valida que");
        System.out.println("la fecha de vencimiento sea posterior a la fecha actual.");
        System.out.print("Ingrese la fecha de vencimiento (MM/AA): ");
    }
}
