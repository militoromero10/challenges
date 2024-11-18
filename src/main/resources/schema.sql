-- Tabla challenge
CREATE TABLE IF NOT EXISTS challenge (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    challenge CHAR(36) NOT NULL UNIQUE,
    name VARCHAR(255),
    challenge_level VARCHAR(10),
    description VARCHAR(255)
);