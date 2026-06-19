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
