## Zadanie 1 - rozwiązywane z wykładowcą

W projekcie stwórz `jsp1.jsp`.
1. Dołącz do projektu bibliotekę **jstl**.
2. W projekcie stwórz servlet `Mvc11` dostępny pod adresem **/mvc11**.
3. W servlecie w metodzie GET pobierz parametr o nazwie `role` a następnie zamień zawartość na wielkie litery oraz dodaj prefix `ROLE_` 
 (dla wartości **manager** otrzymamy **ROLE_MANAGER**).
4. Ustaw atrybut o nazwie **userRole** ze zmienioną wartością.
4. Ustaw plik **jsp** jako plik widoku dla tego servletu.
5. W przypadku braku wartości ma się wyświetlić napis `guest`.




## Zadanie 2 - rozwiązywane z wykładowcą

W projekcie stwórz servlet `Mvc12` dostępny pod adresem **/mvc12** ,
 który wczyta dwie zmienne GET : ```start``` i ```end``` . Następnie: 
1. W servlecie zwiększ obie wartości o wartość `10`, przekaż zwiększone zmienne do widoku `jsp2.jsp`.
2. W widoku wyświetl wszystkie liczby od  ```start``` do ```end```. 


## Zadanie 3

W projekcie stwórz servlet `Mvc13` dostępny pod adresem **/mvc13**. 
1. W widoku `jsp3.jsp` stwórz formularz zawierający pola o nazwach: `title`, `author` i `isbn`.
 Formularz ma przesłać dane metodą POST do tego samego servletu (do metody `doPost`).
2. Stwórz klasę **Book** zawierającą pola zgodne z polami wcześniej utworzonego formularza.
3. Odbierz dane i na ich podstawie stwórz obiekt klasy **Book**.
4. Przekaż obiekt do widoku `result.jsp`. 
5. Wyświetl właściwości nowo dodanego obiektu: `title`, `author`, `isbn`.


## Zadanie 4

W projekcie stwórz servlet `Mvc14` dostępny pod adresem **/mvc14**. 
1. W metodzie `doGet` utwórz listę obiektów klasy Book: `List<Book>`.
2. Dodaj kilka dowolnych obiektów do listy, a następnie przekaż do widoku `resultList.jsp`. 
3. W pętli wyświetl właściwości wszystkich obiektów `title`, `author`, `isbn`.
