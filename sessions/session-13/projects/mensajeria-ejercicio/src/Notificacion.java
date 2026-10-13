import java.util.Date;

public class Notificacion {
    private String identificador;
    private String destinatario;
    private String mensaje;
    private Date fecha;

    public Notificacion(String mensaje){
        this.mensaje = mensaje;
    }

    public void enviar(){
        System.out.println("identificador");
        System.out.println(identificador);
        System.out.println("destinatario");
        System.out.println(destinatario);
        System.out.println("mensaje");
        System.out.println(mensaje);
        System.out.println("fecha");
        System.out.println(fecha);
    }

    protected void info(){



    }
}
