## Zadanie 1 - rozwiązywane z wykładowcą

Uzupełnij implementację metody klasy AddressBook. Optional<String> findNameByAddress(String address) tak, by dla zadanego adresu zwróciła odpowiedniego użytkownika.
Zachowaj istniejącą sygnaturę metody.

## Zadanie 2

Uzupełnij implementację metody klasy AddressBook. public Optional<String> findAddressByName(String name) tak, by dla zadanego użytkownika zwróciła odpowiedni adres.
Zachowaj istniejącą sygnaturę metody.

## Zadanie 3

Skonstruuj strumień, który z listy podanej poniżej wybierze i wypisze na ekranie tylko niepuste łańcuchy.

```java
List<Optional<String>> listOfOptionals = Arrays.asList(
Optional.empty(), Optional.of("java"), Optional.empty(),
Optional.of("python"), Optional.of("php"), Optional.empty(), Optional.of(""));
```