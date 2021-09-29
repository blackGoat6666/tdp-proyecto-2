package Grilla;

import java.util.Random;

import javax.swing.ImageIcon;

import Bloque.Bloque;
import Logica.Logica;
import ParOrdenado.ParOrdenado;
import Tetrimino.PiezaI;
import Tetrimino.PiezaJ;
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
	private Logica miLogica;
	
	//constructor
	

	public Grilla (Logica log) {
        casilleros = new Bloque[21][10];
        for(int filas=0; filas<casilleros.length ; filas++) {
            for(int columnas=0; columnas<casilleros[0].length; columnas++) {
              casilleros[filas][columnas]= new Bloque();
            }
          }
        miLogica = log;
        this.generarTetrimino();
        this.actualizarTetriminoActual();
        
    }
	
	//metodos
	
	
	
	public void borrarFilaLlena(int fila) {
	  boolean hayAlgo=true;
	  int filaActual=fila;
	  while(hayAlgo && filaActual>0){
	    hayAlgo=false;
	      for(int columna=0; columna<casilleros[0].length; columna++){
	        if(casilleros[filaActual][columna].getEstado()==true) {
	          hayAlgo=true;  
	        }
	        casilleros[filaActual][columna].setEstado(casilleros[filaActual-1][columna].getEstado());  
	        if(casilleros[filaActual][columna].getEstado()==false) {
	          miLogica.actualizarBloqueGrafico(filaActual, columna, null);  	
	        }
	        else {
	          String color=miLogica.getColor(filaActual-1, columna);
	          miLogica.actualizarBloqueGrafico(filaActual, columna, new javax.swing.ImageIcon(getClass().getResource(color)));
	        }
	      } 
	    filaActual--;
	  }
    }	

	public void moverIzquierda() {
	  ParOrdenado[] posicionActual=tetriminoActual.colisionIzquierda();	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionActual.length ; i++) {
	    if(posicionActual[i].getY()>0 && casilleros[posicionActual[i].getX()][posicionActual[i].getY()-1].getEstado()==false ) {
	      puedenMoverse++;
	    }
	  }
	  if(puedenMoverse==posicionActual.length){
		miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), null);
	    tetriminoActual.cambiarPosicion(0, -1);
	    miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), new javax.swing.ImageIcon(getClass().getResource(tetriminoActual.getColor())));
	  }
	}
	
	public void moverDerecha() {
	  ParOrdenado[] posicionActual=tetriminoActual.colisionDerecha();	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionActual.length ; i++) {
	    if(posicionActual[i].getY()<9 && casilleros[posicionActual[i].getX()][posicionActual[i].getY()+1].getEstado()==false ) {
		  puedenMoverse++;
		}
	  }
	  if(puedenMoverse==posicionActual.length){
	    miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), null);
	    tetriminoActual.cambiarPosicion(0, 1);
	    miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), new javax.swing.ImageIcon(getClass().getResource(tetriminoActual.getColor())));
	  }
	}
	
    public boolean girarTetrimino() {
	  ParOrdenado[] posicionDer=tetriminoActual.colisionDerecha();	
	  int puedenMoverse=0;
	  tetriminoActual.rotar();
	  for(int i=0; i<posicionDer.length ; i++) {
	    if(posicionDer[i].getY()<=9 && posicionDer[i].getY()>=0 && casilleros[posicionDer[i].getX()][posicionDer[i].getY()].getEstado()==false ) {
	      puedenMoverse++;
	    }
	  }
	  if(puedenMoverse!=posicionDer.length){
		for(int i=0; i<3; i++){
		  tetriminoActual.rotar();	
		}
	    return false;  
	  }
	  ParOrdenado[] posicionIzq=tetriminoActual.colisionIzquierda();	
	  puedenMoverse=0;
	  for(int i=0; i<posicionIzq.length ; i++) {
	    if(posicionIzq[i].getY()<=9 && posicionIzq[i].getY()>=0 && casilleros[posicionIzq[i].getX()][posicionIzq[i].getY()].getEstado()==false ) {
	      puedenMoverse++;
	    }
	  }
	  if(puedenMoverse!=posicionIzq.length){
		for(int i=0; i<3; i++){
		  tetriminoActual.rotar();	
		}  
	    return false;
	  } 
	  ParOrdenado[] posicionAbajo=tetriminoActual.colisionPiso();	
	  puedenMoverse=0;
	  for(int i=0; i<posicionAbajo.length ; i++) {
	    if(posicionAbajo[i].getX()<=20 && casilleros[posicionAbajo[i].getX()][posicionAbajo[i].getY()].getEstado()==false ) {
		  puedenMoverse++;
	    }
	  }
	  if(puedenMoverse!=posicionAbajo.length){
		for(int i=0; i<3; i++){
		  tetriminoActual.rotar();	
		}  
		return false;
	  }
	  for(int i=0; i<3; i++){
		  tetriminoActual.rotar();	
	  }
	  miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), null);
	  tetriminoActual.rotar();
	  miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), new javax.swing.ImageIcon(getClass().getResource(tetriminoActual.getColor())));
	  return true;
	}
	
	public boolean moverAbajo() { //retorna true cuando pudo bajar, false cuando no pudo. Es decir, false si colisionó
	  ParOrdenado[] posicionActual=tetriminoActual.colisionPiso();	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionActual.length ; i++) {
	    if(posicionActual[i].getX()<=19 && casilleros[(posicionActual[i].getX()+1)][posicionActual[i].getY()].getEstado()==false ) {
		  puedenMoverse++;
		}
	  }
	  if(puedenMoverse==posicionActual.length){
		miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), null);
	    tetriminoActual.cambiarPosicion(1, 0);
	    miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), new javax.swing.ImageIcon(getClass().getResource(tetriminoActual.getColor())));
	    return true;
	  }
	  return false;
	}
	
	public void colisiona(){
	  ParOrdenado[] posiciones=tetriminoActual.getPosicion();	
	  miLogica.actualizarTetriminoGrafico( posiciones, null);
	  for(int i=0; i<posiciones.length; i++){
	    casilleros[posiciones[i].getX()][posiciones[i].getY()].setEstado(true);
	    miLogica.actualizarBloqueGrafico( posiciones[i].getX(), posiciones[i].getY(), new javax.swing.ImageIcon(getClass().getResource(tetriminoActual.getColor())));
	  }
	  this.actualizarTetriminoActual();
	}
	
	private void generarTetrimino() {
	  Random rand= new Random();
	  int tetri= rand.nextInt(7);
	  switch (tetri) 
      {
	      case 0:  tetriminoSiguiente= new PiezaT();
	               break;
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
	  miLogica.actualizarProximoTetriminoGrafico(tetriminoSiguiente.getImagen());
	}
	
	public void actualizarTetriminoActual() {
	  tetriminoActual=tetriminoSiguiente;
	  this.generarTetrimino();
	}
	
	
	//consultas
	
	public boolean grillaLlena() {
	 ParOrdenado[] spawnea=tetriminoSiguiente.getPosicion();
	 for(int i=0; i<spawnea.length; i++) {
	   if(casilleros[spawnea[i].getX()][spawnea[i].getY()].getEstado()==true){
	     return true;  
	   }
	 }
	 return false;
	}

	public boolean filaLlena(int fila) {
	  for(int columna=0; columna<casilleros[0].length; columna++){
	    if(casilleros[fila][columna].getEstado()==false) {
	      return false;
	    }
	  }
	  return true;
	}
	
	public ParOrdenado getTetriminoFilas() {
	  ParOrdenado[] posiciones= tetriminoActual.getPosicion();
	  int masAbajo= posiciones[0].getX();
	  int masArriba= posiciones[0].getX();
	  for(int i=1; i<posiciones.length; i++) {
	    if(posiciones[i].getX()>masAbajo) {
	      masAbajo=posiciones[i].getX(); 	
	    }
	    if(posiciones[i].getX()<masArriba) {
		  masArriba=posiciones[i].getX(); 	
	    }
	  }
	  return new ParOrdenado(masAbajo,masArriba);
	}
	
	
}
