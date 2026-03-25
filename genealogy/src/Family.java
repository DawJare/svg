import java.util.HashMap;
import java.util.Map;

public class Family{
    private Map<String, Person> members = new HashMap<>();

    public void add(Person... persons){
        for (Person p : persons) {
            members.put(p.getFullName(), p);
        }
    }
    public Person get(String fullName){
        return members.get(fullName);
    }
}