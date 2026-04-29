import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Person implements Comparable<Person>, Serializable {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Set<Person> children = new HashSet<>();

    public Person(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) throws NegativeLifespanException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        if (deathDate != null && deathDate.isBefore(birthDate)) {
            throw new NegativeLifespanException(firstName + " " + lastName + ": data smierci (" + deathDate + ") jest przed data urodzenia (" + birthDate + ")!");
        }
        this.deathDate = deathDate;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public boolean adopt(Person child) throws ParentingAgeException {
        if (this.deathDate != null && this.deathDate.isBefore(child.birthDate)) {
            throw new ParentingAgeException("Rodzic " + this.getFullName() + " nie zyje w chwili narodzin dziecka " + child.getFullName());
        }
        long ageAtBirth = ChronoUnit.YEARS.between(this.birthDate, child.birthDate);
        if (ageAtBirth < 15) {
            throw new ParentingAgeException("Rodzic " + this.getFullName() + " mial tylko " + ageAtBirth + " lat w chwili narodzin dziecka " + child.getFullName());
        }
        return children.add(child);
    }

    public void forceAdopt(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        List<Person> sorted = new ArrayList<>(children);
        Collections.sort(sorted);
        return sorted;
    }

    @Override
    public int compareTo(Person other) {
        return this.birthDate.compareTo(other.birthDate);
    }

    @Override
    public String toString() {
        String deathStr = (deathDate != null) ? " [+ " + deathDate + "]" : "";
        return firstName + " " + lastName + " (ur. " + birthDate + deathStr + ")";
    }

    public static Person fromCsvLine(String line) throws NegativeLifespanException {
        String[] parts = line.split(",", -1);
        String[] nameParts = parts[0].trim().split(" ", 2);
        String fName = nameParts[0];
        String lName = nameParts.length > 1 ? nameParts[1] : "";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate bDate = LocalDate.parse(parts[1].trim(), formatter);
        LocalDate dDate = null;
        if (!parts[2].trim().isEmpty()) {
            dDate = LocalDate.parse(parts[2].trim(), formatter);
        }
        return new Person(fName, lName, bDate, dDate);
    }

    public static List<Person> fromCsv(String path) throws IOException, NegativeLifespanException, AmbiguousPersonException {
        List<String> lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(path));
        Map<String, Person> map = new LinkedHashMap<>();
        
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) continue;
            Person p = fromCsvLine(lines.get(i));
            if (map.containsKey(p.getFullName())) {
                throw new AmbiguousPersonException("Wykryto duplikat: " + p.getFullName());
            }
            map.put(p.getFullName(), p);
        }
        
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).trim().isEmpty()) continue;
            String[] parts = lines.get(i).split(",", -1);
            Person child = map.get(parts[0].trim());
            
            for (int j = 3; j <= 4; j++) {
                if (parts.length > j && !parts[j].trim().isEmpty()) {
                    Person parent = map.get(parts[j].trim());
                    if (parent != null) {
                        try {
                            parent.adopt(child);
                        } catch (ParentingAgeException e) {
                            System.out.println("UWAGA: " + e.getMessage());
                            System.out.print("Czy mimo to dodac relacje? (Y/N): ");
                            if (scanner.nextLine().trim().equalsIgnoreCase("Y")) {
                                parent.forceAdopt(child);
                            }
                        }
                    }
                }
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void toBinaryFile(String path, List<Person> people) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(people);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Person> fromBinaryFile(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Person>) ois.readObject();
        }
    }
}