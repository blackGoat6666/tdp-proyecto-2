package Grilla;

import Bloque.Bloque;
import Tetrimino.Tetrimino;

public class Grilla {
	// atributos
	private Bloque casilleros[] [];
	private Tetrimino tetriminoActual;
	
	//constructor
	
	public Grilla () {
		casilleros = new Bloque[10][21];
	}
	
	//metodos
	
	public void borrarFilaLlena() {
		
	}
	
	public void generarTetrimino() {
		
	}
	
	public void moverIzquierda() {
		
	}
	
	public void moverDerecha() {
		
	}
	
    public void girarTetrimino() {
		
	}
	
	public boolean moverAbajo() {
		return true;
		
	}
	
	public boolean agregarTetrimno (Tetrimino bloque) {
		return true;
	}
	
	public void actualizarTetriminoActual() {
		
	}
	
	public boolean filaLlena(int fila) {
		return true;
	}
	//consultas
	
	public boolean grillaLlena () {
		return false;
	}

}
