CREATE TABLE IF NOT EXISTS `AFFEROLABPAPELARIA.produto` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nome` varchar(20),
    `categoria` varchar(50),
    `codigo_de_barras` varchar(50),
    `quantidade` int ,
    `criacao` timestamp,
    `atualizacao` timestamp

);