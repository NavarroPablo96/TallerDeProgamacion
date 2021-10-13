package persistencia;

import java.util.HashMap;

import modelo.*;



public class PersistenciaPacientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Paciente> pac = new HashMap<String, Paciente>();
		Paciente p1 = new Joven("111", "Seba", "A", "112233", "mdp", "123", 123123);
		Paciente p2 = new Mayor("222", "Ima", "V", "445566", "balcarce", "456", 456456);
		pac.put(p1.getDni(),p1);
		pac.put(p2.getDni(),p2);
		Clinica.getInstance().setPacientesRegistrados(pac);
		
		
		
		
	}

}
