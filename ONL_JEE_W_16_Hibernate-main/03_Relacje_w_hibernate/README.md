![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/30623667/104709394-2cabee80-571f-11eb-9518-ea6a794e558e.png)


## Zadanie 1 - rozwiązywane z wykładowcą

1. Połącz klasę `Publisher` i `Book` relacją jeden do wielu.
2. Zmodyfikuj kontroler do obsługi książek tak, by w metodzie dodawania książki:
- utworzyć i zapisać obiekt `Publisher`,
- połączyć obiekt klasy `Book` z obiektem klasy `Publisher`,
- zapisać obiekt klasy `Book`.


## Zadanie 2

1. Połącz klasę autora i książkę relacją wiele do wielu.
2. Zmodyfikuj kontroler do obsługi książek tak, by w metodzie dodawania książki:
- pobrać dwóch dowolnych autorów po ich `id`.
- połączyć obiekt klasy `Book` z pobranymi autorami
- zapisać obiekt klasy `Book`.


## Zadanie 3

1. Utwórz klasę `Person` zawierającą pola:
- id 
- login
- password
- email

2. Utwórz klasę `PersonDetails` zawierającą pola:
- id 
- firstName
- lastName
- streetNumber
- street
- city

3. Połącz encje za pomocą relacji `@OneToOne`.
4. Utwórz klasy `Dao` z operacjami zapisu, edycji, usuwania oraz pobierania po identyfikatorze.
5. Utwórz kontroler, realizujący operacje CRUD (create, read, update, delete).
