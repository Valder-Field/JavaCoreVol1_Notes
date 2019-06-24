import java.util.*;

public class ComparatorTest {
    public static void main(String[] args) {
        Person[] people = new Person[6];
        people[0] = new Person("abc", "bwec", "sdg");
        people[1] = new Person("bawe", "bwec", "absgd");
        people[2] = new Person("sdb", null, "cxzagagd");
        people[3] = new Person("dg", "bwec", "sggad");
        people[4] = new Person("asgag", "bwec", "sdg");
        people[5] = new Person("gdg", null, "dgd");
        show("original array :", people);

        Arrays.sort(people, Comparator.comparing(Person::getLastName));
        show("Sorted by last name :", people);

        Arrays.sort(people, 
            Comparator.comparing(Person::getLastName)
                      .thenComparing(Person::getFirstName));
        show("Sorted by last name (then first name) :", people);

        Arrays.sort(people, 
            Comparator.comparing(Person::getLastName,
                (s, t) -> Integer.compare(s.length(), t.length())));
        show("Sorted by last name length :", people);

        Arrays.sort(people, Comparator.comparingInt(p -> p.getLastName().length()));
        show("Sorted by last name length :", people);

        Arrays.sort(people, Comparator.comparing(Person::getMiddleName,                        
                                                Comparator.nullsFirst(Comparator.naturalOrder())));
        show("Sorted by middle name (null first) :", people);
    }
    public static void show(String s, Person[] arr) {
        System.out.println(s);
        boolean fi =  true;
        for(Person p : arr) {
            if(!fi) System.out.print(", ");
            fi = false;
            System.out.print(p.getFirstName() + " " + p.getMiddleName() + " " + p.getLastName());
        }
        System.out.println();
    }
}
class Person {
    private String firstName, middleName, lastName;
    Person(String fi, String mi, String la) {
        firstName = fi;
        middleName = mi;
        lastName = la;
    }
    String getFirstName() {
        return firstName;
    }
    String getMiddleName() {
        return middleName;
    }
    String getLastName() {
        return lastName;
    }
}