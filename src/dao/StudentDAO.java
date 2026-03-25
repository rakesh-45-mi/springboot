package dao;

import db.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insertStudent(Student s) {
        String sql = "INSERT INTO students (name, gender, regno, email, dob) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getGender());
            ps.setInt   (3, s.getRegno());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getDob());

            int rows = ps.executeUpdate();
            System.out.println(rows + " student inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    public void deleteStudent(int regno) {
        String sql = "DELETE FROM students WHERE regno = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, regno);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student with regno " + regno + " deleted.");
            else
                System.out.println("No student found with regno " + regno);

        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    public Student findStudent(int regno) {
        String sql = "SELECT * FROM students WHERE regno = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, regno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("sno"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getInt("regno"),
                        rs.getString("email"),
                        rs.getString("dob")
                );
            } else {
                System.out.println("No student found with regno " + regno);
            }

        } catch (SQLException e) {
            System.out.println("Find failed: " + e.getMessage());
        }
        return null;
    }

    public List<Student> findAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("sno"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getInt("regno"),
                        rs.getString("email"),
                        rs.getString("dob")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Find All failed: " + e.getMessage());
        }
        return list;
    }
}
