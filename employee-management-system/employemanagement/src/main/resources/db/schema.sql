-- Create database (already done via docker-compose, but included for completeness)
CREATE DATABASE IF NOT EXISTS employemanagement_db;

USE employemanagement_db;

-- Employee table
CREATE TABLE IF NOT EXISTS employe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    poste VARCHAR(50) NOT NULL
);

-- Overtime table
CREATE TABLE IF NOT EXISTS heures_sup (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employe_id INT NOT NULL,
    date DATE NOT NULL,
    nb_heures FLOAT NOT NULL,
    FOREIGN KEY (employe_id) REFERENCES employe(id)
);

-- Rate table
CREATE TABLE IF NOT EXISTS tarif (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type_jour VARCHAR(20) NOT NULL,
    tarif FLOAT NOT NULL
);

-- Sample data
INSERT INTO employe (nom, prenom, poste) VALUES 
('Doe', 'John', 'Developer'),
('Smith', 'Jane', 'Manager');

INSERT INTO tarif (type_jour, tarif) VALUES 
('weekend', 1.5),
('jour ordinaire', 1.0);

INSERT INTO heures_sup (employe_id, date, nb_heures) VALUES
(1, '2023-10-01', 2.5),
(2, '2023-10-02', 1.0);