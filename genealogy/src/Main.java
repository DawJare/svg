import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Jan", "Kowalski", LocalDate.of(1980, 5, 15)));
        people.add(new Person("Anna", "Nowak", LocalDate.of(1985, 10, 20)));

        System.out.println("Utworzono liste osob!");
    }
}