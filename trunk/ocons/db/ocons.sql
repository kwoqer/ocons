-- ��������� �������
CREATE TABLE PriceStore (
	Cat_ID		INTEGER,
	Prod_ID		INTEGER,
	Name		VARCHAR(50),
	Price1		NUMERIC(5,2),
	Price2		NUMERIC(5,2),
	Price3		NUMERIC(5,2),
	Points		NUMERIC(3),
	CatPage		NUMERIC(3)
);

-- ������� �����
CREATE TABLE Prices (
	Prod_ID		INTEGER PRIMARY KEY,
	Name		VARCHAR(50),
	Price1		NUMERIC(5,2),
	Price2		NUMERIC(5,2),
	Price3		NUMERIC(5,2),
	Points		NUMERIC(3),
	Cat_ID		NUMERIC(6),
	CatPage		NUMERIC(3),
	Special		CHAR(1)
);

-- ����������� �������
CREATE TABLE Conditions (
	Cond_ID		INTEGER PRIMARY KEY AUTOINCREMENT,
	CondType	NUMERIC(2),
	N		NUMERIC(2),
	M		NUMERIC(2),
	K		NUMERIC(2),
	Summa		NUMERIC(5,2)
);

-- �������� ������
CREATE TABLE Groups (
	Group_ID	INTEGER PRIMARY KEY,
	Cond_ID		INTEGER,
	Name		VARCHAR(15)
);

-- ������ �������� �����
CREATE TABLE MGroup (
	Group_ID	INTEGER,
	Cond_ID		INTEGER,
	Prod_ID		INTEGER,
	Price1		NUMERIC(5,2),
	Price2		NUMERIC(5,2),
	Price3		NUMERIC(5,2),
	Points		NUMERIC(3)
);

-- ������ ������ ��������
CREATE TABLE KGroup (
	Cond_ID		INTEGER,
	Prod_ID		INTEGER,
	Price1		NUMERIC(5,2),
	Price2		NUMERIC(5,2),
	Price3		NUMERIC(5,2),
	Points		NUMERIC(3)
);


-- ��������� ���������
CREATE TABLE CatCalendar (
	Cat_ID		INTEGER PRIMARY KEY,
	CatBegin	DATE,
	CatEnd		DATE
);

-- ������������
CREATE TABLE Consultants (
	Cons_ID		VARCHAR(10),
	Name		VARCHAR(30),
	Phone		VARCHAR(20),
	EMail		VARCHAR(30),
	First		BOOL,
	PasswordHash	INTEGER	
);