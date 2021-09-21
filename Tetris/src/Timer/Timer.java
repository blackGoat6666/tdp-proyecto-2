package Timer;

import Logica.Logica;

public class Timer implements Runnable {
    // atributos
   
	private Logica miLogica;
    private long tiempoBase;
    boolean correr;
    
    //constructor
    
    public Timer(Logica log) {
      miLogica=log;
      tiempoBase=System.currentTimeMillis();
      correr=true;
    }
    
    
    //metodos
    
    public void run() {
      while(correr) {
        try {
          miLogica.setTiempo(this.getTotalTime());
          if(this.segundos()% this.getVelocidad()==0) {
            miLogica.moverTetAbajo();
          }
          Thread.sleep(250);
        }
        catch(InterruptedException e) {
             e.printStackTrace();
        }
      }
    }
    public void terminar(){
      correr=false;
    }

    //consultas
    private String getTotalTime () {
      long segundos= this.segundos();
      long minutos= segundos/60;
      String retorno= new String("");
      retorno=(minutos+":");
      if(minutos<10) {
        retorno=("0"+minutos+":");
      }
      if(segundos<10) {
        retorno=retorno+("0"+segundos);
      }
      else {
        retorno=retorno+(segundos);
      }
      return (retorno);
    }
   
    
    private int getVelocidad() {
      if(this.segundos()>150) {
        return 500;
      }else { 
        if(this.segundos()>60) {
          return 725;
        }
        else {
          return 1000;
        }
      } 
    }

    private long segundos(){
      return (System.currentTimeMillis()-tiempoBase)/1000;
    }

}