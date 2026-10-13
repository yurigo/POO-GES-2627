public class Main{
    public static void main(){

        Estandar estandar = new Estandar(3.14f);
        Estandar estandar2 = new Estandar(1.0f);
        System.out.println(estandar.calculaPrecio());
        System.out.println(estandar2.calculaPrecio());

        // estandar.mostrarResumen();
    }
}
