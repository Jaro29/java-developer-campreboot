## Zadanie 1 - rozwiązywane z wykładowcą


W bazie danych o nazwie ```products_ex``` stwórz następującą tabelę:
```SQL
* opinions:
  * description: string
```

1. Tabela ```opinions``` ma być połączona z tabelą ```products``` relacją jeden do wielu (produkt ma wiele opinii, opinia jest przypisana do jednego produktu).
2. Napisz po **5** zapytań, które dodadzą opinie do **3** istniejących produktów.  

Zapytania zapisz do przygotowanego pliku `Main1.java`.



## Zadanie 2

W pliku `Main2.java` zapisz do przygotowanych zmiennych odpowiednie zapytania.

W bazie danych o nazwie ```products_ex``` stwórz następujące tabele:
```SQL
* categories:
  * id: int
  * name: varchar(100)
* categories_sub:
  * id: int
  * main_id: int -- relacja z id głównej kategorii
  * name: varchar(100)
```
Połącz tabele `categories` i `categories_sub` za pomocą relacji wiele do jednego 
(jedna kategoria może mieć wiele podkategorii, jedna podkategoria ma jedną kategorię nadrzędną).

