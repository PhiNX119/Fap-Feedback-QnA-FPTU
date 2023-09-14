<%-- 
    Document   : ShowAnswer
    Created on : Jul 12, 2023, 10:25:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University Academic Portal</title>
        <style>
            body {
                font-family: "Arial", sans-serif;
            }

            .answer {
                background-color: white;
                font-size: 15px;
                border-radius: 0.25em;
                padding: 15px 15px;
                width: 500px;
                margin: 0px auto;
            }

            .buttonU {
                text-decoration: none;
                border-radius: 0.25em;
                border: none;
                background-color: #5cb85c;
                color: white;
                padding: 7px 10px;
            }

            .buttonU:hover {
                background-color: green;
            }

            .buttonC {
                text-decoration: none;
                border-radius: 0.25em;
                background-color: #d43f3a;
                color: white;
                padding: 7px 13px;
                font-size: 14px;
            }

            .buttonC:hover {
                background-color: #cc0033
            }
        </style>
    </head>
    <body style="background-color: black">
        <div class="answer">
            <div style="border-bottom: 1px solid #e5e5e5; padding-bottom: 15px; text-align: center; font-size: 20px;">
                Help/QnA
            </div>
            <form action="qna?update=1" method="post">
                <div style="padding: 15px 0px; text-align: center; font-size: 13px;">
                    <input hidden type="text" name="questionId" value="${answer.getQuestionId()}">
                    <textarea style="font-family: arial, sans-serif; width: 460px; height: 200px;" name="answer" required>${answer.getAnswer()}</textarea>                
                </div>
                <div style="border-top: 1px solid #e5e5e5; padding-top: 20px; text-align: right">
                    <input class="buttonU" type="submit" name="button" value="Update">
                    <a class="buttonC" href="qna">Close</a>
                </div>
            </form>
        </div>
    </body>
</html>
