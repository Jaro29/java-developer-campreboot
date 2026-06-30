package pl.coderslab.oop.inheritance;

public final class ExpressPackage extends Package {
    private double weightLimit;

    public ExpressPackage(String trackingNumber, double weight, double weightLimit) throws PackageTooHeavyException {
        super(trackingNumber, weight);
        if (weight > weightLimit) {
            throw new PackageTooHeavyException("The weight of the package exceeds the package weight limit.");
        }
        this.weightLimit = weightLimit;
    }

    @Override
    public double getShippingCost() {
        return super.getShippingCost() + 20.0;
    }
}

/*

Stwórz klasę finalną ExpressPackage, która dziedziczy po Package [53, 83]:

    Posiada dodatkowe pole: weightLimit (double, prywatne).

    Uwaga na "Field Hiding": Nie deklaruj tutaj ponownie pola weight! Skorzystaj z pola klasy nadrzędnej [91].

    Konstruktor przyjmujący: String trackingNumber, double weight, double weightLimit.

        Pierwszą instrukcją musi być wywołanie super(trackingNumber, weight) [101].

        Walidacja: Zaraz po super(), sprawdź, czy waga (weight) przekracza weightLimit. Jeśli tak, rzuć PackageTooHeavyException [121].

        Z racji tego, że jest to wyjątek kontrolowany, konstruktor musi deklarować go w sygnaturze (throws PackageTooHeavyException) [122].

    Nadpisz metodę getShippingCost(), dodając stałą dopłatę 20.0 do kosztu podstawowego (wykorzystaj super.getShippingCost()) [104, 105].


*/
