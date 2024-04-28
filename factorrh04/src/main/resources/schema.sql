-- Creación de la tabla Users
CREATE TABLE IF NOT EXISTS Users (
    UserID INT PRIMARY KEY,
    UserName VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL
);

-- Creación de la tabla Roles
CREATE TABLE IF NOT EXISTS Roles (
    RoleID INT PRIMARY KEY,
    RoleName VARCHAR(255) NOT NULL UNIQUE
);

-- Creación de la tabla UserRoles para establecer la relación entre Users y Roles
CREATE TABLE IF NOT EXISTS UserRoles (
    UserRolesID INT PRIMARY KEY,
    UserID INT,
    RoleID INT,
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (RoleID) REFERENCES Roles(RoleID)
);

-- Inserta los datos de ejemplo en la tabla Users
INSERT INTO Users (UserID, UserName, Email, Password) VALUES
(1, 'usuario1', 'usuario1@example.com', 'contraseña1'),
(2, 'usuario2', 'usuario2@example.com', 'contraseña2'),
(3, 'usuario3', 'usuario3@example.com', 'contraseña3');

-- Inserta los datos de ejemplo en la tabla Roles
INSERT INTO Roles (RoleID, RoleName) VALUES
(1, 'Admin'),
(2, 'Moderador'),
(3, 'Usuario Regular');

-- Inserta los datos de ejemplo en la tabla UserRoles
INSERT INTO UserRoles (UserRolesID, UserID, RoleID) VALUES
(1, 1, 1), -- usuario1 es Admin
(2, 2, 2), -- usuario2 es Moderador
(3, 3, 3), -- usuario3 es Usuario Regular
(4, 3, 2); -- usuario3 también es Moderador