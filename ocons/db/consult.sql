-- Создание БД консультанта

-- Таблица товаров
CREATE TABLE Products (
	Prod_ID		INTEGER,
	GetDate		DATE,
	GetPrice	NUMERIC(5,2),
	RealDate	DATE,
	RealPrice	NUMERIC(5,2),
	Client_ID	INTEGER
);

-- Таблица клиентов
CREATE TABLE Clients (
	Client_ID	INTEGER PRIMARY KEY AUTOINCREMENT,
	Name		VARCHAR(30),
	Phone		VARCHAR(15),
	PhoneMob	VARCHAR(15),
	Adress		VARCHAR(30),
	Birthday	DATE,
	Other		VARCHAR(50),
	Otherdate	DATE,
	Status		CHAR(1),
	Discount	NUMERIC(3,2)
);

-- Накладные
CREATE TABLE Invoices (
	Inv_ID		INTEGER PRIMARY KEY,
	Prod_ID		INTEGER,
	Ordered		NUMERIC(3),
	Receive		NUMERIC(3),
	Price		NUMERIC(5,2),
	Points		NUMERIC(3)
);

-- Заказы
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

-- Каталоги
CREATE TABLE Catalogs (
	Cat_ID		INTEGER,
	Client_ID	INTEGER,
	GiveDate	DATE,
	ReturnDate	DATE,
	Returned	DATE,
	Info		TEXT
);

-- События
CREATE TABLE Events (
	Coming		DATETIME,
	Completion	DATETIME,
	Fixed		BOOLEAN,
	Info		TEXT
);

-- Финансовый результат консультанта
CREATE TABLE Results (
	Cat_ID		INTEGER,
	Income		NUMERIC(7,2),
	Expense		NUMERIC(7,2)
);