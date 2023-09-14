/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Feedback;
import Model.Student;
import Model.Subject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class RetakeFeedback extends HttpServlet {

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
        if (session.getAttribute("username") == null) {
            request.getRequestDispatcher("login").forward(request, response);
        } else {
            String subjectId = request.getParameter("subjectId");
            Subject subject = new Subject();
            Subject subjectData = subject.getSubjectbyId(subjectId);

            request.setAttribute("subjectData", subjectData);
            request.getRequestDispatcher("RetakeFeedback.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        Student loginStudentData = (Student) session.getAttribute("loginStudentData");
        String studentId = loginStudentData.getStudentId();

        String subjectId = request.getParameter("subjectId");
        Subject subject = new Subject();
        Subject subjectData = subject.getSubjectbyId(subjectId);

        Feedback feedback = new Feedback();

        String teacher = subjectData.getTeacher();
        String classname = subjectData.getClasscode();

        int i = 0;
        String q1 = request.getParameter("q1");
        if ("0".equals(q1)) {
            i = 1;
        }

        String q2 = request.getParameter("q2");
        if ("0".equals(q2)) {
            i = 1;
        }

        String q3 = request.getParameter("q3");
        if ("0".equals(q3)) {
            i = 1;
        }

        String q4 = request.getParameter("q4");
        if ("0".equals(q4)) {
            i = 1;
        }

        String q5 = request.getParameter("q5");
        if ("0".equals(q5)) {
            i = 1;
        }

        String comment = request.getParameter("comment");

        if (i != 0) {
            String mess = "You must answer all multiple choice questions.";
            request.setAttribute("mess", mess);
            doGet(request, response);
        } else {
            if (feedback.deleteFeedback(subjectId, studentId)) {
                if (feedback.addFeedback(subjectId, teacher, classname, studentId, q1, q2, q3, q4, q5, comment)) {
                    String mess = "Retake successfull, Thank you";
                    request.setAttribute("mess", mess);
                    doGet(request, response);
                }
            } else {
                String mess = "Retake fail!";
                request.setAttribute("mess", mess);
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
