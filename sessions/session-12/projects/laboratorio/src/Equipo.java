import java.util.ArrayList;
import java.util.Date;

public class Equipo {
    private String codigo;
    private String modelo;
    private Date fechaUltimaRevision;
    private ArrayList<Analisis> analisis;

    public Equipo(String codigo, String modelo, Date fechaUltimaRevision) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.fechaUltimaRevision = fechaUltimaRevision;
        this.analisis = new ArrayList<Analisis>();
    }

    public void añadirAnalisis(Analisis analisis) {
        this.analisis.add(analisis);
    }
}
