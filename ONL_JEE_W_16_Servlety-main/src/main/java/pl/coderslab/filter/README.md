## Zadanie 1 - rozwiązywane z wykładowcą

1. Utwórz filtr, który będzie ustawiał kodowanie dla obiektu żądania i odpowiedzi na `utf-8`.




## Zadanie 2 - rozwiązywane z wykładowcą

1. Utwórz filtr, który będzie **w konsoli** wyświetlał informacje o wykorzystywanej przez użytkownika przeglądarce,
 wykorzystaj nagłówek `User-Agent`.
2. Obliczaj i wyświetlaj **w konsoli** czas wywołania żądania.
Wykorzystaj poniższy kod w metodzie filtra:
````java
long startTime = System.currentTimeMillis();
chain.doFilter(request, response);
long stopTime = System.currentTimeMillis();
````


## Zadanie 3

1. Utwórz servlet `Login` dostępny pod adresem **/login** (metoda **doGet**) wyświetlający widok o nazwie: `login.jsp`.
Servlet ten będzie się zajmował sprawdzaniem czy wpisane dane są poprawne.
W kodzie servletu zdefiniuj następujące atrybuty:
````java
private final static String USER = "admin";
private final static String PASSWORD = "coderslab";
````    
W pliku `login.jsp` umieść formularz:

````html
<form  method="post">
    <input type="text"  name="username"/>
    <input name="password" type="password"/>
<button type="submit">Zaloguj</button>
</form>

````

3. W metodzie **doPost** servletu `Login` odbierz parametry a następnie porównaj je z atrybutami `USER` oraz `PASSWORD`,
w następujący sposób (pomijamy hashowanie hasła):
````java
String user = request.getParameter("username");
String pass = request.getParameter("password");
if (user.equals(USER) && pass.equals(PASSWORD)) {
  // dodaj dane do sesji pod kluczem: username 
  // przekieruj na adres /admin  
} else {
   // wyświetl informacje o błędnych danych
}
````
4. Uzupełnij powyższą metodę o elementy opisane w komentarzach.
5. Utwórz servlet `Admin` dostępny pod adresem **/admin** (metoda **doGet**) wyświetlający widok o nazwie: `admin.jsp`.
 W pliku `admin.jsp` umieść dowolną zawartość, która Twoim zdaniem powinna być dostępna po zalogowaniu.
6. Dodaj filtr o nazwie `AuthFilter`, który będzie się uruchamiał dla wszystkich adresów pasujących do wzorca **/admin/***, 
oraz sprawdzał czy w sesji jest klucz o nazwie `username`, jeżeli nie ma przekieruj na adres **/login**.
7. Dodaj servlet `Logout`, który będzie usuwał dane z sesji.

