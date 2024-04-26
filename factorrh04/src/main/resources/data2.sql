-- Datos de ejemplo para la tabla Users
INSERT INTO Users (UserID, UserName, Email, Password) VALUES
(1, 'usuario1', 'usuario1@example.com', 'contraseña1'),
(2, 'usuario2', 'usuario2@example.com', 'contraseña2'),
(3, 'usuario3', 'usuario3@example.com', 'contraseña3');

-- Datos de ejemplo para la tabla Roles
INSERT INTO Roles (RoleID, RoleName) VALUES
(1, 'Admin'),
(2, 'Moderador'),
(3, 'Usuario Regular');

-- Datos de ejemplo para la tabla UserRoles (relación entre usuarios y roles)
INSERT INTO UserRoles (UserRolesID, UserID, RoleID) VALUES
(1, 1, 1), -- usuario1 es Admin
(2, 2, 2), -- usuario2 es Moderador
(3, 3, 3), -- usuario3 es Usuario Regular
(4, 3, 2); -- usuario3 también es Moderador