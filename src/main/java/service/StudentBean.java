package service;

import java.util.List;

import DAO.StudentDAO;
import DAO.StudentDAO_Imp;
import Modele.Student;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;


@ManagedBean
@ViewScoped
public class StudentBean {
    private List<Student> students;
    @Inject
    private StudentDAO studentDAO;
    private Student selectedStudent;

    public StudentBean() {
        this.studentDAO = new StudentDAO_Imp();
        this.students = studentDAO.selectAll();

    }

    public void toggleEditMode(Student student) {
        student.setEditMode(!student.getEditMode());
    }

    public void saveChanges() {
        try {
            System.out.println("Saving changes for student: " + selectedStudent.getId());
            System.out.println("Selected Student before update: " + selectedStudent);

            studentDAO.update(selectedStudent);
            toggleEditMode(selectedStudent);
            students = studentDAO.selectAll();

            System.out.println("Update successful for student: " +selectedStudent.getPrenom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentDAO getStudentDAO() {
        return studentDAO;
    }

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }
}