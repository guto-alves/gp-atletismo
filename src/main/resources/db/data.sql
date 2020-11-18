-- Trigger para criar as duas fases para a prova inserida
CREATE TRIGGER trg_prova 
ON prova
AFTER INSERT
AS 
BEGIN
	DECLARE @id INT;
	
	SELECT @id = id FROM inserted;

	INSERT INTO fase (nome, prova_id)	
	VALUES 
		('Fase Inicial', @id),
		('Fase Final', @id);
END;

GO

INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('Lançamento do Dardo / Javelin Throw', 'Distancia', 'Feminino/Women', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('Salto em Distância / Long Jump', 'Distancia', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('Salto com Vara / Pole Vault', 'Distancia', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial)
VALUES ('400 m com barreiras / 400 m Hurdles ', 'Tempo', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('100 m / 100 m', 'Tempo', 'Feminino/Women', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('Arremesso do Peso / Shot Put', 'Distancia', 'Feminino/Women', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('100 m / 100 m', 'Tempo', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('3000 m / 3000 m', 'Tempo', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('Lançamento do Disco / Discus Throw', 'Distancia', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('3000 m com obstáculos / 3000 m Steeplechase', 'Tempo', 'Feminino/Women', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('Salto Triplo / Triple Jump', 'Distancia', 'Feminino/Women', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('400 m / 400 m', 'Tempo', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('800 m / 800 m', 'Tempo', 'Feminino/Women', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('800 m / 800 m', 'Tempo', 'Masculino/Men', 10, 10);
INSERT INTO	prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('200 m / 200 m', 'Tempo', 'Feminino/Women', 10, 10);
INSERT INTO prova (nome, tipo, sexo, recorde_evento, recorde_mundial) 
VALUES ('200 m / 200 m', 'Tempo', 'Masculino/Men', 10, 10);

GO

CREATE OR ALTER PROCEDURE insert_atletas
AS
BEGIN
	DECLARE @i INT = 1,
			@pais_id INT = 1;

	WHILE @i <= 160
	BEGIN
		SET @pais_id = FLOOR(RAND() * 206) + 1;

		IF @i % 2 = 0
			INSERT INTO atleta (nome, sexo, pais_id)
			VALUES ('Atleta ' + CONVERT(VARCHAR, @i), 'Masculino/Men', @pais_id);
		ELSE
			INSERT INTO atleta (nome, sexo, pais_id)
			VALUES ('Atleta ' + CONVERT(VARCHAR, @i), 'Feminino/Women', @pais_id);

		INSERT INTO prova_atleta
		VALUES (@i % 16 + 1, @i);

		SET @i = @i + 1;
	END;
END;

GO

EXEC insert_atletas;

GO

select * from prova;
select * from pais;
select * from atleta;
select * from resultado;
select * from fase;

drop table pais;

SELECT pais.nome, COUNT(atleta.id) as total_atletas
FROM pais 
INNER JOIN atleta  
ON pais.id = atleta.pais_id
GROUP BY pais.nome