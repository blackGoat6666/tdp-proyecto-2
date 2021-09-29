package Tetrimino;

import ParOrdenado.ParOrdenado;

public abstract class Tetrimino {

    // atributos
    protected int rotacion;
    protected String color;
    protected ParOrdenado p1,p2,p3,p4;
    protected ParOrdenado [] coordenadasActuales;

     //constructor ---

    //metodos
    public void cambiarPosicion(int x, int y) {
        if (y !=0) {
            p1.setY(p1.getY()+y);
            p2.setY(p2.getY()+y);
            p3.setY(p3.getY()+y);
            p4.setY(p4.getY()+y);
        }
        if(x==1) {
            p1.setX(p1.getX()+1);
            p2.setX(p2.getX()+1);
            p3.setX(p3.getX()+1);
            p4.setX(p4.getX()+1);
        }
    }


    public void rotar() {
        if (rotacion==1)
            this.posicion2();
        else
            if (rotacion==2)
                this.posicion3();
            else
                if (rotacion==3)
                    this.posicion4();
                else 
                    this.posicion1(); 
    }
    
    public String getColor() {
    	return color;
    }
    
    protected abstract void posicion1();
    protected abstract void posicion2();
    protected abstract void posicion3();
    protected abstract void posicion4();


    //consultas--
    public ParOrdenado[] getPosicion() {
        return coordenadasActuales;
    }


    public int getRotacion() {
      return rotacion;
    }


    public abstract ParOrdenado[] colisionIzquierda();


    public abstract ParOrdenado[] colisionDerecha();


    public abstract ParOrdenado[] colisionPiso();

}