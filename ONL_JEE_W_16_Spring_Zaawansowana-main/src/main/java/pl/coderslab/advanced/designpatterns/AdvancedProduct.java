package pl.coderslab.advanced.designpatterns;

public class AdvancedProduct implements Product{
    public String getName(){
        return "AdvancedProduct";
    }
    @Override
    public String getDescription() {
        return getName();
    }

    @Override
    public String toString() {
        return "AdvancedProduct{}";
    }
}
