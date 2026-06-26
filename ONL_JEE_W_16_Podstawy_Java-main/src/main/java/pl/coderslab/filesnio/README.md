## Zadanie 1 - rozwiązywane z wykładowcą

W pliku `Main01.java` stwórz metodę o sygnaturze:
 
 `public static void createDirectory(String directoryName)`.

1. uzupełnij ciało metody tak, aby tworzyła katalog o zadanej nazwie,
2. sprawdzaj, czy katalog nie istnieje,
3. wykorzystaj metody klas pakietu `java.nio.file`: 
 - `Files.exists(directory)`,
 - `Files.createDirectory(directory)`.



## Zadanie 2

W pliku `Main02.java` stwórz metodę o sygnaturze:
 
 `public static void createFile (String fileName)`.

1. uzupełnij ciało metody tak, aby tworzyła plik o zadanej nazwie,
2. sprawdzaj czy plik nie istnieje,
3. wykorzystaj metody klas pakietu `java.nio.file`.


## Zadanie 3

W pliku `Main03.java` stwórz metodę o sygnaturze:
 
 `public static void copyFile(String directory, String fileName, String secondFileName)`.
   
Następnie:  

1. uzupełnij ciało metody tak, aby z katalogu `directory` kopiowała plik o nazwie `fileName` do pliku o nazwie `secondFileName`.
2. sprawdzaj czy plik nie istnieje.


## Zadanie 4

W pliku `Main04.java` stwórz metodę o sygnaturze:
 
 `public static void writeToFile(String fileName)`.
   
Uzupełnij ciało metody tak, aby:

1. utworzyła (jeżeli nie istnieje) plik o nazwie `fileName`. 
2. pobierała z konsoli całe linie, a następnie zapisywała je do pliku. 
Wykorzystaj odpowiednią metodę klasy `Scanner`.
3. Wczytuj dane do momentu wystąpienia napisu `quit`.



## Zadanie 5

W pliku `Main05.java` stwórz metodę o sygnaturze:
 
 `public static void readFromFile(String fileName)`.
   
Uzupełnij ciało metody tak, aby:

1. wczytała zawartość pliku podanego w parametrze metody (sprawdzaj czy istnieje plik źródłowy),
2. utworzyła nowy plik o rozszerzeniu `html` i nazwie takiej samej jak plik wczytywany,
3. wpisywała do nowego pliku dane w postaci `html`, gdzie każda linia pliku wczytanego będzie się znajdować w tagu `<p>`.

Przykład:
```html
<html>
<body>
<p>pierwsza linia</p>
<p>druga linia</p>
</body>
</html>

```

## Zadanie 6

W pliku AiTask01.java napisz metodę, która sprawdzi, czy istnieje plik o nazwie notatki.txt. Jeśli istnieje, 
program ma stworzyć jego kopię bezpieczeństwa o nazwie backup_notatki.txt, 
automatycznie nadpisując stary backup, jeśli ten już istniał. Na koniec 
program ma bezpiecznie usunąć oryginalny plik notatki.txt

## Zadanie 7

W pliku AiTask02.java napisz program, który 
pobierze z konsoli nazwę pliku (użyj do tego swojej 
bezpiecznej metody, np. readString). Program ma 
sprawdzić, czy podany plik istnieje. Jeśli istnieje, 
ma zmienić jego nazwę, dodając na początku słowo 
zarchiwizowane_ (wykorzystaj do tego metodę Files.move()). 
Jeśli plik nie istnieje, program ma poinformować użytkownika o błędzie i... 
zapytać o nazwę pliku jeszcze raz (czyli pętla ma się kręcić, 
dopóki użytkownik nie poda nazwy pliku, który realnie istnieje na dysku).

## Zadanie 8

W pliku AiTask03.java napisz program, który poprosi użytkownika o 
podanie ścieżki do pliku tekstowego. Program ma sprawdzić:Czy podana 
ścieżka istnieje (Files.exists),Czy podana ścieżka na pewno prowadzi do 
zwykłego pliku, a nie do folderu (wykorzystaj do tego metodę 
Files.isRegularFile(path)).Jeśli oba warunki są spełnione, program ma 
za pomocą jednej linijki (Files.readString(path)) wczytać cały ten 
plik, wyświetlić jego zawartość na ekranie oraz podać informację, 
z ilu dokładnie znaków składa się ten tekst. Jeśli któryś warunek 
zawiedzie – program ma ponowić pytanie.

## Zadanie 9

### Analizator Ścieżki

W pliku `AiTask04.java` napisz program, który poprosi użytkownika o podanie 
dowolnej ścieżki (pliku lub folderu). Program ma sprawdzić, czy ta ścieżka 
w ogóle istnieje na dysku.

Jeśli istnieje, program ma wyświetlić o niej następujące informacje:
* Czy jest to zwykły plik, czy katalog (folder) (użyj `Files.isRegularFile` oraz `Files.isDirectory`).
* Samą nazwę końcową (użyj `path.getFileName()`).
* Ścieżkę do katalogu nadrzędnego (użyj `path.getParent()`).
* Liczbę elementów (folderów) składających się na tę ścieżkę (użyj `path.getNameCount()`).

Jeśli podana ścieżka nie istnieje – program ma poinformować o tym użytkownika 
i poprosić o podanie nowej (pętla kręci się do skutku).

**Podpowiedź na start:** Pamiętaj o architekturze z poprzednich zadań – pętlę 
sprawdzającą istnienie najlepiej zamknąć w metodzie pobierającej dane, tak aby metoda 
biznesowa dostała już pewną, istniejącą ścieżkę.

## Zadanie 10
W pliku AiTask05.java napisz program, który: 
1. Pobierze od użytkownika nazwę nowego projektu (zwykły tekst, np. MojaAplikacja).
2. Stworzy katalog o tej nazwie (użyj Files.createDirectory).
3. Wewnątrz tego nowo utworzonego katalogu stworzy automatycznie dwa podfoldery: o nazwie src oraz o nazwie resources (użyj Files.createDirectories lub po prostu odpowiednio złóż ścieżki).
4. Na koniec, wewnątrz folderu resources, stworzy pusty plik o nazwie config.properties (użyj Files.createFile).
Program ma oczywiście sprawdzać, czy taki projekt już nie istnieje, aby nie nadpisać danych użytkownika.