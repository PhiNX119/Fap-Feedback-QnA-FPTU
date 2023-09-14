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
public class Answer extends DBContext{
    
    private String questionId, answer;

    public Answer() {
        connect();
    }

    public Answer(String questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
        connect();
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
    
    public void getAnswerbyId(String id){
        try {
            String strSQL = "select * from Answer where questionId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                setQuestionId(rs.getString(1));
                setAnswer(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("error getAnswerbyId: " + e.getMessage());
        }    
    }
    
    public boolean addAnswer(String questionId, String answer) {
        try {
            String strSQL = "INSERT [dbo].[Answer] ([questionId], [answer]) VALUES (?, ?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, questionId);
            pstm.setString(2, answer);
            pstm.executeUpdate();
            System.out.println("1answer: " + answer);
            return true;
        } catch (Exception e) {            
            System.out.println("error addAnswer: " + e.getMessage());
            System.out.println("2answer: " + answer);
        }
        return false;
    }
    
    public boolean updateAnswer(String questionId, String answer) {
        try {
            String strSQL = "update Answer set answer = ? where questionId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, answer);
            pstm.setString(2, questionId);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error updateAnswer: " + e.getMessage());
        }
        return false;
    }
    
    public boolean deleteAnswer(String questionId) {
        try {
            String strSQL = "delete from Answer where questionId = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, questionId);
            pstm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error deleteAnswer: " + e.getMessage());
        }
        return false;
    }
}
