package Grilla;

import java.util.Random;

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
        this.generarTetrimino();
        this.actualizarTetriminoActual();
        miLogica = log;
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
	  ParOrdenado[] posicionActual=tetriminoActual.colisionIzquierda(tetriminoActual.getRotacion());	
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
	  ParOrdenado[] posicionActual=tetriminoActual.colisionDerecha(tetriminoActual.getRotacion());	
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
	  ParOrdenado[] posicionDer=tetriminoActual.colisionDerecha((tetriminoActual.getRotacion()+1)%4);	
	  int puedenMoverse=0;
	  for(int i=0; i<posicionDer.length ; i++) {
	    if(posicionDer[i].getY()<9 && casilleros[posicionDer[i].getX()][posicionDer[i].getY()+1].getEstado()==false ) {
	      puedenMoverse++;
        }
	  }
	  if(puedenMoverse!=posicionDer.length){
	    return false;  
	  }
	  ParOrdenado[] posicionIzq=tetriminoActual.colisionIzquierda((tetriminoActual.getRotacion()+1)%4);	
	  puedenMoverse=0;
	  for(int i=0; i<posicionIzq.length ; i++) {
	    if(posicionIzq[i].getY()>0 && casilleros[posicionIzq[i].getX()][posicionIzq[i].getY()-1].getEstado()==false ) {
	      puedenMoverse++;
	    }
	  }
	  if(puedenMoverse!=posicionIzq.length){
	    return false;
	  } 
	  ParOrdenado[] posicionAbajo=tetriminoActual.colisionPiso((tetriminoActual.getRotacion()+1)%4);	
	  puedenMoverse=0;
	  for(int i=0; i<posicionAbajo.length ; i++) {
	    if(posicionAbajo[i].getX()<20 && casilleros[posicionAbajo[i].getX()+1][posicionAbajo[i].getY()].getEstado()==false ) {
		  puedenMoverse++;
	    }
	  }
	  if(puedenMoverse!=posicionAbajo.length){
	    return false;
	  }
	  miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), null);
	  tetriminoActual.rotar();
	  miLogica.actualizarTetriminoGrafico( tetriminoActual.getPosicion(), new javax.swing.ImageIcon(getClass().getResource(tetriminoActual.getColor())));
	  return true;
	}
	
	public boolean moverAbajo() { //retorna true cuando pudo bajar, false cuando no pudo. Es decir, false si colisionó
	  ParOrdenado[] posicionActual=tetriminoActual.colisionPiso(tetriminoActual.getRotacion());	
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
	  this.colisiona();
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
	  int tetri= rand.nextInt(8);
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
          case 7:  tetriminoSiguiente= new PiezaT();
                   break;         
        
      }
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
	      System.out.println("casillero "+fila+" "+columna+" "+casilleros[fila][columna].getEstado());	
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
