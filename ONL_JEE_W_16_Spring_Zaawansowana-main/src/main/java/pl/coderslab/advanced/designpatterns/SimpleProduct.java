package pl.coderslab.advanced.designpatterns;

public class SimpleProduct implements Product{

    public String getName(){
        return "SimpleProduct";
    }

    @Override
    public String getDescription() {
        return getName();
    }

    @Override
    public String toString() {
        return "SimpleProduct{}";
    }
}
