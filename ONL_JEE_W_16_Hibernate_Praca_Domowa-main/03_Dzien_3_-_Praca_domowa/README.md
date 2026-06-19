![Coders-Lab-1920px-no-background](https://user-images.githubusercontent.com/30623667/104709394-2cabee80-571f-11eb-9518-ea6a794e558e.png)


W ramach pracy domowej rozbudujemy nasz system do zarządzania treścią (CMS - Content Management System).

## Zadanie 1

1. Dla encji `Category` ustaw następujące ograniczenia:
- name - minimum 5 znaków, pole wymagane

2. Dla encji `Author` ustaw następujące ograniczenia:
- firstName - pole wymagane
- lastName - pole wymagane

3. Dla encji `Article` ustaw następujące ograniczenia:
- title - pole wymagane, maksymalnie 200 znaków
- content - pole wymagane, minimalnie 500 znaków
- categories - minimum jedna wybrana kategoria


## Zadanie 2

1. Dodaj walidację formularzy dla akcji kontrolerów:
- CategoryController 
- AuthorController
- ArticleController
