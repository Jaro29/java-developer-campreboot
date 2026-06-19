### Zadanie 1
1. Utwórz klasę `Hero` zawierającą atrybuty:
    - `name` (String),
    - `power` (Long),
    - `dateOfbirth` (LocalDate),
    - `phoneNumber` (String).

2. Klasa ma implementować interfejs `Comparable` oraz `Serializable`.
3. Utwórz `gettery` i `settery`.
3. Dodaj implementację odpowiedniej dla interfejsu Comparable metody tak, 
by kolejność sortowania była zgodna z mocą danego bohatera. 
Im więcej mocy tym wyższa pozycja, sprawdzaj, czy `power` nie jest równe `null`;



## Zadanie 2

1. Utwórz klasę `MainHero`. 
2. W metodzie `main` utwórz listę obiektów typu `Hero`, a następnie przy pomocy strumieni:
- wybierz tylko tych bohaterów, których druga litera nazwy to `u` oraz ich moc jest większa od 5,
 (nie zapomnij o sprawdzeniu czy nazwa ma minimum 2 znaki oraz czy moc nie jest równa `null`)
- sortuj bohaterów pod względem mocy (domyślnie zostanie wykorzystana utworzona metoda z interfejsu),
- przekształć obiekty pobierając tylko ich nazwy,
- przekształć nazwy, zostawiając z nich tylko pierwszą literę oraz zamieniaj litery na wielkie,
- zwróć przekształcone nazwy, połączone za pomocą znaku myślnika `-` w postaci jednego obiektu typu `String`.

Wszystkie operacje wykonaj na jednym strumieniu. 
Przykładowy wynik:
````
H-S
````


## Zadanie 3

1. Utwórz komponent `HeroComponent`, zawierający listę obiektów typu `Hero` oraz dodatkową metodę:
`addHero(Hero hero)` - metoda ma dodawać obiekt `Hero` do listy w komponencie.
2. Utwórz getter do pobrania listy.
3. Utwórz metodę o sygnaturze:
````
 public Optional<Hero> findHeroByPhoneNumber(String phoneNumber) 
````
4. Uzupełnij metodę tak by zwracała `Optional<Hero>` spośród listy obiektów z zadanego `phoneNumber`.


## Zadanie 4

1. Stwórz kontroler o nazwie `ExamController`.
2. Stwórz akcję obsługiwaną metodą GET, dostępną pod adresem `/add-hero`, wyświetlającą formularz w **jsp**
 zawierający 2 pola:
   - `heroName`,
   - `heroPower`,
   - `dateOfbirth`,
   - `phoneNumber`.
3. Formularz ma być wysyłany metodą POST na ten sam adres.
4. Po zatwierdzeniu formularza odbierz przesłane parametry i utwórz z nich obiekt typu `Hero`.
5. Wstrzyknij do kontrolera wcześniej utworzony komponent `HeroComponent`.
6. Wykorzystaj metodę komponentu `addHero(Hero hero)`, aby dodać nowy obiekt do listy obiektów.
5. Po utworzeniu obiektu przekaż go do widoku, a następnie wyświetl jego atrybuty.


## Zadanie 5 

1. Stwórz akcję obsługiwaną metodą GET, dostępną pod adresem `/hero-list`, wyświetlającą widok `heroes.jsp`.
2. Pobierz z komponentu `HeroComponent` listę obiektów typu `Hero`.
3. Przy pomocy strumieni wybierz tylko tych urodzonych po 2000 roku.
4. Przetworzoną listę przekształć do mapy `<String name, Integer age>`
wykorzystaj w tym celu `Collectors.toMap`
5. Oblicz wiek w latach każdego bohatera.
6. W widoku wyświetl wszystkie elementy mapy w następujący sposób:
````
klucz - wartość
````
w naszym przypadku:
```
nazwa bohatera - wiek w latach
```


## Zadanie 6

1. Stwórz akcję obsługiwaną metodą GET, dostępną pod adresem `/add-cookies`, 
dodającą 3 ciasteczka o nazwach, wartościach oraz czasie życia:
   - user, Jan, 10 minut,
   - uid, ccb1b154-c4ff, 10 dni,
   - IDE, IntelliJ, 30 dni.
   
    Akcja nie musi nic wyświetlać.
2. Utwórz akcję dostępną pod adresem `/all-cookies`, w której pobierzesz wcześniej utworzone ciasteczka i zapiszesz je
do listy obiektów typu `Cookie`.
3. Przekaż do widoku listę obiektów typu `Cookie`, a następnie wyświetl tylko nazwę i wartość.
