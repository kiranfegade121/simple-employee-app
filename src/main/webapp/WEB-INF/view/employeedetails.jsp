<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Details</h1>
	<hr>
	<br>
	
	<table border="1" cellspacing="5" cellpadding="5">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Department</th>
				<th>Salary</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${employees}">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.employeeDepartment}</td>
					<td>${employee.employeeSalary}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>