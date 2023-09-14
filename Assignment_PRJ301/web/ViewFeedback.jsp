<%-- 
    Document   : Login
    Created on : Jul 3, 2023, 5:11:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Feedback</title>
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

            h1, h2, h3 {
                font-weight: 500;
                line-height: 1.1;
                color: inherit;
            }

            a {
                color: #337ab7;
                text-decoration: none;
            }

            .listfeedback {
                border: solid 1px white;
                width: 1000px;
                font-size: 15px;
                padding-bottom: 30px;
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
                    <a href="result">Teacher Feedback</a>
                </span>
                <span>|</span>
                <span>
                    <b>Class Feedback</b>
                </span>
            </div>       
            <div style="margin-top: 2px">
                <span class="info"><b>${loginTeacherData.getUsername()}</b></span>
                <span>|</span>
                <span class="info"><b><a style="color: white" href="logout">Logout</a></b></span>
                <span>|</span>
                <span class="info"><b>${loginTeacherData.getCampus()}</b></span>
            </div> 
        </div>

        <!--------------------------Body-------------------------------------------->
        <div class="center">

            <div style="width: 1000px;">

                <div>
                    <h2>List of feedbacks for ${loginTeacherData.getUsername()}</h2>
                    <h3>Class: ${classname}</h3>
                    <h3>Subject: ${subject}</h3>
                </div>

                <table class="listfeedback">
                    <tr style="background-color: #6b90da; color: white">
                        <td>NO</td>
                        <td>Q1</td>
                        <td>Q2</td>
                        <td>Q3</td>
                        <td>Q4</td>
                        <td>Q5</td>
                        <td>AVERAGE</td>
                        <td>COMMENT</td>
                        <td>ACTION</td>
                    </tr>
                    <c:set var="i" value="0"/>
                    <c:forEach items="${ListFeedbackByClass}" var="s">
                        <tr style="font-size: 13px">
                            <td>
                                <c:set var="i" value="${i + 1}"/>
                                ${i}
                            </td>
                            <td>${s.getQ1()}</td>
                            <td>${s.getQ2()}</td>
                            <td>${s.getQ3()}</td>
                            <td>${s.getQ4()}</td>
                            <td>${s.getQ5()}</td>
                            <td>
                                ${(s.getQ1()+s.getQ2()+s.getQ3()+s.getQ4()+s.getQ5())/5}
                                <c:set var="total" value="${total + (s.getQ1()+s.getQ2()+s.getQ3()+s.getQ4()+s.getQ5())/5}"/>
                            </td>
                            <td>${s.getComment()}</td>                              
                            <td>
                                <a href="onefeedback?subjectId=${s.getSubjectId()}&studentId=${s.getStudentId()}&subject=${subject}">Detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <h5>GPA: ${total/i}</h5>

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
