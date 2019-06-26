package SisFiguras;

public class Quadrado implements AreaCalculavel{
	private double lado;
	
	public Quadrado(double tLados) {
		this.lado = tLados;
	}
	
	public String toString() {
		return "O quadrado possui lados de medida "+this.lado;
	}
	
	public double calcularArea() {
		return this.lado*this.lado;
	}

}
