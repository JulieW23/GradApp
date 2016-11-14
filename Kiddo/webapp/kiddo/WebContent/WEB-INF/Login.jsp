<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style/Login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>

<body>

<jsp:include page="Header.jsp"></jsp:include>
       
       <div id="content">
              
          <div id="logindiv">
           <p id="loginmessage">FitXFit  Login</p>
           <div id="topline"> </div>
           <form> 
                 <table border=0 style="color:#595959; margin: 1.6em auto; font: 1em Arial, Helvetica, sans-serif;">
                 <tr><td><p>Username:</p></td><td><input type="text" class="Inputs" maxlength="20"></td></tr>
                 <tr><td><p>Password:</p></td><td><input type="password" class="Inputs" maxlength="15"></td></tr>
                 <tr><td></td><td><input type="submit" id="submitbutton" value="Login"/></td></tr>
                 </table>
           </form>
           
           <a href="" id="loginlabel">Forgotten Your Username or Password?</a>
           
           <div id="bottomline"> </div>
           <p style=" color:#456ab4; margin-left: 2.5em; margin-top: 1.8em; font: .8em Arial, Helvetica, sans-serif;">Don't have an account yet?<a href="SignUp.jsp" id="signuplink"> Click Here To Sign Up For FitXFit</a></p> 
          </div>
           
       </div> <!-- End of content-->
       
       
       
<div id="footer">
  <jsp:include page="Footer.jsp"></jsp:include>
</div>  
</body>
</html>