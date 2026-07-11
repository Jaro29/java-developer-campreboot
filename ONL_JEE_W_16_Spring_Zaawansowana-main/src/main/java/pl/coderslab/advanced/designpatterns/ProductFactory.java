package pl.coderslab.advanced.designpatterns;

public class ProductFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "simple": return new SimpleProduct();
            case "advanced": return new AdvancedProduct();
            case "virtual": return new VirtualProduct();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}