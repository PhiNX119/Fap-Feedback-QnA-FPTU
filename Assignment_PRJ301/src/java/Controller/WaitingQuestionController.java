/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Answer;
import Model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class WaitingQuestionController extends HttpServlet {

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
        //Lay ra ma so sinh vien
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            request.getRequestDispatcher("login").forward(request, response);
        } else {
            Question question = new Question();

            if (request.getParameter("questionId") != null) {
                //delete
                if (request.getParameter("delete") != null) {
                    if (question.deleteWaitingQuestion(request.getParameter("questionId"))) {
                        ArrayList<Question> listWaitingQuestion = question.getListWaitingQuestion();
                        session.setAttribute("listWaitingQuestion", listWaitingQuestion);
                        request.getRequestDispatcher("WaitingQuestion.jsp").forward(request, response);
                    }
                }
                //answer
                if (request.getParameter("answer") != null) {
                    String questionId = request.getParameter("questionId");
                    question.getWaitingQuestionbyId(questionId);

                    session.setAttribute("question", question);
                    request.getRequestDispatcher("AddAnswer.jsp").forward(request, response);
                }
            }

            ArrayList<Question> listWaitingQuestion = question.getListWaitingQuestion();
            request.setAttribute("listWaitingQuestion", listWaitingQuestion);
            request.getRequestDispatcher("WaitingQuestion.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();

        Question q = new Question();
        Answer a = new Answer();

        String question = request.getParameter("question");
        String questionId = request.getParameter("questionId");
        String answer = request.getParameter("answer");

        if (q.addQuestion(question)) {
            q.getQuestionbyId(question);
            if (q.deleteWaitingQuestion(questionId)) {
                if (a.addAnswer(q.getQuestionId(), answer)) {
                    ArrayList<Question> listWaitingQuestion = q.getListWaitingQuestion();
                    request.setAttribute("listWaitingQuestion", listWaitingQuestion);
                    request.getRequestDispatcher("WaitingQuestion.jsp").forward(request, response);
                } else {
                    out.print("a.addAnswer(q.getQuestionId(), answer): " + q.getQuestionId() + ", " + answer);
                }
            } else {
                out.print("loi q.deleteWaitingQuestion(q.getQuestionId()): " + q.getQuestionId());
            }
        } else {
            out.print("loi q.addQuestion(question): " + question);
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
