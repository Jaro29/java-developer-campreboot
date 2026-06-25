package pl.coderslab.filesnio;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main02 {

    public static void main(String[] args) {


    }

    public static void createFile(String fileName) {
        Path file = Path.of(fileName);

        if (!Files.exists(file)) {

        } else {
            System.out.printf("Informacja: Plik o nazwie '%s' już istnieje. Nie ma potrzeby go tworzyć.%n", fileName);
        }

    }
}
