<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script defer src="Javascript/jquery-3.0.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="Style/Teacher_List.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<jsp:include page="Header.jsp"></jsp:include>

	<div id="content">

		<c:if test="${not empty error}">
			<div id="error_div">
				<h6 id="err_message">${error}</h6>
			</div>
		</c:if>

		<div id="infoDiv">
			<p id="signupmessage">Teacher Information Lookup</p>
			<div id="topline"></div>
			<!--  sign up form -->
			<c:if test="${not empty teachers}">
			  <c:forEach var="cur_Teacher" items="teachers">
			   <div class="teacher_div">
			     <table>
		              <tr> <td> Name: </td> <td> ${cur_Teacher.name} </td><td> Last Name: </td> <td> ${cur_Teacher.lname} </td></tr>
		              <tr> <td> Email: </td> <td> ${cur_Teacher.email} </td> <td> User Name: </td> <td> ${cur_Teacher.uname} </td></tr>
		         </table>
		       </div>
		      </c:forEach>   	
			</c:if>
			
         	<div id="bottomline"></div>
			<table id="nav_tab">
				<tr>
					<td><a href="SignUp.jsp">Click To Go To Your Dashboard</a></td>
				</tr>
			</table>
		</div>
		<!-- end of signupdiv -->
    </div>



	<div id="footer">
		<p id="footmessage">&#169;Copyright 2016 Kiddo, All rights
			reserved.</p>
	</div>


</body>
</html>