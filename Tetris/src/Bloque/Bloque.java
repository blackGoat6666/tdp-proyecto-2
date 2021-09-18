package Bloque;

public class Bloque {
	// atributos
	boolean lleno;
	
	//constructor
	Bloque () {
		lleno = false;
	}
	
	//comandos
	void cambiarEstado () {
		if (lleno == false) {
			lleno = true;
		} else {
			lleno = false;
		}
	}
	 
	//consultas
	boolean getEstado () {
		return lleno;
	}
	

}
