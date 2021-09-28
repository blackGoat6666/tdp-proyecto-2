package Tetrimino;

import ParOrdenado.ParOrdenado;

public class PiezaO extends Tetrimino{
	//atributos de instancia
	
	ParOrdenado [] coordenadasActuales;
	//constructor
	public PiezaO() {
		color="/Images/BloqueAmarillo.png";
		p1= new ParOrdenado(0,4);
		p2= new ParOrdenado(0,5);
		p3= new ParOrdenado(1,4);
		p4= new ParOrdenado(1,5);
		coordenadasActuales = new ParOrdenado[4];
		coordenadasActuales[0]=p1;
		coordenadasActuales[1]=p2;
		coordenadasActuales[2]=p3;
		coordenadasActuales[3]=p4;
		
		rotacion=1;
			
	}
	@Override
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
	@Override
	protected void posicion1() {
		rotacion=1;
	}
	@Override
	protected void posicion2() {
		rotacion=2;
		
	}
	@Override
	protected void posicion3() {
		rotacion=3;
	}
	@Override
	protected void posicion4() {
		rotacion=4;
		
	}
	public ParOrdenado[] getPosicion() {
        return coordenadasActuales;
    }
	public ParOrdenado[] colisionIzquierda(int rotacion) {
		ParOrdenado[] retorno = new ParOrdenado[2];
		retorno[0]=p1;
		retorno[1]=p3;
		return retorno;		
	}
	public ParOrdenado[] colisionDerecha(int rotacion) {
		ParOrdenado[] retorno = new ParOrdenado[2];
		retorno[0]=p2;
		retorno[1]=p4;
		return retorno;		
	}
	public ParOrdenado[] colisionPiso(int rotacion) {
		ParOrdenado[] retorno = new ParOrdenado[2];
		retorno[0]=p3;
		retorno[1]=p4;
		return retorno;		
	}
}