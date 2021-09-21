package Tetrimino;

import ParOrdenado.ParOrdenado;

public abstract class Tetrimino {

	// atributos
	int rotacion;
	ParOrdenado [] coordenadasActuales;
	
	 //constructor ---
	
	//metodos
	public abstract void cambiarPosicion (int x, int y);
	
	public void rotar() {
		if (rotacion==1)
			this.posicion2();
		else
			if (rotacion==2)
				this.posicion3();
			else
				if (rotacion==3)
					this.posicion4();
				else 
					this.posicion1(); 
	}
	public abstract void posicion1();
	public abstract void posicion2();
	public abstract void posicion3();
	public abstract void posicion4();
	
	//consultas--

}
