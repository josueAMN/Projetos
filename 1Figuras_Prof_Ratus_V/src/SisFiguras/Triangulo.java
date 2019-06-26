package SisFiguras;

public class Triangulo implements AreaCalculavel{
	private double base;
	private double altura;
	
	public Triangulo(double b, double a) {
		this.base = b;
		this.altura = a;
	}
	public double calcularArea() {
		return (this.base*this.altura)/2;
	}
	
	public String toString() {
		return "O triângulo possui "+this.altura+" de altura e "+this.base+" de base";
	}

}
