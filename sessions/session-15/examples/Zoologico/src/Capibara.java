public class Capibara extends Animal {
    private Integer mandarinas;

    public Capibara(String nombre, Integer mandarinas){
        super(nombre);
        this.mandarinas = mandarinas;
    }

    public Integer getMandarinas() {
        return mandarinas;
    }
    public void habla(){
        System.out.println("aaaaahaahaahhahhaa");
    }

    public String toString(){
        return super.toString() + "y tiene " + mandarinas + " mandarinas";
    }
}
