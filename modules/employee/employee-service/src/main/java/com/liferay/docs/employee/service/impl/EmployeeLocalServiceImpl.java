/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.employee.service.impl;

import com.liferay.docs.employee.model.Employee;
import com.liferay.docs.employee.service.base.EmployeeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.docs.employee.service.EmployeeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Liferay
 * @see EmployeeLocalServiceBaseImpl
 * @see com.liferay.docs.employee.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.docs.employee.service.EmployeeLocalServiceUtil} to access the employee local service.
	 */
	
	public Employee addEmployee(long userId, long psno, String fname, String lname, String empAddress, ServiceContext serviceContext) throws PortalException
	{
		long groupId = serviceContext.getScopeGroupId();

	    User user = userLocalService.getUserById(userId);

	    Date now = new Date();
	    
	    long empId = counterLocalService.increment();
	    
	    Employee employee = employeePersistence.create(empId);
	    
	    employee.setUuid(serviceContext.getUuid());
	    employee.setUserId(userId);
	    employee.setGroupId(groupId);
	    employee.setCompanyId(user.getCompanyId());
	    employee.setUserName(user.getFullName());
	    employee.setCreateDate(serviceContext.getCreateDate(now));
	    employee.setModifiedDate(serviceContext.getModifiedDate(now));
	    employee.setExpandoBridgeAttributes(serviceContext);
	    employee.setPsno(psno);
	    employee.setFname(fname);
	    employee.setLname(lname);
	    employee.setEmpAddress(empAddress);
	    
	    employeePersistence.update(employee);
	    
	    return employee;
	}
	
	public Employee updateEmployee(long userId, long psno, long empId, String fname, String lname, String empAddress, ServiceContext serviceContext) throws PortalException
	{
		Date now = new Date();
		User user = userLocalService.getUserById(userId);
		
		Employee employee = getEmployee(empId);
		
		employee.setUserId(userId);
	    employee.setUserName(user.getFullName());
	    employee.setModifiedDate(serviceContext.getModifiedDate(now));
	    employee.setPsno(psno);
	    employee.setFname(fname);
	    employee.setLname(lname);
	    employee.setEmpAddress(empAddress);
	    employee.setExpandoBridgeAttributes(serviceContext);
	    
	    employeePersistence.update(employee);
	    
	    return employee;
	}
	
	public Employee deleteEmployee(long empId, ServiceContext serviceContext) throws PortalException
	{
		Employee employee = getEmployee(empId);
		employee = deleteEmployee(empId);
		return employee;
	}
	
	public List<Employee> getEmployees(long groupId)
	{
		return employeePersistence.findByGroupId(groupId);
	}
	
	public int getEmployeesCount(long groupId)
	{
		return employeePersistence.countByGroupId(groupId);
	}
	
	
	
	
	
	
	
	
}