CREATE TABLE tb_atendimento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data DATE NOT NULL,
    hora TIME NOT NULL,
    idade_dia int NOT NULL,
    peso_dia float NOT NULL,
    altura_dia float NOT NULL,
    largura_dia float NOT NULL,
    diagnostico VARCHAR(255) NOT NULL,
    comentarios VARCHAR(255),
    cliente_id BIGINT NOT NULL,
    veterinario_id BIGINT NOT NULL,
    cachorro_id BIGINT NOT NULL,
    CONSTRAINT fk_cliente_atendimento FOREIGN KEY (cliente_id) REFERENCES tb_cliente(id),
    CONSTRAINT fk_veterinario FOREIGN KEY (veterinario_id) REFERENCES tb_veterinario(id),
    CONSTRAINT fk_cachorro FOREIGN KEY (cachorro_id) REFERENCES tb_cachorro(id)
);