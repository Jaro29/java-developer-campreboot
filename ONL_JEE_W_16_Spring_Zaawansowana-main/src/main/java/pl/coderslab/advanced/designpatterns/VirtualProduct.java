package pl.coderslab.advanced.designpatterns;

public class VirtualProduct implements Product{
    public String getName(){
        return "VirtualProduct";
    }
    @Override
    public String getDescription() {
        return getName();
    }

    @Override
    public String toString() {
        return "VirtualProduct{}";
    }
}
