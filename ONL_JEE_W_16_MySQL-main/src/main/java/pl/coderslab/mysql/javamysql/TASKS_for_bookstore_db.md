
---

### TWOJA AGENDA ZADAŃ: Baza `bookstore_db`

#### Zadanie 1
W pliku `DbUtil.java`:
1. Utwórz statyczne zmienne typu `String`: `DB_URL`, `DB_USER`, `DB_PASS`, które będą zawierać Twoje dane do połączenia z MariaDB [1.1.2].
2. Utwórz statyczną metodę zwracającą połączenie o sygnaturze:
   `public static Connection connect() throws SQLException`

W pliku `Main1.java` napisz kod, który stworzy połączenie do bazy danych za pomocą `DbUtil.connect()`, a po udanym połączeniu wypisze `"Connected!"` na konsolę.

---

#### Zadanie 2
Uzupełnij klasę `DbUtil.java` o metodę `insert`:
```java
public static void insert(Connection conn, String query, String... params) {
     try (PreparedStatement statement = conn.prepareStatement(query)) {
         for (int i = 0; i < params.length; i++) {
             statement.setString(i + 1, params[i]);
         }
         statement.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
}
```

W pliku `Main2.java`:
1. Napisz zapytania SQL, aby za pomocą metody `insert` wypełnić dwoma nowymi wpisami tabelę `books` (np. książki o cenach `35.00` i `45.00` zł) oraz dwoma wpisami tabelę `customers` [12].
2. *Wskazówka:* Zauważ, że `params` to tablica typu `String...`. Aby przekazać cenę (która jest typu `double`), musisz ją wcześniej skonwertować na tekst (np. używając `String.valueOf(...)`).

---

#### Zadanie 3
W pliku `Main3.java` stwórz metodę o sygnaturze `static void addCustomer(String name, String email)`.

1. Uzupełnij ciało metody tak, aby podane parametry zapisała do tabeli `customers`. Wykorzystaj metodę `insert` z klasy `DbUtil`.
2. W metodzie `main` pobierz od użytkownika z konsoli (`Scanner`) imię oraz email, a następnie wywołaj utworzoną metodę. Przetestuj działanie, wpisując unikalny adres email, a następnie spróbuj wpisać ten sam email drugi raz (zobacz, czy baza poprawnie zgłosi błąd unikalności `UQ_Customers_Email`).

---

#### Zadanie 4
Uzupełnij klasę `DbUtil.java` o metodę `printData`:
```java
public static void printData(Connection conn, String query, String... columnNames) throws SQLException {
    try (PreparedStatement statement = conn.prepareStatement(query);
         ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
            for (String columnName : columnNames) {
                System.out.print(columnName + ": " + resultSet.getString(columnName) + " | ");
            }
            System.out.println();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

W pliku `Main4.java`:
1. Napisz program, który wyświetli na konsoli wszystkie książki (ich `book_id`, `title` oraz `price`) z bazy `bookstore_db` [12].
2. Wykorzystaj do tego metodę `printData` klasy `DbUtil`.

---

#### Zadanie 5 (Test relacji i CASCADE)
W pliku `DbUtil.java` uzupełnij klasę o metodę `remove`:
```java
private static final String DELETE_QUERY = "DELETE FROM tableName where id = ?";

public static void remove(Connection conn, String tableName, String idColumnName, int id) {
    String query = DELETE_QUERY.replace("tableName", tableName).replace("id", idColumnName);
    try (PreparedStatement statement = conn.prepareStatement(query)) {
        statement.setInt(1, id);
        statement.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```
*(Lekko zmodyfikowałem metodę `remove`, aby przyjmowała też nazwę kolumny identyfikatora, ponieważ u nas klucze główne nazywają się `book_id`, `customer_id` itd., a nie tylko `id`).*

W pliku `Main5.java`:
1. Pobierz od użytkownika z konsoli identyfikator klienta (`customer_id`), którego chcesz usunąć.
2. Usuń go za pomocą metody `remove`.
3. *Sprawdź w bazie:* Ponieważ przy tworzeniu tabeli `addresses` ustawiliśmy `ON DELETE CASCADE` dla klucza obcego, usunięcie klienta powinno automatycznie usunąć również jego adres z tabeli `addresses`. Sprawdź w terminalu MariaDB, czy ten adres rzeczywiście zniknął!

---

#### Zadanie 6 (Agregacja i podzapytania)
W pliku `Main6.java` napisz program, który wyświetli na konsoli listę książek, których cena jest większa niż średnia cena wszystkich książek w bazie.

*   *Wskazówka:* Do obliczenia średniej ceny wykorzystaj zapytanie SQL z funkcją agregującą `AVG(price)` [12]. Możesz to zrobić w dwóch krokach (najpierw pobrać średnią, a potem pobrać książki) lub za pomocą jednego zapytania z podzapytaniem (*subquery*): `SELECT * FROM books WHERE price > (SELECT AVG(price) FROM books)`.

---

#### Zadanie 7 – Interaktywny menedżer (Dodatkowe)
W pliku `Main7.java` napisz program, który:
1. Pobierze z bazy wszystkie książki i wyświetli ich `book_id`, `title` oraz `price` na konsoli.
2. Pobierze z konsoli od użytkownika informację, czy chce dokonać edycji lub usunięcia książki (wpisuje **e** jeśli edycja, **u** jeśli usunięcie, **x** jeśli wyjście). Pytanie powinno kręcić się w pętli `while`.
3. Jeśli użytkownik wybrał **u** (usunięcie):
    * Zapytaj o `book_id`.
    * Poproś o potwierdzenie (`T` lub `N`). Po wybraniu `T` usuń książkę i wyświetl listę książek ponownie.
4. Jeśli użytkownik wybrał **e** (edycja):
    * Zapytaj o `book_id`.
    * Pobierz nowy tytuł oraz nową cenę, zmodyfikuj dane w bazie za pomocą `PreparedStatement` i zapytania `UPDATE`, a następnie wyświetl odświeżoną listę książek.

---

### Propozycja

Proponuję zacząć od przygotowania klasy `DbUtil.java` oraz **Zadania 1 i Zadania 2**.