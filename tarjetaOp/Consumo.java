package tarjetaOp;

import java.time.LocalDateTime;

public class Consumo {
    private float monto;
    private LocalDateTime fechaHora;
    // punto de venta
    private int pdv;
    private Tarjeta tarjeta;
    
    public Consumo(float monto, LocalDateTime fechaHora, int pdv, Tarjeta tarjeta) {
        this.monto = monto;
        this.fechaHora = fechaHora;
        this.pdv = pdv;
        this.tarjeta = tarjeta;
    }
    
    public float getMonto() {
        return monto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public int getPdv() {
        return pdv;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

}
