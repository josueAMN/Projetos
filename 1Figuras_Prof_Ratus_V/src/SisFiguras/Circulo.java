package SisFiguras;

public class Circulo implements AreaCalculavel{
	
	private double raio;
	
	public Circulo(double r) {
		this.raio = r;
	}
	
	public String toString() {
		return "O Circulo possui uma area de medida "+this.calcularArea();
	}
	
	public double calcularArea() {
		double area = (this.raio*this.raio)*3.14 ;
		return area;
	}
}