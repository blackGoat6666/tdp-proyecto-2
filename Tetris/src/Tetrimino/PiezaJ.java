package Tetrimino;

import ParOrdenado.ParOrdenado;

public class PiezaJ extends Tetrimino{
	//atributos de instancia
	
	private int rotacion;
	ParOrdenado [] coordenadasActuales;
	//constructor
	public PiezaJ() {
		color='a';
		p1= new ParOrdenado(0,3);
		p2= new ParOrdenado(1,3);
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
		// TODO Auto-generated method stub
		
	}
	protected void posicion1() {
		p1.setY(p1.getY()-1);
		p2.setX(p2.getX()-1);
		p4.setY(p4.getY()+1);
		p3.setX(p3.getX()-1);
		rotacion=1;
		
	}
	protected void posicion2() {
		p1.setY(p1.getY()+1);
		p3.setX(p3.getX()+1);
		p2.setY(p2.getY()+1);
		p3.setX(p4.getX()-1);
		rotacion=2;
	}
	protected void posicion3() {
		p2.setY(p2.getY()-1);
		p1.setX(p1.getX()+1);
		p3.setY(p3.getY()+1);
		p4.setX(p4.getX()+1);
		
		rotacion=3;
	}
	protected void posicion4() {
		p1.setX(p1.getX()-1);
		p2.setX(p2.getX()+1);
		p3.setY(p3.getY()-1);
		p4.setY(p4.getY()-1);
		rotacion=4;
	}
}
