package Logica;

import GUI.GUI;
import Grilla.Grilla;

public class Logica {

    // atributos
    private int puntuacion;
    private Grilla miGrilla;
    private GUI miGUI;
    private Boolean jugando;

    //constructor
    public Logica (GUI interfaz) {
        puntuacion = 0;
        miGrilla = new Grilla();
        miGUI=interfaz;
        jugando=false;
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
      System.out.println(tiempo);
    }
    //consultas

    public int getPuntuacion () {
        return puntuacion;
    }

}