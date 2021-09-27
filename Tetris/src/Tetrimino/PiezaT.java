package Tetrimino;

import ParOrdenado.ParOrdenado;

public class PiezaT extends Tetrimino{
	//atributos de instancia
	
	private int rotacion;
	ParOrdenado [] coordenadasActuales;
	//constructor
	public PiezaT() {
		color='v';
		p1= new ParOrdenado(0,5);
		p2= new ParOrdenado(1,4);
		p3= new ParOrdenado(1,5);
		p4= new ParOrdenado(1,6);
		coordenadasActuales = new ParOrdenado[4];
		coordenadasActuales[0]=p1;
		coordenadasActuales[1]=p2;
		coordenadasActuales[2]=p3;
		coordenadasActuales[3]=p4;
		rotacion=1;
			
	}
	@Override
	public void cambiarPosicion(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void posicion1() {
		p4.setY(p4.getY()+1);
		p3.setX(p3.getY()-1);
		rotacion=1;
		
	}
	@Override
	protected void posicion2() {
		p3.setX(p3.getX()+1);
		p2.setY(p2.getY()+1);
		rotacion=2;
		
	}
	@Override
	protected void posicion3() {
		p2.setY(p2.getY()-1);
		p1.setX(p1.getY()+1);
		rotacion=3;
		
	}
	@Override
	protected void posicion4() {
		p1.setX(p1.getX()-1);
		p4.setY(p4.getY()-1);
		rotacion=4;
		
	}
	public ParOrdenado[] getPosicion() {
        return coordenadasActuales;
    }
	public ParOrdenado[] colisionIzquierda(int rotacion) {
		if(rotacion==1) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p1;
			retorno[1]=p2;
			return retorno;
		}
		else if (rotacion==2) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p1;
			retorno[1]=p2;
			retorno[2]=p3;
			return retorno;
		}
		else if (rotacion==3) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p2;
			retorno[1]=p3;
			return retorno;
		}
		else {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p1;
			retorno[1]=p2;
			retorno[2]=p3;
			return retorno;
		}		
	}
	public ParOrdenado[] colisionDerecha(int rotacion) {
		if(rotacion==1) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p1;
			retorno[1]=p4;
			return retorno;
		}
		else if (rotacion==2) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p1;
			retorno[1]=p4;
			retorno[2]=p3;
			return retorno;
		}
		else if (rotacion==3) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p4;
			retorno[1]=p3;
			return retorno;
		}
		else {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p1;
			retorno[1]=p4;
			retorno[2]=p3;
			return retorno;
		}		
	}
	public ParOrdenado[] colisionPiso(int rotacion) {
		if(rotacion==1) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p2;
			retorno[1]=p3;
			retorno[2]=p4;
			return retorno;
		}
		else if (rotacion==2) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p3;
			retorno[1]=p4;
			return retorno;
		}
		else if (rotacion==3) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p2;
			retorno[1]=p3;
			retorno[2]=p4;
			return retorno;
		}
		else {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p2;
			retorno[1]=p3;
			return retorno;
		}		
	}
	
}