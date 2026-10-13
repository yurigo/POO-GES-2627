import java.util.ArrayList;

public class Main{
    public static void main(String[] args){

        int a = 0;  // a = 0
        a += 10;  // a = 10
        a =+ 10;  // a <- 10
        a = +10;  // a <- 10


        ArrayList<Notificacion> notificaciones = new ArrayList<>();

        ArrayList<Float> floats = new ArrayList<Float>();
        float[] f = new float[300];

        notificaciones.add(new Push("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis malesuada enim vel libero mattis dignissim. Praesent commodo sed nisi et rhoncus. Duis magna donec."));
        notificaciones.add(new SMS("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis malesuada enim vel libero mattis dignissim. Praesent commodo sed nisi et rhoncus. Duis magna donec."));
        notificaciones.add(new Correo("Mensaje del correo"));
        notificaciones.add(new Correo("Mensaje del correo"));
        notificaciones.add(new Correo("Mensaje del correo"));
        notificaciones.add(new Push("el mensaje"));
        notificaciones.add(new Push("el mensaje"));
        notificaciones.add(new SMS("el mensaje"));

        for(Notificacion notificacionQueVisito : notificaciones){
            notificacionQueVisito.enviar();
        }



    }
}