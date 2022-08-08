package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import conexao.Conexao;
import model.Author;
import model.Book;
import model.BookStatus;
import model.User;

public class DaoBook {
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
    
    public ArrayList<Book> listarTodos(){
    	ArrayList<Book> resultado = new ArrayList<Book>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT book.id, book.name, book.date, book.status, author.name as name_author, "
            		+ "author.id as id_author FROM book inner join author ON book.id_author = author.id;");
            while(rs.next()){
            	Book book  = new Book();
            	Author author = new Author();
            	BookStatus status;
            	
            	if (rs.getString("status").equals("DISPONIVEL")) {
            		status = BookStatus.DISPONIVEL;
            	}else if (rs.getString("status").equals("INDISPONIVEL")) {
            		status = BookStatus.INDISPONIVEL;
            	}else {
            		status = BookStatus.EMPRESTADO;
            	}
            	
            	book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDate(rs.getDate("date"));
                book.setBookStatus(status);
                
                author.setId(rs.getInt("id_author"));
                author.setName(rs.getString("name_author"));
                book.setAuthor(author);
                
                resultado.add(book);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }
    
    public int excluir(int cod){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "DELETE FROM book where id = " + cod + ";";
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();
        }catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }
    
    public Book consultar(int codigo){
    	Book book = new Book();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT book.id, book.name, book.date, book.status, author.name as name_author, "
            		+ "author.id as id_author FROM book inner join author ON book.id_author = author.id WHERE book.id = "+codigo+";");
            if (rs.next()){
            	Author author = new Author();
            	BookStatus status;
            	
            	book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDate(rs.getDate("date"));
                
                if (rs.getString("status").equals("DISPONIVEL")) {
            		status = BookStatus.DISPONIVEL;
            	}else if (rs.getString("status").equals("INDISPONIVEL")) {
            		status = BookStatus.INDISPONIVEL;
            	}else {
            		status = BookStatus.EMPRESTADO;
            	}
                
                book.setBookStatus(status);
                author.setId(rs.getInt("id_author"));
                author.setName(rs.getString("name_author"));
                book.setAuthor(author);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return book;
    }
    
    public int alterar(int idBook, String status){
        int qtde = 0;
        try {
            this.conectar();
            String comando = "UPDATE book set status = '"+ status +"' where id = " + idBook + ";";
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
    }
    
    public boolean inserir(Book book){
        boolean resultado = false;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
            		"INSERT INTO author VALUES (NULL, '"+book.getAuthor().getName()+"')", Statement.RETURN_GENERATED_KEYS
                );
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            
            int idAuthor = 0;
            
            if(rs.next()) {
            	idAuthor = rs.getInt(1);
            	PreparedStatement pstBook = conn.prepareStatement(
                        "INSERT INTO book VALUES (NULL, '"+book.getName()+"', '"+book.getDate()+"', '"+book.getBookStatus()+"', "+idAuthor+")", Statement.RETURN_GENERATED_KEYS
                    );
            	pstBook.executeUpdate();
            }
            
            resultado = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir o registro: " 
                + e.getMessage());
        }finally{
            this.desconectar();
        }
        return resultado;
    }
}
