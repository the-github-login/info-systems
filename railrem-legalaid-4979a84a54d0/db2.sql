CREATE SEQUENCE auto_id_topic;

CREATE TABLE TOPIC(
ID INTEGER NOT NULL PRIMARY KEY default nextval('auto_id_topic') ,
CREATE_TIME  TIMESTAMP  NOT NULL default now(),
user_id integer not null
);
CREATE SEQUENCE auto_id_message;
create table message(
id INTEGER NOT NULL PRIMARY KEY default nextval('auto_id_message'),
top_id integer NOT NULL,
message text NOT NULL,
user_id integer NOT NULL,
CREATE_TIME  TIMESTAMP  NOT NULL default now()
);
ALTER TABLE message
  ADD CONSTRAINT FK_9 FOREIGN KEY (top_id) REFERENCES topic(id);
 