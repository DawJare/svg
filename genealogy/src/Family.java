import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Family {

    private Map <String, List<Person>> members = new HashMap<>();

    public void add(Person... persons){
        for (Person p : persons){
            String key = p.getFullName();
            members.putIfAbsent(key, new ArrayList<>());
            members.get(key).add(p);
        }
    }
    public Person[] get(String fullName){
        List<Person> people = members.get(fullName);
        if(people == null){
            return new Person[0];
        }
        java.util.Collections.sort(people);
        return people.toArray(new Person[0]);
    }
}