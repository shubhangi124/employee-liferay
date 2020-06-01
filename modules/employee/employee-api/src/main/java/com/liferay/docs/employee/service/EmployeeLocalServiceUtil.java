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

package com.liferay.docs.employee.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Employee. This utility wraps
 * {@link com.liferay.docs.employee.service.impl.EmployeeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Liferay
 * @see EmployeeLocalService
 * @see com.liferay.docs.employee.service.base.EmployeeLocalServiceBaseImpl
 * @see com.liferay.docs.employee.service.impl.EmployeeLocalServiceImpl
 * @generated
 */
@ProviderType
public class EmployeeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.docs.employee.service.impl.EmployeeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the employee to the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was added
	*/
	public static com.liferay.docs.employee.model.Employee addEmployee(
		com.liferay.docs.employee.model.Employee employee) {
		return getService().addEmployee(employee);
	}

	public static com.liferay.docs.employee.model.Employee addEmployee(
		long userId, long psno, String fname, String lname, String email,
		String empAddress,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addEmployee(userId, psno, fname, lname, email, empAddress,
			serviceContext);
	}

	/**
	* Creates a new employee with the primary key. Does not add the employee to the database.
	*
	* @param empId the primary key for the new employee
	* @return the new employee
	*/
	public static com.liferay.docs.employee.model.Employee createEmployee(
		long empId) {
		return getService().createEmployee(empId);
	}

	/**
	* Deletes the employee from the database. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was removed
	*/
	public static com.liferay.docs.employee.model.Employee deleteEmployee(
		com.liferay.docs.employee.model.Employee employee) {
		return getService().deleteEmployee(employee);
	}

	/**
	* Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the employee
	* @return the employee that was removed
	* @throws PortalException if a employee with the primary key could not be found
	*/
	public static com.liferay.docs.employee.model.Employee deleteEmployee(
		long empId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEmployee(empId);
	}

	public static com.liferay.docs.employee.model.Employee deleteEmployee(
		long empId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEmployee(empId, serviceContext);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.employee.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.employee.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.docs.employee.model.Employee fetchEmployee(
		long empId) {
		return getService().fetchEmployee(empId);
	}

	/**
	* Returns the employee matching the UUID and group.
	*
	* @param uuid the employee's UUID
	* @param groupId the primary key of the group
	* @return the matching employee, or <code>null</code> if a matching employee could not be found
	*/
	public static com.liferay.docs.employee.model.Employee fetchEmployeeByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchEmployeeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the employee with the primary key.
	*
	* @param empId the primary key of the employee
	* @return the employee
	* @throws PortalException if a employee with the primary key could not be found
	*/
	public static com.liferay.docs.employee.model.Employee getEmployee(
		long empId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEmployee(empId);
	}

	/**
	* Returns the employee matching the UUID and group.
	*
	* @param uuid the employee's UUID
	* @param groupId the primary key of the group
	* @return the matching employee
	* @throws PortalException if a matching employee could not be found
	*/
	public static com.liferay.docs.employee.model.Employee getEmployeeByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEmployeeByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.employee.model.impl.EmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @return the range of employees
	*/
	public static java.util.List<com.liferay.docs.employee.model.Employee> getEmployees(
		int start, int end) {
		return getService().getEmployees(start, end);
	}

	public static java.util.List<com.liferay.docs.employee.model.Employee> getEmployees(
		long groupId) {
		return getService().getEmployees(groupId);
	}

	public static java.util.List<com.liferay.docs.employee.model.Employee> getEmployees(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmployees(groupId, start, end);
	}

	public static java.util.List<com.liferay.docs.employee.model.Employee> getEmployees(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.docs.employee.model.Employee> obc) {
		return getService().getEmployees(groupId, start, end, obc);
	}

	/**
	* Returns all the employees matching the UUID and company.
	*
	* @param uuid the UUID of the employees
	* @param companyId the primary key of the company
	* @return the matching employees, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.docs.employee.model.Employee> getEmployeesByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getEmployeesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of employees matching the UUID and company.
	*
	* @param uuid the UUID of the employees
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of employees
	* @param end the upper bound of the range of employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching employees, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.docs.employee.model.Employee> getEmployeesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.docs.employee.model.Employee> orderByComparator) {
		return getService()
				   .getEmployeesByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of employees.
	*
	* @return the number of employees
	*/
	public static int getEmployeesCount() {
		return getService().getEmployeesCount();
	}

	public static int getEmployeesCount(long groupId) {
		return getService().getEmployeesCount(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employee the employee
	* @return the employee that was updated
	*/
	public static com.liferay.docs.employee.model.Employee updateEmployee(
		com.liferay.docs.employee.model.Employee employee) {
		return getService().updateEmployee(employee);
	}

	public static com.liferay.docs.employee.model.Employee updateEmployee(
		long userId, long psno, long empId, String fname, String lname,
		String email, String empAddress,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateEmployee(userId, psno, empId, fname, lname, email,
			empAddress, serviceContext);
	}

	public static EmployeeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployeeLocalService, EmployeeLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EmployeeLocalService.class);

		ServiceTracker<EmployeeLocalService, EmployeeLocalService> serviceTracker =
			new ServiceTracker<EmployeeLocalService, EmployeeLocalService>(bundle.getBundleContext(),
				EmployeeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}