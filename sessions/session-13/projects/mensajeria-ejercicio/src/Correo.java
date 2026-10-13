public class Correo extends Notificacion {
    private String asunto;

    public Correo(String mensaje){
        super(mensaje);
    }

    public void enviar(){
        System.out.println("se envia un correo");
        System.out.println("asunto");
        System.out.println(asunto);
        super.enviar();
    }

}
