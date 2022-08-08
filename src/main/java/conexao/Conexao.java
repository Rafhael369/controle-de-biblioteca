package conexao;

import java.sql.*;

public class Conexao {
	private static Connection conexao;

    public static Connection pegarConexao() throws ClassNotFoundException, SQLException{
        String bd = "biblioteca";
    	String url = "jdbc:mysql://127.0.0.1/"+bd;
        String usuario = "root";
        String senha = "coloca sua senha";

        Class.forName("com.mysql.cj.jdbc.Driver");
        conexao = DriverManager.getConnection(url, usuario, senha);
        return conexao;
    }
}
