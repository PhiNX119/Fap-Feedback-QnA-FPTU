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
                background-color: #d43f3a;
                color: white;
                padding: 8px 12px;
            }
        </style>
    </head>
    <body style="background-color: black">
        <div class="answer">
            <div style="border-bottom: 1px solid #e5e5e5; padding-bottom: 15px; text-align: center; font-size: 20px;">
                Help/QnA
            </div>
            <div style="padding: 15px 0px; text-align: left; font-size: 13px;">
                ${answer.getAnswer()}
            </div>
            <div style="border-top: 1px solid #e5e5e5; padding-top: 20px; text-align: right">
                <a class="button" href="qna">Close</a>
            </div>
        </div>
    </body>
</html>
