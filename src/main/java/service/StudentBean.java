package service;

import java.lang.ref.PhantomReference;
import java.util.List;

import DAO.StudentDAO;
import DAO.StudentDAO_Imp;
import Modele.Student;
<<<<<<< HEAD
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.component.html.HtmlCommandButton;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.faces.component.html.HtmlInputText;
=======
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

>>>>>>> chaymae1

@ManagedBean
@ViewScoped
public class StudentBean {
<<<<<<< HEAD
    private boolean showAddStudentForm;
    private int studentIdToDelete;
    private HtmlDataTable htmlDataTable;
    private HtmlInputText inputId;
    private HtmlInputText inputNom;
    private HtmlInputText inputPrenom;
    private HtmlInputText inputEmail;
    private String id;
    private int pageNumber = 1; //numero de page actielle
    private int pageSize = 10;  //nombre de lignes a afficher dans chaque page

    public StudentBean() {
        this.showAddStudentForm=false;
        this.studentDAO = new StudentDAO_Imp();
        this.htmlDataTable=new HtmlDataTable();
        this.studentAdd=new Student();
        this.inputId=new HtmlInputText();
        this.inputNom=new HtmlInputText();
        this.inputPrenom=new HtmlInputText();
        this.inputEmail=new HtmlInputText();
    }

    public int getStudentIdToDelete() {
        return studentIdToDelete;
    }

    public void setStudentIdToDelete(int studentIdToDelete) {
        this.studentIdToDelete = studentIdToDelete;
    }

    public HtmlInputText getInputNom() {
        return inputNom;
    }

    public void setInputNom(HtmlInputText inputNom) {
        this.inputNom = inputNom;
    }

    public HtmlInputText getInputPrenom() {
        return inputPrenom;
    }

    public void setInputPrenom(HtmlInputText inputPrenom) {
        this.inputPrenom = inputPrenom;
    }

    public HtmlInputText getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(HtmlInputText inputEmail) {
        this.inputEmail = inputEmail;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HtmlInputText getInputId() {
        return inputId;
    }

    public void setInputId(HtmlInputText inputId) {
        this.inputId = inputId;
    }

    private StudentDAO studentDAO;
    private Student studentAdd;

    public Student getStudentAdd() {
        return studentAdd;
    }

    public boolean isShowAddStudentForm() {
        return showAddStudentForm;
    }

    public void setShowAddStudentForm(boolean showAddStudentForm) {
        this.showAddStudentForm = showAddStudentForm;
    }

    public void setStudentAdd(Student studentAdd) {
        this.studentAdd = studentAdd;
=======
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
>>>>>>> chaymae1
    }



<<<<<<< HEAD
=======


>>>>>>> chaymae1
    public List<Student> getStudents() {
        return studentDAO.selectAll();
    }

<<<<<<< HEAD
    public void saveStudent() {
        this.showAddStudentForm=false;
        studentDAO.saveStudent(studentAdd);
        System.out.println("student saved");
    }

    public void addStudent(){
        System.out.println("row added");
        this.showAddStudentForm=true;
    }

    public void deleteStudent(){
        if(studentDAO.deleteStudent(studentIdToDelete)){
            System.out.println("deleted");
        }
        else{
            System.out.println("not deleted");
        }

    }

    // Méthode pour récupérer les étudiants visibles sur la page actuelle
    public List<Student> getVisibleStudents() {
        int start = (pageNumber - 1) * pageSize;
        int end = Math.min(start + pageSize, getStudents().size());
        return getStudents().subList(start, end);
    }
    // Méthode pour aller à la page précédente
    public void previousPage() {
        if (pageNumber > 1) {
            pageNumber--;
        }
    }

    // Méthode pour aller à la page suivante
    public void nextPage() {
        if (isHasMoreStudents()) {
            pageNumber++;
        }
    }

    // Méthode pour vérifier s'il y a plus d'étudiants à afficher sur la page suivante
    public boolean isHasMoreStudents() {
        int start = pageNumber * pageSize;
        return start < getStudents().size();
    }



}
=======
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
>>>>>>> chaymae1
