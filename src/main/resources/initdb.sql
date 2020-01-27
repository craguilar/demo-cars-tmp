-- noinspection SqlNoDataSourceInspectionForFile
-----------------------------------------------------------------------------------------------------------------------
--- Cleanup data base
-----------------------------------------------------------------------------------------------------------------------
SET search_path = db_demo;
-- Cleanup database Users
DROP SEQUENCE s_users_id;
DROP TABLE users;
-- Cleanup Authentication
DROP TABLE permissions;
-- Car model cleanup
DROP TABLE car_compliance_verification;
DROP TABLE car_documents;
DROP TABLE cars;
DROP SCHEMA db_demo;
COMMIT;
-----------------------------------------------------------------------------------------------------------------------
--- Create data base
-----------------------------------------------------------------------------------------------------------------------

-- Create  DB Schemas
CREATE SCHEMA db_demo;
COMMIT;
--- Sequence creation
CREATE SEQUENCE s_users_id
  START 1001;

-- CREATE TABLES
-- id refers to user email.
CREATE TABLE users (
  id         VARCHAR(255),
  created_on DATE,
  created_by VARCHAR(255),
  CONSTRAINT pk_users PRIMARY KEY (id)
);
COMMENT ON TABLE users IS 'TABLE users, needed to store  email for particular user';
-- Permissions
CREATE TABLE permissions (
  email       VARCHAR(255) REFERENCES users (id), -- fk for users,
  resource    VARCHAR(1000),
  operation   VARCHAR(10),
  enabled     BOOLEAN,
  modified_on DATE,
  modified_by VARCHAR(255),
  created_on  DATE,
  created_by  VARCHAR(255),
  CONSTRAINT pk_permissions PRIMARY KEY (email, resource, operation)
);
-- Actual model
CREATE TABLE cars (
  cars_id     VARCHAR(32),-- This is the plate
  make       VARCHAR(32), -- This could be a catalog
  model      VARCHAR(32), -- This could be a catalog
  description VARCHAR(1024),
  type_of_use VARCHAR(32),
  national_key VARCHAR(255), -- National key also known as "Clave vehicular"
  serial_number VARCHAR(255),
  engine_serial_number VARCHAR(255),
  company VARCHAR(255),
  created_on DATE,
  created_by VARCHAR(255),
  CONSTRAINT pk_cars PRIMARY KEY (cars_id)
);


CREATE TABLE car_documents(
    car_documents_id VARCHAR(32),
    cars_id       VARCHAR(32) REFERENCES cars (cars_id),
    type VARCHAR(32), -- Could be tenencia or tarjeta de circulacion
    expedition_date DATE,
    expiring_date DATE,
    CONSTRAINT pk_car_documents PRIMARY KEY (car_documents_id)
);

CREATE TABLE car_compliance_verification(
    car_compliance_verirication_id VARCHAR(32),
    cars_id       VARCHAR(32) REFERENCES cars (cars_id),
    from_date DATE,
    to_date DATE,
    next_dat DATE,
    CONSTRAINT pk_car_compliance_verification PRIMARY KEY (car_compliance_verirication_id)
);

-----------------------------------------------------------------------------------------------------------------------
--- Initial setups 
--- 1 is always created by Admin
-----------------------------------------------------------------------------------------------------------------------
INSERT INTO users
VALUES ('caruizag@gmail.com', current_timestamp, 'caruizag@gmail.com');

INSERT INTO permissions (email, resource, operation,enabled, modified_on, modified_by, created_on, created_by)
VALUES ('caruizag@gmail.com', '*', 'CRUD', TRUE, NULL,NULL, current_timestamp, 'caruizag@gmail.com');

COMMIT;

