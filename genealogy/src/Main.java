import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Person tata = new Person("Jan", "Kowalski", LocalDate.of(1970, 5, 20));
        Person dziecko1 = new Person("Anna", "Kowalska", LocalDate.of(1995, 8, 15));
        Person dziecko2 = new Person("Zofia", "Kowalska", LocalDate.of(2005, 1, 10));
        Person dziecko3 = new Person("Piotr", "Kowalski", LocalDate.of(1998, 3, 22));

        tata.adopt(dziecko1);
        tata.adopt(dziecko2);
        tata.adopt(dziecko3);

        System.out.println("Najmlodsze dziecko taty to: " + tata.getYoungestChild());
        System.out.println("\nWszystkie dzieci taty(posortowane):");
        List<Person> dzieci = tata.getChildren();
        for (Person dziecko : dzieci){
            System.out.println(" - " + dziecko);
        }
        Family rodzina = new Family();

        Person imiennik1 = new Person("Tomasz", "Nowak", LocalDate.of(1980, 1, 1));
        Person imiennik2 = new Person("Tomasz", "Nowak", LocalDate.of(2010, 5, 5));
        Person imiennik3 = new Person("Tomasz", "Nowak", LocalDate.of(1950, 12, 12));

        rodzina.add(tata, dziecko1, dziecko2, dziecko3, imiennik1, imiennik2, imiennik3);

        System.out.println("\nWszyscy Tomasze Nowakowie w rodzinie(posortowane):");
        Person[] tomasze = rodzina.get("Tomasz Nowak");
        for (Person t : tomasze){
            System.out.println(" - " + t);
        }
    }
}