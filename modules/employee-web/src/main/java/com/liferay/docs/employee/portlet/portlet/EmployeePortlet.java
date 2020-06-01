package com.liferay.docs.employee.portlet.portlet;

import com.liferay.docs.employee.model.Employee;
import com.liferay.docs.employee.portlet.constants.EmployeePortletKeys;
import com.liferay.docs.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Shubhangi Bhargava
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeePortletKeys.Employee,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeePortlet extends MVCPortlet 
{
	
	public void addEmployee(ActionRequest request, ActionResponse response) throws PortalException 
	{
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Employee.class.getName(), request);

        long empId = ParamUtil.getLong(request, "empId");
		long psno =ParamUtil.getLong(request, "psno");
		String fname = ParamUtil.getString(request, "fname");
		String lname = ParamUtil.getString(request, "lname");
		String email = ParamUtil.getString(request, "email");
		String empAddress = ParamUtil.getString(request, "empAddress");

	    if (empId > 0) 
	    {
	        try 
	        {
	            _employeeLocalService.updateEmployee(serviceContext.getUserId(), psno, empId, fname, lname, email, empAddress, serviceContext);
	        }
	        catch (Exception e) 
	        {
	            System.out.println(e);
	            
	            PortalUtil.copyRequestParameters(request, response);
	
	            response.setRenderParameter( "mvcPath", "/edit_employee.jsp");
	        }
	
	    }
	    else 
	    {
	        try 
	        {
	            _employeeLocalService.addEmployee(serviceContext.getUserId(), psno, fname, lname, email, empAddress, serviceContext);
	        }
	        catch (Exception e) 
	        {
	            PortalUtil.copyRequestParameters(request, response);
	
	            response.setRenderParameter( "mvcPath", "/edit_employee.jsp");
	        }
	    }
	}
	
	public void deleteEmployee(ActionRequest request, ActionResponse response) throws PortalException 
	{
        long empId = ParamUtil.getLong(request, "empId");

        ServiceContext serviceContext = ServiceContextFactory.getInstance( Employee.class.getName(), request);

        try 
        {
        	_employeeLocalService.deleteEmployee(empId, serviceContext);
        }
        catch (Exception e) 
        {
            Logger.getLogger(EmployeePortlet.class.getName()).log( Level.SEVERE, null, e);
        }
	}	
	
	@Reference(unbind="-")
	protected void setEmployeeService(EmployeeLocalService employeeLocalService)
	{
		_employeeLocalService = employeeLocalService;
	}
	
	private EmployeeLocalService _employeeLocalService;
}