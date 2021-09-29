package Tetrimino;

import ParOrdenado.ParOrdenado;

public class PiezaS extends Tetrimino{
	//atributos de instancia
    
	ParOrdenado [] coordenadasActuales;
	//constructor
	public PiezaS() {
		color="/Images/BloqueVerde.png";
		p1= new ParOrdenado(0,4);
		p2= new ParOrdenado(0,5);
		p3= new ParOrdenado(1,3);
		p4= new ParOrdenado(1,4);
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
	protected void posicion1() {
		p1.setX(p1.getX()-2);
		p2.setY(p2.getY()+2);
		rotacion=1;
		
	}
	protected void posicion2() {
		p2.setX(p2.getX()+2);
		p3.setY(p3.getY()+2);
		rotacion=2;
		
	}
	protected void posicion3() {
		p1.setX(p1.getX()+2);
		p2.setY(p2.getY()-2);
		rotacion=3;
	}
	protected void posicion4() {
		p2.setX(p2.getX()-2);
		p3.setY(p3.getY()-2);
		rotacion=4;
	}
	public ParOrdenado[] getPosicion() {
        return coordenadasActuales;
    }
	public ParOrdenado[] colisionIzquierda() {
		if(rotacion==1) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p1;
			retorno[1]=p3;
			return retorno;
		}
		else if (rotacion==2) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p1;
			retorno[1]=p4;
			retorno[2]=p2;
			return retorno;
		}
		else if (rotacion==3) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p2;
			retorno[1]=p4;
			return retorno;
		}
		else {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p2;
			retorno[1]=p3;
			retorno[2]=p1;
			return retorno;
		}		
	}
	public ParOrdenado[] colisionDerecha() {
		if(rotacion==1) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p2;
			retorno[1]=p4;
			return retorno;
		}
		else if (rotacion==2) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p1;
			retorno[1]=p3;
			retorno[2]=p2;
			return retorno;
		}
		else if (rotacion==3) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p3;
			retorno[1]=p1;
			return retorno;
		}
		else {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p2;
			retorno[1]=p4;
			retorno[2]=p1;
			return retorno;
		}		
	}
	public ParOrdenado[] colisionPiso() {
		if(rotacion==1) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p3;
			retorno[1]=p4;
			retorno[2]=p2;
			return retorno;
		}
		else if (rotacion==2) {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p4;
			retorno[1]=p2;
			return retorno;
		}
		else if (rotacion==3) {
			ParOrdenado[] retorno = new ParOrdenado[3];
			retorno[0]=p2;
			retorno[1]=p1;
			retorno[2]=p3;
			return retorno;
		}
		else {
			ParOrdenado[] retorno = new ParOrdenado[2];
			retorno[0]=p3;
			retorno[1]=p1;
			return retorno;
		}		
	}
	
}
