<%@ include file="init.jsp" %>

<portlet:actionURL name="updateEmployee" var="updateEmployeeURL" />
<portlet:actionURL name="getEmployee" var="getEmployeeURL" >
	<portlet:param name="cmd" value="UPDATE"/>
</portlet:actionURL>

<h2>Update Employee</h2>

<%
List<Employee> employees = EmployeeLocalServiceUtil.getEmployees(scopeGroupId);
Employee selectedEmployeeObj = (Employee)renderRequest.getAttribute("employeeObj");
%>

<form action="<%= getEmployeeURL.toString() %>" name="employeeForm" method="POST">

<h3>Select Employee ID</h3><br>
<select name="<portlet:namespace />empId" onchange="submitForm(this.value)">

	<option value="-1">--Select--</option>
	<%
	for(Employee employee: employees)
	{
	%>
	<option value="<%= employee.getEmpId() %>" <%= selectedEmployeeObj!=null && selectedEmployeeObj.getEmpId()==employee.getEmpId()?"selected":"" %>> <%=employee.getEmpId() %> </option>
	<% } %>
	
</select>
<br><br>
<% if(selectedEmployeeObj!=null) { %>
<table>
	<tr><td>PS no. </td><td><input type="text" name="<portlet:namespace/>psno" id="<portlet:namespace/>psno" value="<%= selectedEmployeeObj.getPsno() %>" ></td></tr>
	<tr><td colspan="2"><br></td></tr>
	<tr><td>First Name </td><td><input type="text" name="<portlet:namespace/>fname" id="<portlet:namespace/>fname" value="<%= selectedEmployeeObj.getFname() %>" ></td></tr>
	<tr><td colspan="2"><br></td></tr>
	<tr><td>Last Name </td><td><input type="text" name="<portlet:namespace/>lname" id="<portlet:namespace/>lname" value="<%= selectedEmployeeObj.getLname() %>" ></td></tr>
	<tr><td colspan="2"><br></td></tr>
	<tr><td>Email </td><td><input type="text" name="<portlet:namespace/>email" id="<portlet:namespace/>email" value="<%= selectedEmployeeObj.getEmail() %>" ></td></tr>
	<tr><td colspan="2"><br></td></tr>
	<tr><td>Address </td><td><input type="text" name="<portlet:namespace/>empAddress" id="<portlet:namespace/>empAddress" value="<%= selectedEmployeeObj.getEmpAddress() %>" ></td></tr>
	<tr><td colspan="2"><br></td></tr>
	<tr><td colspan="2"><input type="button" name="updateEmployee"  id="updateEmployee" value="Update Employee" onclick="updateEmployeeRecord()" ></td></tr>
</table>
<% } %>
</form>

<script>
function submitForm(selectedValue)
{
  if(selectedValue!="-1"){
         document.employeeForm.submit(); 
  }
      
}
function updateEmployeeRecord()
{
	document.employeeForm.action="<%=updateEmployeeURL.toString()%>"
	document.employeeForm.submit();
}
</script>




