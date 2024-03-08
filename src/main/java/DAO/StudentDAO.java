package DAO;

import Modele.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> selectAll();
}
