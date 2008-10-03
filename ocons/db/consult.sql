-- �������� �� ������������

-- ������� �������
CREATE TABLE Products (
	Prod_ID		INTEGER,
	GetDate		DATE,
	GetPrice	NUMERIC(5,2),
	RealDate	DATE,
	RealPrice	NUMERIC(5,2),
	Inv_ID		INTEGER,
	Client_ID	INTEGER
);

-- ������� ��������
CREATE TABLE Clients (
	Client_ID	INTEGER PRIMARY KEY AUTOINCREMENT,
	Name		VARCHAR(50),
	Phone		VARCHAR(20),
	PhoneMob	VARCHAR(20),
	Adress		VARCHAR(30),
	Birthday	DATE,
	Other		VARCHAR(50),
	Otherdate	DATE,
	Status		CHAR(1),
	Discount	NUMERIC(3,2)
);

-- ������� �����
CREATE TABLE Prices (
	Prod_ID		INTEGER PRIMARY KEY,
	Name		VARCHAR(50),
	Price1		NUMERIC(5,2),
	Price2		NUMERIC(5,2),
	Price3		NUMERIC(5,2),
	Points		NUMERIC(3),
	Cat_ID		INTEGER,
	CatPage		NUMERIC(3),
	Special		CHAR(1)
);

-- ����������� �������
CREATE TABLE Conditions (
	Cond_ID		INTEGER,
	CondType	CHAR(1),
	N			NUMERIC(2),
	M			NUMERIC(2),
	K			NUMERIC(2),
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

-- ���������
CREATE TABLE Invoices (
	Inv_ID		INTEGER PRIMARY KEY,
	Prod_ID		INTEGER,
	Ordered		NUMERIC(3),
	Received	NUMERIC(3),
	Price		NUMERIC(5,2),
	Points		NUMERIC(3)
);

-- ������
CREATE TABLE OrderHeads (
	Order_ID	INTEGER PRIMARY KEY AUTOINCREMENT,
	Client_ID	INTEGER,
	OrderDate	DATE
);

CREATE TABLE Orders (
	Order_ID	INTEGER,
	Prod_ID		INTEGER,
	Quantity	NUMERIC(3)
);

-- ��������
CREATE TABLE Catalogs (
	Cat_ID		INTEGER,
	Client_ID	INTEGER,
	GiveDate	DATE,
	ReturnDate	DATE,
	Returned	DATE,
	Info		TEXT
);

-- �������
CREATE TABLE Events (
	Coming		DATETIME,
	Completion	DATETIME,
	Fixed		DATETIME,
	Info		TEXT
);

-- ���������� ��������� ������������
CREATE TABLE Results (
	Cat_ID		INTEGER,
	Income		NUMERIC(7,2),
	Expense		NUMERIC(7,2),
	Points		NUMERIC(7)
);