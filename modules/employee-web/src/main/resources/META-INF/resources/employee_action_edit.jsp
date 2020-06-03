<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Employee employee = (Employee)row.getObject(); 
%>
 
<portlet:renderURL var="editURL">
    <portlet:param name="empId" value="<%= String.valueOf(employee.getEmpId()) %>" />
    <portlet:param name="mvcPath" value="/edit_employee.jsp" />
</portlet:renderURL>

<a href="<%=editURL.toString() %>"><span title="Edit" class="glyphicon glyphicon-pencil"></span></a>
