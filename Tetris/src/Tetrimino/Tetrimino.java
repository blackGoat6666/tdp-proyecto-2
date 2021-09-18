package Tetrimino;

import ParOrdenado.ParOrdenado;

public abstract class Tetrimino {

	// atributos
	int rotacion;
	ParOrdenado [] coordenadasActuales;
	
	 //constructor ---
	
	//metodos
	public abstract void cambiarPosicion (int x, int y);
	
	public abstract void rotar ();
		
	//consultas--

}
