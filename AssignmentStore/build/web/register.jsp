<%-- 
    Document   : register
    Created on : Mar 16, 2021, 9:41:03 PM
    Author     : Marshallein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Register</title>
        <!-- Mobile Specific Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- Font-->
        <link rel="stylesheet" type="text/css" href="assets/css/roboto-font.css">
        <link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-5/css/fontawesome-all.min.css">
        <!-- Main Style Css -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/loginstyle.css"/>
        <link rel="icon" type="image/png" href="assets/resource/gundam_rx_78_2_by_vietanhussr_d4csudy-fullview.png" />
    </head>
    <body class="form-v5">
        <div class="page-content">
            <div class="form-v5-content">
                <form class="form-detail" action="register" method="post">
                    <h2>Register Account Form</h2>
                    <div class="form-row">
                        <label for="full-name">Username</label>
                        <input type="text" name="username" id="full-name" class="input-text" placeholder="Your Username" required>
                        <i class="fas fa-user"></i>
                    </div>
                    <div class="form-row">
                        <label for="password">Password</label>
                        <input type="password" name="password" id="password" class="input-text" placeholder="Your Password" required>
                        <i class="fas fa-lock"></i>
                    </div>
                    <div class="form-check form-switch">
                        <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault" name="seller" value="1">
                        <label class="form-check-label" for="flexSwitchCheckDefault">User is Seller ?</label>
                    </div>
                    <div class="form-row-last">
                        <input type="submit" name="register" class="register" value="Register">
                    </div>
                </form>

            </div>
        </div>
        <%@ include file="component/footer.jsp" %>
    </body>
</html>
