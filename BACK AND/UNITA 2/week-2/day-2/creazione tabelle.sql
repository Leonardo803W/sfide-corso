CREATE TABLE authors (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
	avatar VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL
)

CREATE TABLE blogposts (
    id SERIAL PRIMARY KEY,
    category VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
	cover VARCHAR(100) NOT NULL,
    content VARCHAR(50) NOT NULL,
	reading_time INTEGER NOT NULL,
	authors_id INT,
	FOREIGN KEY (authors_id) REFERENCES authors(id)
)