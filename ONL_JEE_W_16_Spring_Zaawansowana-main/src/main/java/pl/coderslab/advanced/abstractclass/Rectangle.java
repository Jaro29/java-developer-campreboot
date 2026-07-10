package pl.coderslab.advanced.abstractclass;

public class Rectangle extends Shape {

    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    double calculateArea() {
        return sideA * sideB;
    }

    @Override
    double calculateCircuit() {
        return 2 * sideA + 2 * sideB;
    }

    @Override
    public String toString() {
        return "Rectangle{" + toStringFields() + '}';
    }

    @Override
    protected String toStringFields() {
        return super.toStringFields() +
                ", sideA=" + sideA + ", sideB=" + sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }
}
