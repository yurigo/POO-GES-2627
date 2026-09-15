public class IMCCalculator {

    public float calculate(Person person) {
        int peso = person.getPeso();
        float altura = person.getAltura();
        float imc = (float) peso / (altura * altura);
        return imc;
    }
    public String classify(float imc) {
        if (imc < 18.5) {
            return "Insuficiencia ponderal";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
