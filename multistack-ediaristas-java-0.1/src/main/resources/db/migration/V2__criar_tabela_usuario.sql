CREATE TABLE `usuario` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) NOT NULL,
    `nome_completo` varchar(255) NOT NULL,
    `senha` varchar(255) NOT NULL,
    `tipo_usuario` varchar(8) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`)
  );