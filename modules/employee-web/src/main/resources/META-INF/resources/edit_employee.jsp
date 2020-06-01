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
		<aui:input name="psno" label="PS No.">
			<aui:validator name="required" />
			<aui:validator name="number" />
			<aui:validator name="rangeLength" errorMessage="Please enter a valid 8-digit PS No.">[8,8]</aui:validator>
		</aui:input>
		<aui:input name="fname" label="First Name">
			<aui:validator name="required" />
			<aui:validator name="alpha" />
		</aui:input>
		<aui:input name="lname" label="Last Name">
			<aui:validator name="required" />
			<aui:validator name="alpha" />
		</aui:input>
		<aui:input name="email" label="Email">
			<aui:validator name="required" />
			<aui:validator name="email" />
		</aui:input>
		<aui:input name="empAddress" label="Address">
			<aui:validator name="custom" errorMessage="Please enter alphanumeric characters only."> 
				function(val, fieldNode, ruleValue)
				{
				var regex = new RegExp(/^[0-9a-zA-Z ]+$/);
				return regex.test(val);
				}
			</aui:validator>
		</aui:input>
		<aui:input name="empId" type="hidden" />
	</aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>

    </aui:button-row>
</aui:form>