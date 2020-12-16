package control;

import java.sql.SQLException;

import DAO.UsuarioDAO;
import model.Usuario;
import redis.clients.jedis.Jedis;

public class UsuarioControl {
	private UsuarioDAO uDao;
	private Jedis jedis;
	
	public UsuarioControl(boolean redis) {
		this.uDao = new UsuarioDAO();
		
		if(redis) this.jedis = new Jedis();
	}

	public void insereUsuario(String nome) throws SQLException {
		uDao.insert(new Usuario(nome));
	}
	
	private String buscaUsuariosVerificandoCache() throws SQLException {
		StringBuilder sb = new StringBuilder();
		
		String userCache = jedis != null ? jedis.get("users") : null;
	
		if(userCache == null) {			
			for(Usuario us : uDao.get()) {
				sb.append(us).append("\n");
			}
			
			jedis.set("users", sb.toString());
		} else {
			sb.append(userCache);
		}
		
		return sb.toString();
	}

	private String buscaUsuariosSemVerificarCache () throws SQLException {
		StringBuilder sb = new StringBuilder();
		for(Usuario us : uDao.get()) {
			sb.append(us).append("\n");
		}
		return sb.toString();
	}
	
	public String buscaUsuarios() throws SQLException {
		return jedis == null ? buscaUsuariosSemVerificarCache() : buscaUsuariosVerificandoCache();
	}
}
