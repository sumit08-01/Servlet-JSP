<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>table of nine</title>
</head>
<body style="background-color:SeaShell;" align="center">
<h1>Table of Nine </h1>
 <h2><% int a=9;
 for(int i=1; i<=10; i++){
	 out.write("9 * "+i +"=" +a*i+"<br><br>");
 }
 %></h2>
 
</body>
</html>