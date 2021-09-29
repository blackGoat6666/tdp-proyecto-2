package Logica;

import javax.swing.ImageIcon;
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
        miGUI=interfaz;
        jugando=false;
        miGrilla = new Grilla(this);
        miTimer=new Timer(this);
    }

    //metodos
    public void comenzarJuego(){
      jugando=true;
      miTimer.comenzar();
      puntuacion=0;
      miGUI.setLabelPuntuacion("0000");

    }

    public void moverTetIzq() {
      if(jugando==true) {
        miGrilla.moverIzquierda();
      }
    }

    public void moverTetDer() {
      if(jugando==true) {
        miGrilla.moverDerecha();
      }
    }

    public void moverTetAbajo(){
      if(jugando) {
        boolean bajo=  miGrilla.moverAbajo(); 
        if(!bajo){ 
          int filasLlenas=0;
          ParOrdenado filas= miGrilla.getTetriminoFilas();
          miGrilla.colisiona();
          int[] filasABorrar= new int[4];
          for(int i=filas.getY(); i<=filas.getX(); i++ ){
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
            for(int i=0; i<filasLlenas; i++){
              miGrilla.borrarFilaLlena(filasABorrar[i]);
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
      miGUI.setGameOver();
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
      miGUI.setLabelPuntuacion(""+puntuacion);
    }

    public void setTiempo(String tiempo) {
      miGUI.setLabelTiempo(tiempo);
    }
    
    public void actualizarTetriminoGrafico(ParOrdenado [] posiciones, ImageIcon imageIcon, String ruta) {
    	if (posiciones != null) {
    		for (int i = 0; i < posiciones.length; i++) {
    			
        		miGUI.graficarBloque(imageIcon, posiciones[i].getX(), posiciones[i].getY(), ruta);
    			
            }
    	}
    }

    public void actualizarBloqueGrafico(int x, int y, ImageIcon imageIcon, String ruta) {
    	miGUI.graficarBloque(imageIcon, x, y, ruta );
    		
    }
    
    
    //consultas

    
    public Timer getTimer() {
      return miTimer;    
    }
    public String getColor(int x, int y) {
        return miGUI.getColor(x, y);	
  	}
}
