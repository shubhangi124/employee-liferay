<%@include file="init.jsp" %>

<% 
	long empId = ParamUtil.getLong(renderRequest, "empId");
	
	Employee employee = null;
	if (empId > 0) 
	{
	  employee = EmployeeLocalServiceUtil.getEmployee(empId);
	}
	
%>

<portlet:renderURL var="viewURL">

	<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addEmployee" var="addEmployeeURL"></portlet:actionURL>

<aui:form action="<%= addEmployeeURL %>" name="<portlet:namespace />fm">

<aui:model-context bean="<%= employee %>" model="<%= Employee.class %>" />

    <aui:fieldset>

        <aui:input name="psno" label="PS No." />
        <aui:input name="fname" label="First Name" />
        <aui:input name="lname" label="Last Name" />
        <aui:input name="email" label="Email" />
        <aui:input name="empAddress" label="Address" />
        <aui:input name="empId" type="hidden" />

    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>