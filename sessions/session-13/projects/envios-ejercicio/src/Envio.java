public class Envio {
    private Float costeBase = 0.0f;
    private Float costeKg = 0.0f;
    private Float peso;

    public Envio(Float costeBase, Float costeKg, Float peso){
        this.costeBase = costeBase;
        this.costeKg = costeKg;
        this.peso = peso;
    }

    public Float calculaPrecio(){
        return this.costeBase + this.costeKg * this.peso;
    }

}
