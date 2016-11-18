<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="JavaScript/form-util.js"></script>
<script defer src="JavaScript/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="Style/Teacher_SignUp.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<jsp:include page="Header.jsp"></jsp:include>
       
       <div id="content">
          <div id="signupdiv">
           <p id="signupmessage">Teacher Registration Form</p>
           <div id="topline"> </div>
           <!--  sign up form -->
            
           <form id="signupform">
           
             <table>
             
               <tr><td>
                 <input type="text" id="email" class="textinput" name="email"  placeholder="Email Address" 
                       onclick="showEmailAlert()" onblur="isEmailEmpty()"/>
                 <div class="errors" id="email_err" ><p></p></div>
               </td></tr>
               
               <tr><td>
                  <input type="text" class="textinput" id="email2" name="email2" placeholder="Re-Enter Email Addresss"
                  onclick="showEmail2Alert()" onblur="isEmail2Empty()"/>
                  <div class="errors" id="email2_err" ><p></p></div>
               </td></tr>
                  
               <tr><td>
                  <input type="password"  id="password" class="textinput" name="password" placeholder="Password"
                  onclick="showPassAlert()" onblur="isPassEmpty()"/>
                  <div class="alerts" id="pass_alert" ><img src="Style/Images/alert.png"/></div>
                  <div id="pass_err" class="callout border_callout" ><b class="border_notch notch"></b><b class="notch"></b><p></p></div>
               </td></tr>
               <tr><td>
                 <span class="check_box">
                      <em id="pass_help_msg" onclick="showPassHelp();">Password Guide</em></br>
                 </span>
                 <div id="pass_err" class="errors" ><p></p></div> 
                 <div id="pass_help" class="h_callout h_border_callout" >
                 <p>Password Must be Between 6-15 Characters, and Consist of at least one UpperCase Letter,
				    one LowerCase Letter, one digit.</p><a onclick="hide('pass_help');">X</a></div>
               </td>
               </tr>   
               <tr><td>
                  <input type="text" class="textinput" id="name"  name="firstname" placeholder="First Name" 
                         onblur="isNameEmpty();" onclick="showNameAlert('name');"/>
               </td></tr>
               <tr><td>
                  <input type="text" class="textinput" id="lastname"   name="lastname" placeholder="Last Name"
                    onblur="isLastNameEmpty();" onclick="showNameAlert('lastname');"/> 
                  <div id="last_name_err" class="errors" ><p></p></div>
               </td></tr>
               
               <tr>
                <td>                        
                  <div id="name_err" class="errors" ><p></p></div>
                </td>
               </tr> 
                
               <tr><td>   
                  <button type="button" id="form_submit" onclick="check_form()" >Register</button>
               </td></tr>
                                    
             </table> 
              
            </form>
           
          </div> <!-- end of signupdiv -->
       </div>
       

 </body>
</html>