package pl.coderslab.advanced.abstractclass;

public class Main01 {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[2];

        vehicles[0] = new Train(260,"Pendolino",1435);
        vehicles[1] = new Car(220,"Toyota","SUV");

        for(Vehicle vehicle:vehicles){
            System.out.println(vehicle);
        }
    }
}
