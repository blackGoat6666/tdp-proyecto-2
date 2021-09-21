package Logica;

import GUI.GUI;
import Grilla.Grilla;
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

    public void moverTetAbajo () {
      if(jugando==true) { 
        miGrilla.moverAbajo();
      }
    }

    public void girarTetrimino () {
      if(jugando==true) { 
        miGrilla.girarTetrimino();
      }
    }

    public void acelerarTetrimino () {

    }

    public void terminarJuego () {

    }

    public void sumarPuntos (int puntos) {

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