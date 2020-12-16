package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Usuario;

public class UsuarioDAO {
	public void insert(Usuario usuario) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into usuario(nome) values (?)");
        stm.setString(1, usuario.getNome());
        stm.executeUpdate();
        con.close();
    };
    
    public ArrayList<Usuario> get() throws SQLException {
    	ArrayList<Usuario> usuarios = new ArrayList<>();
    	
    	Connection con = Conexao.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from usuario");
        ResultSet res = stm.executeQuery();
        
        while(res.next()){
        	usuarios.add(new Usuario(res.getInt("idusuario"), res.getString("nome")));
        }
        res.close();
        con.close();
        return usuarios;
    }
}
