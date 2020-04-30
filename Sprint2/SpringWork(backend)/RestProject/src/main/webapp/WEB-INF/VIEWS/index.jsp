<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>QUIZ!</h2>
<form method="post" action="${pageContext.request.contextPath }/submit">
<ol type="1">

<c:forEach var="questions1" items="${questions}">
<% int k=0; %>
<li>  ${questions1.questionTitle}  
<input type="hidden" name="questionId" value="${ questions1.questionId}">
<ol type="a">
<c:forEach var="questions2" items="${questions1.questionOptions}">
<% k++; %>
<li>
<input type="radio" name="answer${questions1.questionId}" value="${k}">
${questions2}
</li> 
</c:forEach>
</ol>
</li>
</c:forEach>
</ol>
<br>
<input type="submit" value="Submit">
</form>
</body>
</html>