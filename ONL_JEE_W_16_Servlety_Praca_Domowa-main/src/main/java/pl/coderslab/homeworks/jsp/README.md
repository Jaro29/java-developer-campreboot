Rozwiązania zadań umieszczaj w utworzonym wcześniej projekcie **jee-servlet**.

## Zadanie 1


W projekcie stwórz stronę jsp `index41.jsp`. Następnie:
1. Pobierz wartość parametru GET o nazwie `author`.
2. Sprawdź czy parametr istnieje oraz czy nie jest pusty.
3. Wyświetl informacje w postaci:
    ```html
    <p>Wybrany autor <Pobrana wartość></p>
    ```


## Zadanie 2

W projekcie stwórz stronę jsp `index42.jsp`. 
Za pomocą pętli forEach wyświetl na stronie liczby w taki sposób by uzyskać poniższy wynik.
 Wykorzystaj dodatkowe atrybuty pętli `begin` oraz `step`.    
```html
2 
4 
6 
8 
10 
```


## Zadanie 3

W projekcie stwórz servlet `Servlet311` oraz `Servlet312`. Następnie:
1. Na pierwszej stronie (`Servlet311`) stwórz formularz z elementem `select`
 oraz opcjami wyboru zgodnymi z kluczami poniższej mapy:
   ```java
   Map<String, String> lang = new  HashMap<>();
   lang.put("en", "Hello");
   lang.put("pl", "Cześć");
   lang.put("de", "Hallo");
   lang.put("es", "Hola");
   lang.put("fr", "Salut");
   ```
2. Strona ma przesyłać dane za pomocą `POST` do drugiej strony (`Servlet312`),
 która ma ustawić ciasteczko `language` na wartość wybraną przez użytkownika.
3. Po ponownym wejściu na pierwszą powinna być wyświetlana informacja powitalna w wybranym przez użytkownika języku.
4. Gdy ciasteczko nie istnieje, wiadomość powitalna powinna być wyświetlana w języku polskim.

Hint: Odpowiednie dane przekaż i przetwórz w pliku widoku.


## Zadanie 4 - dodatkowe

1. Umieść na stronie dostępnej pod adresem **/newsletter** dowolny tekst,
 możesz skorzystać z generatora: [lorem-ipsum].
2. Umieść na stronie formularz z możliwością zapisu użytkownika na newsletter.
Formularz musi mieć następujące pola:
  * email (Adres email),
  * name (Imię i nazwisko).
3. Formularz powinien wyświetlać się dla użytkownika raz na 24 godziny - wykorzystaj w tym celu ciasteczka.
4. Napisz obsługę formularza, dane zapisz do bazy.
5. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
 
[lorem-ipsum]:http://pl.lipsum.com/


## Zadanie 5 - dodatkowe

Utwórz filtr, który będzie zapisywał do bazy danych poniższe informacje pobrane w filtrze:
  - przeglądarkę użytkownika,  
  - datę i godzinę żądania,  
  - wszystkie parametry żądania (zastanów się, w jaki sposób przechowywać te dane w bazie),  
  - czas wykonania żądania.
