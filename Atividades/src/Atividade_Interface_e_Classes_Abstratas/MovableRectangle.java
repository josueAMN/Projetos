package Atividade_Interface_e_Classes_Abstratas;

public class MovableRectangle implements Movable{
	private MovablePoint upperLeft;
	private MovablePoint lowerRight;
	
	public MovableRectangle(int x1,int y1, int x2, int y2, int xSpeed, int ySpeed) {
		this.lowerRight = new MovablePoint(x1,y1,xSpeed,ySpeed);
		this.upperLeft = new MovablePoint(x2,y2,xSpeed,ySpeed);
	}
	
	public String toString() {
		return "Canto Superior Esquerdo: ["+this.upperLeft.toString()+"]\nCanto Inferior "
				+ "Direito: ["+this.lowerRight.toString()+"]";
		}

	public void moveUp() {
		this.lowerRight.moveUp();
		this.upperLeft.moveUp();
		
	}

	public void moveDown() {
		this.lowerRight.moveDown();
		this.upperLeft.moveDown();
		
	}

	public void moveLeft() {
		this.lowerRight.moveLeft();
		this.upperLeft.moveLeft();
		
	}

	public void moveRight() {
		this.lowerRight.moveRight();
		this.upperLeft.moveRight();
	}
	

}
