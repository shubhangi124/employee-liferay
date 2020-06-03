<%@include file="init.jsp"%>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Employee employee = (Employee)row.getObject(); 
%>

<portlet:actionURL name="deleteEmployee" var="deleteURL">
	<portlet:param name="empId" value="<%= String.valueOf(employee.getEmpId()) %>" />
</portlet:actionURL>

<a href="<%=deleteURL.toString() %>"><span title="Delete" class="glyphicon glyphicon-trash"></span></a>
