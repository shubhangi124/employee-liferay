create index IX_39BC8DFF on EMP_Employee (groupId);
create index IX_DF92183F on EMP_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EF1A281 on EMP_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);