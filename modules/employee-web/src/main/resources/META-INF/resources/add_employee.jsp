<%@ include file="init.jsp" %>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="addEmployee" var="addEmployeeURL" />

<h2>Add Employee</h2>

<aui:form action="<%= addEmployeeURL %>" name="employeeForm">
	<aui:fieldset>
		<aui:input name="psno" label="PS No."></aui:input>
		<aui:input name="fname" label="First Name"></aui:input>
		<aui:input name="lname" label="Last Name"></aui:input>
		<aui:input name="empAddress" label="Address" type="textarea"></aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"/>
		<aui:button onClick="<%= viewURL %>" type="cancel" />
	</aui:button-row>
</aui:form>


	
