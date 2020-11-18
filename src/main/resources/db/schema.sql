CREATE TABLE pais (
	id INT IDENTITY,
    nome VARCHAR(255) not null,
    sigla VARCHAR(255),
    imagem_url VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE atleta (
	id INT IDENTITY,
	nome VARCHAR(255) not null,
    sexo VARCHAR(255) not null,
    pais_id INT,
    PRIMARY KEY (id),
	FOREIGN KEY (pais_id) 
       REFERENCES pais (id)
);

CREATE TABLE prova (
	id INT IDENTITY,
    nome VARCHAR(255) not null,
    sexo VARCHAR(255) not null,
    tipo VARCHAR(255) not null,
    recorde_evento double precision not null,
    recorde_mundial double precision not null,
    PRIMARY KEY (id)
);

CREATE TABLE prova_atleta (
	prova_id INT,
    atleta_id INT,
	PRIMARY KEY (prova_id, atleta_id)
);

CREATE TABLE fase (
	id INT IDENTITY,
    nome VARCHAR(255) not null,
	prova_id INT,
    PRIMARY KEY (id),
	FOREIGN KEY (prova_id)
		REFERENCES prova(id)
);
    
CREATE TABLE resultado (
	id INT IDENTITY,
    marca double precision not null,
    fase_id INT,
	atleta_id INT,
    PRIMARY KEY (id),
	FOREIGN KEY (atleta_id)
		REFERENCES atleta (id),
	FOREIGN KEY (fase_id)
		REFERENCES fase (id)
);