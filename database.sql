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
	name TEXT
);

CREATE TABLE operation(
	id SERIAL PRIMARY KEY,
	name CHARACTER VARYING(10)
);

CREATE OTHER TABLE ... 