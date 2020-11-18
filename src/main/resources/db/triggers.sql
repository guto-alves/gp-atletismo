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
	RAISERROR('Os países não podem sem modificados', 16, 1);
END ^;

GO
CREATE TRIGGER trg_atleta
ON atleta
INSTEAD OF INSERT, DELETE, UPDATE
AS
BEGIN
	RAISERROR('Os atletas não podem sem modificados', 16, 1);
END ^;

GO 
CREATE TRIGGER trg_resultado
ON resultado
INSTEAD OF DELETE, UPDATE
AS 
BEGIN
	RAISERROR('o resultado não pode ser modificado', 16, 1);
END ^;
