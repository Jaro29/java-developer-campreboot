# README-4-thymeleaf.md — Zadania JSP → Thymeleaf

## Zadanie 1 - rozwiązywane z wykładowcą

W projekcie stwórz servlet `KmToMile` dostępny pod adresem **/km-to-mile** (metoda **doGet**).

1. Za pomocą Thymeleaf (zamiast EL z JSP) wyświetl zawartość parametru `km`, przesyłanego jako parametr GET w pasku adresu.
2. Przelicz km na mile (1 km = 0.62 mili), zabezpiecz się przed brakiem parametru, pustym polem oraz błędnym formatem liczby.
3. Przekaż wynik do widoku `first.html` przez `WebContext.setVariable(...)`.
4. W widoku użyj `th:text` do wyświetlenia wartości oraz `th:if` / `th:unless` do obsługi przypadku błędnych danych.

**Kluczowe elementy:**
- Klasa narzędziowa `ThymeleafUtil` (budowa `TemplateEngine` i `WebContext`).
- Bezpieczne parsowanie: `isBlank()` + `try-catch` na `NumberFormatException`.
- `th:if="${miles != null}"` — bezpieczne porównanie z `null` bez wyjątku.


## Zadanie 2 - rozwiązywane z wykładowcą

W projekcie stwórz strony `layout.html` oraz `index.html` (zamiast `header.jsp`, `footer.jsp`, `index.jsp`).

1. W pliku `layout.html` zdefiniuj dwa fragmenty: `th:fragment="header"` oraz `th:fragment="footer"`.
2. W pliku `index.html` dołącz oba fragmenty za pomocą `th:replace="~{layout :: header}"` i `th:replace="~{layout :: footer}"`.
3. Stwórz servlet `IndexServlet` pod adresem **/index**, renderujący `index.html` (bez potrzeby przekazywania danych do kontekstu).

**Kluczowe elementy:**
- Składnia `~{nazwaPliku :: nazwaFragmentu}` jako zamiennik `<jsp:include>` / `<%@ include %>`.
- Reużywalność wspólnych elementów strony (nagłówek, stopka) bez duplikacji kodu HTML.


## Zadanie 3

W projekcie stwórz servlet `ThirdServlet` dostępny pod adresem **/third**.

1. Pobierz z GET wartości `a` i `b` (jako surowe stringi, bez parsowania na liczby).
2. Przekaż je do widoku `third.html` jako `paramA` i `paramB`.
3. W widoku wyświetl wartości, a w przypadku braku parametru (`null`), pustego stringa (`""`) lub samych spacji (`"   "`) wyświetl napis **brak**.
4. Dodaj formularz GET z polami `a` i `b`, aby móc przetestować różne warianty wejścia (w tym spacje wpisane w polu tekstowym).

**Kluczowe elementy:**
- `#strings.isEmpty(paramA)` — w Thymeleaf 3.1 metoda ta wykonuje `trim()` przed sprawdzeniem, więc obsługuje jednocześnie `null`, `""` i same spacje (odpowiednik `isBlank()` z Javy).
- Kolejność warunku `${paramA == null or #strings.isEmpty(paramA)}` — krótkie spięcie (`short-circuit`) chroni przed `NullPointerException`.
- Różnica między testowaniem spacji w adresie URL (przeglądarka automatycznie trimuje) a spacjami wpisanymi w polu formularza (przesyłane nietrknięte, zakodowane jako `+` lub `%20`).


## Zadanie 4

W projekcie stwórz servlet `FourthServlet` dostępny pod adresem **/fourth**.

1. Utwórz ciasteczko o nazwie **foo** oraz wartości **bar** (z flagami bezpieczeństwa: `HttpOnly`, `SameSite=Lax`).
2. W tym samym servlecie odczytaj ciasteczko `foo` z `request.getCookies()` i przekaż jego wartość do widoku `fourth.html`.
3. W widoku wyświetl wartość ciasteczka, z obsługą przypadku braku danych.

**Kluczowe elementy:**
- Cykl request-response: ciasteczko ustawione w danym żądaniu jest widoczne w `request.getCookies()` dopiero przy **następnym** żądaniu (dlatego pierwsze wejście pokazuje "brak", a odświeżenie — poprawną wartość).
- Zabezpieczenie `if (cookies != null)` przed `NullPointerException`, gdy przeglądarka nie ma żadnych ciasteczek.
- Nazwa ciasteczka (`foo`) jako statyczna etykieta w kodzie Java — nie trzeba jej "odkrywać" w pętli, bo jest znana z góry; w pętli wyciągamy tylko wartość (`c.getValue()`).

## Zadanie 5

W projekcie stwórz servlet `FifthServlet` dostępny pod adresem **/fifth** (odpowiednik JSTL `<c:forEach>` → Thymeleaf `th:each`).

1. Stwórz rekord `Book(String title, String author, String isbn)`.
2. W metodzie `doGet` utwórz listę `List<Book>` i dodaj do niej co najmniej 3-4 obiekty.
3. Przekaż listę do widoku `fifth.html` jako zmienną `books`.
4. W widoku wyświetl tabelę HTML (`<table>`) z kolumnami: Nr, Tytuł, Autor, ISBN — dla każdej książki jeden wiersz.
5. Wykorzystaj `th:each="book, iterStat : ${books}"`, aby uzyskać dostęp do numeru porządkowego przez `iterStat.count`.

**Kluczowe elementy:**
- `th:each` jako bezpośredni odpowiednik JSTL `<c:forEach var="..." items="${...}">` — silnik Thymeleaf pod spodem korzysta z mechanizmu `Iterator`, tak jak tradycyjna pętla for-each w Javie.
- Dostęp do pól rekordu w widoku przez `${book.title}` — Thymeleaf automatycznie rozpoznaje akcesory rekordów (metody `title()`, `author()`, `isbn()`), tak jak klasyczne gettery (`getTitle()`).
- `iterStat.count` (liczy od 1) vs `iterStat.index` (liczy od 0) — do naturalnej numeracji w tabeli używamy `.count`.
- Odwrócenie kolejności elementów bez zmiany widoku: `List<Book> reversedBooks = books.reversed();` — metoda `reversed()` z Sequenced Collections API (Java 21, JEP 431), zwraca nową listę, nie modyfikuje oryginalnej. Sortowanie/odwracanie danych to odpowiedzialność kontrolera (servletu), nie widoku.