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

package com.liferay.docs.employee.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author Liferay
 * @see Employee
 * @generated
 */
@ProviderType
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("empId", getEmpId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("psno", getPsno());
		attributes.put("fname", getFname());
		attributes.put("lname", getLname());
		attributes.put("email", getEmail());
		attributes.put("empAddress", getEmpAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long psno = (Long)attributes.get("psno");

		if (psno != null) {
			setPsno(psno);
		}

		String fname = (String)attributes.get("fname");

		if (fname != null) {
			setFname(fname);
		}

		String lname = (String)attributes.get("lname");

		if (lname != null) {
			setLname(lname);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String empAddress = (String)attributes.get("empAddress");

		if (empAddress != null) {
			setEmpAddress(empAddress);
		}
	}

	@Override
	public Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	@Override
	public int compareTo(Employee employee) {
		return _employee.compareTo(employee);
	}

	/**
	* Returns the company ID of this employee.
	*
	* @return the company ID of this employee
	*/
	@Override
	public long getCompanyId() {
		return _employee.getCompanyId();
	}

	/**
	* Returns the create date of this employee.
	*
	* @return the create date of this employee
	*/
	@Override
	public Date getCreateDate() {
		return _employee.getCreateDate();
	}

	/**
	* Returns the email of this employee.
	*
	* @return the email of this employee
	*/
	@Override
	public String getEmail() {
		return _employee.getEmail();
	}

	/**
	* Returns the emp address of this employee.
	*
	* @return the emp address of this employee
	*/
	@Override
	public String getEmpAddress() {
		return _employee.getEmpAddress();
	}

	/**
	* Returns the emp ID of this employee.
	*
	* @return the emp ID of this employee
	*/
	@Override
	public long getEmpId() {
		return _employee.getEmpId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	/**
	* Returns the fname of this employee.
	*
	* @return the fname of this employee
	*/
	@Override
	public String getFname() {
		return _employee.getFname();
	}

	/**
	* Returns the group ID of this employee.
	*
	* @return the group ID of this employee
	*/
	@Override
	public long getGroupId() {
		return _employee.getGroupId();
	}

	/**
	* Returns the lname of this employee.
	*
	* @return the lname of this employee
	*/
	@Override
	public String getLname() {
		return _employee.getLname();
	}

	/**
	* Returns the modified date of this employee.
	*
	* @return the modified date of this employee
	*/
	@Override
	public Date getModifiedDate() {
		return _employee.getModifiedDate();
	}

	/**
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	@Override
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	/**
	* Returns the psno of this employee.
	*
	* @return the psno of this employee
	*/
	@Override
	public long getPsno() {
		return _employee.getPsno();
	}

	/**
	* Returns the status of this employee.
	*
	* @return the status of this employee
	*/
	@Override
	public int getStatus() {
		return _employee.getStatus();
	}

	/**
	* Returns the status by user ID of this employee.
	*
	* @return the status by user ID of this employee
	*/
	@Override
	public long getStatusByUserId() {
		return _employee.getStatusByUserId();
	}

	/**
	* Returns the status by user name of this employee.
	*
	* @return the status by user name of this employee
	*/
	@Override
	public String getStatusByUserName() {
		return _employee.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this employee.
	*
	* @return the status by user uuid of this employee
	*/
	@Override
	public String getStatusByUserUuid() {
		return _employee.getStatusByUserUuid();
	}

	/**
	* Returns the status date of this employee.
	*
	* @return the status date of this employee
	*/
	@Override
	public Date getStatusDate() {
		return _employee.getStatusDate();
	}

	/**
	* Returns the user ID of this employee.
	*
	* @return the user ID of this employee
	*/
	@Override
	public long getUserId() {
		return _employee.getUserId();
	}

	/**
	* Returns the user name of this employee.
	*
	* @return the user name of this employee
	*/
	@Override
	public String getUserName() {
		return _employee.getUserName();
	}

	/**
	* Returns the user uuid of this employee.
	*
	* @return the user uuid of this employee
	*/
	@Override
	public String getUserUuid() {
		return _employee.getUserUuid();
	}

	/**
	* Returns the uuid of this employee.
	*
	* @return the uuid of this employee
	*/
	@Override
	public String getUuid() {
		return _employee.getUuid();
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	/**
	* Returns <code>true</code> if this employee is approved.
	*
	* @return <code>true</code> if this employee is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _employee.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this employee is denied.
	*
	* @return <code>true</code> if this employee is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _employee.isDenied();
	}

	/**
	* Returns <code>true</code> if this employee is a draft.
	*
	* @return <code>true</code> if this employee is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _employee.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this employee is expired.
	*
	* @return <code>true</code> if this employee is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _employee.isExpired();
	}

	/**
	* Returns <code>true</code> if this employee is inactive.
	*
	* @return <code>true</code> if this employee is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _employee.isInactive();
	}

	/**
	* Returns <code>true</code> if this employee is incomplete.
	*
	* @return <code>true</code> if this employee is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _employee.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _employee.isNew();
	}

	/**
	* Returns <code>true</code> if this employee is pending.
	*
	* @return <code>true</code> if this employee is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _employee.isPending();
	}

	/**
	* Returns <code>true</code> if this employee is scheduled.
	*
	* @return <code>true</code> if this employee is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _employee.isScheduled();
	}

	@Override
	public void persist() {
		_employee.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this employee.
	*
	* @param companyId the company ID of this employee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employee.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this employee.
	*
	* @param createDate the create date of this employee
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_employee.setCreateDate(createDate);
	}

	/**
	* Sets the email of this employee.
	*
	* @param email the email of this employee
	*/
	@Override
	public void setEmail(String email) {
		_employee.setEmail(email);
	}

	/**
	* Sets the emp address of this employee.
	*
	* @param empAddress the emp address of this employee
	*/
	@Override
	public void setEmpAddress(String empAddress) {
		_employee.setEmpAddress(empAddress);
	}

	/**
	* Sets the emp ID of this employee.
	*
	* @param empId the emp ID of this employee
	*/
	@Override
	public void setEmpId(long empId) {
		_employee.setEmpId(empId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_employee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_employee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the fname of this employee.
	*
	* @param fname the fname of this employee
	*/
	@Override
	public void setFname(String fname) {
		_employee.setFname(fname);
	}

	/**
	* Sets the group ID of this employee.
	*
	* @param groupId the group ID of this employee
	*/
	@Override
	public void setGroupId(long groupId) {
		_employee.setGroupId(groupId);
	}

	/**
	* Sets the lname of this employee.
	*
	* @param lname the lname of this employee
	*/
	@Override
	public void setLname(String lname) {
		_employee.setLname(lname);
	}

	/**
	* Sets the modified date of this employee.
	*
	* @param modifiedDate the modified date of this employee
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_employee.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the psno of this employee.
	*
	* @param psno the psno of this employee
	*/
	@Override
	public void setPsno(long psno) {
		_employee.setPsno(psno);
	}

	/**
	* Sets the status of this employee.
	*
	* @param status the status of this employee
	*/
	@Override
	public void setStatus(int status) {
		_employee.setStatus(status);
	}

	/**
	* Sets the status by user ID of this employee.
	*
	* @param statusByUserId the status by user ID of this employee
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_employee.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this employee.
	*
	* @param statusByUserName the status by user name of this employee
	*/
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_employee.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this employee.
	*
	* @param statusByUserUuid the status by user uuid of this employee
	*/
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_employee.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this employee.
	*
	* @param statusDate the status date of this employee
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_employee.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this employee.
	*
	* @param userId the user ID of this employee
	*/
	@Override
	public void setUserId(long userId) {
		_employee.setUserId(userId);
	}

	/**
	* Sets the user name of this employee.
	*
	* @param userName the user name of this employee
	*/
	@Override
	public void setUserName(String userName) {
		_employee.setUserName(userName);
	}

	/**
	* Sets the user uuid of this employee.
	*
	* @param userUuid the user uuid of this employee
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_employee.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this employee.
	*
	* @param uuid the uuid of this employee
	*/
	@Override
	public void setUuid(String uuid) {
		_employee.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	@Override
	public Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public String toString() {
		return _employee.toString();
	}

	@Override
	public Employee toUnescapedModel() {
		return new EmployeeWrapper(_employee.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _employee.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeWrapper)) {
			return false;
		}

		EmployeeWrapper employeeWrapper = (EmployeeWrapper)obj;

		if (Objects.equals(_employee, employeeWrapper._employee)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _employee.getStagedModelType();
	}

	@Override
	public Employee getWrappedModel() {
		return _employee;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _employee.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _employee.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private final Employee _employee;
}