package Bloque;

public class Bloque {
	// atributos
	private boolean lleno;
	
	//constructor
	public Bloque () {
		lleno = false;
	}
	
	//comandos
	public void setEstado(boolean estado) {
	  lleno=estado;	
	}
	
	 
	//consultas
	public boolean getEstado () {
		return lleno;
	}
	

}