-- Crear la base de datos
DROP DATABASE IF EXISTS VideojuegosDB;
CREATE DATABASE VideojuegosDB;
USE VideojuegosDB;

-- Tabla de plataformas
CREATE TABLE Plataforma (
    id_plataforma INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla de géneros
CREATE TABLE Genero (
    id_genero INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla de videojuegos
CREATE TABLE Videojuego (
    id_videojuego INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    id_plataforma INT,
    id_genero INT,
    FOREIGN KEY (id_plataforma) REFERENCES Plataforma(id_plataforma),
    FOREIGN KEY (id_genero) REFERENCES Genero(id_genero)
);

-- Insertar plataformas
INSERT INTO Plataforma (nombre) VALUES
('Xbox'),
('PC'),
('PlayStation'),
('Nintendo Switch'),
('Móvil');

-- Insertar géneros
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

-- Insertar videojuegos
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

ALTER TABLE Videojuego ADD fecha_creacion DATETIME;
DELIMITER //
CREATE TRIGGER trg_fecha_creacion
BEFORE INSERT ON Videojuego
FOR EACH ROW
BEGIN
    SET NEW.fecha_creacion = NOW();
END;
//
DELIMITER ;

CREATE TABLE PlataformaResumen (
    id_plataforma INT PRIMARY KEY,
    num_videojuegos INT DEFAULT 0,
    FOREIGN KEY (id_plataforma) REFERENCES Plataforma(id_plataforma)
);

INSERT INTO PlataformaResumen (id_plataforma, num_videojuegos)
SELECT id_plataforma, COUNT(*) FROM Videojuego GROUP BY id_plataforma;

DELIMITER //
CREATE TRIGGER trg_incrementar_contador
AFTER INSERT ON Videojuego
FOR EACH ROW
BEGIN
    UPDATE PlataformaResumen
    SET num_videojuegos = num_videojuegos + 1
    WHERE id_plataforma = NEW.id_plataforma;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER trg_decrementar_contador
AFTER DELETE ON Videojuego
FOR EACH ROW
BEGIN
    UPDATE PlataformaResumen
    SET num_videojuegos = num_videojuegos - 1
    WHERE id_plataforma = OLD.id_plataforma;
END;
//
DELIMITER ;
