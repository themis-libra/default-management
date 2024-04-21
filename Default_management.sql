/*违约原因表*/
create table Default_reason (
	DContent varchar(100),	/*原因内容*/
	Dno varchar(10)					/*原因编号*/
);

/*违约申请表*/
create table Default_Application (
	Dcname varchar(20),			/*客户名称（申请人）*/
	Dlevel varchar(2),			/*违约严重性（等级）*/
	Danote varchar(100),		/*备注信息*/
	Dano varchar(10),				/*违约申请编号*/
	Datime varchar(10),			/*申请时间（年）*/
	Dname varchar(10)				/*违约人姓名*/
);

/*违约申请——原因表*/
create table DDA (
	Dno varchar(10),				/*违约原因编号*/
	Dano varchar(10)				/*违约申请编号*/
);

/*违约审核表*/
create table Default_Check (
	Dcno varchar(10),				/*审核编号*/
	Dcstatus varchar(2),		/*审核状态*/
	Dchecker varchar(10),		/*认定人*/
	Dctime varchar(10)			/*审核时间（年）*/
);

/*违约申请——审核表*/
create table DAC (
	Dano varchar(10),				/*违约申请编号*/
	Dcno varchar(10)				/*违约审核编号*/
);


/*重生原因表*/
create table Renew_reason (
	RContent varchar(100),	/*原因内容*/
	Rno varchar(10)					/*原因编号*/
);

/*重生申请表*/
create table Renew_Application (
	Rcname varchar(20),			/*客户名称（申请人）*/
	Rlevel varchar(2),			/*违约严重性（等级）*/
	Ranote varchar(100),		/*备注信息*/
	Rano varchar(10),				/*重生申请编号*/
	Ratime varchar(10)			/*申请时间（年）*/
);

/*重生申请——原因表*/
create table RRA (
	Rno varchar(10),				/*重生原因编号*/
	Rano varchar(10)				/*重生申请编号*/
);

/*重生审核表*/
create table Renew_Check (
	Rcno varchar(10),				/*审核编号*/
	Rcstatus varchar(2),		/*审核状态*/
	Rchecker varchar(10),		/*认定人*/
	Rctime varchar(10)			/*审核时间（年）*/
);

/*重生申请——审核表*/
create table RAC (
	Rano varchar(10),				/*重生申请编号*/
	Rcno varchar(10)				/*重生审核编号*/
);


/*客户信息表*/
create table Customer (
	Cname varchar(20),			/*客户名称*/
	Profession varchar(10),	/*客户行业*/
	Area varchar(10),				/*客户区域*/
	Ctype varchar(5)				/*客户类型*/
);

insert into customer
values ('张三','房地产','广东省','个体');

insert into customer
values ('李四','房地产','浙江省','个体');

insert into customer
values ('金地集团','房地产','广东省','集团');

insert into customer
values ('杭州金金房地产开发有限公司','房地产','浙江省','集团');