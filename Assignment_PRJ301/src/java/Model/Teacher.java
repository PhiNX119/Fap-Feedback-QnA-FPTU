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
public class Teacher extends DBContext {

    private String username, password, campus;

    public Teacher() {
        connect();
    }

    public Teacher(String username, String password, String campus) {
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

    public boolean checkTeacherLogin(String username, String password, String campus) {
        try {
            String strSQL = "select * from Teacher where username = ? and password = ? and campus = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, username);
            pstm.setString(2, password);
            pstm.setString(3, campus);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("error checkTeacherLogin: " + e.getMessage());
        }
        return false;
    }

    public Teacher getTDatabyAccount(String fUsername, String fPassword, String fCampus) {
        try {
            String strSQL = "select * from Teacher where username = ? and password = ? and campus = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, fUsername);
            pstm.setString(2, fPassword);
            pstm.setString(3, fCampus);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String campus = rs.getString(3);
                Teacher t = new Teacher(username, password, campus);
                return t;
            }
        } catch (Exception e) {
            System.out.println("error getDatabyAccount: " + e.getMessage());
        }
        return null;
    }
}
