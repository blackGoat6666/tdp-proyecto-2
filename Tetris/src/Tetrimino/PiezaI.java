package Tetrimino;


import ParOrdenado.ParOrdenado;

public class PiezaI extends Tetrimino{
	//atributos de instancia
	private ParOrdenado p1,p2,p3,p4;
	private int rotacion;
	ParOrdenado [] coordenadasActuales;
	//constructor
	public PiezaI() {
		p1= new ParOrdenado(0,3);
		p2= new ParOrdenado(0,4);
		p3= new ParOrdenado(0,5);
		p4= new ParOrdenado(0,6);
		coordenadasActuales = new ParOrdenado[3];
		coordenadasActuales[0]=p1;
		coordenadasActuales[1]=p2;
		coordenadasActuales[2]=p3;
		coordenadasActuales[3]=p4;
		
		rotacion=1;
		
	}
	public void cambiarPosicion(int x, int y) {
		
		
	}

	public void posicion2() {
		int columna=p3.getY();
		p1.setY(columna);
		p1.setX(p1.getX()-1);
		p3.setX(p3.getX()+1);
		p2.setY(columna);
		p4.setY(columna);
		p4.setX(p4.getX()+2);
		rotacion=2;
	
	}
	public void posicion3() {
		int piso=p3.getX();
		p1.setX(piso);
		p1.setY(p1.getY()+1);
		p3.setY(p3.getY()-1);
		p2.setX(piso);
		p4.setY(p4.getY()-2);
		p4.setX(piso);
		
		
		rotacion=3;
		
	}
	public void posicion4() {
		int columna=p3.getY();
		p1.setY(columna);
		p1.setX(p1.getX()+1);
		p3.setX(p3.getX()-1);
		p2.setY(columna);
		p4.setY(columna);
		p4.setX(p4.getX()-2);
		rotacion=4;
	
	}
	public void posicion1() {
		int piso=p3.getX();
		p1.setX(piso);
		p1.setY(p1.getY()-1);
		p3.setY(p3.getY()+1);
		p2.setX(piso);
		p4.setY(p4.getY()+2);
		p4.setX(piso);
		rotacion=1;
	
	}
	
}
