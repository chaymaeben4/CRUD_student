package DAO;

import Modele.Student;
import util.DatabaseConfig;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO_Imp implements StudentDAO {
    private final DatabaseConfig db = new DatabaseConfig();

    @Override
    public List<Student> selectAll() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = db.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
                list.add(s);
            }
        } catch (SQLException E) {
            E.printStackTrace();
        }
        return list;
    }
}
