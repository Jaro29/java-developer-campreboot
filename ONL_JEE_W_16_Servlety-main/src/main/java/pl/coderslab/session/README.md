## Zadanie 1 - rozwiązywane z wykładowcą

W projekcie stwórz trzy servlety:
 - `Session1Set` dostępny pod adresem `/session1Set`, 
 - `Session1Get` dostępny pod adresem `/session1Get` ,
 - `Session1Del` dostępny pod adresem `/session1Del`.

1. Pierwszy ma ustawiać atrybut sesji pod kluczem ```counter``` na `0`.
2. Drugi ma wyświetlać zawartość sesji pod kluczem ```counter``` i zwiększać go o `1`. 
Jeżeli nie ma takich danych w sesji, to strona powinna wyświetlić informację: `EMPTY`.
3. Trzeci ma usuwać dane z sesji (tylko te trzymane pod kluczem ```counter```).




## Zadanie 2 - rozwiązywane z wykładowcą

W projekcie stwórz servlet `Session2` dostępny pod adresem `/session2`.
1. W metodzie `doGet` wyświetl formularz z możliwością wpisania oceny. 
2. Po zatwierdzeniu formularza dodaj ocenę do sesji. Oceny trzymaj w liście, którą będziesz wkładać do sesji.
3. Wylicz średnią z ocen (pamiętaj o właśnie dodanej ocenie).
4. Wszystkie zapamiętane oceny i ich średnia powinny być wyświetlane po zatwierdzeniu formularza.


## Zadanie 3

W projekcie stwórz servlet  `Session3Add` dostępny pod adresem `/addToSession` oraz servlet `Session3All`
 dostępny pod adresem `/showAllSessions`. Następnie:
1. Dodaj do servletu `Session3Add` do niego następujący formularz:  
    ```html
    <form action="" method="POST">
        <label>
            Klucz:
            <input type="text" name="key">
        </label>
        <label>
            Wartość:
            <input type="text" name="value">
        </label>
        <input type="submit">
    </form>
    ```
2. Dodaj do servletu `Session3Add` funkcjonalność, 
która po zatwierdzeniu formularza metodą POST doda nową zmienną sesyjną o podanej nazwie i wartości. 
3. Dodaj do servletu `Session3All` funkcjonalność,
 która wyświetli w formie tabeli wszystkie dane znajdujące się w sesji (zarówno klucz jak i wartość). 
Do przechowywania kluczy wszystkich wartości w sesji użyj dodatkowej zmiennej sesyjnej, 
która będzie przechowywać (w tablicy lub w kolekcji) wszystkie klucze.


## Zadanie 4

W projekcie stwórz servlet `Session4` oraz stronę HTML `session4.html`.
1. Dodaj do strony formularz, zawierający jedno pole tekstowe (nazwa) oraz dwa pola liczbowe (ilość i cena),
służący do symulacji kosztów listy potrzebnych zakupów.  
Formularz powinien przekierować do servletu metodą POST.
2. Po odebraniu danych POST w servlecie, dodaj do sesji przedmiot. 
Informacje o produkcie możesz przechowywać w dodatkowej klasie: `CartItem` zawierającej pola `name`, `quantity`, `price`.
Pamiętaj, że przedmiotów będzie więcej, więc użyj do tego tablicy lub kolekcji. 
3. Dodaj do servletu funkcjonalność, która wyświetli zawartość naszego koszyka.

Przykładowy koszyk:
```
Produkt 1 - 4 x 5.20zł = 20.80zł
Produkt 2 - 1 x 9.99zł =  9.99zł
Produkt 3 - 1 x 2.20zł =  2.20zł
                   SUMA: 32.99zł
```


## Zadanie 5

W projekcie stwórz servlet `Session5`.
1. Dodaj do niego formularz z 3 polami tekstowymi (imię, nazwisko, email) oraz polem numerycznym,
 do którego będzie wpisywana captcha: wynik działania matematycznego. 
2. Nad polem numerycznym do wpisania zabezpieczenia widnieje informacja:
 `Wpisz poniżej sumę {liczba1} + {liczba2}`.
  Liczby powinny być losowe z zakresu od 0 do 100. 
  Servlet powinien obliczyć sumę tych liczb i zapisać wynik do sesji pod kluczem `captcha`
3. Po przesłaniu formularza aplikacja sprawdzi czy wpisany przez użytkownika wynik zgadza 
się z tym z sesji i wyświetli odpowiedni komunikat.

