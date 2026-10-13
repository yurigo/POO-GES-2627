public class Push extends Notificacion {
    private String titulo;
    private String nombreApp;

    public Push(String mensaje){
        super(mensaje);
    }

    public void enviar(){
        System.out.println("se envia una notificacion push");
        System.out.println("titulo");
        System.out.println(titulo);
        System.out.println("nombre de la aplicación");
        System.out.println(nombreApp);
        super.enviar();
    }

}
