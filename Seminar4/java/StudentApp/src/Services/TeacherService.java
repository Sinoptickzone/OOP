package Services;

import Domain.PersonComparator;
import Domain.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements iPersonService<Teacher> {
    private int count;
    private List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public List<Teacher> getAll() {
        return this.teachers;
    }

    @Override
    public void create(String name, int age) {
        Teacher teacher = new Teacher(name, age, "Docent");
        teachers.add(teacher);
        this.count++;
    }

    public void sortByFIO() {
        teachers.sort(new PersonComparator<>());
    }

    public void printTeachersList() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
}
