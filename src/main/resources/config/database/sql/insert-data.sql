INSERT INTO person (person_id, first_name, last_name) VALUES
  (1, 'Mehdi', 'Hakka'),
  (2, 'Amine', 'Abbes'),
  (3, 'Julien', 'Rouziere');

INSERT INTO manager (person_id, free_time, work_time) VALUES
  (3, 50, 50);

INSERT INTO country (country_id, country_name) VALUES
  (1, 'France');

INSERT INTO address (address_id, address_line_1, zip_code, city, country_id) VALUES
  (1, '58 bis rue de la Chaussée d''Antin', '75009', 'Paris', 1),
  (2, '62 rue Louis Bleriot', '92100', 'Boulogne Billancourt', 1);

INSERT INTO client (client_id, client_name, address_id) VALUES
  (1, 'VO2 Group', 1),
  (2, 'UFF', 2);

INSERT INTO mission (person_id,  client_id, title, from_date, to_date) VALUES
  (1, 2, 'Mission JAVA/JEE', '2016-12-01', null),
  (1, 1, 'JAVA/Babyfoot', '2015-06-01', '2016-11-30'),
  (2, 2, 'Babyfoot', '2017-02-15', '2017-04-06'),
  (3, 1, 'CTO', '2014-05-01', null);