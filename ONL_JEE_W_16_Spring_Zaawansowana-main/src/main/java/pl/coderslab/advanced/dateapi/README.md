## Zadanie 1 - rozwiązywane z wykładowcą

1. Napisz program, który wypisze na standardowym wyjściu aktualną godzinę we wszystkich europejskich strefach czasowych
 Wykorzystaj `getAvailableZoneIds()` z klasy `ZoneId` - filtruj sprawdzając czy strefa czasowa zawiera słowo `Europe`.


## Zadanie 2

1. Napisz metodę, która na ekranie wypisze dzień tygodnia, w który przez kolejnych dziesięć lat będzie wypadała Wigilia.
Wykorzystaj `LocalDate date = LocalDate.of(2019, Month.DECEMBER, 24);` a następnie pobieraj odpowiednie dane w pętli.


## Zadanie 3

1. Utwórz klasę **MapTime** a w niej metodę o sygnaturze:
````
public static Map<String, LocalTime> getMapTime()
````
metoda ma zwracać mapę, gdzie kluczem jest nazwa strefy czasowej, a wartością aktualna godzina w tej strefie.
 Wykorzystaj `getAvailableZoneIds()` z klasy `ZoneId` oraz `toMap` z `Collectors`.


## Zadanie 4

1.  Korzystając z `Date API` oblicz ile miesięcy upłynęło od początku epoki Uniksa (`01.01.1970`).
