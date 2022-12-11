CREATE TABLE tb_perfil(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(14) NOT NULL
);

CREATE TABLE tb_usuario(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(40) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    perfil_id BIGINT NOT NULL,
    CONSTRAINT fk_perfil FOREIGN KEY (perfil_id) REFERENCES tb_perfil(id)
);