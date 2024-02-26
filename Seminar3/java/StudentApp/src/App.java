import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Domain.Student;
import Domain.StudentGroup;
import Domain.StudentStream;

public class App {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("Иван", 25);
        Student s2 = new Student("Игорь", 23);
        Student s3 = new Student("Иван", 22);
        Student s4 = new Student("Игорь", 23);
        Student s5 = new Student("Даша", 23);
        Student s6 = new Student("Лена", 23);

        Student s7 = new Student("Леша", 25);
        Student s8 = new Student("Петя", 23);
        Student s9 = new Student("Наташа", 22);

        Student s10 = new Student("Маша", 23);
        Student s11 = new Student("Соня", 23);
        Student s12 = new Student("Саша", 23);

        List<Student> listStud = new ArrayList<Student>();
        listStud.add(s1);
        listStud.add(s2);
        listStud.add(s3);
        listStud.add(s4);
        listStud.add(s5);
        listStud.add(s6);

        List<Student> listStud1 = new ArrayList<Student>();
        listStud1.add(s7);
        listStud1.add(s8);
        listStud1.add(s9);

        List<Student> listStud2 = new ArrayList<Student>();
        listStud2.add(s10);
        listStud2.add(s11);
        listStud2.add(s12);

        StudentGroup group4580 = new StudentGroup(listStud, 4580);
        StudentGroup group4581 = new StudentGroup(listStud1, 4581);
        StudentGroup group4582 = new StudentGroup(listStud2, 4582);

        List<StudentGroup> groups = new ArrayList<>();
        groups.add(group4580);
        groups.add(group4581);
        groups.add(group4582);
        StudentStream studentStream = new StudentStream(groups, 1);

        //Вывод списка групп
        for (StudentGroup group : studentStream) {
            System.out.println(group);
        }

        System.out.println("=========================================================");

        //Сортировка групп в потоке по количеству студентов в группе
        Collections.sort(studentStream.getGroups());

        //Вывод списка групп
        for (StudentGroup group : studentStream) {
            System.out.println(group);
        }

        System.out.println("=========================================================");

        //Вывод списка студентов из группы
        System.out.println(group4580);
        for (Student std : group4580) {
            System.out.println(std);
        }

        System.out.println("=========================================================");
        System.out.println(studentStream);
        //Сортировка списка студентов из группы
        //Collections.sort(group4580.getGroup());
        //Вывод списка студентов из группы
        //for (Student std : group4580.getGroup()) {
        //    System.out.println(std);
        //}
    }
}
