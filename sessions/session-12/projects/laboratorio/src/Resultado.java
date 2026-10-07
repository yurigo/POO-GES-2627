import java.util.Date;

public class Resultado {
    private double valor;
    private String unidadMedida;
    private Date fecha;

    public Resultado(double valor, String unidadMedida, Date fecha) {
        this.valor = valor;
        this.unidadMedida = unidadMedida;
        this.fecha = fecha;
    }
}
