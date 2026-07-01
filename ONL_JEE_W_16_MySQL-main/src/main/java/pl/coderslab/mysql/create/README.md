Wszystkie zapytania do bazy wykonuj w konsoli lub z wykorzystaniem IntelliJ.
Dodatkowo zapisz treść zapytań do plików java, przygotowanych do każdego zadania.

## Zadanie 1 - rozwiązywane z wykładowcą

1. Utwórz bazę o nazwie ```products_ex```, pamiętaj o prawidłowym kodowaniu.
2. Zapisz zapytanie w zmiennej `query` w pliku `Main1.java`.


## Zadanie 2 - rozwiązywane z wykładowcą

W bazie danych o nazwie ```products_ex``` stwórz następujące tabele:
```SQL
* products:
  * id: int
  * name: varchar(100)
  * description: varchar(1000)
  * price: decimal (2 decimal places)

* orders:
  * id:int
  * description: varchar(1000)

* clients:
  * id: int
  * name: varchar(100)
  * surname: varchar(100)
```

Zapytania SQL zapisz w przygotowanym pliku `Main2.java`.  

**Pamiętaj, aby użyć odpowiednich typów danych dla każdej kolumny w bazie.**


## Zadanie 3

1. Stwórz nową bazę danych o nazwie ```cinemas_ex```. Pamiętaj, że zapytanie się nie uda, jeżeli baza już istnieje.
2. W pliku `Main03.java` zapisz treść zapytania.


## Zadanie 4

w bazie danych o nazwie ```cinemas_ex``` stwórz następujące tabele (jeżeli tabela już istnieje, to nie da się jej stworzyć – SQL zwróci błąd):
```SQL
* cinemas:
  * id: int
  * name: varchar(100)
  * address: varchar(200)

* movies:
  * id: int
  * title: varchar(100)
  * description: varchar(1000)
  * rating: decimal (2 decimal places)

* tickets:
  * id: int
  * quantity: int
  * price: decimal (2 decimal places)
  * status: int (1 - opłacony, 0 - nie opłacony)

* payments:
  * id: int
  * type: char(10) (Zakładamy, że są trzy typy płatności: `cash`, `transfer` lub `card`).
  * payment_date: date
```

Zapytania SQL zapisz w przygotowanym pliku `Main4.java`. 

Pamiętaj o:  
* zakładaniu odpowiednich atrybutów na pola (np. każde **id** powinno być kluczem głównym, automatycznie numerowanym),  
* używaniu **odpowiednich typów danych** dla każdej kolumny w bazie,
* dokładnym czytaniu **kodów błędów** zwracanych przez MySQL.  

Przejście od czystej Javy do relacyjnych baz danych to naturalny i niezwykle ważny krok. W dzisiejszych czasach (mamy rok 2026) niemal każda aplikacja backendowa współpracuje z bazą danych (np. za pomocą technologii takich jak JDBC, Hibernate czy Spring Data).

Przeanalizowałem Twoje materiały. Standardy języka SQL oraz zasady relacyjności baz danych są wyjątkowo stabilne, więc **około 95% tych informacji jest wciąż w pełni aktualnych i stanowi absolutny kanon**. Przygotowałem jednak dla Ciebie krótki przegląd zmian oraz „pro-tips”, które warto mieć na uwadze z perspektywy współczesnych standardów.

---

### Analiza materiałów i aktualizacja (Stan na 2026 rok)

#### 1. Połączenie z MySQL w IntelliJ (PDF 3)
*   **Co się zmieniło:** Sam proces i konfiguracja w zakładce `Database` są identyczne. Jednak obecnie w IntelliJ domyślnym wyglądem jest tzw. *New UI* (nowy interfejs), który jest znacznie bardziej minimalistyczny. Zakładka `Database` nadal znajduje się po prawej stronie, ale ikony mogą wyglądać nieco nowocześniej.
*   **Wersje:** Screeny pokazują sterownik MySQL w wersji `8.0.15`. Obecnie standardem są nowsze wersje MySQL (linia 8.x oraz najnowsze 9.x), ale IntelliJ sam dba o pobranie najnowszego, stabilnego sterownika po kliknięciu *Download missing driver files*.

#### 2. Tworzenie baz danych i kodowanie (PDF 6)
*   Zapytanie: `CREATE DATABASE new_db_name CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;` [4]
*   **Pro-tip:** Od wersji MySQL 8.0 kodowanie `utf8mb4` oraz kolacja `utf8mb4_0900_ai_ci` (lub pokrewne) są **domyślnymi ustawieniami** serwera. Oznacza to, że jeśli napiszesz po prostu `CREATE DATABASE nazwa_bazy;` [3], MySQL automatycznie utworzy ją z pełnym wsparciem dla czterobajtowych znaków Unicode (emotki, znaki specjalne). Jawne dopisywanie kodowania jest jednak nadal bardzo dobrą praktyką, gwarantującą, że baza zachowa się tak samo na każdym serwerze.

#### 3. Typy danych (PDF 6)
*   Podział na `TINYINT`, `INT`, `DECIMAL` itd. jest niezmienny [10, 11, 12].
*   **Ważna uwaga o `VARCHAR(M)`:** Prezentacja słusznie wspomina, że maksymalny rozmiar to `65535` [14]. Warto jednak wiedzieć, że jest to limit **bajtów** na cały wiersz tabeli. Ponieważ kodowanie `utf8mb4` zużywa do 4 bajtów na jeden znak, maksymalna liczba znaków w kolumnie `VARCHAR` przy tym kodowaniu wynosi w praktyce około `16383` znaków. Jeśli potrzebujesz więcej – używasz typu `TEXT` [15].

#### 4. Relacja wiele do wielu (PDF 1)
*   W prezentacji tabela pomocnicza `items_orders` posiada własną kolumnę `id int AUTO_INCREMENT` jako klucz główny [5].
*   **Pro-tip (Dobra praktyka projektowa):** W tabelach łączących (pomocniczych) dla relacji wiele do wielu bardzo często rezygnuje się z dodatkowej kolumny `id`. Zamiast tego tworzy się **złożony klucz główny** składający się z obu kluczy obcych: `PRIMARY KEY (item_id, order_id)`. Zapobiega to sytuacji, w której ten sam przedmiot zostanie przypisany do tego samego zamówienia dwukrotnie, i oszczędza pamięć.

#### 5. Klauzule LIMIT i OFFSET (PDF 5)
*   Zapis skrócony: `LIMIT 2, 5` [19]
*   **Dobra praktyka:** Zapis skrócony (gdzie pierwsza liczba to przesunięcie, a druga to limit) jest specyficzny dla MySQL. Znacznie bezpieczniejszym i czytelniejszym zapisem (zgodnym ze standardem ANSI SQL, który zadziała też w PostgreSQL czy Oracle) jest pełny zapis: `LIMIT 5 OFFSET 2` [19]. Zalecam stosowanie tej drugiej formy.

---

### Zadanie praktyczne: Projekt bazy danych „Księgarnia”

Czas przetestować tę wiedzę w praktyce! Napiszemy czysty kod SQL (Dolina zapytań DDL i DML), który odzwierciedli strukturę bazy danych. Możesz go uruchomić bezpośrednio w konsoli bazy danych w IntelliJ.

Zaprojektuj bazę danych o nazwie `bookstore_db` spełniającą następujące założenia:

1.  **Tworzenie bazy danych:**
    *   Stwórz bazę danych `bookstore_db` z kodowaniem `utf8mb4` [4].
2.  **Tabela `customers` (Klienci):**
    *   Kolumny: `customer_id` (klucz główny, auto-increment) [18], `name` (napis, wymagany) [17], `email` (napis, unikalny, wymagany) [17, 21].
3.  **Tabela `addresses` (Adresy - relacja 1:1 z `customers`):**
    *   Zgodnie z PDF 4, klucz główny tej tabeli ma być jednocześnie kluczem obcym wskazującym na `customers(customer_id)` [2, 3].
    *   Dodaj opcję `ON DELETE CASCADE` [3].
    *   Kolumny: `customer_id` (klucz główny i obcy), `city` (napis), `street` (napis) [3].
4.  **Tabela `books` (Książki):**
    *   Kolumny: `book_id` (klucz główny, auto-increment), `title` (napis, wymagany), `price` (użyj zalecanego typu dla cen z PDF 6, slajd 12 [12], np. `DECIMAL(6,2)`).
5.  **Tabela pomocnicza `borrowings` (Wypożyczenia - relacja wiele do wielu):**
    *   Łączy klientów (`customers`) z książkami (`books`) – jeden klient może wypożyczyć wiele książek, a jedna książka może być wypożyczona przez wielu klientów [2].
    *   Stwórz tabelę `borrowings` z kolumnami: `customer_id` (int), `book_id` (int), `borrow_date` (typ daty, domyślnie obecna data - użyj `DEFAULT CURRENT_DATE` lub po prostu typu `DATE` [13, 17]).
    *   **Wyzwanie:** Spróbuj ustawić **złożony klucz główny** na kolumnach `(customer_id, book_id)` oraz zdefiniuj odpowiednie klucze obce (`FOREIGN KEY`) wskazujące na tabele `customers` i `books` [3].

6.  **Zapytania SQL (DML):**
    Napisz zapytanie `SELECT`, które:
    *   Wypisze wszystkie książki z tabeli `books`, których cena jest większa niż `30.00` zł, posortowane od najdroższej do najtańszej (`ORDER BY`) [4, 9, 10].
    *   **Wyzwanie z `GROUP BY`:** Napisz zapytanie, które zliczy (`COUNT`), ile książek wypożyczył każdy klient (pogrupowane po `customer_id`) [12, 14].

Napisz skrypt SQL i wklej go tutaj. Przeanalizuję poprawność relacji, kluczy obcych oraz zapytania filtrujące! Powodzenia!