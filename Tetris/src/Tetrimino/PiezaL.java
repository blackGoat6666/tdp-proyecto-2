package Tetrimino;


import ParOrdenado.ParOrdenado;

public class PiezaL extends Tetrimino {
	//atributos de instancia
	private ParOrdenado p1,p2,p3,p4;
	private int rotacion;
	ParOrdenado [] coordenadasActuales;
	//constructor
	public PiezaL() {
		p1= new ParOrdenado(0,5);
		p2= new ParOrdenado(1,5);
		p3= new ParOrdenado(2,5);
		p4= new ParOrdenado(2,6);
		coordenadasActuales = new ParOrdenado[3];
		coordenadasActuales[0]=p1;
		coordenadasActuales[1]=p2;
		coordenadasActuales[2]=p3;
		coordenadasActuales[3]=p4;
		
		rotacion=1;
		
	}
	public void cambiarPosicion(int x, int y) {
		
	}

	public void posicion1() {
		p1.setY(p1.getY()+1);
		p1.setX(p1.getX()-1);
		p3.setY(p3.getY()-1);
		p3.setX(p3.getX()+1);
		p4.setX(p4.getX()+2);
		rotacion=1;
		
	}
	public void posicion2() {
		p1.setY(p1.getY()+1);
		p1.setX(p1.getX()+1);
		p3.setY(p3.getY()-1);
		p3.setX(p3.getX()-1);
		p4.setY(p4.getY()-2);
	}
	public void posicion3() {
		p1.setY(p1.getY()-1);
		p1.setX(p1.getX()+1);
		p3.setY(p3.getY()+1);
		p3.setX(p3.getX()-1);
		p4.setX(p4.getX()-2);
		rotacion=3;
	}
	public void posicion4() {
		p1.setY(p1.getY()-1);
		p1.setX(p1.getX()-1);
		p3.setY(p3.getY()+1);
		p3.setX(p3.getX()+1);
		p4.setY(p4.getY()+2);
		rotacion=4;
	}
}
