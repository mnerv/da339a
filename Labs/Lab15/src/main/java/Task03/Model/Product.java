package Task03.Model;

public class Product {
    String name;
    double price;
    int count;

    ProductType productType;
    UnitType unit;

    public Product() {
        initializeValues();
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        initializeValues();
    }

    public void initializeValues() {
        name = "No name";
        productType = ProductType.Food;

        unit = UnitType.kg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCoutn() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public UnitType getUnit() {
        return unit;
    }

    public void setUnit(UnitType unit) {
        this.unit = unit;
    }

    public double totalPrice() {
        return price + calcVAT();
    }

    public double calcVAT() {
        return VATCalculator.getVATFactor(productType) * price;
    }

    @Override
    public String toString() {
        return String.format("Name %16s\nPrice %15.2f\nCount %15d\nUnit %16s\nCategory %13s\n\nVAT (moms) %8.2f", name,
                price, count, unit.name(), productType.name(), calcVAT());
    }

}