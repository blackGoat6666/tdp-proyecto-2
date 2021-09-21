package Grilla;

import Bloque.Bloque;
import Tetrimino.Tetrimino;

public class Grilla {
	// atributos
	private Bloque[][] casilleros;
	private Tetrimino tetriminoActual;
	
	//constructor
	
	public Grilla () {
		casilleros = new Bloque[21][10];
	}
	
	//metodos
	
	public void borrarFilaLlena(int fila) {
	  for(int i=0; i<casilleros[0].length; i++){
	    casilleros[fila][i].setEstado(false);  
	  } 
	  boolean hayAlgo=true;
	  int filaActual=fila;
	  while(hayAlgo){
	  hayAlgo=false;
	    for(int i=0; i<casilleros[0].length; i++){
	      if(casilleros[filaActual][i].getEstado()==true) {
	        hayAlgo=true;  
	      }
	      casilleros[filaActual][i]=casilleros[filaActual+1][i];  
	      filaActual++;
	    } 
	  }
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
