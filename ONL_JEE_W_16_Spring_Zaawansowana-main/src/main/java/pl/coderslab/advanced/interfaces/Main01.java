package pl.coderslab.advanced.interfaces;

public class Main01 {
    public static void main(String[] args) {
        Moveable[] moveableTab = new Moveable[3];
        Car car = new Car();
        Cat cat = new Cat();
        Person person = new Person();
        moveableTab[0]=car;
        moveableTab[1]=cat;
        moveableTab[2]=person;
        for (Moveable moveable : moveableTab) {
            moveable.start();
        }
    }
}
