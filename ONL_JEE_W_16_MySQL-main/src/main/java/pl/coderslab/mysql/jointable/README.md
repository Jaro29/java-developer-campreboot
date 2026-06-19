Wszystkie zapytania do bazy wykonuj w **konsoli** lub z wykorzystaniem **IntelliJ**.
Dodatkowo zapisz treść zapytań do plików ``java``, przygotowanych do każdego zadania.  

## Zadanie 1 - rozwiązywane z wykładowcą

W pliku `Main1.java` napisz zapytania SQL (praca na bazie danych `cinemas_ex`).  

Zapytania mają zwracać następujące wyniki:
1. Wszystkie bilety które zostały opłacone gotówką (czyli `type` = `cash`).
2. Wszystkie bilety które nie zostały jeszcze opłacone.


## Zadanie 2 - rozwiązywane z wykładowcą

Praca na bazie `products_ex`.  
W pliku `Main2.java` do przygotowanych zmiennych wpisz zapytania, które pobiorą:  

1. zamówienia dla produktu o id równym `1`,
2. produkty dla zamówienia o id równym `1`.


## Zadanie 3

W pliku `Main03.java` zapisz treść zapytań, a następnie wypisz w konsoli:

1. wszystkie produkty, które mają opinie oraz wszystkie dostępne dla nich opinie 
(nie powinny występować wartości null),
2. pobierz wszystkie produkty razem z opiniami, niezależnie od tego czy mają opinie 
(mogą występować wartości null),
3. pobierz wszystkie opinie dla produktu o `id` = `1`, 
wynik ma zawierać również wszystkie dane dotyczące produktu.


## Zadanie 4

W pliku `Main4.java` zapisz treść zapytań, a następnie wypisz w konsoli:

1. wszystkie podkategorie kategorii o `id` = `1`, pobrane za pomocą odpowiedniego złączenia,
2. `id` oraz nazwę kategorii, ale tylko tych kategorii, które mają podkategorie (skorzystaj z `DISTINCT`).


## Zadanie 5

Praca na bazie `cinemas_ex`.

W pliku `Main5.java` wpisz zapytania, które pobiorą:  

1. kina, w którym wyświetlany jest film o id równym `1`,
2. filmy wyświetlane w kinie o id równym `1`.

