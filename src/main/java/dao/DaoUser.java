package dao;
import conexao.*;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class DaoUser {
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
    
    public User consultar(String email, String password){
    	User user = new User();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM user WHERE email = '"+email+"' AND password = '"+password+"';");
            if (rs.next()){
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setType(rs.getString("type"));
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.desconectar();
        }
        return user;
    }
    
    public boolean inserir(User user){
        boolean resultado = false;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
            		"INSERT INTO user VALUES (NULL, '"+user.getName()+"', '"+user.getEmail()+"', '"+user.getPassword()+"',"
            				+ "'"+user.getType()+"');");
            pst.executeUpdate();
            
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