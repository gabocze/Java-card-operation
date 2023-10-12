package tarjetaOp;

import java.time.LocalDateTime;

public class Tarjeta {
    private Marca marca;
    private long numero;
    private String cardholder;
    private LocalDateTime vencimiento;

    public Tarjeta(Marca marca, long numero, String cardholder, LocalDateTime vencimiento) {
        this.marca = marca;
        this.numero = numero;
        this.cardholder = cardholder;
        this.vencimiento = vencimiento;
    }
    
    public Marca getMarca() {
        return marca;
    }

    public long getNumero() {
        return numero;
    }

    public String getCardholder() {
        return cardholder;
    }

    public LocalDateTime getVencimiento() {
        return vencimiento;
    }


    @Override
    public boolean equals(Object tarjeta) {
        Tarjeta tar = (Tarjeta) tarjeta;
        return marca==tar.marca && cardholder.equals(tar.cardholder) && vencimiento.equals(tar.vencimiento) && numero==tar.numero;
    }
}