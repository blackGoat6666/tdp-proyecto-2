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
      tiempoBase=0;
      correr=false;
    }

    
    //metodos
    public void comenzar(){
     correr=true;
     tiempoBase=System.currentTimeMillis();
    }
    
    
    public void run() {
      while(correr) {
        try {
          miLogica.setTiempo(this.getTotalTime());
          miLogica.moverTetAbajo();
          Thread.sleep(this.getVelocidad());
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
      segundos=segundos%60;
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
          return 750;
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