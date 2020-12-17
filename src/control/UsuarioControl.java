package control;

import java.sql.SQLException;

import DAO.UsuarioDAO;
import model.Usuario;
import redis.clients.jedis.Jedis;

public class UsuarioControl {
	private UsuarioDAO uDao;
	
	public UsuarioControl() {
		this.uDao = new UsuarioDAO();
	}

	public void insereUsuario(String nome) throws SQLException {
		uDao.insert(new Usuario(nome));
	}

	public String buscaUsuarios() throws SQLException {
		StringBuilder sb = new StringBuilder();
		Jedis cache = new Jedis();
		
		String usuarios = cache.get("users");
		
		if(usuarios == null) {
			for(Usuario us : uDao.get()) {
				sb.append(us).append("\n");
			}
			cache.set("users", sb.toString());
		}else{
			sb.append(usuarios);
		}
		
		cache.close();
		
		return sb.toString();
	}
}
