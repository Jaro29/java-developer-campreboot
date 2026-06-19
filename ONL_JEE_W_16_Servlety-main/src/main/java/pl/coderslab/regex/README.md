## Zadanie 1 - rozwiązywane z wykładowcą

W pliku `Main01.java`

1. Napisz metodę `static boolean verifyEmail(String email)`,
 która zwróci **true** jeżeli podany parametr jest poprawnym adresem email, **false** w przeciwnym wypadku.
2. Wykorzystaj wyrażenia regularne.


## Zadanie 2

W pliku `Main02.java`

1. Napisz metodę `static boolean verifyPassword(String password)`, która zwróci **true** jeżeli ciąg znaków:
   * Ma od 10 do 15 znaków.
   * Ma minimum jedną małą literę.
   * Ma minimum jedną wielką literę.
   * Nie zawiera dwóch wielkich lub dwóch małych liter z rzędu.

**false** w przeciwnym wypadku.

2. Wykorzystaj wyrażenia regularne. Warunki możesz sprawdzać oddzielnie.


## Zadanie 3

W pliku `Main03.java`

1. Napisz program, który będzie przyjmował linie z konsoli, do momentu wpisania `quit`.
2. Przy pomocy metody `replaceAll` usuń z podanego wyrażenia znaki białe (np. spacje). 
3. Program ma sprawdzać czy wpisany napis jest poprawnym działaniem matematycznym, np:
    ````
    2+3 - 1 = 4
    2 + 2 =4
    1+ 1 =2
    3-1 + 2 =122
    2 * 4- 2 = 6
    6 / 3 + 10 = 12
    ````
Możesz dokończyć wyrażenie :
````
private static final String REGEX = "(\\d[\\/*])*\\d=";
````
  
4. Jeżeli wyrażenie jest poprawny działaniem matematycznym zapisz je do pliku o nazwie `operations.txt`.
5. Pomijamy sprawdzanie poprawności wyniku, istotna jest poprawność składniowa.



## Zadanie 4

W pliku `Main04.java` w metodzie `main` zostały przygotowane wyrażenia regularne,
uruchom program i przeanalizuj działanie.
