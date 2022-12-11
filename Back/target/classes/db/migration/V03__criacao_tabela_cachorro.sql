CREATE TABLE tb_cachorro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(70) NOT NULL,
    raca_id BIGINT NOT NULL,
    idade int NOT NULL,
    peso float NOT NULL,
    altura float NOT NULL,
    largura float NOT NULL,
    cliente_id BIGINT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id)
);