## Zadanie 1

W pakiecie `pl.coderslab.homeworks.datainput`, w pliku `Main01.java` stwórz metodę o sygnaturze:
 
 `public static void printTriangle()`.

1. uzupełnij ciało metody tak, aby wczytała z konsoli wartość typu `int`,
2. wypisze na konsoli trójkąt zbudowany ze znaku `x`, w którym obie przyprostokątne będą równe wczytanej wartości.

Przykład dla wczytanej wartości równej 5.

````
x
x x
x x x
x x x x 
x x x x x
````


## Zadanie 2

W pakiecie w pliku `pl.coderslab.homeworks.datainput`, w pliku `Main02.java` stwórz metodę o sygnaturze:
 
 `public static int[] sortedArray()`.

1. uzupełnij ciało metody tak, aby wczytała z konsoli, ile liczb należy wylosować,
2. stworzy tablicę oraz umieść w niej losowe wartości z zakresu `[0,100]`,
3. posortuje elementy tablicy, a następnie ją zwróci.


## Zadanie 3

W pakiecie `pl.coderslab.homeworks.datainput`, w pliku `Main03.java` napisz program, który:

1. Pobierze z konsoli dane w postaci:
```
Nazwisko Imie RokUrodzenia Płeć:
```
2. Dane będą pobierane do momentu wpisania na konsoli **quit**. Dane zapisuj do tablicy typu **String**.

3. Po wpisaniu **quit** wykorzystaj te dane do utworzenia drugiej tablicy zawierającej tylko osoby, które mogą przejść na emeryturę.
Dla kobiet będzie to 60 lat, dla mężczyzn 65.
Dane umieszczaj w postaci `imię + nazwisko`.

3. Kod powinien być zawarty w metodzie o sygnaturze
 `public static String[] retirement()`.

Przykładowe linie z danymi:

```
Kowalski Marek 1955 M
Krzak Marianna 1966 K
Kowalski Kamil 2020 M
```
