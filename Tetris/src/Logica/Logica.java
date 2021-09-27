package Logica;

<<<<<<< HEAD
import javax.swing.ImageIcon;
=======
import javax.swing.JLabel;
>>>>>>> refs/remotes/origin/main

import GUI.GUI;
import Grilla.Grilla;
import ParOrdenado.ParOrdenado;
import Timer.Timer;

public class Logica {

    // atributos
    private int puntuacion;
    private Grilla miGrilla;
    private boolean jugando;
    private Timer miTimer;
    private JLabel lbltiempo;
    private JLabel lblpuntos;
    
    //constructor
    public Logica (JLabel tiempo, JLabel puntos) {
        puntuacion = 0;
<<<<<<< HEAD
        miGUI=interfaz;
=======
        miGrilla = new Grilla();
>>>>>>> refs/remotes/origin/main
        jugando=false;
        miGrilla = new Grilla(this);
        miTimer=new Timer(this);
        lbltiempo=tiempo;
        lblpuntos=puntos;
    }

    //metodos
    public void comenzarJuego(){
      jugando=true;
      miTimer.comenzar();
      puntuacion=0;
<<<<<<< HEAD
      miGUI.setLabelPuntuacion("0000");
=======
      lblpuntos.setText("0000");
>>>>>>> refs/remotes/origin/main
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
<<<<<<< HEAD
      miGUI.setLabelPuntuacion(""+puntuacion);
    }

    public void setTiempo(String tiempo) {
      miGUI.setLabelTiempo(tiempo);
    }
    
    public void actualizarTetriminoGrafico(ParOrdenado [] posiciones, ImageIcon imageIcon) {
    	if (posiciones != null) {
    		for (int i = 0; i < posiciones.length; i++) {
        		miGUI.graficarBloque(imageIcon, posiciones[i].getX(), posiciones[i].getY());
        	}
    	}
=======
      lblpuntos.setText(""+puntuacion);
    }

    public void setTiempo(String tiempo) {
      lbltiempo.setText(tiempo);  
>>>>>>> refs/remotes/origin/main
    }
    
    //consultas

    
    public Timer getTimer() {
      return miTimer;    
    }
}
