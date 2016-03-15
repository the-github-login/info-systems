CREATE SEQUENCE auto_id_users;

CREATE TABLE IF NOT EXISTS users (
  id integer NOT NULL PRIMARY KEY DEFAULT nextval('auto_id_users'),
  password varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  surname varchar(255) NOT NULL, 
  lockated boolean DEFAULT FALSE,
  UNIQUE (EMAIL)
);

--
-- Дамп данных таблицы `user`
--

INSERT INTO users (id,password, email, name,surname) VALUES
(10, '$2a$10$QQ4NZCEK6IASCKabjfe2lOkRIGSRj6CtVJYHTasoSosIh4./3amkK', 'lamp@kpfu.ru', 'Rail','Hisa'),
(11, '$2a$10$IQd/X6Y66q42K7QhcsdXduByMM/KkG9BHXOHzS4AKUj2KPZ8Mkd1W', 'lamp2@kpfu.ru', 'Admin' ,'Adminovich');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--
CREATE SEQUENCE auto_id_user_role;

CREATE TABLE IF NOT EXISTS user_role (
  id intEGER NOT NULL Primary key default nextval('auto_id_user_role'),
  authority varchar(30) NOT NULL,
  
  UNIQUE(authority)
) 

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO user_role (id, authority) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Структура таблицы `user_user_role`
--

CREATE TABLE IF NOT EXISTS user_user_role (
  user_id integer NOT NULL,
  user_role integer NOT NULL,
  PRIMARY KEY (user_id,user_role)
) ;

--
-- Дамп данных таблицы `user_user_role`
--

INSERT INTO user_user_role (user_id, user_role) VALUES
(11, 1),
(10, 2),
(11, 2);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

-- Ограничения внешнего ключа таблицы `user_user_role`
--
ALTER TABLE user_user_role
  ADD CONSTRAINT FK_1 FOREIGN KEY (user_id) REFERENCES users(id),
  ADD CONSTRAINT FK_4 FOREIGN KEY (user_role) REFERENCES user_role(id);