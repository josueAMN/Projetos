package Atividade_Interface_e_Classes_Abstratas;

public class MovableCircle implements Movable{
	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.radius = radius;
		this.center = new MovablePoint(x,y,xSpeed,ySpeed);
	}
	
	public String toString() {
		return"---Mobilidade do Raio---\nRaio de:["+this.radius+"]\nCentro:"+this.center.toString();
	}
	
	public void moveUp() {
		this.center.moveUp();
	}
	
	public void moveDown() {
		this.center.moveDown();
	}
	
	public void moveLeft() {
		this.center.moveLeft();
	}
	
	public void moveRight() {
		this.center.moveRight();
	}

}
