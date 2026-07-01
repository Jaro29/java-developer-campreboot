USE bookstore_db;

INSERT INTO customers (name, email) VALUES
                                        ('Anna Kowalska', 'anna.kowalska@example.com'),
                                        ('Piotr Nowak', 'piotr.nowak@example.com'),
                                        ('Katarzyna Wiśniewska', 'katarzyna.wisniewska@example.com'),
                                        ('Marek Wójcik', 'marek.wojcik@example.com'),
                                        ('Ewa Kowalczyk', 'ewa.kowalczyk@example.com'),
                                        ('Tomasz Kamiński', 'tomasz.kaminski@example.com'),
                                        ('Magdalena Lewandowska', 'magdalena.lewandowska@example.com'),
                                        ('Michał Zieliński', 'michal.zielinski@example.com'),
                                        ('Agnieszka Szymańska', 'agnieszka.szymanska@example.com'),
                                        ('Krzysztof Dąbrowski', 'krzysztof.dabrowski@example.com');

INSERT INTO addresses (customer_id, city, street) VALUES
                                                      (1, 'Warszawa', 'Marszałkowska 12'),
                                                      (2, 'Kraków', 'Floriańska 5'),
                                                      (3, 'Wrocław', 'Świdnicka 8'),
                                                      (4, 'Poznań', 'Półwiejska 20'),
                                                      (5, 'Gdańsk', 'Długa 3'),
                                                      (6, 'Łódź', 'Piotrkowska 100'),
                                                      (7, 'Szczecin', 'Wojska Polskiego 15'),
                                                      (8, 'Lublin', 'Krakowskie Przedmieście 7'),
                                                      (9, 'Katowice', 'Mariacka 9'),
                                                      (10, 'Bydgoszcz', 'Gdańska 22');

INSERT INTO books (title, price) VALUES
                                     ('Pan Tadeusz', 29.99),
                                     ('Lalka', 34.50),
                                     ('Wiedźmin: Ostatnie życzenie', 39.90),
                                     ('Zbrodnia i kara', 24.99),
                                     ('Chłopi', 27.50),
                                     ('Ferdydurke', 22.00),
                                     ('Solaris', 32.90),
                                     ('Quo Vadis', 28.75),
                                     ('Dżuma', 25.60),
                                     ('Rok 1984', 31.20);

INSERT INTO borrowings (customer_id, book_id, borrow_date) VALUES
                                                               (1, 3, '2025-01-10'),
                                                               (2, 1, '2025-02-15'),
                                                               (3, 7, '2025-03-01'),
                                                               (4, 5, '2025-03-20'),
                                                               (5, 2, '2025-04-05'),
                                                               (6, 9, '2025-04-18'),
                                                               (7, 4, '2025-05-02'),
                                                               (8, 10, '2025-05-25'),
                                                               (9, 6, '2025-06-10'),
                                                               (10, 8, '2025-06-22');