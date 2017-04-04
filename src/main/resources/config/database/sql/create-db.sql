CREATE TABLE person (
  person_id  BIGINT  PRIMARY KEY,
  first_name VARCHAR(30),
  last_name  VARCHAR(50)
);

CREATE TABLE manager (
  person_id BIGINT PRIMARY KEY,
  free_time INTEGER,
  work_time INTEGER,
  CONSTRAINT FK_MANAGER_PERSON FOREIGN KEY (person_id) REFERENCES person,
  CONSTRAINT CK_manager_prct CHECK (free_time + work_time = 100)
);

CREATE TABLE country (
  country_id BIGINT PRIMARY KEY,
  country_name VARCHAR(50) NOT NULL,
  CONSTRAINT UK_COUNTRY_NAME UNIQUE (country_name)
);


CREATE TABLE address (
  address_id BIGINT  PRIMARY KEY,
  address_line_1 VARCHAR(150),
  address_line_2 VARCHAR(150),
  zip_code VARCHAR(5),
  city VARCHAR(30),
  country_id BIGINT NOT NULL,
  CONSTRAINT FK_ADDRESS_COUNTRY FOREIGN KEY (country_id) REFERENCES country(country_id)
);


CREATE TABLE client (
  client_id BIGINT  PRIMARY KEY,
  client_name VARCHAR(30),
  address_id BIGINT not NULL,
  CONSTRAINT FK_CLIENT_ADDRESS FOREIGN KEY (address_id) REFERENCES address(address_id),
  CONSTRAINT UK_CLIENT_ADDRESS_ID UNIQUE (address_id)
);

CREATE TABLE mission (
  person_id BIGINT NOT NULL,
  client_id BIGINT NOT NULL,
  CONSTRAINT PK_MISSION_PERSON_CLIENT PRIMARY KEY (person_id, client_id)
);