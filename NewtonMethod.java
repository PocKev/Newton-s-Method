package functionStuff;

import java.text.DecimalFormat;

public class NewtonMethod {
	static float error = 5;
	static final float mostPreciseError = (float) 0.000001;
	
	public NewtonMethod() {
		
	}
	
	static float nextGuess(float guess, PolynomialFunction f) {
		
		float newGuess = guess - f.evaluate(guess) / PolynomialFunction.theDerivativeWithRespectToXOf(f).evaluate(guess);
		error = Math.abs(newGuess - guess);
		//System.out.println(newGuess + "\t" + error);
		return newGuess;
	}
	
	static float doNewtonsMethod(float guess, PolynomialFunction f) {
		int counter = 0;
		while (error > mostPreciseError) {
			float newGuess = nextGuess(guess, f);
			guess = newGuess;
			//System.out.println(newGuess + "\t" + error);
			
			counter++;
			if (counter > 100) {
				System.out.println("overload error");
				return -99999;
			}
		}
		
		DecimalFormat df = new DecimalFormat("#.#####");
		//System.out.println(df.format(guess));
		return Float.parseFloat(df.format(guess));
		//System.out.println("f(" + df.format(guess) + ") = 0");
	}
	
}
