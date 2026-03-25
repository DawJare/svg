import java.util.HashMap;
import java.util.Map;

public class Family{
    private Map<String, Person> members = new HashMap<>();

    public void add(Person person){
        members.put(person.getFullName(), person);
    }
    public Person get(String fullName){
        return members.get(fullName);
    }
}