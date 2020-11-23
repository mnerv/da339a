package Task03.Model;

public class VATCalculator {
    public static double getVATFactor(ProductType productType) {
        double factor = 0.0;

        switch (productType) {
            case Food:
                factor = 0.12;
                break;
            case Books:
                factor = 0.06;
                break;
            case Beverage:
            default:
                factor = 0.25;
                break;
        }

        return factor;
    }
}
