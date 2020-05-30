<%@ include file="init.jsp" %>

<portlet:actionURL name="deleteEmployee" var="deleteEmployeeURL" />
<portlet:actionURL name="getEmployee" var="getEmployeeURL">
	<portlet:param name="cmd" value="DELETE" />
</portlet:actionURL>

<h2>Delete Employee</h2>

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
	PS no.:  <%= selectedEmployeeObj.getPsno() %>
	<br><br>
	Employee Name: <%= selectedEmployeeObj.getFname()+"&nbsp;"+selectedEmployeeObj.getLname() %>
	<br><br>
	Address: <%= selectedEmployeeObj.getEmpAddress() %>
	<br><br>
	<input type="button" name="deleteEmployee"  id="deleteEmployee" value="Delete Employee" onclick="deleteEmployeeRecord()" >
<% } %>
</form>

<script>
function submitForm(selectedValue)
{
  if(selectedValue!="-1"){
         document.employeeForm.submit(); 
  }
      
}
function deleteEmployeeRecord()
{
	document.employeeForm.action="<%=deleteEmployeeURL.toString()%>"
	document.employeeForm.submit();
}
</script>
