import java.sql.SQLException;

import control.UsuarioControl;

public class Main {
	private static void insereUsuarios(UsuarioControl uc) throws SQLException {
		uc.insereUsuario("Felix");
		uc.insereUsuario("Lidia");
		uc.insereUsuario("Joao");
	}
	
	public static void main(String[] args) {
		UsuarioControl uc = new UsuarioControl();
		try {
//			insereUsuarios(uc);
//			System.out.println("Usuários inseridos!");
			
			System.out.println(uc.buscaUsuarios());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
