package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import Controller.Interfaces.iGetModel;
import Model.Domain.Student;

/**
 * This class represents a model for handling student data stored in a file.
 */
public class FileModelClass implements iGetModel {
    private String fileName;

    /**
     * Constructs a new FileModelClass with the specified file name.
     *
     * @param fileName the name of the file to be used for storing student data
     */
    public FileModelClass(String fileName) {
        this.fileName = fileName;
        // open fileWriter
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush(); // flush the outputStream and write buffered output bytes
        } catch (Exception e) {
            System.out.println(e.getMessage()); // print exception message to console
        }
    }

    /**
     * Saves a list of students to the file. Appends to the file if specified.
     *
     * @param students the list of students to save
     * @param append   true if data should be appended to the file, false to overwrite
     */
    public void saveAllStudentsToFile(List<Student> students, boolean append) {
        // open fileWriter
        try(FileWriter fw = new FileWriter(fileName, append)) {
            // iterate through list of students and write each as separate line
            for(Student pers : students) {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush(); // flush the outputStream and write buffered output bytes
        } catch (Exception e) {
            System.out.println(e.getMessage()); // print exception message to console
        }
    }

    /**
     * Retrieves all students stored in the file.
     *
     * @return a list of Student objects read from the file
     */
    @Override
    public List<Student> getAllStudents() {
        List<Student> students  = new ArrayList<>();
        try {
            // read from file line by line
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line != null) {
                String[] param = line.split(" "); // split line by spaces
                // construct student object
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                pers.setId(Integer.parseInt(param[2])); // set id
                students.add(pers); // add student to list
                line = reader.readLine(); // read next line
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage()); // write exception message to console
        }
        return students;
    }

    /**
     * Deletes a student with the specified id from the file.
     *
     * @param id the id of the student to delete
     * @return true if student was successfully deleted, false otherwise
     */
    @Override
    public boolean delete(int id) {
        List<Student> students = getAllStudents(); // get list of all students
        boolean removed = students.removeIf(student -> student.getId() == id); // delete student from list if id matches
        // if student deleted save modified list to file
        if (removed) {
            saveAllStudentsToFile(students, false);
        }
        // return result of deletion
        return removed;
    }
}
