## Zadanie 1

W pliku `Main01.java` są przygotowane zmienne, zapisz do nich zapytania `SQL`, które:

1. zwiększą cenę o `1 000` w ofertach, których właściciel ma `id` pomiędzy `20` a `25`,
2. usuną oferty, które wygasły ponad lub równo `3` dni temu (np. jeśli aktualna data to `2017-11-05 12:45:03`, ma usunąć starsze niż `2017-11-02 12:45:03`) –> hint [DATE_ADD()][mysql_date_add], [NOW()][mysql_now],
3. usuną oferty, których numer telefonu rozpoczyna się od `+48` i są promowane oraz aktywne (**których data ważności jest większa niż aktualny czas** i mają odpowiedni status).
4. zmienią status promowania na `1` i dodadzą koniec promowania za `23` dni dla ofert, których `3` i `4` cyfra telefonu to `48` i które nie są aktualnie promowane –> hint [SUBSTRING()][mysql_substring]
5. zmienią w opisach ofert słowo `executed` na `found` ale tylko tych, gdzie telefon posiada `(` lub `)` i cena jest większa niż `400 000`.

<!-- Links -->
[mysql_date_add]: https://dev.mysql.com/doc/refman/5.6/en/date-and-time-functions.html#function_date-add
[mysql_now]: https://dev.mysql.com/doc/refman/5.6/en/date-and-time-functions.html#function_now
[mysql_substring]: https://dev.mysql.com/doc/refman/5.6/en/string-functions.html#function_substring


## Zadanie 2

W pliku `Main02.java`, do dwóch tabel z zadań z dnia pierwszego, dodaj odpowiednie relacje opisane poniżej: 

```SQL
* images (relacja jeden do wielu do tabeli offers [offer_id]):
  * offer_id: int unsigned -> foreign key
* users_companies (relacja jeden do jeden do tabeli users [user_id]):
  * user_id: int unsigned -> foreign key -> 
pamiętaj, że jest to relacja jeden do jeden
```


## Zadanie 3

W pliku `Main03.java` utwórz tabelę `screenings` (pokazy w danym kinie, z określoną datą i godziną), która będzie zawierać następujące pola:
```SQL
* id: int
* cinema_id: int
* movie_id: int
* show_time: datetime
```
Kolumny `cinema_id` oraz `movie_id` – mają być kluczami obcymi odpowiednio dla tabel: **cinemas** oraz **movies**.


## Zadanie 4

W pliku `Main04.java` napisz program, który wyświetli wszystkie filmy (powinien wyświetlić się opis, rating i lista kin, które mają go w swoim repertuarze).


## Zadanie 5


W pliku `Main05.java` napisz program, który wyświetli:

1. wszystkie kina,
2. wszystkie filmy w danym kinie,
3. wszystkie seanse każdego filmu.


## Zadanie 6


W pliku `Main06.java` program, który:

1. pobierze od użytkownika tytuł filmu do wyświetlenia,
2. wyświetli wybrany film – nazwę, opis i rating,
3. jeżeli film nie zostanie odnaleziony w bazie danych, program ma wyświetlić komunikat: "Nie odnaleziono filmu".


## Zadanie 7

W pliku `Main07.java` napisz program, który: 

1. pobierze od użytkownika nazwę kina,
2. wybrane kino zostanie wyświetlone razem z filmami w formacie:
```
Kino o id 12:
* Film o id 5
* Film o id 6
* Film o id 11
```


## Zadanie 8

W pliku `Main08.java` napisz program, który: 

1. wyświetli wszystkie dostępne kina,
2. pobierze z konsoli `id` kina, a następnie wyświetli wszystkie filmy w nim grane,
3. pobierze z konsoli `id` filmu, a następnie wyświetli wszystkie dostępne seanse dla filmu.


## Poćwicz SQL

Zadanie: poćwicz SQL (dodatkowe)

W repozytorium z zadaniami domowymi znajdziesz zrzut bazy danych **football.sql**. 
Jest to baza danych z wynikami Ligi Okręgowej Warszawa II w sezonie 2016/17 (wyniki na dzień 14 listopada 2016 roku).

Utwórz na serwerze bazę danych i zaimportuj plik SQL. 
Jeśli nie wiesz, jak to zrobić, poszukaj w Google, używając słów kluczowych: *MySQL, import, dump*.

Przyjrzyj się strukturze i danym. Znajdują się tam dwie tabele: **Teams** i **Games**. 
Pierwsza z nich to lista klubów piłkarskich i punkty zdobyte do dnia eksportu bazy danych. 
Druga tabela to wyniki gier. Pola `team_home` i `team_away` to klucze obce do tabeli **Teams**.

Napisz zapytania, które:

1. wyciągną klub, który jest liderem tabeli,
2. wyciągną tabelę, posortowaną według liczby zdobytych punktów,
3. wyciągną wszystkie mecze, które Naprzód Brwinów grał u siebie,
4. wyciągną wszystkie mecze, które Naprzód Brwinów grał na wyjeździe,
5. wyciągną wszystkie mecze (u siebie i na wyjeździe) klubu Naprzód Brwinów, 
6. zsumują wszystkie gole zdobyte przez klub Naprzód Brwinów u siebie i na wyjeździe (zrób dwa zapytania: osobno u siebie, osobno na wyjeździe).

W podpunktach 3-5 wynik ma zawierać kolejno: 

* nazwę klubu gospodarzy,
* nazwę klubu gości,
* liczbę goli strzelonych przez gospodarzy,
* liczbę goli strzelonych przez gości.  

