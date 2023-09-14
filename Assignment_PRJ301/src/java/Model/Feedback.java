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
public class Feedback extends DBContext {

    private String subjectId, teacher, classname, studentId, q1, q2, q3, q4, q5, comment;

    public Feedback() {
        connect();
    }

    public Feedback(String subjectId, String teacher, String classname, String studentId, String q1, String q2, String q3, String q4, String q5, String comment) {
        this.subjectId = subjectId;
        this.teacher = teacher;
        this.classname = classname;
        this.studentId = studentId;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.q5 = q5;
        this.comment = comment;
        connect();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
    }

    public String getQ4() {
        return q4;
    }

    public void setQ4(String q4) {
        this.q4 = q4;
    }

    public String getQ5() {
        return q5;
    }

    public void setQ5(String q5) {
        this.q5 = q5;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public boolean addFeedback(String subjectId, String teacher, String classname, String studentId, String q1, String q2, String q3, String q4, String q5, String comment) {
        try {
            String strSQL = "INSERT [dbo].[Feedback] ([subjectId], [teacher], [class], [studentId], [q1], [q2], [q3], [q4], [q5], [comment]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, subjectId);
            pstm.setString(2, teacher);
            pstm.setString(3, classname);
            pstm.setString(4, studentId);
            pstm.setString(5, q1);
            pstm.setString(6, q2);
            pstm.setString(7, q3);
            pstm.setString(8, q4);
            pstm.setString(9, q5);
            pstm.setString(10, comment);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error addFeedback: " + e.getMessage());
        }
        return false;
    }

    public boolean checkFeedbackExist(String subjectId, String studentId) {
        try {
            String strSQL = "select * from Feedback where subjectId = ? and studentId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, subjectId);
            pstm.setString(2, studentId);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("error checkFeedbackExist: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteFeedback(String subjectId, String studentId) {
        try {
            String strSQL = "delete from Feedback where subjectId = ? and studentId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, subjectId);
            pstm.setString(2, studentId);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error deleteFeedback: " + e.getMessage());
        }
        return false;
    }

    public Feedback getFeedbackByID(String subject_Id, String student_Id) {
        try {
            String strSQL = "select * from Feedback where subjectId = ? and studentId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, subject_Id);
            pstm.setString(2, student_Id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String subjectId = rs.getString(1);
                String teacher = rs.getString(2);
                String classname = rs.getString(3);
                String studentId = rs.getString(4);
                String q1 = rs.getString(5);
                String q2 = rs.getString(6);
                String q3 = rs.getString(7);
                String q4 = rs.getString(8);
                String q5 = rs.getString(9);
                String comment = rs.getString(10);
                Feedback f = new Feedback(subjectId, teacher, classname, studentId, q1, q2, q3, q4, q5, comment);
                return f;
            }
        } catch (Exception e) {
            System.out.println("error getFeedbackByID: " + e.getMessage());
        }
        return null;
    }

    public boolean updateFeedback(String subjectId, String studentId, String q1, String q2, String q3, String q4, String q5, String comment) {
        try {
            String strSQL = "update Feedback set q1 = ?, q2 = ?, q3 = ?, q4 = ?, q5 = ?, comment = ? where subjectId = ? and studentId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, q1);
            pstm.setString(2, q2);
            pstm.setString(3, q3);
            pstm.setString(4, q4);
            pstm.setString(5, q5);
            pstm.setString(6, comment);
            pstm.setString(7, subjectId);
            pstm.setString(7, studentId);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error updateFeedback: " + e.getMessage());
        }
        return false;
    }

    public boolean updateComment(String subjectId, String studentId, String comment) {
        try {
            String strSQL = "update Feedback set comment = ? where subjectId = ? and studentId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, comment);
            pstm.setString(2, subjectId);
            pstm.setString(3, studentId);
            pstm.executeUpdate();
            System.out.println("comment: " + comment);
            System.out.println("studentId: " + studentId);
            System.out.println("subjectId: " + subjectId);
            return true;
        } catch (Exception e) {
            System.out.println("error updateComment: " + e.getMessage());
        }
        return false;
    }
    
    public ArrayList<Feedback> getFeedbackbyId(String subject_Id) {
        ArrayList<Feedback> data = new ArrayList<Feedback>();
        try {
            String strSQL = "select * from Feedback where subjectId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, subject_Id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String subjectId = rs.getString(1);
                String teacher = rs.getString(2);
                String classname = rs.getString(3);
                String studentId = rs.getString(4);
                String q1 = rs.getString(5);
                String q2 = rs.getString(6);
                String q3 = rs.getString(7);
                String q4 = rs.getString(8);
                String q5 = rs.getString(9);
                String comment = rs.getString(10);
                Feedback f = new Feedback(subjectId, teacher, classname, studentId, q1, q2, q3, q4, q5, comment);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("error getFeedbackByID: " + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<Feedback> getListFeedbackByClass(String subject_Id, String teacher0, String class_name) {
        ArrayList<Feedback> data = new ArrayList<Feedback>();
        try {
            String strSQL = "select * from Feedback where subjectId = ? and teacher = ? and class = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, subject_Id);
            pstm.setString(2, teacher0);
            pstm.setString(3, class_name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String subjectId = rs.getString(1);
                String teacher = rs.getString(2);
                String classname = rs.getString(3);
                String studentId = rs.getString(4);
                String q1 = rs.getString(5);
                String q2 = rs.getString(6);
                String q3 = rs.getString(7);
                String q4 = rs.getString(8);
                String q5 = rs.getString(9);
                String comment = rs.getString(10);
                Feedback f = new Feedback(subjectId, teacher, classname, studentId, q1, q2, q3, q4, q5, comment);
                data.add(f);
            }
        } catch (Exception e) {
            System.out.println("error getListFeedbackByClass: " + e.getMessage());
        }
        return data;
    }
}
