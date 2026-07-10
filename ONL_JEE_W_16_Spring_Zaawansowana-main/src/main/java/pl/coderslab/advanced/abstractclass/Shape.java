package pl.coderslab.advanced.abstractclass;

import java.util.StringJoiner;

public abstract class Shape {
    double area;
    double circuit;
    abstract double  calculateArea();
    abstract double  calculateCircuit();

    public Shape() {
    }

    @Override
    public String toString() {
        return "Shape{" + toStringFields() + '}';
    }

    protected String toStringFields() {
        return "area=" + area +
                ", circuit=" + circuit;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCircuit() {
        return circuit;
    }

    public void setCircuit(double circuit) {
        this.circuit = circuit;
    }
}
