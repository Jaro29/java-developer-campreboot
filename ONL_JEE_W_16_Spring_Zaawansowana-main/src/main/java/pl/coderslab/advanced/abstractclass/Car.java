package pl.coderslab.advanced.abstractclass;

public class Car extends Vehicle{

    String type;

    public Car(Integer maxSpeed, String model, String type) {
        super(maxSpeed, model);
        this.type = type;
    }

    @Override
    public String getSound() {
        return "Brrrrrr";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + type;
    }
}
