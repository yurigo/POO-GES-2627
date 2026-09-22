public class FactoryBall {
    public Ball createBall(String a, String b, String c){
        Ball ball = new Ball(a,b,c);
        return ball;
    }

    public Ball createBall(String a){

        // convierto a en los atributos que necesite new Ball
        String x = "";
        String y = "";
        String z = "";

        Ball ball = new Ball(x,y,z);
        return ball;
    }
}
