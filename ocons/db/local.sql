-- Заполнение таблицы локализации

INSERT INTO Localization (Name, RU, UA) VALUES 
	("G","Русский","Українська");

-- Общие 
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Language","Язык","Мова");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Attention","Внимание!","Увага!");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Error","Ошибка!","Помилка!");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Open","Открыть","Відкрити");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Save","Сохранить","Зберігти");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Cancel","Отмена","Відміна");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Yes","Да","Так");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_No","Нет","Ні");
INSERT INTO Localization (Name, RU, UA) VALUES
	("G_Ok","Согласен","Згоден");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("G_AYouSure","Вы действительно хотите","Ви дійсно бажаєте");

-- AddConsultantDialog
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_Title","Новый консультант","Новий консультант");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_PersonalNumber","Личный номер","Приватний номер");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_Name","Фамилия И.О.","Прізвище І.Б.");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_Phone","Телефон","Телефон");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_EMail","E-Mail","E-Mail");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_Remember","Запомнить меня","Запам'ятати мене");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_Password","Пароль","Пароль");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_RepeatPassword","Еще раз","Ще раз");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_RedLighting","Красным выделены обязательные поля","Червоним виділені обов'язкові поля");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_ConsultantPresent","Консультант с таким номером уже есть!","Консультант з таким номером вже є!");
INSERT INTO Localization (Name, RU, UA) VALUES
	("ACD_PasswordsNotCoincide","Пароли не совпадают!","Паролі не співпадають!");

-- LoginDialog
INSERT INTO Localization (Name, RU, UA) VALUES
	("LD_Title","Вход","Вхід");
INSERT INTO Localization (Name, RU, UA) VALUES
	("LD_Number","Номер","Номер");
INSERT INTO Localization (Name, RU, UA) VALUES
	("LD_Password","Пароль","Пароль");
INSERT INTO Localization (Name, RU, UA) VALUES
	("LD_Enter","Вход","Вхід");
INSERT INTO Localization (Name, RU, UA) VALUES
	("LD_ConsultantNumberNotPoint","Номер консультанта не указан!","Номер консультанта не вказано!");
INSERT INTO Localization (Name, RU, UA) VALUES
	("LD_IncorrectPassword","Неправильный пароль!","Невірний пароль!");
INSERT INTO Localization (Name, RU, UA) VALUES
	("LD_ConsultantNumberNotFound","Консультант с таким номером не найден!","Консультанта з таким номером не знайдено!");

-- MainMenu
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_1_Control","Управление","Керування");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_Config","Настройки","Настройки");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_AboutProgram","О программе","Про програму");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_Exit","Выход","Вихід");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_2_Consultant","Консультант","Консультант");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_NewConsultant","Новый консультант","Новий консультант");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_Enter","Вход","Вхід");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_OtherConsultant","Другой консультант","Інший консультант");
INSERT INTO Localization (Name, RU, UA) VALUES
	("MM_ConfirmOtherConsultant","Вы действительно хотите зайти другим консультантом?","Ви дійсно бажаєте увійти іншим консультантом?");

-- NavigationTree
INSERT INTO Localization (Name, RU, UA) VALUES
	("NT_Clients","Клиенты","Клієнти");
INSERT INTO Localization (Name, RU, UA) VALUES
	("NT_Invoices","Накладные","Накладні");
INSERT INTO Localization (Name, RU, UA) VALUES
	("NT_Catalogs","Каталоги","Каталоги");
INSERT INTO Localization (Name, RU, UA) VALUES
	("NT_Orders","Заказы","Закази");	
INSERT INTO Localization (Name, RU, UA) VALUES
	("NT_Pricelist","Прайслист","Прайслист");
INSERT INTO Localization (Name, RU, UA) VALUES
	("NT_Reports","Отчеты","Звіти");


-- InfoPanel
-- -- Global
-- -- -- Пункты дерева для подсказок
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_Clients","клиента","клієнта");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_Catalogs","каталог","каталог");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_Orders","заказ","заказ");	
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_Invoices","накладную","накладну");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_Prices","прайслист","прайсліст");
		
-- -- -- Действия
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_AddAction","Добавить","Додати");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_DeleteAction","Удалить","Видалити");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_EditAction","Редактировать","Редагувати");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_FindAction","Найти","Знайти");		
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_PreviewAction","Просмотреть","Передивитись");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_PrintAction","Печатать","Друкувати");
	
-- -- -- Поля таблиц и форм
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_CatalogNumber","Номер каталога","Номер каталогу");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_CatalogGiveDate","Дата выдачи","Дата видачі");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_CatalogReturnDate","Вернуть","Повернути");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_CatalogReturned","Возвращен","Повернуто");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_CatalogInfo","Примечания","Помітки");
	
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientName","Ф.И.О. Клиента","П.І.Б. Клієнта");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientPhone","Дом. телефон","Дом. телефон");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientPhoneMob","Моб. телефон","Моб. телефон");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientAdress","Адрес","Адреса");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientBirthday","День рождения","День народження");	
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientOther","Иное событие","Інша подія");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientOtherDate","Дата события","Дата події");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientStatus","Статус","Статус");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientStatus_1","Обычный","Звичайний");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientStatus_2","Постоянный","Постійний");		
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientDiscount","Скидка","Знижка");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientIncorrectDiscountFormat","Неверный формат скидки!","Невірний формат знижки!");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientAdd","Добавить клиента","Додати клієнта");	
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ClientEdit","Редактировать клиента","Редагувати клієнта");		
		
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_OrderDate","Дата заказа","Дата заказу");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_OrderQuantity","Количество товара","Кількість товару");
	
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_InvoicesID","Номер накладной","Номер накладної");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_InvoicesOrdered","Заказано","Заказано");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_InvoicesReceived","Получено","Отримано");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_InvoicesPrice","Цена","Ціна");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_InvoicesPoints","Баллы","Бали");
	
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ProductID","Код продукта","Код продукту");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ProductGetDate","Дата накладной","Дата накладної");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ProductGetPrice","Цена накладной","Ціна накладної");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ProductRealDate","Дата реализации","Дата реалізації");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_ProductRealPrice","Цена реализации","Ціна реалізації");
		
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_EventsComing","Начало события","Початок події");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_EventsCompletion","Конец события","Закінчення події");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_EventsFixed","Завершено","Завершено");
INSERT INTO Localization (Name, RU, UA) VALUES 
	("IP_EventInfo","Событие","Подія");	

-- INSERT INTO Localization (Name, RU, UA) VALUES 
--	("","","")


