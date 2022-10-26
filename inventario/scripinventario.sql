--Autor : Daniel Salazar Sepulveda
--Fecha : 07-octubre-2022 05:23 PM
--Creating schema
--DROP SCHEMA inventario  CASCADE;
CREATE SCHEMA inventario
    AUTHORIZATION postgres;
COMMENT ON SCHEMA inventario
    IS 'esquema para servicios de inventario';
--Patron de diseno arquitectonico para poder incluir
--diferentes caracteristicas a los datos
-- Ejemplo 
--         Grupo: 1- Caracteristicas inventario
--         Dato   1-ABARROTE 2-Venta de servicio 3 - Libro
--         Grupodato : pk(1) - 1,1. pk(2)- 1,2. pk(3) 1-3                                                                                                                          
--Creando la informacion de grupos de datos
--grupos 
--drop table inventario.grupo cascade;
CREATE TABLE inventario.grupo (
   id          SERIAL NOT NULL,
   descripcion varchar(130) NOT NULL,
   compania    int4 NOT NULL,
   constraint pk_grupo
   PRIMARY KEY (id),
   constraint uk_grupo
   UNIQUE (descripcion));
COMMENT ON TABLE inventario.grupo is 'Entidad que agrupa informacion';
COMMENT ON COLUMN inventario.grupo.id IS 'Llave primaria de grupo';
COMMENT ON COLUMN inventario.grupo.descripcion IS 'Nombre de la agrupacion';
COMMENT ON COLUMN inventario.grupo.compania IS 'Compañía a la que pertenece el grupo';
--Datos
--drop table inventario.dato cascade;
drop table inventario.dato cascade;
CREATE TABLE inventario.dato (
   id          SERIAL NOT NULL,
   descripcion varchar(130) NOT NULL,
   compania    int4 NOT NULL,
   constraint pk_dato
   PRIMARY KEY (id),
   constraint uk_dato
   UNIQUE (descripcion));
COMMENT ON TABLE inventario.dato is 'Entidad que contiene un dato';
COMMENT ON COLUMN inventario.dato.id IS 'Llave primaria de dato';
COMMENT ON COLUMN inventario.dato.descripcion IS 'Nombre del dato';
COMMENT ON COLUMN inventario.dato.compania IS 'Compañía a la que pertenece el dato';
--Rompimiento entre grupo y datos
--drop table inventario.grupodato cascade;
CREATE TABLE inventario.grupodato (
   id          int4 NOT NULL,
   grupofk     int4 NOT NULL,
   datofk      int4 NOT NULL,
   constraint pk_grupodato PRIMARY KEY (id),
   CONSTRAINT fkgrupodatogrupo FOREIGN KEY (grupofk) REFERENCES inventario.grupo (id),
   CONSTRAINT fkgrupodatodato  FOREIGN KEY (datofk) REFERENCES  inventario.dato (id)
   );
COMMENT ON TABLE inventario.grupodato is 'Entidad de rompimiento entre grupo y dato';
COMMENT ON COLUMN inventario.grupodato.id IS 'Llave primaria de grupodato';
COMMENT ON COLUMN inventario.grupodato.grupofk IS 'Relacion foranea con grupo';
COMMENT ON COLUMN inventario.grupodato.datofk  IS 'Relacion foranea con dato';
--Validador de datos
--Datos
CREATE TABLE inventario.datovalidador (
   id          int4 NOT NULL,
   datofk      int4 NOT NULL,
   validar     varchar(4000) NOT NULL,
   constraint pk_datovalidador PRIMARY KEY (id),
   constraint uk_datovalidador
   UNIQUE (datofk),
   CONSTRAINT fkdatovalidadordato  FOREIGN KEY (datofk) REFERENCES  inventario.dato (id)
 );
COMMENT ON TABLE inventario.datovalidador is 'Entidad que expresiones regulares para validar dato';
COMMENT ON COLUMN inventario.datovalidador.datofk IS 'Llave foranea de dato';
COMMENT ON COLUMN inventario.datovalidador.validar IS 'Expresion regular para evaluar un dato';
---   Fin Patron de diseno arquitectonico Base datos 

--
--Permite manejar multiples compañias
--drop table inventario.compania cascade;
CREATE TABLE inventario.compania (
  codigo         SERIAL NOT NULL,
  nombre         varchar(130) NOT NULL,
  referencia     int4,
  activo         boolean default true,
  usuarioaud     int8 NOT NULL,
  fechahoraud    timestamp NOT NULL,
  CONSTRAINT pk_compania
    PRIMARY KEY (codigo),
  CONSTRAINT UK_compania
    UNIQUE (nombre));
COMMENT ON TABLE inventario.compania IS 'Define una compania nombre comercial';
COMMENT ON COLUMN inventario.compania.codigo IS 'identificador de la compania';
COMMENT ON COLUMN inventario.compania.nombre IS 'Nombre de la compania';
COMMENT ON COLUMN inventario.compania.referencia IS 'Referencia jerarquica de la compania';
COMMENT ON COLUMN inventario.compania.activo IS 'Indica si la compania se encuentra activa';
COMMENT ON COLUMN inventario.compania.usuarioaud IS 'Usuario para auditoria';
COMMENT ON COLUMN inventario.compania.fechahoraud IS 'Fecha y hora para auditoria';
   
--Detalles de cada compania / sucursal 
--drop table inventario.companiadetalle cascade;
CREATE TABLE inventario.companiadetalle (
  codigo      SERIAL NOT NULL,
  compania    int4 NOT NULL,
  caracteristica int8 NOT NULL,
  valor          varchar(500) NOT NULL,
  CONSTRAINT pk_companiadetalle
    PRIMARY KEY (codigo),
  CONSTRAINT fkcompaniadetalle  FOREIGN KEY (compania) REFERENCES  inventario.compania(codigo),
  CONSTRAINT fkcompaniacaracteristica  FOREIGN KEY (caracteristica) REFERENCES  inventario.grupodato (id)
);
COMMENT ON TABLE inventario.companiadetalle IS 'Define detalles de una compania comercial';
COMMENT ON COLUMN inventario.companiadetalle.codigo IS 'identificador de  compania detalle';
COMMENT ON COLUMN inventario.companiadetalle.compania IS 'enlace a la tabla compania';
COMMENT ON COLUMN inventario.companiadetalle.caracteristica IS 'enlace a la tabla grupodato';
COMMENT ON COLUMN inventario.companiadetalle.valor IS 'valor que corresponde con la informacion grupodato';
--
-- Definicion de usuario 
CREATE TABLE inventario.usuario(
    codigo          SERIAL NOT NULL,
    email	    TEXT   NOT NULL UNIQUE,
    contrasena  TEXT   NOT null,
    CONSTRAINT pk_usuario
    PRIMARY KEY (codigo)
);
COMMENT ON TABLE inventario.usuario is 'Entidad para guardar usuarios autorizados al servicio';
COMMENT ON COLUMN inventario.usuario.codigo is 'Identificador exclusivo del usuario';
COMMENT ON COLUMN inventario.usuario.email is 'correo electronico identificador del usuario';
COMMENT ON COLUMN inventario.usuario.contrasena is 'contrasena para acceder al servicio';
--Detalle del usuario 
CREATE TABLE inventario.usuariodetalle(
    codigo          SERIAL NOT NULL,
    usuario 		int4 NOT NULL,
    nombre			varchar(130),
    apellido		varchar(130),
    compania        int4 NOT NULL,
    CONSTRAINT pk_usuariodetalle
    PRIMARY KEY (codigo),
    CONSTRAINT fkusuariodetalle  FOREIGN KEY (usuario)  REFERENCES  inventario.usuario(codigo),
    CONSTRAINT fkusuadetcompania FOREIGN KEY (compania) REFERENCES  inventario.compania(codigo)
);    
COMMENT ON TABLE inventario.usuariodetalle is 'Entidad para guardar detalle de usuarios autorizados al servicio';
COMMENT ON COLUMN inventario.usuariodetalle.codigo is 'Identificador exclusivo del detalle del usuario';
COMMENT ON COLUMN inventario.usuariodetalle.usuario is 'Llave foranea a tabla usuario';
COMMENT ON COLUMN inventario.usuariodetalle.nombre is 'Nombre(s) del usuario';
COMMENT ON COLUMN inventario.usuariodetalle.apellido is 'Apellidos(s) del usuario';
COMMENT ON COLUMN inventario.usuariodetalle.compania IS 'enlace a la tabla compania';
  
--Articulo 
--Creando la tabla principal que almacena los articulos   
--drop table inventario.articulo cascade;
CREATE TABLE inventario.articulo(
  codigo         int8 NOT NULL,
  descripcion    varchar(500) NOT NULL,
  compania       int4 NOT NULL,
  usuarioaud     int8 NOT NULL,
  fechahoraud    timestamp NOT null,
  constraint pk_articulo
  PRIMARY KEY (codigo),
  CONSTRAINT UK_articulocompania
    UNIQUE (descripcion,compania),
  CONSTRAINT fkarticulocompania  FOREIGN KEY (compania) REFERENCES  inventario.compania(codigo)
);
COMMENT ON TABLE inventario.articulo is 'Inventario de servicios articulos';
COMMENT ON COLUMN inventario.articulo.codigo IS 'Llave primaria del inventario';
COMMENT ON COLUMN inventario.articulo.descripcion IS 'Descripcion del inventario';
COMMENT ON COLUMN inventario.articulo.compania IS 'Compania del inventario';
--Tabla que almacena detalles del articulo
--drop table inventario.articulodetalle cascade;
CREATE TABLE inventario.articulodetalle(
  codigo         int8 NOT NULL,
  articulo       int8 NOT NULL,
  caracteristica int4 NOT null,
  valor			 text, 
  constraint pk_articulodetalle  PRIMARY KEY (codigo),
  CONSTRAINT UK_articaracter    UNIQUE (articulo,caracteristica),
  CONSTRAINT fkartdetalleart   FOREIGN KEY (articulo) references        inventario.articulo(codigo),
  CONSTRAINT fkartdetallecarac  FOREIGN KEY (caracteristica) REFERENCES inventario.grupodato(id)
);
COMMENT ON TABLE inventario.articulodetalle is 'Inventario de servicios articulos el detalle';
COMMENT ON COLUMN inventario.articulodetalle.codigo IS 'Llave primaria del detalle de inventario';
COMMENT ON COLUMN inventario.articulodetalle.articulo IS 'Llave foranea que va a la tabla articulo';
COMMENT ON COLUMN inventario.articulodetalle.caracteristica IS 'Llave foranea que va a la tabla de grupo dato';
COMMENT ON COLUMN inventario.articulodetalle.valor IS 'Valor asociado a la caracteristica';
--Tabla para el control de stocks
--drop table inventario.articulocontrol cascade; 
CREATE TABLE inventario.articulocontrol(
  codigo         int8 NOT NULL,
  articulo       int8 NOT NULL,
  maximo         int8 NOT NULL,
  minimo		 int8 NOT null,
  constraint pk_articulocontrol  PRIMARY KEY (codigo),
  CONSTRAINT UK_articontrol      UNIQUE (articulo),
  CONSTRAINT fkartcontrolart     FOREIGN KEY (articulo) references        inventario.articulo(codigo)
);
COMMENT ON TABLE inventario.articulocontrol is 'Inventario control de stocks de un articulo';
COMMENT ON COLUMN inventario.articulocontrol.codigo IS 'Llave primaria del control de articulo';
COMMENT ON COLUMN inventario.articulocontrol.articulo IS 'Llave foranea que va a la tabla articulo';
COMMENT ON COLUMN inventario.articulocontrol.maximo IS 'Cantidad maxima para almacenar un articulo (0) cero si no controla';
COMMENT ON COLUMN inventario.articulocontrol.minimo IS 'Cantidad minima de existencias de un articulo (0) cero si no controla';
--Bodega (hace las veces de caja)
--Tabla de las Bodegas / puntos acopio
--drop table inventario.bodega cascade;
CREATE TABLE inventario.bodega (
  codigo         SERIAL NOT NULL,
  referencia     int4,
  compania       int4 NOT NULL,
  identificacion varchar(150) NOT NULL,
  nombre         varchar(130) NULL,
  nivel          smallint NOT NULL,
  constraint pk_bodega
  PRIMARY KEY (codigo),
  constraint uk_inventario
  UNIQUE (nombre),
  CONSTRAINT fkbodegacompania  FOREIGN KEY (compania) REFERENCES  inventario.compania(codigo)
);
COMMENT ON TABLE inventario.bodega is 'Informacion de la bodega(caja)';
COMMENT ON COLUMN inventario.bodega.codigo IS 'Codigo identificador de la bodega(caja)';
COMMENT ON COLUMN inventario.bodega.referencia IS 'Auto enlace de la bodega(caja)';
COMMENT ON COLUMN inventario.bodega.compania IS 'Compania a la que pertenece la bodega(caja)';
COMMENT ON COLUMN inventario.bodega.identificacion IS 'Codigo numero identificador de la bodega';
COMMENT ON COLUMN inventario.bodega.nombre IS 'Nombre de la bodega(caja)';
COMMENT ON COLUMN inventario.bodega.nivel IS 'Nivel de la bodega(caja)';
--Centro de costo 
--Tabla que registra los centros de costo 
--
--drop table inventario.centrocosto cascade;
CREATE TABLE inventario.centrocosto (
  codigo         SERIAL NOT NULL,
  referencia     int4,
  compania       int4 NOT NULL,
  nombre         varchar(130) NOT NULL,
  nivel          smallint NOT NULL,
  constraint pk_centrocosto
  PRIMARY KEY (codigo),
  CONSTRAINT fkcentrocostocompania  FOREIGN KEY (compania) REFERENCES  inventario.compania(codigo)
);
COMMENT ON TABLE inventario.centrocosto is 'Informacion del centro de costo';
COMMENT ON COLUMN inventario.centrocosto.codigo IS 'Codigo identificador del centro de costo';
COMMENT ON COLUMN inventario.centrocosto.referencia IS 'Auto enlace del centro de costo';
COMMENT ON COLUMN inventario.centrocosto.compania IS 'Compania a la que pertenece el centro de costo';
COMMENT ON COLUMN inventario.centrocosto.nombre IS 'Nombre del centro del costo';
COMMENT ON COLUMN inventario.centrocosto.nivel IS 'Nivel del centro de costo'; 
--Tipo movimiento (operacion) inventario
--drop table inventario.tipomovimiento cascade;
CREATE TABLE inventario.tipomovimiento(
    codigo         SERIAL NOT NULL,
    nombre         varchar(150) NOT null,
    tipooperacion  int2,
    constraint pk_tipomovimiento
  PRIMARY KEY (codigo),
  constraint uk_tipomovimiento
  UNIQUE (nombre)
);
COMMENT ON TABLE inventario.tipomovimiento is 'Informacion de la operacion o del tipo de movimiento';
COMMENT ON COLUMN inventario.tipomovimiento.codigo IS 'Codigo identificador del codigo';
COMMENT ON COLUMN inventario.tipomovimiento.nombre IS 'Nombre del movimiento u operacion';
COMMENT ON COLUMN inventario.tipomovimiento.tipooperacion IS 'Operacion aritmetica suma (1) resta (2)';
--Tipo de tercero
--Tercero
--drop table inventario.tercero cascade;
CREATE TABLE inventario.tercero (
   codigo    SERIAL NOT NULL,
   tipodocumento smallint NOT NULL,
   numero        varchar(50) NOT NULL,
   constraint pk_tercero
   PRIMARY KEY (codigo),
   CONSTRAINT fktercerotipdoc  FOREIGN KEY (tipodocumento) REFERENCES  inventario.grupodato (id)
);
COMMENT ON TABLE inventario.tercero is 'Terceros participan en alguna transaccion';
COMMENT ON COLUMN inventario.tercero.codigo IS 'Codigo identificador unico de un tercero';
COMMENT ON COLUMN inventario.tercero.tipodocumento IS 'Relacion con la tabla grupodato';
COMMENT ON COLUMN inventario.tercero.numero IS 'Numero de documento';
--Detalle tercero
--drop table inventario.tercerodetalle cascade;
CREATE TABLE inventario.tercerodetalle (
   codigo    	  SERIAL NOT NULL,
   tercero        int8 NOT NULL,
   caracteristica int8 NOT NULL,
   valor          varchar(500) NOT NULL,
   constraint pk_tercerodetalle
   PRIMARY KEY (codigo),
   CONSTRAINT fktercerodetalle         FOREIGN KEY (tercero) REFERENCES  inventario.tercero (codigo),
   CONSTRAINT fktercerocaracteristica  FOREIGN KEY (caracteristica) REFERENCES  inventario.grupodato (id)
);
COMMENT ON TABLE inventario.tercerodetalle is 'Terceros informacion detallada';
COMMENT ON COLUMN inventario.tercerodetalle.codigo IS 'Llave primaria unico de tercero detalle';
COMMENT ON COLUMN inventario.tercerodetalle.tercero IS 'Relacion con la tabla tercero';
COMMENT ON COLUMN inventario.tercerodetalle.caracteristica IS 'Relacion con la tabla grupodato';
COMMENT ON COLUMN inventario.tercerodetalle.valor IS 'Informacion sobre la caracteristica';
--
--Transaccion core de la operacion del registro al inventario 
--drop table inventario.transaccion cascade;
CREATE TABLE inventario.transaccion (
       codigo    		SERIAL NOT NULL,
       articulo   		int8 NOT NULL,
       bodega			int8 NOT NULL,
       centrocosto		int8 NOT NULL,
       tercero			int8 NOT NULL,
       tipomovimiento	int2 NOT NULL,
       cantidad			int8 NOT NULL,
       valor          	numeric(12,2),
       compania			int8 NOT NULL,
       usuarioaud     	int8 NOT NULL,
       fechahoraud    	timestamp NOT NULL,
       fecha          	date NOT NULL,
       hora           	time NOT NULL,
       vigencia       	int2 NOT null,
       CONSTRAINT pktransaccion PRIMARY KEY (codigo),
       CONSTRAINT fktrxarticulo       FOREIGN KEY (articulo) references inventario.articulo,
       CONSTRAINT fktrxbodega         FOREIGN KEY (bodega) references inventario.bodega,
       CONSTRAINT fktrxcentrocosto    FOREIGN KEY (centrocosto) references inventario.centrocosto,
       CONSTRAINT fktrxtercero	      FOREIGN KEY (tercero) references inventario.tercero,
       CONSTRAINT fktrxtipmov	      FOREIGN KEY (tipomovimiento) references inventario.tipomovimiento,
       CONSTRAINT fktrxcompania	      FOREIGN KEY (compania) references inventario.compania
);
COMMENT ON TABLE inventario.transaccion is 'Tabla de transacciones detallada';
COMMENT ON COLUMN inventario.transaccion.codigo IS 'Llave primaria unico de la transaccion';
COMMENT ON COLUMN inventario.transaccion.articulo IS 'Articulo involucrado en la transaccion';
COMMENT ON COLUMN inventario.transaccion.bodega IS 'Bodega donde se realiza la transaccion';
COMMENT ON COLUMN inventario.transaccion.centrocosto IS 'Centro de costo donde se realiza la transaccion';
COMMENT ON COLUMN inventario.transaccion.tercero IS 'Tercero con el que se realiza la transaccion';
COMMENT ON COLUMN inventario.transaccion.tipomovimiento IS 'Operacion que se realiza en la transaccion';
COMMENT ON COLUMN inventario.transaccion.cantidad IS 'cantidad que se involucra en la transaccion';
COMMENT ON COLUMN inventario.transaccion.valor IS 'Valor que se involucra en la transaccion';
COMMENT ON COLUMN inventario.transaccion.compania IS 'compania que se involucra en la transaccion';
COMMENT ON COLUMN inventario.transaccion.usuarioaud IS 'Usuario que realiza la transaccion';
COMMENT ON COLUMN inventario.transaccion.fechahoraud IS 'Fecha que realiza la transaccion';
COMMENT ON COLUMN inventario.transaccion.fecha IS 'Fecha que realiza la transaccion primera vez';
COMMENT ON COLUMN inventario.transaccion.hora IS 'Hora que realiza la transaccion primera vez';
COMMENT ON COLUMN inventario.transaccion.vigencia IS 'Periodo anual en que realiza la transaccion';
--
--
--ingreso de datos
--usuario
insert into inventario.usuario(codigo,email,contrasena) values(1,'admin@cipres.com.co','123');
--compania
insert into inventario.compania(codigo,nombre,referencia,activo,usuarioaud,fechahoraud) values(1,'compañía xyz',null,true,1,(select current_timestamp));
--
--grupo de datos 
insert into inventario.grupo (id,descripcion,compania) values(1,'Características del producto',1);       
--datos
insert into inventario.dato  (id,descripcion,compania) values(1,'Color',1);
insert into inventario.dato  (id,descripcion,compania) values(2,'Tamaño',1);
insert into inventario.dato  (id,descripcion,compania) values(3,'Dimensiones',1);
insert into inventario.dato  (id,descripcion,compania) values(4,'Peso',1);
insert into inventario.dato  (id,descripcion,compania) values(5,'Potencia',1);
insert into inventario.dato  (id,descripcion,compania) values(6,'Precio venta',1);
insert into inventario.dato  (id,descripcion,compania) values(7,'Almacenamiento',1);
insert into inventario.dato  (id,descripcion,compania) values(8,'Procesador',1);
insert into inventario.dato  (id,descripcion,compania) values(9,'Voltaje',1);
insert into inventario.dato  (id,descripcion,compania) values(10,'Tipo conector',1);
insert into inventario.dato  (id,descripcion,compania) values(11,'Conectividad',1);
insert into inventario.dato  (id,descripcion,compania) values(12,'Bateria',1);
insert into inventario.dato  (id,descripcion,compania) values(13,'Cámara delantera',1);
insert into inventario.dato  (id,descripcion,compania) values(14,'Cámara trasera',1);
insert into inventario.dato  (id,descripcion,compania) values(15,'Memoria interna',1);
insert into inventario.dato  (id,descripcion,compania) values(16,'Pantalla',1);
insert into inventario.dato  (id,descripcion,compania) values(17,'Modelo',1);
insert into inventario.dato  (id,descripcion,compania) values(18,'Marca',1);
insert into inventario.dato  (id,descripcion,compania) values(19,'Línea',1);
insert into inventario.dato  (id,descripcion,compania) values(20,'Serie',1);
insert into inventario.dato  (id,descripcion,compania) values(21,'Sistema operativo',1);
insert into inventario.dato  (id,descripcion,compania) values(22,'Mes lanzamiento',1);
insert into inventario.dato  (id,descripcion,compania) values(23,'Año lanzamiento',1);
--
-
insert into inventario.dato  (id,descripcion,compania) values(24, 'Registro civil de nacimiento',1); --11

--
insert into inventario.grupodato(id,grupofk,datofk) values (1,1,1);
insert into inventario.grupodato(id,grupofk,datofk) values (2,1,2);
insert into inventario.grupodato(id,grupofk,datofk) values (3,1,3);
insert into inventario.grupodato(id,grupofk,datofk) values (4,1,4);
insert into inventario.grupodato(id,grupofk,datofk) values (5,1,5);
insert into inventario.grupodato(id,grupofk,datofk) values (6,1,6);
insert into inventario.grupodato(id,grupofk,datofk) values (7,1,7);
insert into inventario.grupodato(id,grupofk,datofk) values (8,1,8);
insert into inventario.grupodato(id,grupofk,datofk) values (9,1,9);
insert into inventario.grupodato(id,grupofk,datofk) values (10,1,10);
insert into inventario.grupodato(id,grupofk,datofk) values (11,1,11);
insert into inventario.grupodato(id,grupofk,datofk) values (12,1,12);
insert into inventario.grupodato(id,grupofk,datofk) values (13,1,13);
insert into inventario.grupodato(id,grupofk,datofk) values (14,1,14);
insert into inventario.grupodato(id,grupofk,datofk) values (15,1,15);
insert into inventario.grupodato(id,grupofk,datofk) values (16,1,16);
insert into inventario.grupodato(id,grupofk,datofk) values (17,1,17);
insert into inventario.grupodato(id,grupofk,datofk) values (18,1,18);
insert into inventario.grupodato(id,grupofk,datofk) values (19,1,19);
insert into inventario.grupodato(id,grupofk,datofk) values (20,1,20);
insert into inventario.grupodato(id,grupofk,datofk) values (21,1,21);
insert into inventario.grupodato(id,grupofk,datofk) values (22,1,22);
insert into inventario.grupodato(id,grupofk,datofk) values (23,1,23);

--
SELECT * FROM inventario.compania;
update inventario.compania set referencia = 1 where codigo  = 2;

select g.descripcion as grupo,
       d.descripcion as dato,
       gd.id 
  from inventario.grupo g 
              ,inventario.dato d 
              ,inventario.grupodato gd
where gd.grupofk = g.id 
  and gd.datofk  = d.id; 