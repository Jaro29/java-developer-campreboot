package pl.coderslab.advanced.abstractclass;

import java.util.ArrayList;
import java.util.List;

public class Main02 {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<>();
        Square square = new Square(23.5);
        Rectangle rectangle = new Rectangle(12.5, 5.87);
        Circle circle = new Circle(11.94);
        list.add(square);
        list.add(rectangle);
        list.add(circle);

        /*
        `Prostokąt o bokach 2 i 4 - pole = 8, obwód = 12`
        `Kwadrat o boku 2 - pole = 4, obwód = 8`
        `Koło o promieniu 3- pole = 28,27, obwód = 18,85`
         */

        System.out.printf("Prostokąt o bokach %.2f i %.2f - pole = %.2f, obwód = %.2f%n",
                rectangle.getSideA(), rectangle.getSideB(), rectangle.calculateArea(), rectangle.calculateCircuit());
        System.out.printf("Kwadrat o bok %.2f - pole = %.2f, obwód = %.2f%n",
                square.getSide(), square.calculateArea(), square.calculateCircuit());
        System.out.printf("Koło o promieniu %.2f - pole = %.2f, obwód = %.2f",
                circle.getRadius(), circle.calculateArea(), circle.calculateCircuit());

    }
}
