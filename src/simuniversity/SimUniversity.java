package simuniversity;

import java.util.ArrayList;

/**
 *
 * @author laurel
 */
public class SimUniversity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create list and add people to it
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("John", "Smith","295-334-4567","admin@personal.co.uk"));
        list.add(new Person("Carrie", "Meyers","295-987-0202","fakeemail@gmail.com"));
        list.add(new Person("Alex", "Woodrow","295-567-9864","realemail@yahoo.com"));
        list.add(new Employee("Jan", "Smythe","295-334-4568","admin@personal.com"));
        list.add(new Employee("Patsy", "Freemon","295-036-7321","psfreemon@gmail.com"));
        list.add(new Employee("Wildred", "Canner","295-855-1089","wcannered@yahoo.com"));
        list.add(new Faculty("Johnathan", "Cena","295-764-3453","blah@yahoo.com", 
                "3A", "325-990-7890","12-19-2016", "assistant professor"));
        list.add(new Faculty("Alvin", "Winks","295-567-3453","blah@yahoo.com", 
                "3B", "325-990-7890","12-19-2016", "associate professor"));
        list.add(new Faculty("Woodrow", "Longman","295-000-3453","something@yahoo.com", 
                "4A", "325-990-7890","12-19-2016", "professor"));
        list.add(new Staff("Agnew", "Christie","295-555-3453","other@yahoo.com", 
                "4B", "325-990-7890","12-19-2016", "janitor"));
        list.add(new Staff("President", "Nixon","295-975-3453","nixon@yahoo.com", 
                "5A", "325-990-7890","12-19-2016", "chimney sweep"));
        list.add(new Staff("Wendy", "Egbert","295-333-3453","blah@yahoo.com", 
                "5B", "325-990-7890","12-19-2016", "slave"));
        list.add(new Student("Nancy", "Collins","295-334-4567","748598792879587@trashmail.com",
                Student.classStatuses[1]));
        list.add(new Student("Janet", "Mann","295-334-4567","ftb@psu.edu",
                Student.classStatuses[2]));
        list.add(new Student("Quince", "Quinn","295-334-4567","edg@psu.edu",
                Student.classStatuses[3]));
        // Iterate over all people in the list 
        for(Person p:list){
            System.out.println(p.toString());
        }
    }
}
/**
 * "The Changeable interface defines one method, 
 * which allows the first and last name to be changed."
 */
interface Changeable{
    void NameChange(String first, String last);
}
class Person{
    String firstName, lastName, phoneNumber, emailAddress;
    Person(String first, String last, String phone, String email){
        firstName=first;lastName=last;phoneNumber=phone;emailAddress=email;
    }
    @Override
    public String toString(){
        return this.getClass().getSimpleName()+": "+firstName+" "+lastName;
    }
}
/**
 * The Employee class works the same as the Person class<br>
 * Employees do not have offices, office phone numbers, or employment dates 
 * because the instructions didn't explicitly say they did.
 */
class Employee extends Person{
    public Employee(String first, String last, String phone, String email) {
        super(first, last, phone, email);
    }
    // Because it must be overridden in each class
    @Override
    public String toString(){
        return super.toString();
    }
}
class Faculty extends Employee implements Changeable{
    String office, officePhoneNumber, employmentDate, rank;
    public Faculty(String first, String last, String phone, String email) {
        super(first, last, phone, email);
    }
    public Faculty(String first, String last, String phone, String email, 
            String officeID, String officePhone, String dateEmployment, String ranking) {
        super(first, last, phone, email);
        office=officeID;officePhoneNumber=officePhone;employmentDate=dateEmployment; rank=ranking;
    }
    @Override
    public void NameChange(String first, String last) {
        super.firstName=first;super.lastName=last;
    }
    @Override
    public String toString(){
        return super.toString()+", "+rank;
    }
}
class Staff extends Employee{
    String office, officePhoneNumber, employmentDate, title;
    public Staff(String first, String last, String phone, String email) {
        super(first, last, phone, email);
    }
    public Staff(String first, String last, String phone, String email, 
            String officeID, String officePhone, String dateEmployment, String titled) {
        super(first, last, phone, email);
        office=officeID;officePhoneNumber=officePhone;employmentDate=dateEmployment; title=titled;
    }
    @Override
    public String toString(){
        return super.toString()+", "+title;
    }
}
class Student extends Person implements Changeable{
    static String[] classStatuses = {"freshman", "sophomore", "junior", "senior"};
    String classStatus;
    public Student(String first, String last, String phone, String email) {
        super(first, last, phone, email);
    }
    public Student(String first, String last, String phone, String email,
            String classStat) {
        super(first, last, phone, email);
        classStatus=classStat;
    }
    @Override
    public void NameChange(String first, String last) {
        super.firstName=first;super.lastName=last;
    }
    @Override
    public String toString(){
        return super.toString()+", "+classStatus;
    }
}