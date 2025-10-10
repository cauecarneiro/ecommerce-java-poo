
CREATE DATABASE ecommerce;


USE ecommerce;


CREATE TABLE produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    estoque INT DEFAULT 0,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE transacoes (
    id_transacao INT AUTO_INCREMENT PRIMARY KEY,
    id_produto INT NOT NULL,
    quantidade INT NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);


CREATE TABLE email (
    id_email INT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(100) NOT NULL,
    email_cliente VARCHAR(150) NOT NULL UNIQUE,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO produto (nome, descricao, preco, estoque)
VALUES
('Camiseta Básica Preta', 'Camiseta 100% algodão, unissex, confortável e durável.', 49.90, 150),
('Tênis Esportivo Running X', 'Tênis leve e respirável, ideal para corridas e caminhadas.', 299.99, 80),
('Fone Bluetooth Pro', 'Fone de ouvido sem fio com cancelamento de ruído e microfone.', 199.90, 120),
('Smartwatch FitBand', 'Relógio inteligente com monitoramento de batimentos e sono.', 499.00, 50),
('Mochila Antifurto Urban', 'Mochila resistente à água, com porta USB e compartimento para notebook.', 179.90, 65),
('Mouse Gamer RGB', 'Mouse com sensor óptico de alta precisão e iluminação RGB personalizável.', 159.00, 100),
('Teclado Mecânico Pro', 'Teclado mecânico com switches azuis e iluminação LED.', 289.90, 70),
('Carregador Turbo 30W', 'Carregador rápido compatível com Android e iPhone.', 89.90, 200),
('Copo Térmico 500ml', 'Copo térmico em aço inox, mantém a bebida quente ou fria por horas.', 79.90, 90),
('Cadeira Ergonômica Office', 'Cadeira com apoio lombar ajustável e revestimento respirável.', 849.00, 30);

show tables;