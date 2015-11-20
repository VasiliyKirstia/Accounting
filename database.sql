CREATE TABLE account(
	id SERIAL PRIMARY KEY,
	account_number CHARACTER(20) NOT NULL
);

CREATE TABLE currency(
	id SERIAL PRIMARY KEY,
	name CHARACTER(3) NOT NULL
);

CREATE TABLE destination(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL
);

CREATE TABLE document(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL
);

CREATE TABLE employee(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL
);

CREATE TABLE operation(
	id INTEGER PRIMARY KEY,
	name CHARACTER VARYING(10) NOT NULL
);

CREATE TABLE product_unit(
	id SERIAL PRIMARY KEY,
	name CHARACTER VARYING(10) NOT NULL
);

CREATE TABLE product_group(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	account_id INTEGER REFERENCES account (id)
);

CREATE TABLE product(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	amount DOUBLE PRECISION CHECK ( 0 <= amount ),
	price NUMERIC(15, 3) CHECK ( 0 < price ),
	currency_id INTEGER REFERENCES currency (id),
	product_group_id INTEGER REFERENCES product_group (id),
	product_unit_id INTEGER REFERENCES product_unit (id)
);

CREATE TABLE transaction(
	id SERIAL PRIMARY KEY,
	date DATE NOT NULL,
	product_amount DOUBLE PRECISION CHECK ( 0 < product_amount ),
	operation_id INTEGER REFERENCES operation ( id ),
	product_id INTEGER REFERENCES product ( id ),
	destination_id INTEGER REFERENCES destination ( id ),
	employee_id INTEGER REFERENCES employee ( id ),
	document_id INTEGER REFERENCES document ( id )
);

INSERT INTO operation (id, name) VALUES (1, 'addition');
INSERT INTO operation (id, name) VALUES (2, 'consuming');

INSERT INTO destination (id, name) VALUES (DEFAULT, 'склад');
