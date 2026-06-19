## Zadanie 1

1. Napisz własny interfejs funkcyjny, który będzie można wykorzystać do sprawdzenia czy podana
 jako parametr liczba całkowita mieści się w przedziale między 0 a 100.


## Zadanie 2

Napisz program, który będzie zawierał metodę **filterList** pozwalającą na filtrowanie zawartości listy obiektów typu String.

Metoda **filterList** ma przyjmować dwa argumenty – listę obiektów String oraz referencję obiektu `Predicate`
  określający warunek filtrowania. 

Metoda ma zwracać listę przefiltrowanych obiektów.

Korzystając z metody filterList, przefiltruj listę, wybierając z niej:
- obiekty, których długość jest większa niż 4
- obiekty zawierające literę „b”
- obiekty, które kończą się na literę „a”

````java
 List<String> list = Arrays.asList("tree", "bird", "park", "snow", "computer", "i jeszcze jakiś inny napis, który na końcu ma a");
````


## Zadanie 3

1. Korzystając z interfejsu `Function` przypisz do zmiennej **sampleText** wyrażenie lambda które dla zadanego napisu utworzy napis bez pierwszych i ostatnich 2 znaków,
zamieniony na małe znaki.

Przykład dla zadanego napisu:
````java
String sample = "CODERSLAB";
````
otrzymamy wynik

````
dersl
````


## Zadanie 4

1. Utwórz klasę `Main04` i umieść w niej metody o sygnaturach:
````
static <T> List<T> search(Collection<T> collection, Predicate<T> predicate) 
````
metoda ma zwrócić listę elementów spełniających warunek określony w `predicate`
````
static <T, S> List<S> changeCollection(Collection<T> collection, Function<T, S> function)
````
metoda ma przekształcić elementy za pomocą `function` i dodać do nowej zwracanej kolekcji
````
static <T> void consumeCollection(Collection<T> collection, Consumer<T> consumer)
````
metoda ma przekształcić elementy za pomocą `consumer`


## Zadanie 5

1. Utwórz klasę `Main05` a następnie w metodzie `main`, korzystając z Date API, pobierz i wyświetl:
- a) ostatni dzień bieżącego miesiąca, np. wtorek
- b) dzień, w który wypadnie następny piątek
- c) pierwszy dzień następnego miesiąca


## Zadanie 6- dodatkowe

Ze względu na oszczędności w pewnej firmie planowane są zwolnienia najlepiej opłacanych pracowników,
którzy nie są spokrewnieni z szefem o nazwisku **Kowalski**.

1. Utwórz klasę `Main06` a następnie w metodzie `main` napisz program, który wczyta dane z pliku `earnings.txt`.
2. Wyświetli listę 3 pracowników z największymi zarobkami, których nazwisko nie jest takie samo jak szefa (Kowalski).

    * Zwróć uwagę, że nazwisko to może się odmieniać (Kowalski, Kowalska).
    * Zwróć uwagę na ułożenie danych w pliku, występują linie, które nie zawierają płac.
    * Zwróć uwagę, że ułożenie danych w pliku może się zmieniać.
    * Zwróć uwagę, że kolejność danych w linii może być przestawiona.
