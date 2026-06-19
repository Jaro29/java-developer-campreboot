## Zadanie 1

W pakiecie `pl.coderslab.homeworks.collection`,  utwórz klasę `GenerateRandom` zawierającą metodę o sygnaturze:
`public static Map<Integer, Integer> checkRand(int amount, int interval)`,
 metoda ta ma zwracać mapę wystąpień wartości losowych generowanych za pomocą klasy `Random`.

Kluczem mapy ma być losowana liczba, wartością ilość jej wystąpień.

Parametry:
- `amount` - oznaczają ilość losowań, jaka ma być wykonana.
- `interval` - zakres wartości dla metody klasy `nextInt` klasy `Random`.

Przykładowy wynik wyświetlenia elementów mapy dla wywołania metody z parametrami `amount` = 500000 oraz `interval` = 10:

````
0 : 50082
1 : 49956
2 : 49771
3 : 50001
4 : 50036
5 : 49699
6 : 50082
7 : 50272
8 : 50094
9 : 50007

````
 Przetestuj działanie metody w klasie `Main01`.


## Zadanie 2

1. W pliku `Main02.java` do zmiennych **reg1**, **reg2**, **reg3**, **reg4** wpisz kolejno wyrażenia regularne, opisujące:

    * liczby zmiennoprzecinkowe (5.65 , 123.123)
    * liczby w notacji naukowej ( 5.4325e+04 ; 2.0000342E-06)
    * datę w formacie `dd/mm/yyyy`
    * datę w formacie `yyyy-mm-dd` - gdzie rok jest powyżej 2000



## Zadanie 3

W pliku `Main03.java`

1. Napisz metodę `static boolean verifyLogin(String login)`,
która zwróci **true** jeżeli ciąg znaków:
    * Ma minimum 5 znaków.
    * Zawiera tylko litery, cyfry, znak podkreślenia, myślnik.
    * Nie zaczyna się od cyfry.

**false** w przeciwnym wypadku.


## Zadanie 4

1. W pliku `Main04.java` napisz program, który wczyta dane z pliku `people.csv`.
2. Za pomocą wyrażeń regularnych sprawdź czy wiersz zawiera poprawny zestaw danych, tzn.:

    ````email,imię,nazwisko,wiek,miasto````
    
Sprawdź:
- poprawność adresu email,
- czy imię, nazwisko oraz miasto zawierają tylko litery,
- czy wiek jest wartością liczbową.
    
    **Pierwsze 6 wierszy zawiera błędne dane.**

3. Utwórz klasę `Person` zawierającą pola:
    ````java private  String email;
    private  String firstName;
    private  String lastName;
    private  Integer age;
    private  String city;
    ````
4. Utwórz listę i - jeżeli dane są poprawne - z każdego wiersza utwórz obiekt klasy `Person`, a następnie umieść go na liście.


## Zadanie 5 - dodatkowe

1. W pliku z zadania 4 utwórz mapę:
````
 Map<Integer, List<Person>> peopleByAge = new HashMap<>();
````   
2. Iterując po liście z zadania 4 umieść dane w powyższej mapie:
- kluczem ma być wiek,
- wartością - lista osób w wieku takim jak wartość zapisana jako klucz.
