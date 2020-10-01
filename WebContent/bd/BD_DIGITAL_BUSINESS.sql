DROP DATABASE IF EXISTS DIGITAL_BUSINESS;

CREATE DATABASE DIGITAL_BUSINESS;
USE DIGITAL_BUSINESS;

-- -----------------------------------


-- 1 : TABLA MARCA --
DROP TABLE IF EXISTS MARCA;
CREATE TABLE MARCA
(
 CODIGO_MARCA  INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 NOMBRE_MARCA  VARCHAR(30) NULL
)AUTO_INCREMENT = 1;

------------------------------------------
INSERT INTO MARCA VALUES(NULL,'LG');
INSERT INTO MARCA VALUES(NULL,'SONY');
INSERT INTO MARCA VALUES(NULL,'SAMSUNG');

INSERT INTO MARCA VALUES(NULL,'MOTOROLA');
INSERT INTO MARCA VALUES(NULL,'HUAWEI');
INSERT INTO MARCA VALUES(NULL,'XIAOMI');
INSERT INTO MARCA VALUES(NULL,'APPLE');
INSERT INTO MARCA VALUES(NULL,'HP');
INSERT INTO MARCA VALUES(NULL,'LENOVO');
INSERT INTO MARCA VALUES(NULL,'MICROSOFT');

SELECT * FROM MARCA;

-----------------------------------------------

-- 2 : TABLA PRODUCTO --
DROP TABLE IF EXISTS PRODUCTO;
CREATE TABLE PRODUCTO
(
  CODIGO_PRODUCTO INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  NOMBRE_PRODUCTO VARCHAR(50) NULL,
  ID_MARCA INT(11) NULL,
  PRECIO_UNITARIO DECIMAL(9,2) NOT NULL,
  STOCK INT(11) NULL,
  CARACTERISTICAS VARCHAR(1024) NULL,
  CONSTRAINT FKCODMARCA FOREIGN KEY(ID_MARCA) REFERENCES MARCA(CODIGO_MARCA)
)AUTO_INCREMENT = 100000;
----------------------------------------------------------
INSERT INTO PRODUCTO VALUES(NULL,'LG K50',1,500,60,'MEMORIA:4GB,CAMARA FRONTAL:13MP');
INSERT INTO PRODUCTO VALUES(NULL,'SONY XPERIA',2,600,60,'MEMORIA:3GB,CAMARA FRONTAL:8MP');
INSERT INTO PRODUCTO VALUES(NULL,'SAMSUNG S10',3,700,60,'MEMORIA:4GB,CAMARA FRONTAL:12MP');


INSERT INTO PRODUCTO VALUES(NULL,'HUAWEI P9',5,1200,45,'MEMORIA RAM:3 O 4GB,CAMARA FRONTAL:12MP, TAMAÑO: 5.2 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'Huawei Y9 Prime',5,920,55,'MEMORIA RAM:4GB,CAMARA FRONTAL:16MP, TAMAÑO: 6.6 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'Huawei Mate 20 Lite',5,789,19,'MEMORIA RAM:4GB,CAMARA FRONTAL:14MP, TAMAÑO: 6.3 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'Huawei Y7',5,599,20,'MEMORIA RAM:3GB,CAMARA FRONTAL:13MP, TAMAÑO: 6.2 pulgadas');


INSERT INTO PRODUCTO VALUES(NULL,'IPHONE 8 PLUS',7,2498,20,'MEMORIA RAM:3GB,CAMARA FRONTAL:16MP, TAMAÑO: 5.5 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'iPhone Xr',7,2430,25,'MEMORIA RAM:3GB,CAMARA FRONTAL:12MP, TAMAÑO: 6.1 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'iPhone 8',7,1590,30,'MEMORIA RAM:3GB,CAMARA FRONTAL:12MP, TAMAÑO: 4.7 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'Audífonos Earpods Lightning',7,80,10,'Formato: In-ear, Largo del cable 1.2m');



INSERT INTO PRODUCTO VALUES(NULL,'Moto G 7 Play',4,730,45,'MEMORIA RAM:2GB,CAMARA FRONTAL:13MP, TAMAÑO: 5.7 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'Motorola Moto Z3 Play',4,1350,26,'MEMORIA RAM:6GB,CAMARA FRONTAL:12MP, TAMAÑO: 6.1 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'Moto One Action',4,1200,32,'MEMORIA RAM:4GB,CAMARA FRONTAL:13MP, TAMAÑO: 5.9 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'Motorola Moto G6 Plus',4,840,29,'MEMORIA RAM:4GB,CAMARA FRONTAL:12MP, TAMAÑO: 5.8 pulgadas');


INSERT INTO PRODUCTO VALUES(NULL,'LG V30',1,2300,60,'MEMORIA RAM:3GB,CAMARA FRONTAL:16MP, TAMAÑO: 6.0 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'LG K40',1,500,30,'MEMORIA RAM:2GB,CAMARA FRONTAL:16MP, TAMAÑO: 5.7 pulgadas');
INSERT INTO PRODUCTO VALUES(NULL,'LG Q60',1,790,15,'MEMORIA RAM:3GB,CAMARA FRONTAL:16MP, TAMAÑO: 6.3 pulgadas');


INSERT INTO PRODUCTO VALUES(NULL,'Xiaomi Redmi Note 7',6,780,50,'MEMORIA RAM:4GB,MEMORIA INTERNA: 64GB, CAMARA FRONTAL:13MP');
INSERT INTO PRODUCTO VALUES(NULL,'Xiaomi Mi 9t Pro',6,1580,50,'MEMORIA RAM:6GB,MEMORIA INTERNA: 128GB, CAMARA FRONTAL:20MP');
INSERT INTO PRODUCTO VALUES(NULL,'Reloj Smartwatch Xiaomi Mi Band 4',6,100,11,'TAMAÑO DE LA PANTALLA: 0.95 pulgadas, DURACION DE BATERIA:20 dias');
INSERT INTO PRODUCTO VALUES(NULL,'Xiaomi Mi Note 10',6,2290,50,'MEMORIA RAM:6GB,MEMORIA INTERNA: 128GB, CAMARA FRONTAL:18MP');


INSERT INTO PRODUCTO VALUES(NULL,'Hp - Memoria Usb 16gb',8,40,200,'MEMORIA USB DE 16 GB');
INSERT INTO PRODUCTO VALUES(NULL,'Lenovo Z6 Pro',3,700,60,'MEMORIA RAM:6GB, MEMORIA INTERNA:128GB CAMARA FRONTAL:13MP');
INSERT INTO PRODUCTO VALUES(NULL,'Microsoft Lumia 640 Xl',10,650,200,'MEMORIA RAM: 2GB, MEMORIA INTERNA: 32GB, TAMAÑO: 4.5 pulgadas');



-- 3 : TABLA TIPO CONTACTO --
DROP TABLE IF EXISTS TIPO_CONTACTO;
CREATE TABLE TIPO_CONTACTO
(
 CODIGO_TIPO  INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 NOMBRE_TIPO  VARCHAR(30) NULL
)AUTO_INCREMENT = 1;
----------------------------------------------------
INSERT INTO TIPO_CONTACTO VALUES(NULL,'CLIENTE');
INSERT INTO TIPO_CONTACTO VALUES(NULL,'PROVEEDOR');
----------------------------------------------------

-- 4 : TABLA CONTACTO --
DROP TABLE IF EXISTS CONTACTO;
CREATE TABLE CONTACTO
(
 CODIGO_CONTACTO  INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 CODIGO_TIPO  INT(11) NOT NULL,
 CODIGO_RUC  VARCHAR(30) NULL,
 DNI  INT(11) NULL,
 RAZON_SOCIAL  VARCHAR(30) NULL,
 DIRECCION  VARCHAR(50) NULL,
 TELEFONO   VARCHAR(30) NULL,
 CONSTRAINT FKTCONTACTO FOREIGN KEY(CODIGO_TIPO) REFERENCES TIPO_CONTACTO(CODIGO_TIPO)
)AUTO_INCREMENT = 100;

INSERT INTO CONTACTO VALUES(NULL,1,NULL,47657824,'JUAN CERVANTES','HUNTER 12 LT5','956349142');
INSERT INTO CONTACTO VALUES(NULL,2,'0123423435',016578119,'EXPORTA S.A.C','MALVINA 12 LT2','054-634941');


INSERT INTO CONTACTO VALUES(NULL,2,'20600705114',40224902,'RECURSOS DEL PRADO E.I.R.L.','AV. ARGENTINA NRO. 3093 INT. 254 - CALLAO','(1) 7618489');
INSERT INTO CONTACTO VALUES(NULL,1,'20551936903',18114701,'SOLUCIONES AI PERU S.A.C.','AL.GUILLERMO PEÑALOZA MZA. U LOTE. 6 - CHORRILLOS','+51 1 2522074');

INSERT INTO CONTACTO VALUES(NULL,2,'20601155185',08711723,'CORPORACION CARMINA SAC','CAL.LOS MOJAVES NRO. 278 SALAMANCA - LIMA - ATE','996665696');
INSERT INTO CONTACTO VALUES(NULL,1,'20548971111',41339949,'VILLA S.A.C','AV. TOMASAL NRO. 909 URB. COLINAS LIMA - SURCO','(01) 4708185');

INSERT INTO CONTACTO VALUES(NULL,2,'20553856451',45371443,'BI GRAND CONFECCIONES S.A.C.','JR. SAN GABRIEL NRO. 284 URB. SAN CARLOS COMAS','(01) 5351998');
INSERT INTO CONTACTO VALUES(NULL,1,'20543248984',08641518,'MODAS LOREN EIRL','AV. JOSE GRANDA NRO. 3884 LIMA-SMP','+51 1 5686317');
INSERT INTO CONTACTO VALUES(NULL,1,'20553856451',43266291,'H & J E HIJOS E.I.R.L','LOS PINOS 6C URB. HUERTOS SANTA GENOVEVA- LURIN','959737794');
INSERT INTO CONTACTO VALUES(NULL,2,'20553476462',08128702,'REPRESENTACIONES DIERA S.A.C.','JR. EMANCIPACION NRO. 320 URB.MONTERRICO-SURCO','(511) 435-7578');



-- 5 : TABLA EMPLEADO --
DROP TABLE IF EXISTS EMPLEADO;
CREATE TABLE EMPLEADO
(
 CODIGO_EMPLEADO INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 NOMBRES_EMPLEADO VARCHAR(30) NOT NULL,
 APELLIDOS_EMPLEADO VARCHAR(60) NULL,
 LOGIN_EMPLEADO   VARCHAR(20) NULL DEFAULT NULL,
 PASSWORD_EMPLEADO VARCHAR(20) NULL DEFAULT NULL,
 DETALLE_EMPLEADO VARCHAR(1024) NULL DEFAULT NULL
 
)AUTO_INCREMENT = 10;

INSERT INTO EMPLEADO VALUES(NULL,'JOSE','CHAVEZ LUJAN','USER01','JOSE123','DNI:89234812,TELEFONO:954765425');
INSERT INTO EMPLEADO VALUES(NULL,'OSCAR','HERNANDEZ VALER','USER02','OSCAR123','DNI:19234812,TELEFONO:944765421');
INSERT INTO EMPLEADO VALUES(NULL,'LAURA','DIAZ MENDOZA','USER03','LAURA123','DNI:23150497,TELEFONO:943945138');
INSERT INTO EMPLEADO VALUES(NULL,'MARIO','TAPIA CASTILLO','USER04','MARIO123','DNI:09097237,TELEFONO:981627960');
INSERT INTO EMPLEADO VALUES(NULL,'MARTHA','GUILLEN FLORES','USER05','MARTHA123','DNI:19811114,TELEFONO:998421627');
INSERT INTO EMPLEADO VALUES(NULL,'JORGE','VALENCIA HUERTA','USER06','JORGE123','DNI:31619357,TELEFONO:954445255');


-- 6 : TABLA PAGO --
DROP TABLE IF EXISTS FORMA_PAGO;
CREATE TABLE FORMA_PAGO 
(
 CODIGO_FORMA_PAGO INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 FORMA_PAGO VARCHAR(30) NOT NULL
 
)AUTO_INCREMENT = 500;

----------------------------------------------------
INSERT INTO FORMA_PAGO VALUES(NULL,'TARJETA');
INSERT INTO FORMA_PAGO VALUES(NULL,'EFECTIVO');
INSERT INTO FORMA_PAGO VALUES(NULL,'CHEQUE');
----------------------------------------------------

-- 7 : TABLA BANCO --
DROP TABLE IF EXISTS BANCO;
CREATE TABLE BANCO
(
 CODIGO_BANCO INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 NOMBRE_BANCO VARCHAR(50) NOT NULL,
 SIGLAS_BANCO VARCHAR(30) NULL DEFAULT NULL
 
)AUTO_INCREMENT = 700;

-------------------------------------------------------------------
insert into BANCO values (null, 'BANCO DE CREDITO DEL PERU','BCP');
insert into BANCO values (null, 'BANCO CONTINENTAL','BBWA');
insert into BANCO values (null, 'BBVA BANCO CONTINENTAL SA','BBVA');
insert into BANCO values (null, 'BANCO INTERAMERICANO DE FINANZAS','BANFIF');
insert into BANCO values (null, 'BANCO DE LA NACIÓN','BN');
insert into BANCO values (null, 'BANCO FALABELLA PERÚ','Falabella');
insert into BANCO values (null, 'CITIBANK DEL PERÚ','Citibank');
insert into BANCO values (null, 'BANCO DE LA MICROEMPRESA','Mibanco');


-------------------------------------------------------------------


-- 8:TABLA PAGO --
DROP TABLE IF EXISTS CONTACTO_ADICIONAL;
CREATE TABLE CONTACTO_ADICIONAL(
 CODIGO_ADICIONAL INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 CODIGO_CONTACTO INT(11) NOT NULL,
 CODIGO_FORMA_PAGO INT(11) NULL DEFAULT NULL,
 CODIGO_BANCO INT(11) NULL DEFAULT NULL,
 NRO_CUENTA VARCHAR(30) NULL DEFAULT NULL,
 CORREO VARCHAR(60) NULL DEFAULT NULL,
 
 
 CONSTRAINT FKCONTACTOP FOREIGN KEY(CODIGO_CONTACTO) REFERENCES CONTACTO(CODIGO_CONTACTO),
 CONSTRAINT FKFORMAPAGO FOREIGN KEY(CODIGO_FORMA_PAGO) REFERENCES FORMA_PAGO(CODIGO_FORMA_PAGO),
 CONSTRAINT FKBANCO FOREIGN KEY(CODIGO_BANCO) REFERENCES BANCO(CODIGO_BANCO)
)AUTO_INCREMENT = 600000;



INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,100,500,700,'300214321001',NULL);
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,101,501,705,'1910111111033','contacto@exporta.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,102,502,706,'7988124442085','contacto@delprado.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,103,502,703,'3012921169424','contacto@solucionesperu.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,104,501,704,'8724269303873','contacto@carmina.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,105,500,700,'1852540119752','contacto@exportaSAC.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,106,500,701,'5347277075000','contacto@bigrand.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,107,501,702,'6542164925686','contacto@loren.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,108,502,703,'4262538505048','contacto@h&e.com');
INSERT INTO CONTACTO_ADICIONAL VALUES(NULL,109,500,707,'4457234698875','contacto@diera.com');




-- 9: TABLA ESTADO --
DROP TABLE IF EXISTS ESTADO;
CREATE TABLE ESTADO
(
 CODIGO_ESTADO INT(4)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
 DESCRIPCION VARCHAR(11) NOT NULL
)AUTO_INCREMENT = 1;
----------------------------------------------------------------------------------
insert into ESTADO values(null,'Pendiente');
insert into ESTADO values(null,'Pagado');
insert into ESTADO values(null,'Anulado');
-------------------------------------------------------------------------------------



-- TABLAS DE TRANSACCIONES VENTA --
-- TABLA VENTA --
DROP TABLE IF EXISTS VENTA;
CREATE TABLE VENTA
(
 CODIGO_VENTA INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 FECHA_REGISTRO DATE NOT NULL,
 CODIGO_EMPLEADO INT (11) NOT NULL,
 CODIGO_CONTACTO INT(11) NOT NULL,  
 CONSTRAINT FKEMPLEADO FOREIGN KEY(CODIGO_EMPLEADO) REFERENCES EMPLEADO(CODIGO_EMPLEADO),
 CONSTRAINT FKCONTACTO FOREIGN KEY(CODIGO_CONTACTO) REFERENCES CONTACTO(CODIGO_CONTACTO)
)AUTO_INCREMENT = 20000;
-------------------------------------------------
INSERT INTO VENTA VALUES(NULL,'2019-10-01',11,100);

INSERT INTO VENTA VALUES(NULL,'2019-11-21',10,106);
INSERT INTO VENTA VALUES(NULL,'2018-12-10',11,104);
INSERT INTO VENTA VALUES(NULL,'2019-02-01',12,107);
INSERT INTO VENTA VALUES(NULL,'2018-08-02',13,103);
INSERT INTO VENTA VALUES(NULL,'2018-06-08',14,102);
INSERT INTO VENTA VALUES(NULL,'2018-07-24',15,104);
INSERT INTO VENTA VALUES(NULL,'2018-10-31',11,101);




--------------------------------------------------

-- TABLA DETALLE_VENTA --
DROP TABLE IF EXISTS DETALLE_VENTA;
CREATE TABLE DETALLE_VENTA
(
 CODIGO_DETALLE_VENTA INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, 
 CODIGO_VENTA INT(11) NOT NULL,
 CODIGO_PRODUCTO INT(11) NOT NULL,
 PRECIO_VENTA DECIMAL(9,2),
 CANTIDAD INT(11),
 DESCUENTO INT (4),
 CONSTRAINT FKCODVENTA FOREIGN KEY (CODIGO_VENTA) REFERENCES  VENTA(CODIGO_VENTA),
 CONSTRAINT FKCODPRODUCTO FOREIGN KEY (CODIGO_PRODUCTO) REFERENCES PRODUCTO(CODIGO_PRODUCTO)

)AUTO_INCREMENT = 200000;


INSERT INTO DETALLE_VENTA VALUES(NULL,20000,100000,500,4,10);
INSERT INTO DETALLE_VENTA VALUES(NULL,20001,100024,650,1,5);
INSERT INTO DETALLE_VENTA VALUES(NULL,20002,100019,1580,2,20);
INSERT INTO DETALLE_VENTA VALUES(NULL,20003,100010,80,1,15);
INSERT INTO DETALLE_VENTA VALUES(NULL,20004,100001,500,2,10);
INSERT INTO DETALLE_VENTA VALUES(NULL,20005,100017,790,3,15);
INSERT INTO DETALLE_VENTA VALUES(NULL,20006,100018,780,1,10);
INSERT INTO DETALLE_VENTA VALUES(NULL,20007,100004,920,4,5);


-- ---------------------------------------------------------------------------------------


-- TABLA FACTURA_VENTA --
DROP TABLE IF EXISTS FACTURA_VENTA;
CREATE TABLE FACTURA_VENTA
(
 CODIGO_FACTURA INT(11)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
 CODIGO_VENTA INT(11) NOT NULL ,
 CODIGO_EMPLEADO INT (11) NOT NULL,
 ESTADO INT(4),
 FECHA_REGISTRO DATE NOT NULL,
 CONSTRAINT FK_CODVENTA FOREIGN KEY(CODIGO_VENTA) REFERENCES VENTA(CODIGO_VENTA),
 CONSTRAINT FK_EMPLEADO FOREIGN KEY(CODIGO_EMPLEADO) REFERENCES EMPLEADO(CODIGO_EMPLEADO),
 CONSTRAINT FKESTADOV FOREIGN KEY(ESTADO) REFERENCES ESTADO(CODIGO_ESTADO)
 
 
)AUTO_INCREMENT = 2000000;



INSERT INTO FACTURA_VENTA VALUES(NULL,20000,10,1,'2019-10-02');

INSERT INTO FACTURA_VENTA VALUES(NULL,20001,15,1,'2019-11-21');
INSERT INTO FACTURA_VENTA VALUES(NULL,20002,13,2,'2018-12-10');
INSERT INTO FACTURA_VENTA VALUES(NULL,20003,12,2,'2019-02-01');
INSERT INTO FACTURA_VENTA VALUES(NULL,20004,11,3,'2018-08-02');
INSERT INTO FACTURA_VENTA VALUES(NULL,20005,10,1,'2018-06-08');
INSERT INTO FACTURA_VENTA VALUES(NULL,20006,12,2,'2018-07-24');
INSERT INTO FACTURA_VENTA VALUES(NULL,20007,15,3,'2018-10-31');


-- ----------------------------------------------------------------------------------------

-- TRIGGER ACTUALIZAR STOCK PRODUCTO  AL REGISTRAR DETALLE VENTA--	
DROP TRIGGER IF EXISTS TR_UPDSTOCKACTUAL;
DELIMITER $$
CREATE TRIGGER TR_UPDSTOCKACTUAL AFTER INSERT ON DETALLE_VENTA FOR EACH ROW
BEGIN 
         UPDATE PRODUCTO P
         JOIN DETALLE_VENTA DV
         ON DV.CODIGO_PRODUCTO=P.CODIGO_PRODUCTO
         AND DV.CODIGO_DETALLE_VENTA=NEW.CODIGO_DETALLE_VENTA
	     SET P.STOCK=P.STOCK-DV.CANTIDAD;
         
        
END $$

DELIMITER ;     
-- ----------------------------------------------------------------------------------

-- TABLAS TRANSACCIONES COMPRA --
DROP TABLE IF EXISTS COMPRA;
CREATE TABLE COMPRA
(
 CODIGO_COMPRA INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
 FECHA_REGISTRO DATE NOT NULL,
 CODIGO_EMPLEADO INT (11) NOT NULL,
 CODIGO_CONTACTO INT(11) NOT NULL,
 CONSTRAINT FKCODEMPLEADO FOREIGN KEY (CODIGO_EMPLEADO) REFERENCES EMPLEADO(CODIGO_EMPLEADO),
 CONSTRAINT FKCODCONTACTO FOREIGN KEY (CODIGO_CONTACTO) REFERENCES CONTACTO(CODIGO_CONTACTO)
 
)AUTO_INCREMENT = 30000;

INSERT INTO COMPRA VALUES(NULL,'2019-01-31',11,101);
INSERT INTO COMPRA VALUES(NULL,'2019-02-05',10,102);
INSERT INTO COMPRA VALUES(NULL,'2019-02-14',11,104);
INSERT INTO COMPRA VALUES(NULL,'2019-02-21',12,106);
INSERT INTO COMPRA VALUES(NULL,'2019-03-12',13,102);
INSERT INTO COMPRA VALUES(NULL,'2019-03-28',14,109);
INSERT INTO COMPRA VALUES(NULL,'2019-04-29',15,104);
INSERT INTO COMPRA VALUES(NULL,'2019-10-11',11,101);



-- -------------------------------------------------------------------------------------------

DROP TABLE IF EXISTS DETALLE_COMPRA;
CREATE TABLE DETALLE_COMPRA
(
 CODIGO_DETALLE_COMPRA INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, 
 CODIGO_COMPRA INT(11) NOT NULL,
 CODIGO_PRODUCTO INT(11) NOT NULL,
 PRECIO_COMPRA DECIMAL(9,2),
 CANTIDAD INT(11),
 DESCUENTO INT (4),
 CONSTRAINT FKCODCOMPRA FOREIGN KEY(CODIGO_COMPRA) REFERENCES COMPRA(CODIGO_COMPRA),
 CONSTRAINT FKCODPRODUCTO1 FOREIGN KEY(CODIGO_PRODUCTO) REFERENCES PRODUCTO(CODIGO_PRODUCTO)
)AUTO_INCREMENT = 300000;


INSERT INTO DETALLE_COMPRA VALUES(NULL,30000,100024,650,3,15);
INSERT INTO DETALLE_COMPRA VALUES(NULL,30001,100024,650,1,15);
INSERT INTO DETALLE_COMPRA VALUES(NULL,30002,100019,1580,2,20);
INSERT INTO DETALLE_COMPRA VALUES(NULL,30003,100010,80,1,15);
INSERT INTO DETALLE_COMPRA VALUES(NULL,30004,100001,500,2,10);
INSERT INTO DETALLE_COMPRA VALUES(NULL,30005,100017,790,3,15);
INSERT INTO DETALLE_COMPRA VALUES(NULL,30006,100018,780,1,10);
INSERT INTO DETALLE_COMPRA VALUES(NULL,30007,100004,920,4,15);


-- -----------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS FACTURA_COMPRA;
CREATE TABLE FACTURA_COMPRA
(
 CODIGO_FACTURA INT(11)  NOT NULL PRIMARY KEY AUTO_INCREMENT,
 CODIGO_COMPRA INT(11) NOT NULL,
 CODIGO_EMPLEADO INT (11) NOT NULL,
 ESTADO INT(4),
 FECHA_REGISTRO DATE,
 CONSTRAINT FKCODCOMPRA1 FOREIGN KEY(CODIGO_COMPRA) REFERENCES COMPRA(CODIGO_COMPRA),
 CONSTRAINT FKCODEMPLEADO1 FOREIGN KEY (CODIGO_EMPLEADO) REFERENCES EMPLEADO(CODIGO_EMPLEADO),
 CONSTRAINT FKESTADO FOREIGN KEY (ESTADO) REFERENCES ESTADO(CODIGO_ESTADO)
 
)AUTO_INCREMENT = 3000000;


INSERT INTO FACTURA_COMPRA VALUES(NULL,30000,10,1,'2019-01-25');
INSERT INTO FACTURA_COMPRA VALUES(NULL,30001,10,1,'2019-04-25');
INSERT INTO FACTURA_COMPRA VALUES(NULL,30002,15,2,'2018-06-01');
INSERT INTO FACTURA_COMPRA VALUES(NULL,30003,11,2,'2019-07-21');
INSERT INTO FACTURA_COMPRA VALUES(NULL,30004,12,3,'2019-08-30');
INSERT INTO FACTURA_COMPRA VALUES(NULL,30005,13,1,'2019-09-15');
INSERT INTO FACTURA_COMPRA VALUES(NULL,30006,11,1,'2019-10-19');
INSERT INTO FACTURA_COMPRA VALUES(NULL,30007,11,1,'2019-12-19');


-- TABLA TRANSACCION ALMACEN --
DROP TABLE IF EXISTS MATERIAL_ENTRADA ;
CREATE TABLE MATERIAL_ENTRADA(
CODIGO_ENTRADA INT(4) PRIMARY KEY AUTO_INCREMENT,
CODIGO_PRODUCTO INT(11) NOT NULL,
CANTIDAD_ENTRADA INT(11) NOT NULL,
FECHA_ENTRADA DATE DEFAULT NULL,
CONSTRAINT FKPRODUCTOM FOREIGN KEY(CODIGO_PRODUCTO) REFERENCES PRODUCTO(CODIGO_PRODUCTO)
)AUTO_INCREMENT=10000;


INSERT INTO MATERIAL_ENTRADA VALUES(null,100002,1,'2019-05-05');
INSERT INTO MATERIAL_ENTRADA VALUES(NULL,100003,2,'2019-05-16');
INSERT INTO MATERIAL_ENTRADA VALUES(NULL,100004,2,'2019-05-19');
INSERT INTO MATERIAL_ENTRADA VALUES(NULL,100009,3,'2019-05-10');
INSERT INTO MATERIAL_ENTRADA VALUES(NULL,100005,2,'2019-01-30');
INSERT INTO MATERIAL_ENTRADA VALUES(NULL,100006,1,'2019-05-19');
INSERT INTO MATERIAL_ENTRADA VALUES(NULL,100002,2,'2019-04-13');
INSERT INTO MATERIAL_ENTRADA VALUES(NULL,100003,2,'2019-05-10');

-- --------------------------------------------------------------

DROP TABLE IF EXISTS MATERIAL_SALIDA ;
CREATE TABLE MATERIAL_SALIDA(
CODIGO_SALIDA INT(4) PRIMARY KEY AUTO_INCREMENT,
CODIGO_PRODUCTO INT(11) NOT NULL,
CANTIDAD_SALIDA INT(11)  NOT NULL,
FECHA_SALIDA DATE NULL DEFAULT NULL,
CONSTRAINT FKPRODUCTON FOREIGN KEY(CODIGO_PRODUCTO) REFERENCES PRODUCTO(CODIGO_PRODUCTO)
)AUTO_INCREMENT=20000;

INSERT INTO MATERIAL_SALIDA VALUES(null,100002,1,'2019-07-15');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100004,2,'2019-01-06');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100007,2,'2019-03-09');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100008,3,'2019-02-20');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100001,2,'2019-06-11');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100004,3,'2019-12-01');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100006,2,'2019-09-09');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100007,1,'2019-03-24');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100007,3,'2018-12-09');
INSERT INTO MATERIAL_SALIDA VALUES(NULL,100008,3,'2019-02-20');




DROP TRIGGER IF EXISTS TR_UPDSTOCKACTUALE;
DELIMITER $$
CREATE TRIGGER TR_UPDSTOCKACTUALE AFTER INSERT ON MATERIAL_ENTRADA FOR EACH ROW
BEGIN 
     
     
         UPDATE PRODUCTO P
         JOIN MATERIAL_ENTRADA M
         ON M.CODIGO_PRODUCTO=P.CODIGO_PRODUCTO
         AND M.CODIGO_ENTRADA=NEW.CODIGO_ENTRADA
	     SET P.STOCK=P.STOCK+M.CANTIDAD_ENTRADA;
END $$

DELIMITER ;

DROP TRIGGER IF EXISTS TR_UPDSTOCKACTUALS;
DELIMITER $$
CREATE TRIGGER TR_UPDSTOCKACTUALS AFTER INSERT ON MATERIAL_SALIDA FOR EACH ROW
BEGIN 
     
     
         UPDATE PRODUCTO P
         JOIN MATERIAL_SALIDA M
         ON M.CODIGO_PRODUCTO=P.CODIGO_PRODUCTO
         AND M.CODIGO_SALIDA=NEW.CODIGO_SALIDA
	     SET P.STOCK=P.STOCK-M.CANTIDAD_SALIDA;
END $$

DELIMITER ;
-- -------------------------------------------------------------------------------------------
