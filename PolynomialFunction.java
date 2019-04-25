package functionStuff;

import java.util.ArrayList;

public class PolynomialFunction {
	public ArrayList<Float> coefficients = new ArrayList<Float>();
	public int length;
	
	public PolynomialFunction(ArrayList<Float> c) {
		coefficients = c;
		length = coefficients.size();
		//index of coefficients is the power the term is raised to
	}
	
	public float evaluate(float x) {
		float result = 0;
		for (int i = 0; i < length; i++) {
			result += coefficients.get(i) * Math.pow(x, i);
		}
		return result;
	}
	
	public static PolynomialFunction theDerivativeWithRespectToXOf(PolynomialFunction f) {
		ArrayList<Float> derivativeCoefficients = new ArrayList<Float>();
		for (int i = 1; i < f.length; i++) {
			derivativeCoefficients.add(f.coefficients.get(i) * i);
		}
		PolynomialFunction derivativeFunction = new PolynomialFunction(derivativeCoefficients);
		return derivativeFunction;
	}

	@Override
	public String toString() {
		String statement = "f(x) = ";
		
		for (int i = length-1; i >= 0; i--) {
			statement += " + " + coefficients.get(i) + "x^" + i;
		}
		return statement;
	}

}
