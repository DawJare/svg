import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable<Person>{
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
    public int compareTo(Person other){
        return this.birthDate.compareTo(other.birthDate);
    }
    public Person getYoungestChild(){
        if(children.isEmpty()){
            return null;
        }
        return java.util.Collections.max(children);
    }
    public java.util.List<Person> getChildren(){
        java.util.List<Person> sortedChildren = new java.util.ArrayList<>(children);
        java.util.Collections.sort(sortedChildren);
        return sortedChildren;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
}