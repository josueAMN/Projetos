package SisFiguras;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraDeAreas {
	public static void main (String []args) {
		List<AreaCalculavel> formas= new ArrayList<AreaCalculavel>(); 
		
		Quadrado q = new Quadrado(2);
		Quadrado q1 = new Quadrado(3);
		Triangulo t = new Triangulo(1,2);
		Circulo c = new Circulo(10);
		formas.add(t);
		formas.add(q);
		formas.add(q1);
		formas.add(c);
		
		for(AreaCalculavel f:formas) {
			System.out.println(f.calcularArea());
		}
	}

}
