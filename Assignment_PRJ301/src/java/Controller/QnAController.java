/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Answer;
import Model.Feedback;
import Model.Question;
import Model.Student;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QnAController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Student loginStudentData = (Student) session.getAttribute("loginStudentData");
        Teacher loginTeacherData = (Teacher) session.getAttribute("loginTeacherData");
        Question question = new Question();
        Answer answer = new Answer();

        if (loginStudentData != null) {
            if (session.getAttribute("username") == null) {
                request.getRequestDispatcher("login").forward(request, response);
            } else {
                if (request.getParameter("questionId") != null) {
                    answer.getAnswerbyId(request.getParameter("questionId"));
                    request.setAttribute("answer", answer);
                    request.getRequestDispatcher("ShowAnswerForStudent.jsp").forward(request, response);
                }
                ArrayList<Question> listQuestion = question.getListQuestion();
                request.setAttribute("listQuestion", listQuestion);
                request.getRequestDispatcher("StudentQnA.jsp").forward(request, response);
            }
        } else if (loginTeacherData != null) {
            if (session.getAttribute("username") == null) {
                request.getRequestDispatcher("login").forward(request, response);
            } else {
                if (request.getParameter("questionId") != null) {
                    //delete
                    if (request.getParameter("delete") != null) {
                        if (answer.deleteAnswer(request.getParameter("questionId"))) {
                            if (question.deleteQuestion(request.getParameter("questionId"))) {
                                ArrayList<Question> listQuestion = question.getListQuestion();
                                request.setAttribute("listQuestion", listQuestion);
                                request.getRequestDispatcher("TeacherQnA.jsp").forward(request, response);
                            }
                        }
                    }
                    //show list answer
                    answer.getAnswerbyId(request.getParameter("questionId"));
                    request.setAttribute("answer", answer);
                    request.getRequestDispatcher("ShowAnswerForTeacher.jsp").forward(request, response);
                }
                ArrayList<Question> listQuestion = question.getListQuestion();
                request.setAttribute("listQuestion", listQuestion);
                request.getRequestDispatcher("TeacherQnA.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("login").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Question question = new Question();
        Answer answer = new Answer();

        if (request.getParameter("update") != null) {
            if (answer.updateAnswer(request.getParameter("questionId"), request.getParameter("answer"))) {
                doGet(request, response);
            }
        }

        if (request.getParameter("add") != null) {
            if (question.addQuestion(request.getParameter("question"))) {
                question.getQuestionbyId(request.getParameter("question"));
                if (answer.addAnswer(question.getQuestionId(), request.getParameter("answer"))) {
                    doGet(request, response);
                }
            }
        }

        if (request.getParameter("addquestion") != null) {
            if (question.addWaitingQuestion((request.getParameter("question")))) {
                doGet(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
