# Ecommerce (POO em Java)

Projeto da disciplina de Programação Orientada a Objetos: classes de produto e acesso a um banco MySQL, em Java.

Projeto acadêmico · Java 24 · 2025

## O que faz
- Modela o produto (`Produto`: id, nome, descrição, preço e estoque) como classe, com atributos privados e métodos de acesso.
- Separa o acesso ao banco num DAO (`ProdutoDAO`) que implementa a interface `InterfaceProdutoDAO`; hoje a interface só tem `ListarTodos()`.
- Abre a conexão com MySQL por uma fábrica (`ConnectionFactory`) que lê o endereço, o usuário e a senha de um arquivo `.env`.
- O script `bd/ecomerce.sql` cria o banco `ecommerce` com as tabelas de produto, transações e e-mails de clientes, e insere 10 produtos de exemplo.
- O `Main.java` conecta ao banco e executa um `DELETE` de um produto por id.

## Meu papel
Trabalho da disciplina. Todos os commits são meus.

## Como foi feito
- Camadas simples: `model` (entidade), `dao` (acesso ao banco), `interfaces` (contrato do DAO) e `conexao` (conexão).
- JDBC com `PreparedStatement` e `try-with-resources`; preço em `BigDecimal`.
- Credenciais fora do código, com a biblioteca dotenv-java.

## Tecnologias
Java 24, JDBC, MySQL (driver mysql-connector-java 8.0.28), dotenv-java e Maven.

## Como rodar
1. Crie o banco com `EcommercePOO/bd/ecomerce.sql` (MySQL).
2. Crie um arquivo `.env` com as variáveis `DB_URL`, `DB_USER` e `DB_PASSWORD`.
3. Abra `EcommercePOO` numa IDE Java com JDK 24 e rode o `Main`.

Atenção: o código ainda não fecha com o script. O SQL cria a tabela `produto` (colunas `id_produto` e `estoque`), e o DAO e o `Main` consultam `Produtos` (colunas `id` e `quantidade_em_estoque`). Também há diferença entre os pacotes declarados e as pastas de `src/ecommerce`.

---
Feito por Cauê Crillanovick · [portfólio](https://cauecarneiro.github.io/portfolio/) · [LinkedIn](https://www.linkedin.com/in/cau%C3%AA-carneiro)
