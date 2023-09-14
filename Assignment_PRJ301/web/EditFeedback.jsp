<%-- 
    Document   : Login
    Created on : Jul 3, 2023, 5:11:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Feedback</title>
        <style>
            .header {
                display: flex;
                justify-content: space-around;
                margin-left: 90px;
                margin-right: 90px;
            }

            .middle {
                display: flex;
                justify-content: space-between;
                background-color: #f5f5f5;
                height: 30px;
                width: 1000px;
                margin: 0px auto;
                border-radius: 3px;
                margin-bottom: 30px;
            }

            .center {
                display: flex;
                justify-content: center;
                margin-top: 10px;
            }

            .option {
                display: flex;
                justify-content: center;
                margin-top: 20px;
            }

            .info{
                background-color: #5cb85c;
                border-radius: 3px;
                color: white;
                font-size: 15px;
                padding: 1px;
                padding-left: 4px;
                padding-right: 4px
            }

            body {
                font-family: "Arial", sans-serif;
            }

            h1, h2 {
                font-weight: 500;
                line-height: 1.1;
                color: inherit;
            }

            a {
                color: #337ab7;
                text-decoration: none;
            }

            .headform {
                width: 1000px;
                font-size: 12px;
                padding-bottom: 10px;
            }

            .bodyform {
                border: solid 1px black;
                width: 1000px;
                font-size: 12px;
            }

            textarea {
                margin-top: 15px;
                height: 100px;
                width: 400px;
            }
        </style>
    </head>
    <body>
        <!--------------------------Header------------------------------------------->
        <div class="header">
            <div>
                <h1>
                    <span>FPT University Academic Portal</span>
                </h1>
            </div>
            <div>
                <table>
                    <tr>
                        <td colspan="2"><strong>FAP mobile app (myFAP) is ready at</strong></td>
                    </tr>
                    <tr>
                        <td><a href="https://apps.apple.com/app/id1527723314">
                                <img src="Images/app-store.png" style="width: 120px; height: 40px" alt="apple store"></a></td>
                        <td><a href="https://play.google.com/store/apps/details?id=com.fuct">
                                <img src="Images/play-store.png" style="width: 120px; height: 40px" alt="google store"></a></td>
                    </tr>
                </table>
            </div>
        </div>
        <!--------------------------Kết thúc header---------------------------------->

        <div class="middle">
            <div style="font-size: 13px; margin-top: 6px">  
                <span>
                    <a href="home">Home</a>
                </span>
                <span>|</span>
                <span>
                    <a href="subject">Student FeedBack</a>
                </span>
                <span>|</span>
                <span>
                    <b>Do FeedBack</b>
                </span>
            </div>       
            <div style="margin-top: 2px">
                <span class="info"><b>${loginStudentData.getUsername()}</b></span>
                <span>|</span>
                <span class="info"><b><a style="color: white" href="logout">Logout</a></b></span>
                <span>|</span>
                <span class="info"><b>${loginStudentData.getCampus()}</b></span>
            </div> 
        </div>

        <!--------------------------Body-------------------------------------------->
        <div class="center">
            <div style="border-bottom: solid 1px #f5f5f5; height: 205px; width: 1000px;">

                <div>
                    <h2>STUDENT FEEDBACK FORM FOR TEACHER</h2>
                </div>

                <div style="font-size: 13px; color: red">${mess}</div>                
                <!--------------------------Form feedback----------------------------------->
                <form style='border-bottom: solid 1px #f5f5f5; padding-bottom: 30px' action="feedback?subjectId=${subjectData.getSubjectId()}" method="post">
                    <table class="headform">
                        <tr>
                            <td>Batch (Lớp): ${subjectData.getClasscode()}</td>
                            <td>Month (Tháng): 
                                <fmt:formatNumber value="${LocalDate.now().getMonthValue()}" pattern="00" />
                            </td>
                        </tr>
                        <tr>
                            <td>Subject (Môn học): ${subjectData.getCode()}</td>
                            <td>Teacher (Giảng viên): ${subjectData.getTeacher()}</td>
                        </tr>
                        <tr>
                            <td colspan="2"><b><i>Tick the phrase, which best suits the teacher (Đánh dấu vào ô thích hợp)</i></b></td>
                        </tr>
                    </table>

                    <table class="bodyform">
                        <tr>
                            <td>
                                <b>Regarding the teacher's punctuality</b><br>
                                <i style="padding-left: 5px">(Sự đúng giờ của giảng viên trong giờ học)</i>
                                <p style="color: red">${alert1}</p>
                                <input type="radio" hidden name="q1" value="0" checked>
                                <input type="radio" name="q1" value="4"><b>Always punctual (Luôn đúng giờ)</b><br>
                                <input type="radio" name="q1" value="3"><b>Mostly punctual (Phần lớn đúng giờ)</b><br>
                                <input type="radio" name="q1" value="2"><b>Rarely punctual (Ít khi đúng giờ)</b><br>
                                <input type="radio" name="q1" value="1"><b>Not at all punctual (Không bao giờ đúng giờ)</b>
                            </td>
                            <td>
                                <b>Teaching skills of teacher</b><br>
                                <i style="padding-left: 5px">(Kĩ năng sư phạm của giảng viên)</i>
                                <p style="color: red">${alert2}</p>
                                <input type="radio" hidden name="q2" value="0" checked>
                                <input type="radio" name="q2" value="4"><b>Very Good (Tốt)</b><br>
                                <input type="radio" name="q2" value="3"><b>Good (Khá)</b><br>
                                <input type="radio" name="q2" value="2"><b>Average (Trung bình)</b><br>
                                <input type="radio" name="q2" value="1"><b>Poor (Kém)</b>
                            </td>
                        </tr>
                        <tr><td colspan="2" style="border-top: solid 1px black"></td></tr>
                        <tr>
                            <td>
                                <b>The teacher adequately covers the topics required by the syllabus</b><br>
                                <i style="padding-left: 5px">(Đảm bảo khối lượng môn học theo chương trình)</i>
                                <p style="color: red">${alert3}</p>
                                <input type="radio" hidden name="q3" value="0" checked>
                                <input type="radio" name="q3" value="4"><b>Fully covered (Đảm bảo hoàn toàn)</b><br>
                                <input type="radio" name="q3" value="3"><b>Mostlt covered (Đảm bảo phần lớn)</b><br>
                                <input type="radio" name="q3" value="2"><b>Partially covered (Chỉ đảm bảo một phần)</b><br>
                                <input type="radio" name="q3" value="1"><b>Not at all covered (Không đảm bảo)</b>
                            </td>
                            <td>
                                <b>Support from the teacher - guidance for practical exercise, answering questions out side of class</b><br>
                                <i style="padding-left: 5px">(Hỗ trợ của giảng viên trong và ngoài giờ - trả lời Email, hướng dẫn thực hành, giải đáp thắc mắc...)</i>
                                <p style="color: red">${alert4}</p>
                                <input type="radio" hidden name="q4" value="0" checked>
                                <input type="radio" name="q4" value="4"><b>Very Good (Tốt)</b><br>
                                <input type="radio" name="q4" value="3"><b>Good (Khá)</b><br>
                                <input type="radio" name="q4" value="2"><b>Average (Trung bình)</b><br>
                                <input type="radio" name="q4" value="1"><b>Poor (Kém)</b>
                            </td>                        
                        </tr>
                        <tr><td colspan="2" style="border-top: solid 1px black"></td></tr>
                        <tr>
                            <td>
                                <b>Teacher's response to student's questions in class</b><br>
                                <i style="padding-left: 5px">(Đáp ứng của giảng viên về những thắc mắc của học viên trong giờ học)</i>
                                <p style="color: red">${alert5}</p>
                                <input type="radio" hidden name="q5" value="0" checked>
                                <input type="radio" name="q5" value="4"><b> (Trả lời ngay hoặc trả lời vào cuối buuổi học)</b><br>
                                <input type="radio" name="q5" value='3'><b> (Trả lời vào buổi học sau)</b><br>
                                <input type="radio" name="q5" value='2'><b> (Một số câu hỏi không được trả lời)</b><br>
                                <input type="radio" name="q5" value='1'><b> (Phần lớn câu hỏi không được trả lời)</b>
                            </td>
                        </tr>
                    </table>
                    <textarea style="font-family: arial, sans-serif" name="comment"></textarea><br>
                    <input type="submit" name="button" value="Send Feedback">
                </form>
                <!-----------------------Ket thuc Form feedback---------------------------->

                <p style="font-size: 12px">Thank you ! /Xin cảm ơn !</p>

                <!-----------------------------Footer-------------------------------------->
                <div style="height: 25px; font-size: 12px">
                    <br>
                    <b>Mọi góp ý, thắc mắc xin liên hệ: </b>
                    <span style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; font-weight: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;">Phòng dịch vụ sinh viên</span>
                    : Email: <a href="mailto:dichvusinhvien@fe.edu.vn">dichvusinhvien@fe.edu.vn</a>.
                    Điện thoại: <span class="style1" style="color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 13.333333969116211px; font-style: normal; font-variant: normal; letter-spacing: normal; line-height: normal; orphans: auto; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: auto; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); display: inline !important; float: none;">(024)7308.13.13 </span>
                </div>
                <div style="border-bottom: solid 1px #f5f5f5; height: 30px; font-size: 12px">
                    <p style="text-align: center">
                        © Powered by <a href="http://fpt.edu.vn" target="_blank">FPT University</a>&nbsp;|&nbsp;
                        <a href="http://cms.fpt.edu.vn/" target="_blank">CMS</a>&nbsp;|&nbsp; <a href="http://library.fpt.edu.vn" target="_blank">library</a>&nbsp;|&nbsp; <a href="http://library.books24x7.com" target="_blank">books24x7</a>
                        <span id="ctl00_lblHelpdesk"></span>
                    </p>
                </div>
                <!--------------------------Kết thúc footer----------------------------------->
            </div>
        </div>
    </body>
</html>
