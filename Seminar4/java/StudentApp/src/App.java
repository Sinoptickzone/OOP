import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Controllers.AccountController;
import Domain.*;
import Services.TeacherService;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Иван", 25);
        Student s2 = new Student("Игорь", 23);
        Student s3 = new Student("Иван", 22);
        Student s4 = new Student("Игорь", 23);
        Student s5 = new Student("Даша", 23);
        Student s6 = new Student("Лена", 23);

        List<Student> listStud = new ArrayList<>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);
        listStud.add(s4);
        listStud.add(s5);
        listStud.add(s6);

        StudentGroup group4580 = new StudentGroup(listStud, 4580);
        //System.out.println(group4580);

        for (Student std : group4580) {
            System.out.println(std);
        }

        System.out.println("=========================================================");

        Collections.sort(group4580.getGroup());

        for (Student std : group4580.getGroup()) {
            System.out.println(std);
        }

        Teacher t1 = new Teacher("Галина", 55, "Docent");
        Teacher t2 = new Teacher("Татьяна", 57, "Docent");
        Teacher t3 = new Teacher("Александра", 36, "Docent");

        TeacherService teacherService = new TeacherService();
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teacherService.setTeachers(teachers);

        System.out.println("Список учителей: ");
        teacherService.printTeachersList();

        teacherService.sortByFIO();

        System.out.println("Отсортированный список учителей: ");
        teacherService.printTeachersList();

        System.out.println(new PersonComparator<Student>().compare(s1, s3));

        Employee e1 = new Employee("Сергей", 55, "Разнорабочий");

        AccountController.paySalary(t1, 50000);
        AccountController.paySalary(e1, 20000);

        List<Person> persons = new ArrayList<>();
        persons.addAll(listStud);
        persons.add(t1);
        persons.add(t2);
        persons.add(e1);

        System.out.println("Средний возраст студентов: " + AccountController.averageAge(listStud));
        System.out.println("Средний возраст всех людей: " + AccountController.averageAge(persons));
    }
}
