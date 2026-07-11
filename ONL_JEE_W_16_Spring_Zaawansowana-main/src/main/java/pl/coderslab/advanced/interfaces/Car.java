package pl.coderslab.advanced.interfaces;

public class Car implements Moveable{
    @Override
    public void start() {
        System.out.println("Samochód jedzie.");
    }
}
