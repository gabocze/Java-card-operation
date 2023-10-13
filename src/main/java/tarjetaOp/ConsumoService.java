package tarjetaOp;

import java.time.LocalDateTime;

public class ConsumoService {
    private Consumo[] consumos = {
            new Consumo(200, LocalDateTime.of(2023, 1, 16, 
                    10, 12, 24), 16, new Tarjeta(Marca.VISA, 
                    123456789012L, "CARLOS GARCIA", LocalDateTime.of(2028, 
                    4, 1, 0, 0))),
            new Consumo(250, LocalDateTime.of(2023, 1, 16,
                    15, 20, 25), 28, new Tarjeta(Marca.VISA,
                    123456789012L, "CARLOS GARCIA", LocalDateTime.of(2028,
                    4, 1, 0, 0)))
    };
    private int i;

    /**
     * @return Los consumos ordenados por tarjeta, o null si no quedan más consumos
     */
    public Consumo getConsumo() {
        return i<consumos.length ? consumos[i++] : null;
    }
}
