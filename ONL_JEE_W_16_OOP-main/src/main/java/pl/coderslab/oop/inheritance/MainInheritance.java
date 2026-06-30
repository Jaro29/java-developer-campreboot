package pl.coderslab.oop.inheritance;

public class MainInheritance {
    public static void main(String[] args) {

        try {
//            ExpressPackage expressPackage1 = new ExpressPackage("03482 29464", 15, 10);
            ExpressPackage expressPackage2 = new ExpressPackage("03482 29467", 7, 10);
            ExpressPackage expressPackage3 = new ExpressPackage("03482 29462", 5, 10);
            Package package1 = new Package("07485 324754", 27);
            Package package2 = new Package("07485 324755", 29);
            Package package3 = new Package("07485 324756", 57);
            System.out.println(ShippingPoint.calculateTotalCost(package1, expressPackage2, package2, package3, expressPackage3));
        } catch (PackageTooHeavyException e) {
            throw new RuntimeException(e);
        }

        Printer printer = new Printer();
        printer.runSelfTest();
        System.out.println(printer);

        int totalPackageWeight = 15;
        int packageCount = 2;
        // double averageWeight = totalPackageWeight/packageCount; // Niepoprawnie
        double averageWeight = (double) totalPackageWeight/packageCount;
        System.out.println(averageWeight);
    }



}
/*
ĆWICZENIE 3: Pułapka dzielenia i rzutowanie typów prostych

    Napisz krótki program w metodzie main, który pokaże, jak radzisz sobie z automatyczną konwersją
    typów i literałami [76]:
    Zadeklaruj dwie zmienne całkowite: int totalPackageWeight = 15; oraz int packageCount = 2;.
    Oblicz średnią wagę paczki i przypisz ją do zmiennej double averageWeight;.
    Zrób to na dwa sposoby:
        Błędny sposób: Napisz kod, który przez nieostrożność spowoduje utratę precyzji (wynik wyniesie 7.0) [79, 81].
        Poprawny sposób: Napisz kod, który poprawnie wypisze 7.5 (wykorzystaj rzutowanie typu prostego
         lub zmianę typu jednego z literałów) [59, 78].


*/
