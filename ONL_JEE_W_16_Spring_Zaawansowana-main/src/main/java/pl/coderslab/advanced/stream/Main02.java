package pl.coderslab.advanced.stream;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Predicate;

public class Main02 {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Jan", "Kowalski", "M", "1999-05-12", new BigDecimal("6500")),
                new Employee("Anna", "Nowak", "K", "2001-11-03", new BigDecimal("3200")),
                new Employee("Piotr", "Wiśniewski", "M", "1995-02-18", new BigDecimal("5800")),
                new Employee("Katarzyna", "Wójcik", "K", "1992-07-25", new BigDecimal("8100")),
                new Employee("Michał", "Kamiński", "M", "1985-09-14", new BigDecimal("9400")),
                new Employee("Agnieszka", "Lewandowska", "K", "1998-01-09", new BigDecimal("5300")),
                new Employee("Tomasz", "Zieliński", "M", "1991-12-21", new BigDecimal("7000")),
                new Employee("Magdalena", "Szymańska", "K", "2000-06-30", new BigDecimal("7600")),
                new Employee("Paweł", "Niwiński", "M", "1987-03-17", new BigDecimal("8900")),
                new Employee("Joanna", "Dąbrowska", "K", "1996-10-05", new BigDecimal("3100"))
        );

        employees.stream()
                .filter(employee -> employee.surname.startsWith("N"))
                .forEach(System.out::println);

        employees.stream()
                .filter(getEmployeePredicate(30, 45))
                .forEach(System.out::println);

        employees.stream()
                .filter(getEmployeePredicate(20, 30))
                .filter(employee -> employee.gender.equalsIgnoreCase("K"))
                .filter(isEligibleForRaise(new BigDecimal("3500")))
                .forEach(e ->
                        e.salary = e.salary.multiply(new BigDecimal("1.05"))
                );
    }

    private static Predicate<Employee> isEligibleForRaise(BigDecimal salaryLimit) {
        return e -> e.salary.compareTo(salaryLimit) <= 0;
    }

    private static @NonNull Predicate<Employee> getEmployeePredicate(int x, int x1) {
        return employee -> {
            int age = Period.between(
                    LocalDate.parse(employee.birthday),
                    LocalDate.now()
            ).getYears();

            return age >= x && age <= x1;
        };
    }
}
