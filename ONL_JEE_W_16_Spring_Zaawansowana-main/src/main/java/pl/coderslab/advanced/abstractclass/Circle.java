package pl.coderslab.advanced.abstractclass;

import static java.lang.Math.PI;

public class Circle extends Shape{


    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" + toStringFields() + '}';
    }

    @Override
    protected String toStringFields() {
        return super.toStringFields() +
                ", radius=" + radius;
    }
    @Override
    double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    double calculateCircuit() {
        return 2 * PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
