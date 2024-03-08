package managedBean;

import java.util.List;

import DAO.StudentDAO;
import DAO.StudentDAO_Imp;
import Modele.Student;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class StudentBean {
    private List<Student> students;

    private StudentDAO studentDAO;

    @PostConstruct
    public void init() {
        studentDAO = new StudentDAO_Imp();
        students = studentDAO.selectAll();
    }

    public List<Student> getStudents() {
        return students;
    }

    //editmode
    public void toggleEditMode(Student student){
        student.setInEditMode(!student.getInEditMode());
    }
}
