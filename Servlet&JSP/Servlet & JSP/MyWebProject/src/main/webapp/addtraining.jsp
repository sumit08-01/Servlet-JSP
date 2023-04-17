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
<title>Add Training</title>
</head>
<body style="background-color:Khaki">
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
<form action="AddTraining" >
	<h1>Add New Training</h1>
	<label for="tid">Training Id : </label><input type="text" id="tid" name="tid"><br><br>
	<label for="tna">Training Name : </label><input type="text" id="tna" name="tna"><br><br>
	<label for="std">Start Date : </label><input type="date" id="std" name="std"><br><br>
	<label for="ed">End Date : </label><input type="date" id="ed" name="ed"><br><br>
	<label for="tnm">Training Mode : </label><input type="text"  id="tnm" name="tnm"><br><br>
	<label for="bnut">Business Unit : </label><input type="text" id="bnut" name="bnut"><br><br>
	<label for="ctid">Contact Person Id : </label><input type="text" id="ctid" name="ctid"><br><br>
	<input type="submit" value="Add">
</form>

</body>
</html>