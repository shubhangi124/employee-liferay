package com.liferay.docs.employee.search;

import com.liferay.docs.employee.model.Employee;
import com.liferay.docs.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    service = Indexer.class
)
public class EmployeeIndexer extends BaseIndexer<Employee> 
{
	public static final String CLASS_NAME = Employee.class.getName();
	    
    public EmployeeIndexer() 
    {
        setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.UID, Field.SCOPE_GROUP_ID, Field.GROUP_ID);
        setDefaultSelectedLocalizedFieldNames(Field.TITLE, Field.CONTENT);
        setFilterSearch(true);
    }
    
    @Override
    public String getClassName() {

        return CLASS_NAME;
    }

    @Override
    public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext) throws Exception 
    {
        addStatus(contextBooleanFilter, searchContext);
    }

    @Override
    public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter, SearchContext searchContext) throws Exception 
    {
    	addSearchLocalizedTerm(searchQuery, searchContext, "lname", false);
        addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
        addSearchLocalizedTerm(searchQuery, searchContext, Field.CONTENT, false);
    }

    @Override
    protected void doDelete(Employee employee) throws Exception 
    {
        deleteDocument(employee.getCompanyId(), employee.getEmpId());
    }

    @Override
    protected Document doGetDocument(Employee employee) throws Exception 
    {
        Document document = getBaseModelDocument(CLASS_NAME, employee);
        document.addDate(Field.MODIFIED_DATE, employee.getModifiedDate());
        document.addText("email", employee.getEmail());
        document.addText("empAddress", employee.getEmpAddress());

        Locale defaultLocale = PortalUtil.getSiteDefaultLocale(employee.getGroupId());
        String localizedTitle = LocalizationUtil.getLocalizedName(Field.TITLE, defaultLocale.toString());
        String localizedName = LocalizationUtil.getLocalizedName(Field.CONTENT, defaultLocale.toString());
        String localizedLname = LocalizationUtil.getLocalizedName("lname", defaultLocale.toString());
        document.addNumber(localizedTitle, employee.getPsno());
        document.addText(localizedName, employee.getFname());
        document.addText(localizedLname, employee.getLname());
        return document;
    }
    
    @Override
    protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) throws Exception 
    {
        Summary summary = createSummary(document);

        summary.setMaxContentLength(200);

        return summary;
    }

    @Override
    protected void doReindex(Employee employee) throws Exception 
    {
        Document document = getDocument(employee);
        indexWriterHelper.updateDocument(getSearchEngineId(), employee.getCompanyId(), document, isCommitImmediately());
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception 
    {
        Employee employee = _employeeLocalService.getEmployee(classPK);
        doReindex(employee);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception 
    {
        long companyId = GetterUtil.getLong(ids[0]);
        reindexEmployees(companyId);
    }

    protected void reindexEmployees(long companyId) throws PortalException 
    {
        final IndexableActionableDynamicQuery indexableActionableDynamicQuery = _employeeLocalService.getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setCompanyId(companyId);

        indexableActionableDynamicQuery.setPerformActionMethod(
            new ActionableDynamicQuery.PerformActionMethod<Employee>() {

                @Override
                public void performAction(Employee employee) {

                    try {
                        Document document = getDocument(employee);
                        indexableActionableDynamicQuery.addDocuments(document);
                    }
                    catch (PortalException pe) {
                        if (_log.isWarnEnabled()) {
                            _log.warn("Unable to index employee " + employee.getEmpId(), pe);
                        }
                    }
                }
            });
        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
        indexableActionableDynamicQuery.performActions();
    }

    private static final Log _log = LogFactoryUtil.getLog(EmployeeIndexer.class);

    @Reference
    protected IndexWriterHelper indexWriterHelper;

    @Reference
    private EmployeeLocalService _employeeLocalService;

}