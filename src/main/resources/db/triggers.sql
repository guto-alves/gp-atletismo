CREATE DATABASE gpatletismo;
GO
USE gpatletismo;



-- Triggers para garantir a integridade do banco
GO
CREATE TRIGGER trg_pais
ON pais
INSTEAD OF INSERT, DELETE, UPDATE
AS
BEGIN
	RAISERROR('Os pa�ses n�o podem sem modificados', 16, 1);
END ^;

GO
CREATE TRIGGER trg_atleta
ON atleta
INSTEAD OF INSERT, DELETE, UPDATE
AS
BEGIN
	RAISERROR('Os atletas n�o podem sem modificados', 16, 1);
END ^;

GO 
CREATE TRIGGER trg_resultado
ON resultado
INSTEAD OF DELETE, UPDATE
AS 
BEGIN
	RAISERROR('o resultado n�o pode ser modificado', 16, 1);
END ^;
