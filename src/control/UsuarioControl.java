package control;

import java.sql.SQLException;

import DAO.UsuarioDAO;
import model.Usuario;

public class UsuarioControl {
	private UsuarioDAO uDao;
	
	public UsuarioControl(boolean redis) {
		if(redis) {
			
		}else {
			this.uDao = new UsuarioDAO();			
		}
	}

	public void insereUsuario(String nome) throws SQLException {
		uDao.insert(new Usuario(nome));
	}
	
	public String buscaUsuarios() throws SQLException {
		StringBuilder sb = new StringBuilder();
		
		for(Usuario us : uDao.get()) {
			sb.append(us).append("\n");
		}
		return sb.toString();
	}
}
