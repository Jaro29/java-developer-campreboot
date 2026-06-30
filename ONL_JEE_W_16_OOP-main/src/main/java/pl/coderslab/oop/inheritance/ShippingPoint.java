package pl.coderslab.oop.inheritance;

public class ShippingPoint {
    public static double calculateTotalCost(Package... packages) {
        double totalCost = 0;
        for (Package aPackage : packages) {
            totalCost += aPackage.getShippingCost();
        }
        return totalCost;
    }
}
