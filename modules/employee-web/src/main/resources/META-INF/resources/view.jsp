<%@ include file="init.jsp" %>

<% 
	long employeescount = EmployeeLocalServiceUtil.getEmployeesCount(scopeGroupId);
	System.out.println(employeescount);
%>

<liferay-portlet:renderURL varImpl="searchURL">
    <portlet:param name="mvcPath" value="/view_search.jsp" />
</liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" /> 
            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>



<aui:button-row cssClass="employee-buttons">
    <portlet:renderURL var="addEmployeeURL">
        <portlet:param name="mvcPath" value="/edit_employee.jsp" />
    </portlet:renderURL>

    <aui:button onClick="<%=addEmployeeURL.toString()%>" value="Add Employee"></aui:button>
</aui:button-row>


<liferay-ui:search-container total="<%= EmployeeLocalServiceUtil.getEmployeesCount(scopeGroupId) %>" >
	<liferay-ui:search-container-results results="<%= EmployeeLocalServiceUtil.getEmployees(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>" />
	<liferay-ui:search-container-row className="com.liferay.docs.employee.model.Employee" modelVar="employee" >
		<liferay-ui:search-container-column-text property="empId" name="Employee ID" />
		<liferay-ui:search-container-column-text property="psno" name="PS No." />
		<liferay-ui:search-container-column-text property="fname" name="First Name" />
		<liferay-ui:search-container-column-text property="lname" name="Last Name" />
		<liferay-ui:search-container-column-text property="email" name="Email" />
		<liferay-ui:search-container-column-text property="empAddress" name="Address"/>
		<liferay-ui:search-container-column-jsp align="right" path="/employee_action_edit.jsp" />
		<liferay-ui:search-container-column-jsp align="right" path="/employee_action_delete.jsp" />
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


