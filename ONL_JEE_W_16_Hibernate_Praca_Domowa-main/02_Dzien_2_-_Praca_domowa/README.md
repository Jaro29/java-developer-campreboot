![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/30623667/104709394-2cabee80-571f-11eb-9518-ea6a794e558e.png)


## Zadanie 1

W ramach pracy domowej rozbudujemy nasz system do zarządzania treścią (CMS - Content Management System).

#### Zadanie 1
1. W klasach `ArticleDao`, `AuthorDao`, `CategoryDao` dodaj metody, które przy użyciu `JPQL` 
umożliwią pobieranie wszystkich obiektów danego typu.  


## Zadanie 2

1. Utwórz kontroler `HomePageController`, 
2. Utwórz akcję startową o nazwie `home()` dostępną pod adresem `/`, wyświetlającą 5 ostatnio dodanych artykułów.
3. Wyświetlamy tytuł, datę dodania oraz zawartość danego artykułu.

**W klasie Dao utwórz wymaganą metodę, wstrzyknij Dao do kontrolera**


## Zadanie 3

1. Utwórz kontroler `CategoryController`, utwórz w nim akcje, które pozwolą:
- wyświetlić listę wszystkich kategorii
- dodać kategorię
- usunąć kategorię
- edytować kategorię

2. Dla akcji dodawania oraz edycji utwórz formularz.
3. Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.


## Zadanie 4

1. Utwórz kontroler `AuthorController`, utwórz w nim akcje, które pozwolą:
- wyświetlić listę wszystkich autorów
- dodać autora
- usunąć autora
- edytować autora

2. Dla akcji dodawania oraz edycji utwórz formularz.
3. Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.


## Zadanie 5

1. Utwórz kontroler `ArticleController`, utwórz w nim akcje, które pozwolą:
- wyświetlić listę wszystkich artykułów
- dodać artykuł
- usunąć artykuł
- edytować artykuł

2. Dla akcji dodawania oraz edycji utwórz formularz.
3. Formularz tworzenia ma zawierać pola z możliwością wyboru autora.
4. Formularz tworzenia ma zawierać pola z możliwością wyboru wielu kategorii.
5. Dodaj konwertery dla klas `Author` oraz `Category`.
3. Utwórz linki nawigacyjne umożliwiające przechodzenie między akcjami - bez konieczności znania adresów URL.


