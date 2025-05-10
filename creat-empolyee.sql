-- Drop table if exists.
DROP TABLE IF EXISTS employee;


-- Create employee table
CREATE TABLE employee (
  id BIGSERIAL PRIMARY KEY,
  first_name VARCHAR(45),
  last_name VARCHAR(45),
  email VARCHAR(45)
);

ALTER SEQUENCE employee_id_seq RESTART WITH 20250001;

-- Inserting data

INSERT INTO employee (first_name, last_name, email)
VALUES
('Leslie', 'Andrews', 'leslie@luv2code.com'),
('Emma', 'Baumgarten', 'emma@luv2code.com'),
('Yuri', 'Petrov', 'yuri@luv2code.com'),
('Juan', 'Vega', 'juan@luv2code.com');
