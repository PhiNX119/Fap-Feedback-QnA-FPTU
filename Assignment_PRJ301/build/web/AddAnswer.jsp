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

            .button {
                text-decoration: none;
                border-radius: 0.25em;
                border: none;
                background-color: #5cb85c;
                color: white;
                padding: 8px 12px;
                width: 70px;
            }

            .button:hover {
                background-color: green;
            }

            .buttonC {
                text-decoration: none;
                border-radius: 0.25em;
                background-color: #d43f3a;
                color: white;
                padding: 8px 12px;
            }

            .buttonC:hover {
                background-color: #cc0033
            }
        </style>
    </head>
    <body style="background-color: black">
        <div class="answer">
            <div style="border-bottom: 1px solid #e5e5e5; padding-bottom: 15px; text-align: center; font-size: 20px;">
                Add new QnA
            </div>
            <form action="waiting?question=${question.getQuestion()}&questionId=${question.getQuestionId()}" method="post">
                <div style="padding: 15px 0px; text-align: left; font-size: 13px;">
                    <table>
                        <tr>
                            <td>Question:</td>
                            <td>
<!--                                <textarea style="font-family: arial, sans-serif; width: 400px" name="question">${question.getQuestion()}</textarea>-->
                                <b name="question">${question.getQuestion()}</b>
                            </td>
                        </tr>
                        <tr>
                            <td>Answer:</td>
                            <td>
                                <textarea style="font-family: arial, sans-serif; width: 400px; height: 200px" name="answer" required></textarea>
                            </td>
                        </tr>
                    </table>              
                </div>
                <div style="border-top: 1px solid #e5e5e5; padding-top: 20px; text-align: right">
                    <input class="button" type="submit" name="button" value="Add">
                    <a class="buttonC" href="waiting">Close</a>
                </div>
            </form>
        </div>
    </body>
</html>
