package tarjetaOp;

import java.time.LocalDateTime;

public class ConsumoService {
    private Consumo[] consumos = {
            new Consumo(200, LocalDateTime.of(2023, 6, 16, 
                    10, 12, 24), 16, new Tarjeta(Marca.VISA, 
                    123456789012L, "CARLOS GARCIA", LocalDateTime.of(2028, 
                    4, 1, 0, 0))),
            new Consumo(999, LocalDateTime.of(2023, 7, 1,
                    15, 20, 25), 28, new Tarjeta(Marca.VISA,
                    123456789012L, "CARLOS GARCIA", LocalDateTime.of(2028,
                    4, 1, 0, 0))),
            new Consumo(1000, LocalDateTime.of(2023, 7, 5,
                    8, 40, 25), 28, new Tarjeta(Marca.VISA,
                    123456789012L, "CARLOS GARCIA", LocalDateTime.of(2028,
                    4, 1, 0, 0))),
            new Consumo(150, LocalDateTime.of(2023, 7, 5,
                    8, 40, 25), 28, new Tarjeta(Marca.NARA,
                    123456789012L, "CARLOS GARCIA", LocalDateTime.of(2020,
                    4, 1, 0, 0))),
            new Consumo(150, LocalDateTime.of(2023, 7, 5,
                    8, 40, 25), 28, new Tarjeta(Marca.NARA,
                    123456789012L, "CARLOS GARCIA", LocalDateTime.of(2029,
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
