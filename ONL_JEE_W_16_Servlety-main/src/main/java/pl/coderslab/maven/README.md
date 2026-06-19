## Zadanie 1 - rozwiązywane z wykładowcą

1. W projekcie dodaj zależność do biblioteki **log4j**,
zgodnie z dokumentacją: [log4j][log4j]
2. Utwórz plik **log4j2.xml** &ndash; możesz skorzystać z załączonego pliku. 
Umieść go w katalogu `/src/main/resources` utworzonego projektu. 
3. Przetestuj działanie tworząc klasę `MainLog.java` jak w poniższym przykładzie:

````java
package pl.coderslab;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainLog {

    private static final Logger log = LogManager.getLogger(MainLog.class);

    public static void main(String[] args) {
        log.debug("Debug");
        log.info("Info");
        log.warn("Warn");
        log.error("Error");
        log.fatal("Fatal");

        log.info("string: {}.", "Hello world");
    }
}

````
4. W pliku konfiguracji, w linii `<Root level="all">`, zmień wartość `all` kolejno na poniższe wartości i zaobserwuj zmiany:

- `fatal`,
- `error`,
- `warn`,
- `info`,
- `debug`.


[log4j]:http://logging.apache.org/log4j/2.x/maven-artifacts.html#Using_Log4j_in_your_Apache_Maven_build


## Zadanie 2

1. Za pomocą pliku `pom.xml` dołącz do projektu bibliotekę `jsoup` &nbsp; poznaną podczas pierwszych warsztatów.
2. Przetestuj działanie, korzystając z poniższego kodu:

````java
Connection connect = Jsoup.connect("http://www.onet.pl/");
try {
    Document document = connect.get();
    Elements links = document.select("span.title");
    for (Element elem : links) {
        System.out.println(elem.text());
    }
} catch (IOException e) {
    e.printStackTrace();
}

````


## Zadanie 3

1. Za pomocą pliku `pom.xml` dołącz do projektu bibliotekę `guava`.
2. Sprawdź poniższy kod korzystający z możliwości biblioteki:
````
List<String> names = Lists.newArrayList("Arek", "Czarek", "Darek");
List<String> reversed = Lists.reverse(names);
System.out.println(reversed);
````
3. Zapoznaj się z jej możliwościami i wypróbuj wybraną z nich.
Więcej informacji dotyczących tej biblioteki znajdziesz w poniższych linkach:
    * [https://www.baeldung.com/guava-lists](https://www.baeldung.com/guava-lists)
    * [https://github.com/google/guava/wiki](https://github.com/google/guava/wiki)
    * [http://zetcode.com/articles/guava/](http://zetcode.com/articles/guava/)
    * [https://www.tutorialspoint.com/guava/index.htm](https://www.tutorialspoint.com/guava/index.htm)



## Zadanie 4

1. Za pomocą pliku `pom.xml` skonfiguruj plugin `maven-assembly-plugin`.  
Plugin ten służy do tworzenia różnego rodzaju archiwów zawierających nasz projekt, np. `zip`, `jar`.
2. Wykorzystamy go do utworzenia wykonywalnego archiwum `jar` z naszego projektu. Plik ten będzie zawierał w sobie wszystkie zależności wymagane do uruchomienia programu.
3. Uzupełnij plik `pom` o definicję pluginu:
    ```xml
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <version>3.0.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <mainClass>pl.coderslab.Example</mainClass>
                        </manifest>
                    </archive>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </plugin>
        </plugins>
    </build>
    ```
    Nazwę **pl.coderslab.Example** &ndash; zamień na własną klasę z metodą main.

4. Z konsoli lub IntelliJ wykonaj następującą komendę:
`mvn clean compile assembly:single`
5. Po poprawnym wykonaniu w folderze **target** otrzymamy plik `jar`
6. Uruchom program wykonując polecenie: `java -jar <nazwa pliku z rozszerzeniem jar>`


## Zadanie 5

1. Zapoznaj się z popularnymi bibliotekami dostępnymi w repozytorium:
[https://mvnrepository.com/popular](https://mvnrepository.com/popular)
2. Nie musisz znać wszystkich &ndash; warto jednak wiedzieć, że są rozwiązania, 
które mogą Ci pomóc w pracy i gdzie możesz ich szukać.
