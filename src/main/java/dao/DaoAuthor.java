package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conexao.Conexao;
import model.Author;
import model.Book;
import model.BookStatus;

public class DaoAuthor {
	private Connection conn;
    private Statement st;
    
    private void conectar(){
        try {
            this.conn = Conexao.pegarConexao();
            st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println(e1.getMessage());
        }catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    private void desconectar(){
        try {
            st.close();
            conn.close();
        }catch (SQLException e) {
            System.out.println("Erro ao fechar a conexao: " 
                + e.getMessage());
        }        
    }
    
    public Author consultar(int codigo){
    	Author author = new Author();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM author WHERE id = "+codigo+";");
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return author;
    }
}
