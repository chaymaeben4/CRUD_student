package service;

import java.lang.ref.PhantomReference;
import java.util.List;

import DAO.StudentDAO;
import DAO.StudentDAO_Imp;
import Modele.Student;
import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.component.html.HtmlCommandButton;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.faces.component.html.HtmlInputText;

@ManagedBean
@ViewScoped
public class StudentBean {
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
    }



    public List<Student> getStudents() {
        return studentDAO.selectAll();
    }

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
