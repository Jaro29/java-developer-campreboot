## Zadanie 1 - rozwiązywane z wykładowcą

1. Napisz program, który:
- pobierze od użytkownika dowolną ilość słów 
- umieści je w liście
- posortuje alfabetycznie
- wyświetli na ekranie.
Do sortowania kolekcji należy użyć wyrażenia lambda.


## Zadanie 2 - rozwiązywane z wykładowcą

1. Korzystając z interfejsu funkcyjnego Predicate napisz wyrażenie lambda, które będzie sprawdzało czy podany parametr jest typu znakowego (String) i jeśli tak, to wypisze go na ekranie


## Zadanie 3

1. Korzystając z interfejsu funkcyjnego Predicate napisz wyrażenie lambda, które będzie sprawdzało czy podany parametr jest typu liczbowego (Number) i jeśli tak, to wypisze go na ekranie.


## Zadanie 4

1. Napisz interfejs funkcyjny, który pozwoli na obliczenie kwadratu i pierwiastka dowolnej liczby zmiennoprzecinkowej oraz silni liczby całkowitej.
2. Napisz wyrażenia lambda korzystające z tego interfejsu.

## Zadanie 5 - porównanie lambdy i referencji do metody statycznej

Cel: napisać interfejs funkcyjny Converter<T, R> z metodą R convert(T t), a potem zaimplementować konwersję String → Integer dwoma sposobami: lambdą i referencją do metody statycznej.

## Zadanie 6 - referencja do metody instancji na konkretnym obiekcie

Cel: wykorzystać System.out::println jako implementację interfejsu Consumer<T> (wbudowanego w Javę, metoda void accept(T t)).

## Zadanie 7 - referencja do metody instancji na dowolnym obiekcie danego typu

Cel: porównać s -> s.toUpperCase() z String::toUpperCase — to jest najbardziej podstępny przypadek, bo składniowo wygląda jak metoda statyczna, ale semantycznie różni się od Zadania 5.

## Zadanie 8 — referencja do konstruktora

Cel: użyć ArrayList::new jako implementacji interfejsu Supplier<T> (metoda T get()), by dynamicznie tworzyć nowe listy.