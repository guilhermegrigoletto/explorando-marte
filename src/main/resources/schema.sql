DROP TABLE IF EXISTS malhas;
DROP TABLE IF EXISTS sondas;
DROP TABLE IF EXISTS instrucoes;

CREATE TABLE malhas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    x INT,
    y INT
);

CREATE TABLE sondas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    x_inicial INT,
    y_inicial INT,
    direcao VARCHAR(1)
);

CREATE TABLE instrucoes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    comando VARCHAR(10),
    sondaId int,
    constraint fk_sonda_id foreign key (sondaId) references sondas (id)
);

