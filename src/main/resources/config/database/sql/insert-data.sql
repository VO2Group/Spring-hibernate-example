INSERT INTO person (person_id, first_name, last_name) VALUES
  (1, 'Mehdi', 'Hakka'),
  (2, 'Amine', 'Abbes'),
  (3, 'Julien', 'Rouzieres');

INSERT INTO manager (person_id, free_time, work_time) VALUES
  (3, 50, 50);

UPDATE person SET manager_id = 3 WHERE person_id in (1, 2);

INSERT INTO country (country_id, country_name) VALUES
  (1, 'France');

INSERT INTO address (address_id, address_line_1, zip_code, city, country_id) VALUES
  (1, '58 bis rue de la Chaussée d''Antin', '75009', 'Paris', 1),
  (2, '62 rue Louis Bleriot', '92100', 'Boulogne Billancourt', 1);

INSERT INTO client (client_id, client_name, address_id) VALUES
  (1, 'VO2 Group', 1),
  (2, 'UFF', 2);

INSERT INTO mission (person_id,  client_id) VALUES
  (1, 2),
  (1, 1),
  (2, 2),
  (3, 1);