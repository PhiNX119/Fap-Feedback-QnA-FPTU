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
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Subject extends DBContext{
    
    private String subjectId, code, name, classcode, teacher;

    public Subject() {
        connect();
    }

    public Subject(String subjectId, String code, String name, String classcode, String teacher) {
        this.subjectId = subjectId;
        this.code = code;
        this.name = name;
        this.classcode = classcode;
        this.teacher = teacher;
        connect();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasscode() {
        return classcode;
    }

    public void setClasscode(String classcode) {
        this.classcode = classcode;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    //Khai bao cac thanh phan xu li DB
    Connection cnn; //Ket noi DB
    Statement stm; //thuc hien cac cau lenh SQL
    ResultSet rs; //luu tru va xu li du lieu
    PreparedStatement pstm;

    public void connect() {
        cnn = super.connection;
        if (cnn != null) {
            System.out.println("Connect success!");
        } else {
            System.out.println("Connect fail");
        }
    }    
    
    public ArrayList<Subject> getListSubject(String id) {
        ArrayList<Subject> data = new ArrayList<Subject>();
        try {
            String strSQL = "select * from Subject c, Class cl, Student s where c.class = cl.name and cl.studentId = s.studentId and s.studentId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String subjectId = rs.getString(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                String classcode = rs.getString(4);
                String teacher = rs.getString(5);
                Subject s = new Subject(subjectId, code, name, classcode, teacher);
                data.add(s);
            }
        } catch (Exception e) {
            System.out.println("error getListSubject: " + e.getMessage());
        }
        return data;
    }
    
    public Subject getSubjectbyId(String id) {
        try {
            String strSQL = "select * from Subject where subjectId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String subjectId = rs.getString(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                String classcode = rs.getString(4);
                String teacher = rs.getString(5);
                Subject data = new Subject(subjectId, code, name, classcode, teacher);
                return data;
            }
        } catch (Exception e) {
            System.out.println("error getSubjectbyId: " + e.getMessage());
        }
        return null;
    }
    
    public ArrayList<Subject> getSubjectbyTeacher(String teacherName) {
        ArrayList<Subject> data = new ArrayList<Subject>();
        try {
            String strSQL = "select * from Subject where teacher = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, teacherName);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String subjectId = rs.getString(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                String classcode = rs.getString(4);
                String teacher = rs.getString(5);
                Subject s = new Subject(subjectId, code, name, classcode, teacher);
                data.add(s);
            }
        } catch (Exception e) {
            System.out.println("error getSubjectbyTeacher: " + e.getMessage());
        }
        return data;
    }
}
