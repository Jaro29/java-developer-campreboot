package pl.coderslab.advanced.abstractclass;

public class Square extends Shape {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double calculateArea() {
        return side * side;
    }

    @Override
    double calculateCircuit() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square{" + toStringFields() + '}';
    }

    @Override
    protected String toStringFields() {
        return super.toStringFields() + ", side=" + side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}

