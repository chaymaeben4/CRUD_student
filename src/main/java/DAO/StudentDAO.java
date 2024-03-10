package DAO;

import Modele.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> selectAll();

    void saveStudent(Student student);
    boolean deleteStudent(int id);

    void update(Student student);


}
