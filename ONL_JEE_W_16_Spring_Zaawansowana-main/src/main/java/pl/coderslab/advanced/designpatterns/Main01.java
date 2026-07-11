package pl.coderslab.advanced.designpatterns;

public class Main01 {
    public static void main(String[] args) {

        AppConfig appConfig1 = AppConfig.getInstance();
        AppConfig appConfig2 = AppConfig.getInstance();

        System.out.println(appConfig1==appConfig2);

        System.out.println(ProductFactory.createProduct("simple"));
        System.out.println(ProductFactory.createProduct("advanced"));
        System.out.println(ProductFactory.createProduct("virtual"));
        System.out.println(ProductFactory.createProduct("some"));

    }
}
