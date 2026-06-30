package pl.coderslab.oop.inheritance;

public class Package {
    private final String trackingNumber;
    private double weight;

    public Package(String trackingNumber, double weight) {
        this.trackingNumber = trackingNumber;
        this.weight = weight;
    }

    public final String getTrackingNumber() {
        return trackingNumber;
    }

    public double getShippingCost() {
        return weight * 5.0;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return "Package [Tracking number: " + trackingNumber + ", Weight: " + weight + "]";
    }


}
/*

Pola: trackingNumber (String, finalny), weight (double, prywatne).

Zwykły konstruktor inicjalizujący te pola [101].

Metoda finalna getTrackingNumber() [82].

Metoda getShippingCost(), która zwraca koszt podstawowy: weight * 5.0.

Getter dla weight oraz metoda toString().


*/
