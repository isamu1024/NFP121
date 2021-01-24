package MVC.ExempleWeb;

public class ModifieTemperaturePlus1 implements  ModifieTemperature{
    @Override
    public double augmenteDegres(double temp) {
        return temp +1;
    }

    @Override
    public double diminueDegres(double temp) {
        return temp -1;
    }
}
