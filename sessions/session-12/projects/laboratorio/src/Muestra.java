import java.util.ArrayList;
import java.util.Date;

public class Muestra {
    private String identificador;
    private Date fechaExtraccion;
    private double volumen;
    private ArrayList<Analisis> analisis;

    public Muestra(String identificador, Date fechaExtraccion, double volumen) {
        this.identificador = identificador;
        this.fechaExtraccion = fechaExtraccion;
        this.volumen = volumen;
        this.analisis = new ArrayList<Analisis>();
    }

    public void añadirAnalisis(Analisis analisis) {
        this.analisis.add(analisis);
    }
}
