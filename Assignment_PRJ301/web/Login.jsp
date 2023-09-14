<%-- 
    Document   : Login
    Created on : Jul 3, 2023, 5:11:06 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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
                height: 20px;
                width: 1000px;
                margin: 0px auto;
                border-radius: 3px;
            }

            .center {
                display: flex;
                justify-content: center;
                margin-top: 10px;
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

            .button {
                background-color: #337ab7;
                color: white;
                border-radius: 3px;
                border: none;
                height: 30px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            }
            
            .button:hover{
                background-color: #0066cc;
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
        </div>

        <!--------------------------Body-------------------------------------------->
        <div class="center">
            <div style="border-bottom: solid 1px #f5f5f5; height: 170px; width: 1000px;">
                <fieldset style="border-color: #f5f5f5; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5); border-radius: 5px">
                    <legend style="background-color: #f0ad4e; color: white; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.5); border-radius: 5px; padding: 4px">
                        <span>
                            <b style="font-size: 20px">Sinh viên, Giảng viên, Cán bộ ĐH-FPT</b>
                        </span>
                    </legend>
                    <div  style="border-top: solid 1px #f5f5f5; width: 900px; margin: 15px auto; padding-top: 10px" class="center">

                        <!--------------------------Login-------------------------------------------->
                        <form action="login" method="post">
                            <table>
                                <tr>
                                    <td>
                                        <select name="campus">
                                            <option selected="selected" value="">Select Campus</option>
                                            <option value="FU-Hoa Lac">FU-Hòa Lạc</option>
                                            <option value="FU-Ho Chi Minh">FU-Hồ Chí Minh</option>
                                            <option value="FU-Đa Nang">FU-Đà Nẵng</option>
                                            <option value="FU-Can Tho">FU-Cần Thơ</option>
                                            <option value="FU-Quy Nhon">FU-Quy Nhơn</option>
                                        </select>
                                    </td>
                                    <td style="padding-left: 5px; font-size: 13px">Account:</td>
                                    <td><input type="text" name="username" required></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td style="padding-left: 5px; font-size: 13px">Password:</td>
                                    <td><input type="password" name="password" required></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td colspan="2">
                                        <input class="button" type="submit" name="button" value="Đăng nhập">
                                    </td>
                                </tr>
                            </table>                            
                        </form>
                        <!--------------------------Ket thuc Login------------------------------------>
                    </div>                 
                </fieldset>

                <!-------------------------------Footer-------------------------------------->
                <div style="border-bottom: solid 1px #f5f5f5; height: 30px; font-size: 12px">
                    <p style="text-align: center">
                        © Powered by <a href="http://fpt.edu.vn" target="_blank">FPT University</a>&nbsp;|&nbsp;
                        <a href="http://cms.fpt.edu.vn/" target="_blank">CMS</a>&nbsp;|&nbsp; <a href="http://library.fpt.edu.vn" target="_blank">library</a>&nbsp;|&nbsp; <a href="http://library.books24x7.com" target="_blank">books24x7</a>
                        <span id="ctl00_lblHelpdesk"></span>
                    </p>
                </div>
                <!--------------------------Kết thúc footer---------------------------------->
            </div>
        </div>
    </body>
</html>
