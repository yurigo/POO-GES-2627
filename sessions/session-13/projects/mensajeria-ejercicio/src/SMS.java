public class SMS extends Notificacion {
    // private final Integer MAX_CHAR = 160;

    public SMS(String mensaje){
        // trunca el mensaje a MAX_CHAR.
        super(mensaje.substring(0,Math.min(mensaje.length(), 10)));
    }

    public void enviar(){
        System.out.println("se envia un SMS");
        super.enviar();
    }


}
