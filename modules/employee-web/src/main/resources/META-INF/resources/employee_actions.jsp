<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Employee employee = (Employee)row.getObject(); 
%>

<liferay-ui:icon-menu>
    
    <portlet:renderURL var="editURL">
        <portlet:param name="empId" value="<%= String.valueOf(employee.getEmpId()) %>" />
        <portlet:param name="mvcPath" value="/edit_employee.jsp" />
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />

    <portlet:actionURL name="deleteEmployee" var="deleteURL">
        <portlet:param name="empId" value="<%= String.valueOf(employee.getEmpId()) %>" />
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />

</liferay-ui:icon-menu>