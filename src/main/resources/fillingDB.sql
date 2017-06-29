USE `universityDB`;

INSERT INTO universitydb.faculties (name, address, letter) VALUES ('Факультет прикладной математики', 'ул. Карла Маркса,4', 'П');
INSERT INTO universitydb.faculties (name, address, letter) VALUES ('Механико-математический факультет', 'ул.Казакова,18', 'М');
INSERT INTO universitydb.faculties (name, address, letter) VALUES ('Факультет международной экономики', 'ул. Научная, 13', 'М');
INSERT INTO universitydb.faculties (name, address, letter) VALUES ('Факультет психологии', 'пр.Д.Яворницкого, 36', 'П');
INSERT INTO universitydb.faculties (name, address, letter) VALUES ('Юридический факультет', 'ул. Научная, 13', 'Ю');
INSERT INTO universitydb.faculties (name, address, letter) VALUES ('Исторический факультет', 'пр. Гагарина, 72', 'И');
INSERT INTO universitydb.faculties (name, address, letter) VALUES ('Экономический факультет', 'пр. Д.Яворницкого, 35', 'Э');

INSERT INTO universitydb.specialities (name, letter, faculty_id) VALUES ('Системный анализ', 'С', 1);
INSERT INTO universitydb.specialities (name, letter, faculty_id) VALUES ('Программная инженерия', 'З', 1);

INSERT INTO universitydb.cathedras (name, faculty_id) VALUES ('Кафедра вычислительной математики', 1);
INSERT INTO universitydb.cathedras (name, faculty_id) VALUES ('Кафедра компьютерных технологий', 1);

INSERT INTO universitydb.teachers (name, cathedras_id) VALUES ('Кузенков Александр Александрович', 1);
INSERT INTO universitydb.teachers (name, cathedras_id) VALUES ('Сегеда Надежда Евстахиевна', 1);

INSERT INTO universitydb.groups (curator_id, specialities_id, year_int, group_num) VALUES (1, 3, 2014, 1);

INSERT INTO universitydb.students (first_name, last_name, group_id, ind_number, address, birthday_date) VALUES ('Константин', 'Мусиенко', 1, '123456879', 'г. Днепр, ул. Илларионовская', '1997-08-18');
INSERT INTO universitydb.students (first_name, last_name, group_id, ind_number, address, birthday_date) VALUES ('Дмитрий', 'Николаев', 1, '213456789', 'г. Днепр, ул. Артема', '1996-10-04');
INSERT INTO universitydb.students (first_name, last_name, group_id, ind_number, address, birthday_date) VALUES ('Константин', 'Караваев', 1, '321456789', 'г. Днепр, ул. Кирова', '1997-01-23');

