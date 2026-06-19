## Zadanie 1

Stwórz klasę `BankAccount`, która ma spełniać następujące wymogi:

1. Mieć prywatne atrybuty:
 * `number` - atrybut ten powinien trzymać numer identyfikacyjny konta (dla uproszczenia możemy założyć że numerem konta może być dowolna liczba całkowita),
 * `cash` - atrybut określający ilość pieniędzy na koncie. Ma to być liczba zmiennoprzecinkowa.  Atrybut `cash` powinien być zawsze nastawiany na 0 dla nowo tworzonego konta.
2. Posiadać konstruktor przyjmujący tylko numer konta.
3. Posiadać gettery do atrybutów `number` i `cash`, ale NIE posiadać do nich setterów (nie chcemy żeby raz stworzone konto mogło zmienić swój numer, a do atrybutu `cash` dodamy specjalne funkcje modyfikujące jego wartość).
4. Posiadać metodę `void depositCash(amount)` której rolą będzie zwiększenie wartości atrybutu `cash` o podaną wartość. Pamiętaj o sprawdzeniu czy podana wartość jest:
 * Większa od 0
5. Posiadać metodę `double withdrawCash(amount)` której rolą będzie zmniejszenie wartości atrybutu `cash` o podaną wartość. 
Metoda ta powinna zwracać ilość wypłaconych pieniędzy. Dla uproszczenia zakładamy że ilość pieniędzy na koncie nie może zejść poniżej 0, np.
jeżeli z konta na którym jest 300zł próbujemy wypłacić 500zł to metoda zwróci nam tylko 300zł. 
Pamiętaj o sprawdzeniu czy podana wartość jest:
 * Większa od 0
6. Posiadać metodę `String printInfo()` nie przyjmującą żadnych parametrów. Metoda ta ma zwracać informację o numerze konta i jego stanie.


## Zadanie 2

Stwórz klasę `Author`, która ma spełniać następujące wymogi:

1. Mieć prywatne atrybuty:
 * `id` - atrybut ten powinien trzymać numer identyfikacyjny,
 * `firstName` - atrybut określający imię autora,
 * `lastName` - atrybut określający nazwisko autora,
 * `pseudonym` - atrybut określający pseudonim autora,
 
2. Posiadać konstruktor przyjmujący id, imię, nazwisko, pseudonim.


## Zadanie 3

Stwórz klasę `Book`, która ma spełniać następujące wymogi:

1. Mieć prywatne atrybuty:
 * `id` - atrybut typu `int` ten powinien trzymać numer identyfikacyjny książki,
 * `title` - atrybut typu `String` określający tytuł książki,
 * `available` - atrybut typu `boolean` określający czy książka jest możliwa do wypożyczenia, z domyślną wartością ustawioną na `true`,
 książka może być wypożyczona, lub np. w renowacji - ma wtedy atrybut określony na **false**.
 * `author` - atrybut typu `Author`,
 * `additionalAuthors`  - tablica obiektów klasy `Author`.
2. Posiadać konstruktor przyjmujący id, title.
3. Posiadać konstruktor przyjmujący id, title, obiekt klasy `Author`.
4. Posiadać konstruktor przyjmujący id, title, obiekt klasy `Author`, tablicę obiektów klasy `Author`.
5. Posiadać gettery do wszystkich pól.
5. Posiadać settery do wszystkich pól.


## Zadanie 4

Stwórz klasę `User`, która ma spełniać następujące wymogi:
1. Mieć prywatne atrybuty:
 * `id` - atrybut ten powinien trzymać numer identyfikacyjny,
 * `firstName` - atrybut określający imię,
 * `lastName` - atrybut określający nazwisko,
 * `books` - tablica obiektów klasy `Book`.
 
2. Posiadać konstruktor przyjmujący id, imię, nazwisko.
3. Dodaj metodę `addBook(Book book)`, która doda nową książkę do tablicy książek danego użytkownika.
4. Zaimplementuj możliwość dynamicznej zmiany rozmiaru tablicy.
