CREATE TABLE cadastro (
    id SERIAL PRIMARY KEY,
    name_product VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    disponible BOOLEAN NOT NULL
);
