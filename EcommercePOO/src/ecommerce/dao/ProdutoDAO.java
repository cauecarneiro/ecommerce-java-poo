package dao;

import conexao.ConnectionFactory;
import interfaces.InterfaceProdutoDAO;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements InterfaceProdutoDAO {

    @Override
    public List<Produto> ListarTodos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM Produtos";

        try (
                Connection conexao = new ConnectionFactory().getConnection();
                PreparedStatement statement = conexao.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();) {
            System.out.println("Conectado");

            while (resultSet.next()) {

                Produto produto = new Produto();
                produto.setId(resultSet.getInt("id"));
                produto.setNome(resultSet.getString("nome"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getBigDecimal("preco"));
                produto.setQuantidadeEmEstoque(resultSet.getInt("quantidade_em_estoque"));

                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco!", e);
        }

        return produtos;
    }
}
