## Zadanie 1 - rozwiązywane z wykładowcą

W pliku `Main01.java` napisz program, który:

1. podzieli na wyrazy ciąg znaków przechowywany w zmiennej `str`, znajdującej się w pliku,
2. wyświetli na konsoli każdy z tych wyrazów w oddzielnej linii.


## Zadanie 2

W pliku `Main02.java` znajduje się zmienna `str`. Napisz program, który:

1. podzieli podany ciąg znaków na bohaterów z filmu `Powrót do przyszłości` – znakiem podziału jest przecinek `(,)`,
2. wyświetli na konsoli każdego bohatera w oddzielnej linii.


## Zadanie 3

W pliku `Main03.java`:

1. umieść metodę o sygnaturze `public static int countTokens(String str)`,
2. uzupełnij ciało metody tak, aby zwracała liczbę wyrazów w podanym ciągu znaków.

Metoda powinna pomijać białe znaki.

Przykład:
dla `String str = "   To jest  tekst do   ";` mamy otrzymać wartość **4**;


## Zadanie 4

W pliku `Main04.java` umieść metodę o sygnaturze:
 
 `public static String[] onlyTwoElements(String str, char separator)`.
 
Uzupełnij ciało metody tak, aby zwracała tablicę dwóch elementów, które powstały po podzieleniu tekstu (`str`) po pierwszym napotkanym znaku podziału (`separator`).

Przykład dla napisu `Java-zadania-podzial-napisow` oraz separatora `-` otrzymamy:
1. pierwszy element tablicy: `Java`
2. drugi element: `zadania-podzial-napisow`.
