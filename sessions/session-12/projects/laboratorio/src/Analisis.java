public class Analisis {
    private Equipo equipo;
    private Muestra muestra;
    private Resultado resultado;

    public Analisis(Equipo equipo, Muestra muestra, Resultado resultado) {
        this.equipo = equipo;
        this.muestra = muestra;
        this.resultado = resultado;
        equipo.añadirAnalisis(this);
        muestra.añadirAnalisis(this);
    }
}
