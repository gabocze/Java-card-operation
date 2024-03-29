package tarjetaOp;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Consigna #0: Clase ejecutable
public class CardBasicOp {
    static final int montoValidoMax = 1000;
    private final ConsumoService consumoService;

    public CardBasicOp(ConsumoService consumoService) {
        this.consumoService = consumoService;
    }

    public static void main(String args[]) {
        new CardBasicOp(new ConsumoService()).mainLoop();
    }

    public void mainLoop() {
        // Consigna #1: Invocar un método que devuelva toda la información de una tarjeta
        for(Consumo consumo = consumoService.getConsumo(), consumoSiguiente = consumoService.getConsumo(); consumo!=null; consumo = consumoSiguiente, consumoSiguiente = consumoService.getConsumo()) {
            Tarjeta tarjeta = consumo.getTarjeta();
            Tarjeta tarjetaSiguiente = consumoSiguiente!=null ? consumoSiguiente.getTarjeta() : null;
            // Consigna #4: Identificar si una tarjeta es distinta a otra
            if(tarjetaSiguiente!=null && !tarjeta.equals(tarjetaSiguiente))
                System.out.printf("Tarjetas distintas %s %d %s %4$tm/%4$ty %5$s %6$d %7$s %8$tm/%8$ty%n", tarjeta.getMarca(), tarjeta.getNumero(), tarjeta.getCardholder(), tarjeta.getVencimiento(), tarjetaSiguiente.getMarca(), tarjetaSiguiente.getNumero(), tarjetaSiguiente.getCardholder(), tarjetaSiguiente.getVencimiento());
            // Consigna #2: Informar si una operación es válida
            if(consumo.getMonto()>=montoValidoMax) {
                System.err.printf("Rechazado: Consumo mayor o igual a %.2f$. %s %d %s %5$tm/%5$ty. Monto: %6$.2f$; PDV: %7$d; %8$td/%8$tm/%8$ty %8$tT%n", (float)montoValidoMax, tarjeta.getMarca(), tarjeta.getNumero(), tarjeta.getCardholder(), tarjeta.getVencimiento(), consumo.getMonto(), consumo.getPdv(), consumo.getFechaHora());
                continue;
            }
            // Consigna #3: Informar si una tarjeta es válida
            if(tarjeta.getVencimiento().isBefore(LocalDateTime.now())) {
                System.err.printf("Rechazado: Tarjeta no válida: %s %d %s %4$tm/%4$ty%n", tarjeta.getMarca(), tarjeta.getNumero(), tarjeta.getCardholder(), tarjeta.getVencimiento());
                continue;
            }
            // Consigna #5: Obtener por medio de un método la tasa de una operación
            System.out.printf("Tasa calculada: %.2f. %s %s%n", calcularTasa(tarjeta.getMarca(), consumo.getMonto(), consumo.getFechaHora().toLocalDate()), tarjeta.getMarca(), tarjeta.getCardholder());
        }
    }
    
    public float calcularTasa(Marca marca, float monto, LocalDate fechaOp) {
        float valorInicial;
        switch(marca) {
            case VISA :
                valorInicial = (float) (fechaOp.getYear()%1000) / fechaOp.getMonthValue();
                break;
            case NARA:
                valorInicial = fechaOp.getDayOfMonth() * 0.5F;
                break;
            default:
                valorInicial = fechaOp.getMonthValue() * 0.1F;
        }
        
        return Math.min(Math.max(valorInicial, 0.3F), 5);
    }
}
