import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Person{
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private Set<Person> children = new HashSet<>();

    public Person(String firstName, String lastName, LocalDate birthDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    public boolean adopt(Person child){
        return children.add(child);
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
}