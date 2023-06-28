INSERT INTO [dbo].[RatingScale]
	([Name],[createdDate])
VALUES
    ('Sin valorar', GETDATE()),
	('Malo', GETDATE()),
	('Regular', GETDATE()),
	('Bueno', GETDATE()),
	('Muy bueno', GETDATE()),
	('Excelente', GETDATE())
;

INSERT INTO [dbo].[OrderState]
    ([Name],[createdDate])
VALUES
 	('En espera', GETDATE()),
	('En curso', GETDATE()),
	('Completado', GETDATE())
;


INSERT INTO [dbo].[BookingType]
    ([Name],[createdDate])
VALUES
 	('No aplica', GETDATE()),
	('Media pensión', GETDATE()),
	('All inclusive', GETDATE())
;






