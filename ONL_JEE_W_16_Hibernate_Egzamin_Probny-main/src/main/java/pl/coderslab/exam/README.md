### Zadanie 1
Nazwa bazy danych to **exam6**. 
`Jeżeli masz inne niż domyślne dane dostępowe do bazy danych, przed wysłaniem zmian zmień je na standardowe.

1. Utwórz następujące encje i określ walidację:

- `Tag` (nazwa tabeli `tags`):
	- id – klucz główny,
	- active (Boolean),
	- name – pole wymagane.

- `Post` (nazwa tabeli `posts`):
	- id – klucz główny,
	- title – minimalna długość 5 znaków, maksymalna długość 100, pole wymagane,
	- content – pole tekstowe.

2. Nazwy kolumn mają pozostać domyślne.
3. Połącz encje `Post` oraz `Tag` relacją wiele do wielu (dwukierunkową – pamiętaj o odpowiednim określeniu atrybutu `mappedBy`).


## Zadanie 2

1. Utwórz repozytorium dla encji `Post` i `Tag`.
2. Uzupełnij repozytorium o poniższe metody umożliwiające pobieranie:
- wszystkich postów dla zadanego obiektu `Tag`,
- wszystkich postów dla zadanej nazwy tagu – typ danych `String`.


## Zadanie 3

1. Utwórz kontrolery: dla encji `Post` z mapowaniem `/post` oraz dla encji `Tag` z mapowaniem `/tag`.
2. Utwórz akcję oraz formularz umożliwiające dodanie tagu. Formularz ma być dostępny pod adresem `/tag/add`. 
3. Utwórz akcję oraz formularz umożliwiające dodanie postu. Formularz ma być dostępny pod adresem `/post/add` 
(formularz ma posiadać możliwość wyboru jednego lub wielu tagów).
4. Poprawność wprowadzonych danych musi być sprawdzana. Wyświetlaj komunikat o błędach.
5. Po dodaniu postu oraz tagu przekieruj ponownie do formularza dodawania.


## Zadanie 4

1. Utwórz akcję dostępną pod adresem `/tag/all`, która wyświetli (w formie tabeli) listę wszystkich tagów. 
2. Dodaj możliwość zmiany aktywności tagu – link do zmiany umieść w tabeli html (`Aktywuj/Dezaktywuj`) dla każdego tagu. 
Akcja ma być dostępna pod adresem: `/tag/{id}/change`.
Jeżeli tag ma aktywność ustawioną na `true` ma się ona zmienić na `false` i odwrotnie. 
3. Dodaj akcję oraz widok wyświetlający wszystkie posty dla określonego tagu. 
Akcja ma być dostępna pod adresem: `/tag/{id}/posts` – link: `Pokaż posty` umieść w tabeli html.

## Przykład interfejsu

| Nazwa     | Aktywność | 					Akcja	   				                           |
| --------- |:---------:| :-------------------------------------------------------------------:|
| java      | TAK       | Aktywuj/Dezaktywuj, Pokaż posty   |
