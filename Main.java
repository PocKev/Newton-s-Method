package functionStuff;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	@SuppressWarnings({ "resource" })
	public static void main(String... args) {
		float input;
		ArrayList<Float> coeff = new ArrayList<Float>();
		Scanner sc = new Scanner(System.in);
		boolean stop;
		
		do {
			stop = false;
			System.out.println("Enter all the coefficients from highest term to lowest term");
			
			try {
				input = sc.nextFloat();
				coeff.add(0, input);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				stop = true;
			}
			
		} while (!stop);
		PolynomialFunction function = new PolynomialFunction(coeff);
		
		//System.out.println(PolynomialFunction.theDerivativeWithRespectToXOf(function));
		//System.out.println(PolynomialFunction.theDerivativeWithRespectToXOf(function).evaluate(5));
		System.out.println(function);
		System.out.println("f(5) = " + function.evaluate(5));
		
		float zero = NewtonMethod.doNewtonsMethod(0, function);
		System.out.println("f(" + zero + ") = 0");
	}
}
