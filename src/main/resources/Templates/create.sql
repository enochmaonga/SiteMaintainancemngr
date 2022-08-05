CREATE TABLE site_maintenance(
  id serial PRIMARY KEY,
  description varchar
);
CREATE TABLE tasks (id serial PRIMARY KEY, description varchar);
CREATE TABLE categories (id serial PRIMARY KEY, name varchar);