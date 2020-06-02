create table EMP_Employee (
	uuid_ VARCHAR(75) null,
	empId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	psno LONG,
	fname VARCHAR(75) null,
	lname VARCHAR(75) null,
	email VARCHAR(75) null,
	empAddress VARCHAR(75) null
);