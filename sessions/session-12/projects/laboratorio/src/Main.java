import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Equipo equipo = new Equipo("EQ-01", "Analizador", new Date());
        Muestra muestra = new Muestra("M-01", new Date(), 5.0);

        Resultado resultado = new Resultado(4.2, "mg/L", new Date());
        new Analisis(equipo, muestra, resultado);
    }
}
