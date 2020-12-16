import java.sql.SQLException;

import control.UsuarioControl;

public class Main {
	@SuppressWarnings("unused")
	private static void insereUsuarios(UsuarioControl uc) throws SQLException {
		uc.insereUsuario("Félix");
		uc.insereUsuario("Lídia");
		uc.insereUsuario("João");
	}
	
	public static void main(String[] args) {
		boolean redis = true;
		UsuarioControl uc = new UsuarioControl(redis);
		try {
//			insereUsuarios(uc);
//			System.out.println("Usuários inseridos!");
			
			System.out.println(uc.buscaUsuarios());
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

}
