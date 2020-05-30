<%@ include file="init.jsp" %>

<% long employeescount = EmployeeLocalServiceUtil.getEmployeesCount(scopeGroupId);
	System.out.println(employeescount);
%>

<liferay-ui:search-container total="<%= EmployeeLocalServiceUtil.getEmployeesCount(scopeGroupId) %>" >
	<liferay-ui:search-container-results results="<%= EmployeeLocalServiceUtil.getEmployees(scopeGroupId) %>" />
	<liferay-ui:search-container-row className="com.liferay.docs.employee.model.Employee" modelVar="employee" >
		<liferay-ui:search-container-column-text property="empId" name="Employee ID" />
		<liferay-ui:search-container-column-text property="psno" name="PS No." />
		<liferay-ui:search-container-column-text property="fname" name="First Name" />
		<liferay-ui:search-container-column-text property="lname" name="Last Name" />
		<liferay-ui:search-container-column-text property="empAddress" name="Address"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>