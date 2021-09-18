package Logica;

import Grilla.Grilla;

public class Logica {

	// atributos
	private int puntuacion;
	private Grilla miGrilla;
	
	//constructor
	public Logica () {
		puntuacion = 0;
		miGrilla = new Grilla();
	}
		
	//metodos
	
	public void moverTetIzq () {
		miGrilla.moverIzquierda();
		
	}
	
	public void moverTetDer () {
		miGrilla.moverDerecha();
		
	}
    
	public void moverTetAbajo () {
		miGrilla.moverAbajo();
	}
    
	public void girarTetrimino () {
		miGrilla.girarTetrimino();
		
	}

	public void acelerarTetrimino () {
		
	}
    
	public void terminarJuego () {
		
	}
    
	public void sumarPuntos (int puntos) {
		
	}
		
	//consultas
    
	public int getPuntuacion () {
		return puntuacion;
	}
    
}
