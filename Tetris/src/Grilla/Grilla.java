package Grilla;

import java.util.Random;

import Bloque.Bloque;
import ParOrdenado.ParOrdenado;
import Tetrimino.PiezaI;
import Tetrimino.PiezaL;
import Tetrimino.PiezaO;
import Tetrimino.PiezaS;
import Tetrimino.PiezaT;
import Tetrimino.PiezaZ;
import Tetrimino.Tetrimino;

public class Grilla {
	// atributos
	private Bloque[][] casilleros;
	private Tetrimino tetriminoActual;
	private Tetrimino tetriminoSiguiente;
	
	//constructor
	
	public Grilla () {
		casilleros = new Bloque[21][10];
		this.generarTetrimino();
		this.actualizarTetriminoActual();
	}
	
	//metodos
	
	public void borrarFilaLlena(int fila) {
	  for(int i=0; i<casilleros[0].length; i++){
	    casilleros[fila][i].setEstado(false);  
	  } 
	  boolean hayAlgo=true;
	  int filaActual=fila;
	  while(hayAlgo && filaActual>0){
	    hayAlgo=false;
	      for(int i=0; i<casilleros[0].length; i++){
	        if(casilleros[filaActual][i].getEstado()==true) {
	          hayAlgo=true;  
	        }
	        casilleros[filaActual][i]=casilleros[filaActual-1][i];  
	       } 
	    filaActual--;  
	  }
    }	

	public void moverIzquierda() {
	  ParOrdenado[] posicionActual=tetriminoActual.getPosicionesIzquierda(tetriminoActual.getRotacion());	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionActual.length ; i++) {
	    if(posicionActual[i].getY()>0 && casilleros[posicionActual[i].getX()][posicionActual[i].getY()-1].getEstado()==false ) {
	      puedenMoverse++;
	    }
	  }
	  if(puedenMoverse==posicionActual.length){
	    tetriminoActual.cambiarPosicion(0, -1);
	  }
	}
	
	public void moverDerecha() {
	  ParOrdenado[] posicionActual=tetriminoActual.getPosicionesDerecha(tetriminoActual.getRotacion());	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionActual.length ; i++) {
	    if(posicionActual[i].getY()<9 && casilleros[posicionActual[i].getX()][posicionActual[i].getY()+1].getEstado()==false ) {
		  puedenMoverse++;
		}
	  }
	  if(puedenMoverse==posicionActual.length){
	    tetriminoActual.cambiarPosicion(0, 1);
	  }
	}
	
    public boolean girarTetrimino() {
	  ParOrdenado[] posicionDer=tetriminoActual.getPosicionesDerecha((tetriminoActual.getRotacion()+1)%4);	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionDer.length ; i++) {
	    if(posicionDer[i].getY()<9 && casilleros[posicionDer[i].getX()][posicionDer[i].getY()+1].getEstado()==false ) {
	      puedenMoverse++;
        }
	  }
	  if(puedenMoverse!=posicionDer.length){
	    return false;  
	  }
	  ParOrdenado[] posicionIzq=tetriminoActual.getPosicionesIzquierda((tetriminoActual.getRotacion()+1)%4);	
	  puedenMoverse=0;
	  for(int i=0; i<posicionIzq.length ; i++) {
	    if(posicionIzq[i].getY()>0 && casilleros[posicionIzq[i].getX()][posicionIzq[i].getY()-1].getEstado()==false ) {
	      puedenMoverse++;
	    }
	  }
	  if(puedenMoverse!=posicionIzq.length){
	    return false;
	  } 
	  ParOrdenado[] posicionAbajo=tetriminoActual.getPosicionesAbajo((tetriminoActual.getRotacion()+1)%4);	
	  puedenMoverse=0;
	  for(int i=0; i<posicionAbajo.length ; i++) {
	    if(posicionAbajo[i].getX()<20 && casilleros[posicionAbajo[i].getX()+1][posicionAbajo[i].getY()].getEstado()==false ) {
		  puedenMoverse++;
	    }
	  }
	  if(puedenMoverse!=posicionAbajo.length){
	    return false;
	  }
	  tetriminoActual.rotar();
	  return true;
	}
	
	public boolean moverAbajo() { //retorna true cuando pudo bajar, false cuando no pudo. Es decir, false si colisionó
	  ParOrdenado[] posicionActual=tetriminoActual.getPosicionesAbajo(tetriminoActual.getRotacion());	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionActual.length ; i++) {
	    if(posicionActual[i].getX()<20 && casilleros[posicionActual[i].getX()+1][posicionActual[i].getY()].getEstado()==false ) {
		  puedenMoverse++;
	    }
	  }
	  if(puedenMoverse==posicionActual.length){
	    tetriminoActual.cambiarPosicion(1, 0);
	    return true;
	  }
	  this.colisiona();
	  return false;
	}
	
	private void colisiona(){
	  ParOrdenado[] posiciones=tetriminoActual.getPosicion();	
	  for(int i=0; i<posiciones.length; i++){
	    casilleros[posiciones[i].getX()][posiciones[i].getY()].setEstado(true);
	  }
	}
	
	private void generarTetrimino() {
	  Random rand= new Random();
	  int tetri= rand.nextInt(7);
	  switch (tetri) 
      {
	      case 0:  tetriminoSiguiente= new PiezaT();
	  
          case 1:  tetriminoSiguiente= new PiezaJ();
                   break;
          case 2:  tetriminoSiguiente= new PiezaL();
                   break;
          case 3:  tetriminoSiguiente= new PiezaI();
                   break;
          case 4:  tetriminoSiguiente= new PiezaO();
                   break;
          case 5:  tetriminoSiguiente= new PiezaS();
                   break;
          case 6:  tetriminoSiguiente= new PiezaZ();
                   break;
        
      }
	}
	
	public void actualizarTetriminoActual() {
	  tetriminoActual=tetriminoSiguiente;
	  this.generarTetrimino();
	}
	
	
	//consultas
	
	public boolean grillaLlena () {
		return false;
	}

	public boolean filaLlena(int fila) {
		return true;
	}
}
