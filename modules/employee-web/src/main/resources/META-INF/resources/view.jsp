<%@ include file="init.jsp" %>

<h2>CRUD Operations</h2>

<portlet:renderURL var="addEmployee">
	<portlet:param name="mvcPath" value="/add_employee.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="updateEmployee">
	<portlet:param name="mvcPath" value="/update_employee.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="displayEmployee">
	<portlet:param name="mvcPath" value="/display_employee.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="deleteEmployee">
	<portlet:param name="mvcPath" value="/delete_employee.jsp"/>
</portlet:renderURL>
<br>
<aui:a href="<%= addEmployee.toString() %>">Add Employee</aui:a><br><br>
<aui:a href="<%= updateEmployee.toString() %>">Update Employee</aui:a><br><br>
<aui:a href="<%= displayEmployee.toString() %>">View Employees</aui:a><br><br>
<aui:a href="<%= deleteEmployee.toString() %>">Delete Employee</aui:a><br><br>
