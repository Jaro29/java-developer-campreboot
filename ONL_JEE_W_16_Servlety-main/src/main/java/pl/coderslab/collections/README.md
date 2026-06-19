## Zadanie 1 - rozwiązywane z wykładowcą

W pliku `Main01.java`

1. W metodzie `main` utwórz listę o nazwie `elements` przechowującą elementy typu Integer.
2. Dodaj do kolekcji 10 elementów od 10 do 19.
3. Wypisz elementy na konsoli używając pętli for.
4. Wypisz elementy na konsoli używając iteratora i pętli while.
5. Wypisz na konsoli elementy używając iteratora i pętli for.
6. Wypisz na konsoli elementy używając konstrukcji for-each.



## Zadanie 2 - rozwiązywane z wykładowcą

W pliku `Main02.java` napisz metodę `public static void removeDivider (List<Integer> list, int divider)`,
która usunie z listy wszystkie elementy podzielne przez `divider`.



## Zadanie 3

Utwórz klasę `City`,  dodaj w niej atrybuty:
* name (String)
* population (int)  

Klasa powinna mieć też konstruktor przyjmujący wszystkie 2 parametry

Następnie w pliku `Main03.java`:
1. Napisz metodę `public static List<City> initialize()`, która utworzy 5 obiektów klasy `City`, doda je do listy, którą następnie zwróci.
2. Napisz metodę `public static List<City> firstSubList(List<City> list, int start, int end )`, 
która zwróci sublistę elementów listy `list` o początku `start` i końcu `end`. Wykorzystaj dowolną pętlę.
3. Napisz metodę `public static List<City> secondSubList(List<City> list, int start, int end )`, 
   która zwróci sublistę elementów listy `list` o początku `start` i końcu `end`. Wykorzystaj wbudowaną metodę `List.subList(int fromIndex, int toIndex)`.


## Zadanie 4

W pliku `Main04.java`:
1. Napisz metodę `public static List<City> reverse (List<City> list )`, która zwróci listę elementów w odwrotnej do otrzymanej kolejności.
2. Zapoznaj się z możliwościami klasy [ListIterator][list-iterator].


<!-- Links -->
[list-iterator]:https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html
