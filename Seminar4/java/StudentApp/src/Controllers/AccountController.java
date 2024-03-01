package Controllers;

import java.util.List;

import Domain.Person;
import Domain.Teacher;
import Domain.WorkingPerson;

public class AccountController {

    public static <T extends WorkingPerson> void paySalary(T person, int salary) {
        System.out.println(person.getName() + " выплачена зарплата " + salary + "р. ");
    }

    //Заготовка для метода averageAge
    public static <T extends Person> double averageAge(List<T> persons) {
        double sum = 0.0;
        for (Person person : persons) {
            sum += person.getAge();
        }
        return sum / persons.size();
    }
}
