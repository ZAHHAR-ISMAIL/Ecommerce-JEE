<%-- 
    Document   : Login
    Created on : 31 mars 2020, 23:10:05
    Author     : ISMAIL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styleLogin.css">
<title>Login / Register</title>
</head>
<body>


<div class="login_page">
    <div class="form">
        <form class="register_form" action="homeServlet" method="post">
            <input type="text" name="f" placeholder="First Name"/>
            <input type="text" name="l" placeholder="Last Name"/>
            <input type="text" name="p" placeholder="Password"/>
            <input type="text" name="e" placeholder="Email"/>
            <input type="text" name="a" placeholder="Adress"/>
            <input type="text" name="t" placeholder="Telephone"/>

            <input id="bb" type="submit" value="Register" name="action"> 
            <p class="message">Already Registered? <a href="#" style="color:black">Login</a></p>
        </form>
        <form class="login_form" action="homeServlet" method="post">
            <input type="text" name="ee" placeholder="Email"/>
             <input type="password" name="pp" placeholder="Password"/>

            <input id="bb" type="submit" value="Login" name="action">   
            <p class="message">Not Registered? <a href="#" style="color:black">Register</a></p>
        </form>

    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.min.js">
</script>

<script>
    $('.message a').click(function(){
        $('form').animate({height: "toggle",opacity: "toggle"},"slow");
    })
    
</script>

</body>
</html>

