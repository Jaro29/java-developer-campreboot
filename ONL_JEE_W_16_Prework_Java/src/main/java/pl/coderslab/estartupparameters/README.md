Pamiętaj, aby rozwiązania do zadań umieszczać w 
odpowiednich plikach `java`, przygotowanych do zadań.

Parametry określ w **IntelliJ** zgodnie z instrukcją zawartą w artykule **Parametry startowe**. 

## Zadanie 1

1. W pliku `Main01.java` w metodzie `main`
- pobierz, następnie wyświetl wszystkie parametry w jednej lini. np.:
```
1 John 4 Kowalski 
```



## Zadanie 2

1. W pliku `Main02.java` w metodzie `main`
- pobierz wszystkie parametry, następnie wyświetli je w odwrotnej kolejności.
np. dla zadanych `1 John 4 Kowalski ` jako wynik otrzymamy
```
Kowalski 4 John 1
```



## Zadanie 3


1. W pliku `Main03.java` w metodzie `main`
napisz program, który ze wszystkich parametrów startowych obliczy średnią i wyświetli na konsoli.
2. Zakładamy, że podawane parametry są liczbami.
3. Do zamiany napisu na liczbę możemy użyć:
````
Integer.parseInt("12")
````
Przykładowy oczekiwany wynik:
````
2.5
````


## Zadanie 4

1. W pliku `Main04.java` napisz program pobierający 3 parametry startowe: `a, b, c`.
2. Program ma sprawdzić, czy podane liczby mogą być bokami trójkąta.
3. Tę figurę geometryczną można zbudować z trzech linii tylko wtedy,
 gdy suma długości dwóch krótszych jest większa niż długość trzeciej linii, czyli:

```
a + b > c
c + b > a
a + c > b
```

Po sprawdzeniu wypisz na konsoli odpowiednią informację, wg poniższego wzoru:  
jeżeli z podanych boków można zbudować trójkąt:
```
YES
```  
lub jeżeli z podanych boków nie można zbudować trójkąta:
```
NO
```


## Zadanie 5

W pliku `Main05.java` napisz program, który wystawi ocenę z testu.

* `0-50` pkt – `F` 
* `51-70` pkt – `E` 
* `71-90` pkt – `C`  
* `91-100` pkt – `A`

1. Utwórz zmienną `points`, do której będzie przypisana wartość parametru startowego.
2. Na początku sprawdź, czy liczba punktów jest:
* większa bądź równa `0`, jeśli nie – wypisz na konsoli komunikat: `BADVALUE`;
* mniejsza bądź równa `100`, jeśli nie – wypisz na konsoli komunikat: `BADVALUE`.
4. Następnie sprawdź jaka ocena odpowiada danej liczbie punktów i wypisz jej symbol na konsoli.
5. Rozwiąż to zadanie używając konstrukcji `if ... else if ... else`.


## Zadanie 6

W pliku `Main06.java` napisz program tworzący tabliczkę mnożenia dla podanej zmiennej `n`. 
Pobierz parametr startowy i przypisz go do zmiennej `n`.
Na przykład dla ```n = 3``` wynik będzie następujący:

```
1 x 1 = 1  
1 x 2 = 2  
1 x 3 = 3  

2 x 1 = 2  
2 x 2 = 4  
2 x 3 = 6  

3 x 1 = 3  
3 x 2 = 6  
3 x 3 = 9  
```

Do mnożenia liczb użyj operatora `*`.  

Pamiętaj, aby dodać spację pomiędzy liczbami i `x` oraz `=`.



## Zadanie 7

W pliku `Main07.java`  

1. Napisz program liczący wartość `x!`, gdzie `!` oznacza silnię, a `x` jest zmienną.  
2. Pobierz parametr startowy i przypisz go do zmiennej `n`.
3. Użyj do tego dowolnej ze znanych Ci pętli.
4. Silnia ma być zapisana do zmiennej `factorial`.
5. Po wyliczeniu silni wyświetl w konsoli wynik.
Przykład dla  ```x = 3```:

````
6
````


**Silnia** to wynik mnożenia wszystkich liczb całkowitych od jeden do podanej liczby włącznie, czyli:

```
5! = 1*2*3*4*5 = 120
8! = 1*2*3*4*5*6*7*8 = 40320
```



## Zadanie 8

W pliku `Main08.java` utwórz dwie zmienne: `x` i `y`, będące dodatnimi liczbami całkowitymi.
1. Pobierz parametry startowe i przypisz je do zmiennej `x` oraz `y`.
2. Napisz program wyliczający największy wspólny dzielnik (*greatest common divisor – GCD*) dwóch liczb.
3. Skorzystaj z opisu na tej [stronie][GCD].
4. Wynik wyświetl w konsoli.
Przykład dla  ```420 i 168```: 

`84`.


**Poszczególne zadania rozwiązuj w odpowiednich przygotowanych plikach.**

<!-- Links -->
[GCD]: http://www.programming-algorithms.net/article/43434/Greatest-common-divisor


