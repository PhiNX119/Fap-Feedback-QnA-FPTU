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
public class Question extends DBContext {

    private String questionId, question;

    public Question() {
        connect();
    }

    public Question(String questionId, String question) {
        this.questionId = questionId;
        this.question = question;
        connect();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    public ArrayList<Question> getListQuestion() {
        ArrayList<Question> data = new ArrayList<Question>();
        try {
            String strSQL = "select * from Question";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String questionId = rs.getString(1);
                String question = rs.getString(2);
                Question q = new Question(questionId, question);
                data.add(q);
            }
            return data;
        } catch (Exception e) {
            System.out.println("error getListQuestion: " + e.getMessage());
        }
        return null;
    }
    
    public ArrayList<Question> getListWaitingQuestion() {
        ArrayList<Question> data = new ArrayList<Question>();
        try {
            String strSQL = "select * from WaitingQuestion";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String questionId = rs.getString(1);
                String question = rs.getString(2);
                System.out.println("id: " + questionId);
                System.out.println("question: " + question);
                Question q = new Question(questionId, question);
                data.add(q);
            }
            return data;
        } catch (Exception e) {
            System.out.println("error getListWaitingQuestion: " + e.getMessage());
        }
        return null;
    }

    public boolean addQuestion(String question) {
        try {
            String strSQL = "INSERT [dbo].[Question] ([question]) VALUES (?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, question);
            pstm.executeUpdate();
            System.out.println("question: " + question);
            return true;
        } catch (Exception e) {
            System.out.println("error addQuestion: " + e.getMessage());
            System.out.println("question: " + question);
        }
        return false;
    }
    
    public boolean addWaitingQuestion(String question) {
        try {
            String strSQL = "INSERT [dbo].[WaitingQuestion] ([question]) VALUES (?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, question);
            pstm.executeUpdate();
            System.out.println("question: " + question);
            return true;
        } catch (Exception e) {
            System.out.println("error addWaitingQuestion: " + e.getMessage());
            System.out.println("question: " + question);
        }
        return false;
    }

    public boolean deleteQuestion(String questionId) {
        try {
            String strSQL = "delete from Question where questionId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, questionId);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error deleteQuestion: " + e.getMessage());
        }
        return false;
    }
    
    public boolean deleteWaitingQuestion(String questionId) {
        try {
            String strSQL = "delete from WaitingQuestion where questionId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, questionId);
            pstm.executeUpdate();
            System.out.println("deletewq: " + questionId);
            return true;
        } catch (Exception e) {
            System.out.println("deletewq error: " + questionId);
            System.out.println("error deleteWaitingQuestion: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Question> findQuestion(String parameter) {
        ArrayList<Question> data = new ArrayList<Question>();
        try {
            String strSQL = "select * from Question where question like ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, "%" + parameter + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String questionId = rs.getString(1);
                String question = rs.getString(2);
                Question q = new Question(questionId, question);
                data.add(q);
            }
            return data;
        } catch (Exception e) {
            System.out.println("error findQuestion: " + e.getMessage());
        }
        return null;
    }

    public void getQuestionbyId(String parameter) {
        try {
            String strSQL = "select * from Question where question = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, parameter);
            rs = pstm.executeQuery();
            while (rs.next()) {
                setQuestionId(rs.getString(1));
                setQuestion(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("error getQuestionbyId: " + e.getMessage());
        }
    }
    
    public void getWaitingQuestionbyId(String parameter) {
        try {
            String strSQL = "select * from WaitingQuestion where questionId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, parameter);
            rs = pstm.executeQuery();
            while (rs.next()) {
                setQuestionId(rs.getString(1));
                setQuestion(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("error getWaitingQuestionbyId: " + e.getMessage());
        }
    }
}
