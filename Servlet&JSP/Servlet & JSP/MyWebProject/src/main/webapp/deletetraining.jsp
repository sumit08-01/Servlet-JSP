<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%
    ArrayList<ArrayList<Object>> list = (ArrayList<ArrayList<Object>>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Training</title>
</head>
<body style="background-color:LemonChiffon">
<div>
<h1>All Trainings Listed Below</h1>
	<table border="1">
		<tbody>
			<tr>
				<th>Training Id</th>
				<th>Training Name</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Training Mode</th>
				<th>Business Unit</th>
				<th>Contact Person Id</th>
			<tr>
			
			<%
			for(ArrayList<Object> li : list){
			%>
			<tr>
				<td><%= li.get(0) %></td>
				<td><%= li.get(1) %></td>
				<td><%= li.get(2) %></td>
				<td><%= li.get(3) %></td>
				<td><%= li.get(4) %></td>
				<td><%= li.get(5) %></td>
				<td><%= li.get(6) %></td>
			</tr>
			<%
			}
			%>
			
		</tbody>
	</table>
</div>
	<form action="DeleteTraining">
	<br>
		<label for="tid">
			<h1>Enter Training Id To Be Deleted</h1>
		</label>
		<input type="number" id="tid" name="tid"/>
		<input type="submit" value="Delete"/>
	</form>
</body>
</html>