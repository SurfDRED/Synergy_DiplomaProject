CREATE TABLE wh_db.warehouse (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(10),
  PRIMARY KEY (id)
);

CREATE TABLE wh_db.materials (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(50),
  diameter  int,
  wall float,
  thickness float,
  PRIMARY KEY (id)
);

CREATE TABLE wh_db.supplier (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(20),
  PRIMARY KEY (id)
);

CREATE TABLE wh_db.pipe(
  id int NOT NULL AUTO_INCREMENT,
  warehouse_id int,
  materials_id int,
  supplier_id int,
  cod_pipe varchar(6),
  weight float,
  length float,
  PRIMARY KEY (id),
  FOREIGN KEY (warehouse_id) REFERENCES wh_db.warehouse(id) ON DELETE CASCADE,
  FOREIGN KEY (supplier_id) REFERENCES wh_db.supplier(id) ON DELETE CASCADE,
  FOREIGN KEY (materials_id) REFERENCES wh_db.materials(id) ON DELETE CASCADE);

INSERT INTO wh_db.warehouse (id, name)
VALUES (1, 'Склад А'),
       (2, 'Склад B'),
       (3, 'Склад С'),
       (4, 'Все склады');

INSERT INTO wh_db.supplier (id, name)
VALUES (1, 'Баржа'),
       (2, 'Машина из РФ'),
       (3, 'Машина из Румынии'),
       (4, 'Железная дорога');

INSERT INTO wh_db.materials (id, name, diameter, wall, thickness)
VALUES (111005,	'Труба с наружным и внутренним покрытием', 1219, 14.27,	3.3),
       (111004,	'Труба с наружным и внутренним покрытием', 1219, 17.48,	3.3),
       (111006,	'Труба с наружным и внутренним покрытием', 1219, 17.8, 3.3),
       (111007,	'Труба с наружным и внутренним покрытием', 1219, 21.2, 3.3),
       (111011,	'Труба с наружным и внутренним покрытием', 1219, 21.2, 6),
       (111009,	'Труба с наружным и внутренним покрытием', 1219, 22.23,	3.3),
       (111008,	'Труба без изоляции', 1219,	22.23, 3.3),
       (111010,	'Труба с наружным и внутренним покрытием', 1219, 25.4, 3.3),
       (111016,	'Труба с наружным и внутренним покрытием', 1219, 25.4, 6),
       (111014,	'Труба с наружным и внутренним покрытием', 1422, 21.6, 6),
       (111015,	'Труба без изоляции', 1422,	21.6, 6),
       (111003,	'Труба без изоляции', 1422,	23,	6);

INSERT INTO wh_db.pipe (id, warehouse_id, materials_id, supplier_id, cod_pipe, weight, length)
VALUES (1, 1, 111005, 1, 770173, 5.108, 12.05),
       (2, 1, 111005, 1, 800027, 5.108, 12.05),
       (3, 1, 111015, 2, 801408, 5.108, 12.05),
       (4, 1, 111015, 2, 747373, 5.108, 12.05),
       (5, 2, 111010, 3, 753526, 5.108, 12.05),
       (6, 2, 111010, 3, 800222, 5.108, 12.05),
       (7, 2, 111007, 4, 788483, 5.108, 12.05),
       (8, 2, 111007, 4, 788486, 5.108, 12.05),
       (9, 3, 111011, 1, 801029, 5.108, 12.05),
       (10, 3, 111011, 2, 740658, 5.108, 12.05),
       (11, 3, 111011, 3, 776633, 5.108, 12.05),
       (12, 3, 111011, 4, 730000, 5.108, 12.05);
