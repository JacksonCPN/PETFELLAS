CREATE TABLE tb_cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(70) NOT NULL,
    cpf VARCHAR(15) NOT NULL,
    email VARCHAR(30) NOT NULL,
    telefone VARCHAR(14) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero VARCHAR(6) NOT NULL,
    complemento VARCHAR(255),
    cep VARCHAR(8) NOT NULL
);