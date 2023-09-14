/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class Student extends DBContext {

    private String username, password, studentId, displayname, campus;

    public Student() {
        connect();
    }

    public Student(String username, String password, String studentId, String displayname, String campus) {
        this.username = username;
        this.password = password;
        this.studentId = studentId;
        this.displayname = displayname;
        this.campus = campus;
        connect();
    }

    public Student(String username, String password, String campus) {
        this.username = username;
        this.password = password;
        this.campus = campus;
        connect();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    //Khai bao cac thanh phan xu li DB
    Connection cnn;         //Ket noi DB
    Statement stm;          //thuc hien cac cau lenh SQL
    ResultSet rs;           //luu tru va xu li du lieu
    PreparedStatement pstm; //thuc hien cac cau lenh sql

    public void connect() {
        cnn = super.connection;
        if (cnn != null) {
            System.out.println("Connect success!");
        } else {
            System.out.println("Connect fail");
        }
    }

    public boolean checkStudentLogin(String username, String password, String campus) {
        try {
            String strSQL = "select * from Student where username = ? and password = ? and campus = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, username);
            pstm.setString(2, password);
            pstm.setString(3, campus);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("error checkStudentLogin: " + e.getMessage());
        }
        return false;
    }

    public Student getSDatabyAccount(String fUsername, String fCampus) {        
        try {
            String strSQL = "select * from Student where username = ? and campus = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, fUsername);
            pstm.setString(2, fCampus);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String studentId = rs.getString(3);
                String displayname = rs.getString(4);
                String campus = rs.getString(5);
                Student data = new Student(username, password, studentId, displayname, campus);
                return data;
            }
        } catch (Exception e) {
            System.out.println("error getDatabyAccount: " + e.getMessage());
        }
        return null;
    }
}
