DROP INDEX "IX_Парихмахер_1";
DROP INDEX "IX_Заказ_1";
DROP INDEX "IX_Заказ_2";

DROP TABLE parichm.zakazusl;
DROP TABLE parichm.zakaz;
DROP TABLE parichm.parichmaher;
DROP TABLE parichm.price;
DROP TABLE parichm.klient;
DROP TABLE parichm.dopusl;
DROP TABLE parichm.pricheska;

CREATE TABLE parichm.pricheska (
       id SERIAL NOT NULL
     , tipprich CHAR(10)
     , cost INT
     , namepric CHAR(10)
);

CREATE TABLE parichm.dopusl (
       id SERIAL NOT NULL
     , name CHAR(10)
     , cost INT
);

CREATE TABLE parichm.klient (
       id SERIAL NOT NULL
     , fio CHAR(10)
     , pol CHAR(1)
);

CREATE TABLE parichm.price (
       id INTEGER NOT NULL
     , name CHAR(30)
     , price INTEGER
);

CREATE TABLE parichm.parichmaher (
       id SERIAL NOT NULL
     , fio CHAR(10)
     , staj INT
     , pay INT
);
CREATE INDEX "IX_Парихмахер_1" ON parichm.parichmaher (fio);

CREATE TABLE parichm.zakaz (
       id SERIAL NOT NULL
     , namezakazchik CHAR(10)
     , numzak INT
     , dataoformlzak DATE
     , datavipzakaza DATE
     , idklient INT
     , idparichm INT
     , idpricha INT
     , cost INT
     , idprice INTEGER
);

CREATE TABLE parichm.zakazusl (
       id SERIAL NOT NULL
     , idzakaz INT
     , iddopusl INT
);

ALTER TABLE parichm.pricheska
  ADD CONSTRAINT PK_PRICHESKA
      PRIMARY KEY (id);

ALTER TABLE parichm.dopusl
  ADD CONSTRAINT PK_DOPUSL
      PRIMARY KEY (id);

ALTER TABLE parichm.klient
  ADD CONSTRAINT PK_KLIENT
      PRIMARY KEY (id);

ALTER TABLE parichm.price
  ADD CONSTRAINT PK_PRICE
      PRIMARY KEY (id);

ALTER TABLE parichm.parichmaher
  ADD CONSTRAINT PK_PARICHMAHER
      PRIMARY KEY (id);

ALTER TABLE parichm.zakaz
  ADD CONSTRAINT PK_ZAKAZ
      PRIMARY KEY (id);

ALTER TABLE parichm.zakazusl
  ADD CONSTRAINT PK_ZAKAZUSL
      PRIMARY KEY (id);

ALTER TABLE parichm.zakaz
  ADD CONSTRAINT "UQ_Заказ_1"
      UNIQUE (id);

ALTER TABLE parichm.zakaz
  ADD CONSTRAINT "UQ_Заказ_2"
      UNIQUE (numzak);

ALTER TABLE parichm.zakaz
  ADD CONSTRAINT "FK_Заказ_3"
      FOREIGN KEY (idpricha)
      REFERENCES parichm.pricheska (id);

ALTER TABLE parichm.zakaz
  ADD CONSTRAINT "FK_Заказ_1"
      FOREIGN KEY (idklient)
      REFERENCES parichm.klient (id);

ALTER TABLE parichm.zakaz
  ADD CONSTRAINT "FK_Заказ_2"
      FOREIGN KEY (idparichm)
      REFERENCES parichm.parichmaher (id);

ALTER TABLE parichm.zakaz
  ADD CONSTRAINT FK_zakaz_4
      FOREIGN KEY (idprice)
      REFERENCES parichm.price (id);

ALTER TABLE parichm.zakazusl
  ADD CONSTRAINT "FK_заказ-услуги_3"
      FOREIGN KEY (iddopusl)
      REFERENCES parichm.dopusl (id);

ALTER TABLE parichm.zakazusl
  ADD CONSTRAINT "FK_заказ-услуги_2"
      FOREIGN KEY (idzakaz)
      REFERENCES parichm.zakaz (id);

