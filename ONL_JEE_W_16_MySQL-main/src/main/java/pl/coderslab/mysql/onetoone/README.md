Wszystkie zapytania do bazy wykonuj w **konsoli** lub z wykorzystaniem **IntelliJ**.  
Dodatkowo zapisz treść zapytań do plików ``java``, przygotowanych do każdego zadania.  
 
> **Część zadań ma w poleceniu utworzenie relacji między tabelami – w takiej sytuacji należy zmodyfikować strukturę tabel**
> **i dodać nowe kolumny lub nowe tabele**


## Zadanie 1 - rozwiązywane z wykładowcą


W bazie danych o nazwie ```products_ex``` stwórz następującą tabelę:
```SQL
* client_address:
  * client_id: int
  * city: varchar(100)
  * street: varchar(100)
  * house_nr: varchar(10)
```

Tabela ```client_address``` ma być połączona relacją jeden do jednego z tabelą ```clients```.  
Napisz 5 zapytań SQL, które wprowadzą adresy dla istniejących już użytkowników.

Zapytania SQL zapisz w przygotowanym pliku `Main1.java`.


## Zadanie 2

Zapytania wykonuj w bazie `cinemas_ex`.  

Tabela `payments` z tabelą `tickets` ma być powiązana relacją jeden do jednego.  
Relacja między biletem a płatnością jest następująca:  

> płatność musi być przypisana do biletu **(dodaj klucz obcy do tabeli `payments`)**

Uzupełnij tabelę `payments` kilkoma wpisami. Przyjmujemy trzy typy płatności: `cash`, `transfer` i `card`.

Zapytania SQL zapisz w przygotowanym pliku `Main02.java`.
