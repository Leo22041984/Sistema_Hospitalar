/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    // Atributos estáticos com os dados do Banco de Dados
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_uc12";
    private static final String USUARIO = "root";
    private static final String SENHA = "227442";

    /*
     * Ao chamar este método getConexao() em outra classe, como por exemplo em um
     * DAO, é retornado um objeto do tipo Connection que será utilizado para
     * realizar as operações de consulta, inserção, atualização ou exclusão de
     * dados no banco de dados.
     */
    public static Connection getConexao() throws SQLException {
        Connection conexao = null;
        try {
            // Registrando o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estabelecendo a conexão com o banco de dados através da URL, usuário e senha
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new SQLException("Erro ao conectar ao banco de dados! " + ex.getMessage());
        }
        return conexao;
    }

}
