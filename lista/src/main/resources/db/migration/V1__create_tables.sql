CREATE TABLE user (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    senha VARCHAR(255)
);

CREATE TABLE lista (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    user_id INT REFERENCES user(id)
);

CREATE TABLE tarefa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    prazo TIMESTAMP,
    finalizado BOOLEAN,
    lista_id INT REFERENCES lista(id)
);
