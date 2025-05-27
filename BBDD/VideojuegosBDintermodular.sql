-- 1. Eliminar y crear la base de datos
DROP DATABASE IF EXISTS VideojuegosDB;
CREATE DATABASE VideojuegosDB;
USE VideojuegosDB;

-- 2. Crear tabla Plataforma
CREATE TABLE Plataforma (
    id_plataforma INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- 3. Crear tabla Genero
CREATE TABLE Genero (
    id_genero INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- 4. Crear tabla Videojuego (ya incluye la columna fecha_creacion)
CREATE TABLE Videojuego (
    id_videojuego INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    id_plataforma INT NOT NULL,
    id_genero INT NOT NULL,
    fecha_creacion DATETIME,
    FOREIGN KEY (id_plataforma) REFERENCES Plataforma(id_plataforma),
    FOREIGN KEY (id_genero) REFERENCES Genero(id_genero)
);

-- 5. Crear trigger para asignar fecha de creación automáticamente
DELIMITER //

CREATE TRIGGER trg_set_fecha_creacion
BEFORE INSERT ON Videojuego
FOR EACH ROW
BEGIN
    SET NEW.fecha_creacion = NOW();
END;
//

DELIMITER ;

-- 6. Crear tabla PlataformaConteo para llevar el total de videojuegos por plataforma
CREATE TABLE PlataformaConteo (
    id_plataforma INT PRIMARY KEY,
    total_videojuegos INT DEFAULT 0,
    FOREIGN KEY (id_plataforma) REFERENCES Plataforma(id_plataforma)
);

-- 7. Crear trigger para incrementar el conteo al insertar un videojuego
DELIMITER //

CREATE TRIGGER trg_incrementar_conteo
AFTER INSERT ON Videojuego
FOR EACH ROW
BEGIN
    UPDATE PlataformaConteo
    SET total_videojuegos = total_videojuegos + 1
    WHERE id_plataforma = NEW.id_plataforma;
END;
//

DELIMITER ;

-- 8. Insertar plataformas
INSERT INTO Plataforma (nombre) VALUES
('Xbox'),
('PC'),
('PlayStation'),
('Nintendo Switch'),
('Móvil');

-- 9. Insertar géneros
INSERT INTO Genero (nombre) VALUES
('Acción'),
('RPG'),
('Deportes'),
('Terror'),
('MOBA'),
('Estrategia'),
('Simulación'),
('Shooter'),
('Indie'),
('Acción/Aventura'),
('Terror Psicológico'),
('Lucha'),
('Plataformas'),
('Aventura'),
('Party'),
('Puzzle'),
('Casual'),
('Battle Royale');

-- 10. Inicializar PlataformaConteo con las plataformas existentes
INSERT INTO PlataformaConteo (id_plataforma)
SELECT id_plataforma FROM Plataforma;

-- 11. Insertar videojuegos (¡Ahora todos tendrán fecha_creacion automáticamente!)
INSERT INTO Videojuego (titulo, id_plataforma, id_genero) VALUES
-- Xbox
('Halo Infinite', 1, 1),
('Gears 5', 1, 1),
('Sunset Overdrive', 1, 1),
('The Outer Worlds', 1, 2),
('Fable', 1, 2),
('Forza Horizon 5', 1, 3),
('FIFA 24', 1, 3),
('The Medium', 1, 4),
('Resident Evil Village', 1, 4),

-- PC
('League of Legends', 2, 5),
('Dota 2', 2, 5),
('StarCraft II', 2, 6),
('Age of Empires IV', 2, 6),
('Microsoft Flight Simulator', 2, 7),
('The Sims 4', 2, 7),
('Counter-Strike 2', 2, 8),
('Valorant', 2, 8),
('Hades', 2, 9),
('Stardew Valley', 2, 9),

-- PlayStation
('God of War: Ragnarök', 3, 10),
('Spider-Man 2', 3, 10),
('Final Fantasy VII Remake', 3, 2),
('Bloodborne', 3, 2),
('Silent Hill 2 Remake', 3, 11),
('Until Dawn', 3, 11),
('Tekken 8', 3, 12),
('Street Fighter 6', 3, 12),

-- Nintendo
('Super Mario Odyssey', 4, 13),
('Donkey Kong Country: Tropical Freeze', 4, 13),
('The Legend of Zelda: Tears of the Kingdom', 4, 14),
('Pokémon Legends: Arceus', 4, 14),
('Mario Party Superstars', 4, 15),
('Super Smash Bros. Ultimate', 4, 15),
('Tetris 99', 4, 16),
('Captain Toad: Treasure Tracker', 4, 16),

-- Móvil
('Candy Crush Saga', 5, 17),
('Subway Surfers', 5, 17),
('Mobile Legends: Bang Bang', 5, 5),
('Pokémon Unite', 5, 5),
('PUBG Mobile', 5, 18),
('Call of Duty: Mobile', 5, 18),
('Genshin Impact', 5, 2),
('AFK Arena', 5, 2);

-- 12. Verificar los datos insertados
SELECT * FROM Videojuego;
SELECT * FROM PlataformaConteo;

-- 13. Insertar un juego nuevo para comprobar triggers
INSERT INTO Videojuego (titulo, id_plataforma, id_genero)
VALUES ('Nuevo Juego Prueba', 1, 1);

-- 14. Verificar que fecha_creacion y conteo funcionan correctamente
SELECT * FROM Videojuego WHERE titulo = 'Nuevo Juego Prueba';
SELECT * FROM PlataformaConteo;






