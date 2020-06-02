<%@ include file="init.jsp" %>

<%
  String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-portlet:renderURL varImpl="searchURL">
        <portlet:param name="mvcPath" value="/view_search.jsp" />
</liferay-portlet:renderURL>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp" />
</portlet:renderURL>

<aui:form action="<%= searchURL %>" method="get" name="fm">
    <liferay-portlet:renderURLParams varImpl="searchURL" />

<liferay-ui:header backURL="<%= viewURL.toString() %>" title="search" />

    <div class="search-form">
        <span class="aui-search-bar">
            <aui:input inlineField="<%= true %>" label="" name="keywords" size="30" title="search-entries" type="text" />

            <aui:button type="submit" value="search" />
        </span>
    </div>
</aui:form>

<%
	SearchContext searchContext = SearchContextFactory.getInstance(request);
	System.out.println(keywords);
	searchContext.setKeywords(keywords);
	searchContext.setAttribute("paginationType", "more");
	searchContext.setStart(0);
	searchContext.setEnd(10);
	
	Indexer indexer = IndexerRegistryUtil.getIndexer(Employee.class);
	System.out.println(indexer);
	Hits hits = indexer.search(searchContext);
	System.out.println(hits);
	List<Employee> employees = new ArrayList<Employee>();

	    for (int i = 0; i < hits.getDocs().length; i++) 
	    {
            Document doc = hits.doc(i);

            long empId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			System.out.println(empId);
            Employee employee = null;

            try 
            {
				employee = EmployeeLocalServiceUtil.getEmployee(empId);
            } catch (PortalException pe) {
                    _log.error(pe.getLocalizedMessage());
            } catch (SystemException se) {
                    _log.error(se.getLocalizedMessage());
            }

            employees.add(employee);
	    }
	    
// 	    List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(scopeGroupId);

//         Map<String, String> guestbookMap = new HashMap<String, String>();

//         for (Guestbook guestbook : guestbooks) {
//                 guestbookMap.put(Long.toString(guestbook.getGuestbookId()), guestbook.getName());
//         }
%>

<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found" total="<%= employees.size() %>">
	<liferay-ui:search-container-results results="<%= employees %>" />
        
	<liferay-ui:search-container-row className="com.liferay.docs.employee.model.Employee" keyProperty="empId" modelVar="employee" escapedModel="<%=true%>">
        
        <liferay-ui:search-container-column-text property="empId" name="Employee ID" />
		<liferay-ui:search-container-column-text property="psno" name="PS No." />
		<liferay-ui:search-container-column-text property="fname" name="First Name" />
		<liferay-ui:search-container-column-text property="lname" name="Last Name" />
		<liferay-ui:search-container-column-text property="email" name="Email" />
		<liferay-ui:search-container-column-text property="empAddress" name="Address"/>
		<liferay-ui:search-container-column-jsp align="right" path="/employee_actions.jsp" />
		
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>

<%!
	private static Log _log = LogFactoryUtil.getLog("html.view_search_jsp");
%>
	
	
	
	
	
    
    
    
    
    
    
    
    
    