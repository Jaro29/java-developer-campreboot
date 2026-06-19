![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/152855/73064373-5ed69780-3ea1-11ea-8a71-3d370a5e7dd8.png)

# Egzamin - Servlety.

Przed przystąpieniem do rozwiązywania zadań przeczytaj poniższe wskazówki

## Jak zacząć?

1. Stwórz [*fork*](https://guides.github.com/activities/forking/) repozytorium z zadaniami.
2. Sklonuj repozytorium na swój komputer. Użyj do tego komendy `git clone adres_repozytorium`.

Adres repozytorium możesz znaleźć na stronie repozytorium po naciśnięciu w guzik "Clone or download".

Zwróć uwagę, żeby użyć adresu własnego forka, powinien wyglądać zgodnie ze schematem:
`https://github.com/twoj-login/adres_repozytorium`


3. Zaimportuj projekt jako projekt `Maven`, wg poniższych wskazówek:

- W `IntelliJ` wybieramy: `File –> Open` następnie wskazujemy katalog z pobranym projektem
(katalog nadrzędny dla src, np. **WAR_JEE_S_01_Exam_3**),
	
    lub:

- W `IntelliJ` wybieramy: `File –> Open` następnie wskazujemy plik **pom.xml** z pobranego projektu, 
następnie wybieramy opcję `Open as project`. 

4. Rozwiąż zadania i zakomituj zmiany do swojego repozytorium. Użyj do tego komend `git add nazwa_pliku`.
Jeżeli chcesz dodać wszystkie zmienione pliki użyj `git add .` 
Pamiętaj że kropka na końcu jest ważna!
Następnie zakomituj zmiany komendą `git commit -m "nazwa_commita"`
5. Wypchnij zmiany do swojego repozytorium na GitHubie.  Użyj do tego komendy `git push origin master`.
W repozytoriach utworzonych po 1 października 2020 `git push origin main`
6. Stwórz [*pull request*](https://help.github.com/articles/creating-a-pull-request) do oryginalnego repozytorium, gdy skończysz wszystkie zadania.
**Zwróć szczególną uwagę na adres repozytorium oraz nazwę folderu.**

7. Rozwiąż zadania i skomituj zmiany do swojego repozytorium. Użyj do tego komend t add nazwa_pliku`.
Jeżeli chcesz dodać wszystkie zmienione pliki użyj `git add .` 
Pamiętaj że kropka na końcu jest ważna!
Następnie skommituj zmiany komendą `git commit -m "nazwa_commita"`
    **Repozytorium może zawierać jedynie katalog `src`, pliki: `pom.xml`, `.gitignore`, `README.md`**
8. Wypchnij zmiany do swojego repozytorium na GitHubie.  Użyj do tego komendy `git push origin master`.
W repozytoriach utworzonych po 1 października 2020 `git push origin main`
9. Stwórz [*pull request*](https://help.github.com/articles/creating-a-pull-request) do oryginalnego repozytorium, gdy skończysz wszystkie zadania.

#### Pamiętaj, że pull request musi być stworzony, aby wykładowca dostał Twoje odpowiedzi.

* podczas egzaminu **możesz** korzystać z notatek, kodu napisanego wcześniej, internetu i prezentacji,
* zabroniona jest jakakolwiek komunikacja z innymi kursantami oraz osobami na zewnątrz.

**Powodzenia!**


## Zadanie 1 

1. Utwórz plik **index.jsp** a następnie dodaj w nim link odnoszący się do servletu dostępnego  **/receiver** i przekazujący zmienne metodą **GET**. 
Przekazane zmienne są następujące:
* name = "coder"
* mail = "coder@somemail.com"
* id = 34

2. W pliku **form.jsp** napisz formularz zawierający te same pola oraz kierujący do tego samego servletu
  **/receiver** i przekazujący zmienne metodą **GET**.
   
W servlecie dostępnym pod adresem **/receiver** napisz kod, który odbierze te zmienne i wyświetli je na ekranie.


## Zadanie 2

1. Utwórz klasę reprezentującą Smerfa o nazwie `Smurf`, 
2. Klasa ma posiadać następujące pola (typu String):
    * name (imię),
    * attribute (atrybut),
    * description (opis).
3. Stwórz klasę `SmurfDao` - a w niej metodę o sygnaturze `public List <Smurf> getList()`- metoda ma tworzyć 5 obiektów klasy `Smurf`,
 które następnie doda do ArrayListy. Metoda ma zwrócić listę obiektów.
4. Utwórz servlet dostępny pod adresem `/smurfs`, przekaż do widoku `smurfs.jsp` listę utworzoną przez klasę `SmurfDao`.
5. Wyświetl w tabeli html wszystkie informacje dotyczące smerfów (nie korzystaj z metody `toString()` obiektu).
6. Dodaj link do rozwiązania zadania w pliku `index.jsp` z zadania 1.


## Zadanie 3

1. Utwórz servlet dostępny pod adresem **/regex**.
2. W metodzie **doGet** za pomocą wyrażeń regularnych sprawdź czy parametr o nazwie `param1`
 jest nazwą pliku graficznego spełniającą warunki:
    - składa się tylko z małych liter
    - ma rozszerzenie (gif, jpg, png),
    - ma kropkę przed rozszerzeniem np.: cat.jpg
3. Jeżeli parametr spełnia warunki to przekieruj do adresu **https://www.google.pl/search?q=cat.jpg** zamieniając `cat.jpg` wartością parametru.
4. Jeżeli parametr nie spełnia warunków wyświetl komunikat: "Niepoprawna nazwa".
 Komunikat wyświetl w następujący sposób:
    ````
    response.getWriter().append("Niepoprawna nazwa");
    ````
Przetestuj działanie dla adresów:
````
http://localhost:8080/regex?param1=cat.jpg
http://localhost:8080/regex?param1=cat.docx
````


## Zadanie 4

1. Utwórz klasę reprezentującą Cytat o nazwie `Quote`, 
2. Klasa ma posiadać następujące pola (typu String):
    * author (imię i nazwisko autora),
    * content (zawartość).
3. Pod adresem **/addquote** wyświetl formularz umożliwiający dodawanie nowego cytatu. Cytaty zapisuj w sesji.
4. Pod adresem **/allquotes** - wyświetl tabelę html ze wszystkimi cytatami, które znajdują się w sesji. 
Wyświetlaj zawartość cytatu oraz autora.
5. W servlecie dostępnym pod adresem **/randomquote** napisz kod, który wyświetli na stronie jsp losowy cytat zapisany w sesji.    
6. Dodaj linki do adresów url z zadania do  w pliku `index.jsp` z zadania 1.



#### Zadanie 5 (5 pkt)

1. Utwórz servlet dostępny pod adresem **/homepage** oraz widok **jsp** wyświetlający dane z servetu.
2. Na stronie wyświetl informację że korzysta ona z ciasteczek w postaci:
```
Informujemy, że ta strona korzysta z plików cookies. 
```
3. Na stronie umieść link z możliwością akceptacji plików cookies.
4. Po kliknięciu w link akceptacji plików cookies oraz odświeżeniu strony informacja nie powinna się pojawiać.
5. Informację o akceptacji plików cookies zapisz w ciasteczku. 
6. Dodaj link do rozwiązania zadania w pliku `index.jsp` z zadania 1.
