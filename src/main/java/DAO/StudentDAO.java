package DAO;

import Modele.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> selectAll();
    void update(Student student);
    Student selectbyId(int id);
}
