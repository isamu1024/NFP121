package Adaptateur.autreExemple;

public class TrouRond {

    private final double rayon;

    public TrouRond(double rayon) {
        this.rayon = rayon;
    }

    public double getRayon() {
        return this.rayon;
    }

    public boolean convient(ChevilleRonde cheville) {
        boolean result;
        result = (this.getRayon() >= cheville.getRayon());
        return result;
    }
}
