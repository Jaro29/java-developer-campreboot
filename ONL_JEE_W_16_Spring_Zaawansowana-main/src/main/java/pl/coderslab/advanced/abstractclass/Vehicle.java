package pl.coderslab.advanced.abstractclass;

public abstract class Vehicle {
    private Integer maxSpeed;
    protected String model;

    public abstract String getSound();

    @Override
    public String toString() {
        return "Class: " + getClass().getSimpleName() +
                ", model: " + model + ", maxSpeed: " + maxSpeed +
                ", sound: " + getSound();
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vehicle(Integer maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}
