package conexao;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class ConnectionFactory {
    public Connection getConnection() {
        try{
            Dotenv dotenv = Dotenv.load();

            String url = dotenv.get("DB_URL");
            String user = dotenv.get("DB_USER");
            String password = dotenv.get("DB_PASSWORD");

            return DriverManager.getConnection(url, user, password);
        } catch(SQLException e){
            throw new RuntimeException("Erro ao conectar ao banco de dados!", e);
        }
    }
}
