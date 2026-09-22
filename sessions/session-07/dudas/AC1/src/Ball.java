public class Ball {


    String at1;
    String at2;
    String at3;

    public Ball(String loLeidoDelFichero){
        this.at1 = ?;
        this.at2 = ?;
        this.at3 = ?;
    }

    public Ball(String a, String b, String c){
        this.at1 = a;
        this.at2 = b;
        this.at3 = c;
    }

    public Ball(String a, Integer b, String c){
        this.at1 = a;
        this.at2 = b.toString();
        this.at3 = c;
    }

    public String getAt1(){
        return this.at1;
    }

    public Ball createBall(String a, String b, String c){

    }

}
