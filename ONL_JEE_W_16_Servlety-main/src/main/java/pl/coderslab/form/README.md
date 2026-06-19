## Zadanie 1 - rozwiązywane z wykładowcą

W projekcie stwórz servlet `Form1` , dostępny pod adresem **/post1** oraz stronę HTML `form1.html`, 
w której zawarty jest formularz przesyłający imię i nazwisko.
Po uruchomieniu na serwerze i uzupełnieniu formularza w przeglądarce wyświetli się napis:
  `Witaj, <podane imię> <podane nazwisko>`.



## Zadanie 2 - rozwiązywane z wykładowcą

W projekcie stwórz servlet `Form2`, dostępny pod adresem **/post2** oraz stronę HTML `form2.html`. Następnie:
1. Dodaj do strony formularz, wysyłany metodą `POST`. 
Formularz powinien zawierać jedno pole tekstowe i jeden checkbox z opisem `Jestem świadomy konsekwencji`.
2. Dopisz funkcjonalność, która po przesłaniu formularza sprawdzi, 
czy wpisany przez użytkownika tekst zawiera wulgaryzmy.
 Jeżeli tak, to nasz kod powinien zastąpić wulgarne słowo znakami: `****`.

Na przykład frazę `cholera, znowu ta JAVA ` powinien zastąpić frazą `*******, znów ta JAVA `.
Jeżeli użytkownik zaznaczy checkbox `Jestem świadomy konsekwencji`, to program nie sprawdzi wulgaryzmów i wyświetli wpisany tekst.
Liczba gwiazdek ma odpowiadać liczbie znaków w cenzurowanym słowie.


Hint: listę wulgaryzmów możesz stworzyć samodzielnie w postaci tablicy, lub poszukać gotowych tablic w internecie.


## Zadanie 3

1. W projekcie stwórz servlet `Form3`, dostępny pod adresem **/getForm3** .
W katalogu `webapp` utwórz plik HTML o nazwie `form3.html`, zawierający poniższy formularz:

```html
<form action="" method="GET">
    <label>
        Page:
        <input type="text" name="page">
    </label>
    <input type="submit">
</form>
```
2. Uzupełnij odpowiednio atrybut **action** formularza.
3. W metodzie  `doGet` servletu pobierz przesłany parametr.
4. Wyświetl na stronie dzielniki całkowite przesłanej liczby.


## Zadanie 4

W projekcie stwórz servlet `Form4`, dostępny pod adresem **/post4** oraz stronę HTML `form4.html`. Następnie:
1. Napisz formularz, zawierający trzy pola liczbowe: a, b i c. 
2. Dopisz funkcjonalność, która po przesłaniu formularza wyliczy miejsca zerowe funkcji kwadratowej zdefiniowanej 
poprzez podane w formularzu liczby `(ax^2+bx+c)`. Wyświetl wyliczone miejsca zerowe na stronie.
W przypadku `delta<0` servlet wyświetli odpowiedni komunikat.


## Zadanie 5

W projekcie stwórz servlet  `Form5` , dostępny pod adresem **/post5** oraz stronę HTML `form5.html`. Następnie:
1. Do strony dodaj formularz zawierający jedno pole liczbowe oraz dwa przyciski `submit`.
 Każdy z przycisków niech ma inny atrybut `name` mówiący o sposobie konwersji. 
3. Po wysłaniu odpowiednich danych servlet ma przeliczać temperaturę w stopniach Celsjusza na temperaturę w stopniach Fahrenheita (i w drugą stronę). 
Który przycisk został kliknięty przez użytkownika dowiesz się po wartości pola `conversionType` przesyłanego POST-em.

Skorzystaj z poniższego formularza:
```html
<form action="" method="POST">
    <label>
        Temperatura:
        <input type="number" min="0.00" step="0.01" name="degrees">
    </label>
    <input type="submit" name="conversionType" value="celcToFahr">
    <input type="submit" name="conversionType" value="FahrToCelc">
</form>
``` 
* Aby przeliczyć jednostki użyj wzorów znajdujących się [tutaj][degrees-convertion].

[degrees-convertion]:https://pl.wikipedia.org/wiki/Skala_Fahrenheita#Spos.C3.B3b_dok.C5.82adny

