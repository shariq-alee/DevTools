CREATE TABLE public.users (
	id integer NOT NULL,
	username varchar NOT NULL,
	name varchar NOT NULL,
	"password" varchar NOT NULL,
	date_of_birth varchar NULL,
	CONSTRAINT users_pk PRIMARY KEY (id),
	CONSTRAINT users_unique UNIQUE (username)
);
