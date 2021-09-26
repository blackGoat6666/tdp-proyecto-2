package Logica;

import GUI.GUI;
import Grilla.Grilla;
import ParOrdenado.ParOrdenado;
import Timer.Timer;

public class Logica {

    // atributos
    private int puntuacion;
    private Grilla miGrilla;
    private GUI miGUI;
    private boolean jugando;
    private Timer miTimer;
    
    //constructor
    public Logica (GUI interfaz) {
        puntuacion = 0;
        miGrilla = new Grilla();
        miGUI=interfaz;
        jugando=false;
        miTimer=new Timer(this);
    }

    //metodos
    public void comenzarJuego(){
      jugando=true;
      miTimer.comenzar();
    }

    public void moverTetIzq () {
      if(jugando==true) {
        miGrilla.moverIzquierda();
      }
    }

    public void moverTetDer () {
      if(jugando==true) {
        miGrilla.moverDerecha();
      }
    }

    public void moverTetAbajo (){
      if(jugando) {
        boolean bajo=  miGrilla.moverAbajo(); 
        if(!bajo){ 
          int filasLlenas=0;
          ParOrdenado filas= miGrilla.getTetriminoFilas();
          int[] filasABorrar= new int[4];
          for(int i=filas.getX(); i>=filas.getY(); i-- ){
            if(miGrilla.filaLlena(i)) {
              filasABorrar[filasLlenas]=i;
              filasLlenas++;
            }
          }
          if(filasLlenas==0 && filas.getY()<=3) {
            if(miGrilla.grillaLlena()) {
              this.terminarJuego();
            }
          }
          if(filasLlenas>0){
            for(int i=1; i<=filasLlenas; i++){
              miGrilla.borrarFilaLlena(filasABorrar[filasLlenas-i]);
            }
            this.sumarPuntos(filasLlenas);
          }
        }
       }
     }
   

    public void girarTetrimino () {
      if(jugando==true) { 
        miGrilla.girarTetrimino();
      }
    }

    public void terminarJuego () {
      jugando=false;
      miTimer.terminar();
    }

    public void sumarPuntos (int cantFilas) {
      switch (cantFilas) 
       {
  	    case 1:  puntuacion+=100;
                     break;
        case 2:  puntuacion+=200;
                     break;
        case 3:  puntuacion+=500;
                     break;
        case 4: puntuacion+=800;
                     break;
      }
    }

    public void setTiempo(String tiempo) {
      miGUI.setLabelTiempo(tiempo); 
    }
    
    //consultas

    public int getPuntuacion () {
        return puntuacion;
    }
  
    public Timer getTimer() {
      return miTimer;	
    }
}