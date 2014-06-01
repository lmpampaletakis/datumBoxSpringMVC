<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<title>Home</title>
</head>
<body>
	<h1>Datumbox Example SpringMVC</h1>

	<form:form method="POST" action="show" commandName="formData">
		<div class="wrapper">
			<div class="container"> 
				<div class="content">
					<form:textarea class="textbox1" id="text" path="requestText"
						placeholder="What's on your mind?" />
				</div>
				</div> 
				
				<input type="submit" value="Submit" class="btn" />
				</div>
	</form:form>
</body>
</html>
