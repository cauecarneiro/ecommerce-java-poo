import java.math.BigDecimal;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();

        String dbUrl = dotenv.get("DB_URL");
        String dbUser = dotenv.get("DB_USER");
        String dbPassword = dotenv.get("DB_PASSWORD");

        try {
            System.out.println("Tentando conectar ao banco...");
            Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Conectado");

            String sql = "DELETE FROM Produtos WHERE id = 20";
            PreparedStatement statement = connection.prepareStatement(sql);
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Sucesso! Produto com ID " + 20 + " foi deletado.");
            } else {
                System.out.println("Atenção! Nenhum produto encontrado com o ID " + 20 + ". Nenhuma linha foi deletada.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}
