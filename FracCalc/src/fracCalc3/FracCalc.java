package fracCalc3;
import java.util.*;
public class FracCalc {

	public static void main(String[] args) 
	{
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter your equation (quit to quit): ");
		String equation = console.nextLine();
	

		while (!equation.toLowerCase().equals("quit")){
			checkFrac(equation);
			equation = console.nextLine();
			
		}
		}
	/**
	 * This method takes the user's input and determines whether they are integers, mixed fractions, fractions, or invalid
	 * 	then moving to the next method accordingly
	 * @param equation
	 * @return
	 */
public static String checkFrac(String equation){

	if(equation.length() < 5){
		System.out.println("Invalid Expression\n");
		System.out.print("Please enter your equation (type quit to quit): ");
		return null;
	}
	else if(equation.indexOf(" ") < 1){
		System.out.println("Invalid Expression");
		System.out.println("Please use spaces between fractions and operator");
		System.out.println("(Ex: 2_1/3 + 4_3/4)");
		System.out.print("Please enter your equation (type quit to quit): ");
		return null;
	}
	else if(!equation.contains("/") && !equation.contains("_")){
	String lNum = equation.substring(0, equation.indexOf(" ")); // First Number
	String operator = equation.substring(equation.indexOf(" ") + 1, equation.indexOf(" ") + 2); // Operator
	String rNum = equation.substring(equation.indexOf(" ") + 3, equation.length()); // Second Number
	int operand1 = Integer.parseInt(lNum); // Parses First Number into integer
	int operand2 = Integer.parseInt(rNum); // Parses Second Number into integer
	calcInt(operand1, operand2, operator); // Calculates Equation
	System.out.print("Please enter your equation (quit to quit): ");
	return null;	
	}
	else if(equation.contains("_")){ 
		String operator = equation.substring(equation.indexOf(" ") + 1, equation.indexOf(" ") + 2);
		toFracNumber(equation);
		System.out.print("Please enter your equation (quit to quit): ");
		return null;
	}
	else if(!equation.contains("_") && equation.contains("/") );{
		toFracNumber(equation);
		System.out.print("Please enter your equation (quit to quit): ");
		return null;
	}
}
			
	
/**
 * This method calculates if the inputs are integers
 * 	then printing out the resultant
 * @param operand1
 * @param operand2
 * @param operator
 * @return
 */
public static String calcInt(int operand1, int operand2, String operator){ // Calculates Integers
	if (operator.equals("+")){ 
		System.out.println(operand1 + operand2);
	}
	else if(operator.equals("-")){
		System.out.println(operand1 - operand2);
	}
	else if(operator.equals("/")){
		if (operand2 == 0){
			System.out.println("Undefined");
		}
		else{
		System.out.println(operand1 / operand2);
		}
	}
	else if(operator.equals("*")){
		System.out.println(operand1 * operand2);
	} 
	else if(operator.equals("^")){
		System.out.println(Math.pow(operand1, operand2));
	}
	else if (operator.equals("%")){
		System.out.println(operand1 % operand2);
	} 
	else {
		System.out.println("Invalid Expression");
	}
		return null;
	} 


/**
 * This method takes mixed numbers and turns them into improper fractions
 *  then moving down to the calculateFrac method
 * @param equation
 * @return
 */
	public static String toFracNumber(String equation)
	{
		String frac1 = equation.substring(0, equation.indexOf(" "));
		String frac2 = equation.substring(equation.indexOf(" ") + 3, equation.length());
		String operator = equation.substring(equation.indexOf(" ") + 1, equation.indexOf(" ") + 2);
		String fracNum1 = "placeholder";
		String fracNum2 = "placeholder";
		String equation2 = "placeholder";
		if(frac1.contains("_") && frac2.contains("_"))
		{
			String mixed1 = frac1.substring(0, frac1.indexOf("_"));
			String num1 = frac1.substring(frac1.indexOf("_") + 1, frac1.indexOf("/"));
			String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
			String mixed2 = frac2.substring(0, frac2.indexOf("_"));
			String num2 = frac2.substring(frac2.indexOf("_") + 1, frac2.indexOf("/"));
			String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
			int mixedNumber1 = Integer.parseInt(mixed1); // Parses Mixed Number
			int numerator1 = Integer.parseInt(num1); // Parses Numerator
			int denominator1 = Integer.parseInt(den1); // Parses Denominator
			int impNum1 = (mixedNumber1 * denominator1) + numerator1;
			int mixedNumber2 = Integer.parseInt(mixed2); // Parses Mixed Number
			int numerator2 = Integer.parseInt(num2); // Parses Numerator
			int denominator2 = Integer.parseInt(den2); // Parses Denominator
			int impNum2 = (mixedNumber2 * denominator2) + numerator2;
			fracNum1 = impNum1 + "/" + denominator1;
			fracNum2 = impNum2 + "/" + denominator2;
			equation2 = fracNum1 + " " + operator + " " + fracNum2;
			calculateFrac(operator, equation2);
			return equation2;
			//FracNumber fracNum1 = new FracNumber(impNum1, denominator1);
			// System.out.print(fracNum1 + " " + operator + " ");
			}
		else if(frac1.contains("_") && !frac2.contains("_"))
		{
			String mixed1 = frac1.substring(0, frac1.indexOf("_"));
			String num1 = frac1.substring(frac1.indexOf("_") + 1, frac1.indexOf("/"));
			String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
			int mixedNumber1 = Integer.parseInt(mixed1); // Parses Mixed Number
			int numerator1 = Integer.parseInt(num1); // Parses Numerator
			int denominator1 = Integer.parseInt(den1); // Parses Denominator
			int impNum1 = (mixedNumber1 * denominator1) + numerator1;
			//FracNumber fracNum2 = new FracNumber(impNum2, denominator2);
			// System.out.print(fracNum2);
			fracNum1 = impNum1+ "/" + denominator1;
			equation2 = fracNum1 + " " + operator + " " + frac2;
			calculateFrac(operator, equation2);
			return equation2;
		
			}
		else if(!frac1.contains("_") && frac2.contains("_")){
			String mixed2 = frac2.substring(0, frac2.indexOf("_"));
			String num2 = frac2.substring(frac2.indexOf("_") + 1, frac2.indexOf("/"));
			String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
			int mixedNumber2 = Integer.parseInt(mixed2); // Parses Mixed Number
			int numerator2 = Integer.parseInt(num2); // Parses Numerator
			int denominator2 = Integer.parseInt(den2); // Parses Denominator
			int impNum2 = (mixedNumber2 * denominator2) + numerator2;
			//FracNumber fracNum2 = new FracNumber(impNum2, denominator2);
			// System.out.print(fracNum2);
			fracNum2 = impNum2+ "/" + denominator2;
			equation2 = frac1 + " " + operator + " " + fracNum2;
			calculateFrac(operator, equation2);
			return equation2;
		
			
		}
		else{
			equation2 = frac1 + " " + operator + " " + frac2;
			calculateFrac(operator, equation2);
			return equation2;
		}

	}
	
	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	// 		e.g. input ==> "1/2 + 3/4"
	//	      
	// The function should return the result of the fraction after it has been calculated
	// 		e.g. return ==> "1_1/4"
	//
	
	
	/**
	 * This method takes and calculates the improper/regular fractions
	 * 	then moving to the simpFrac method
	 * @param operator
	 * @param equation2
	 * @return
	 */
	public static String calculateFrac(String operator, String equation2)
	{ 
		String frac1 = equation2.substring(0, equation2.indexOf(" "));
		String frac2 = equation2.substring(equation2.indexOf(" ") + 3, equation2.length());
			if(frac1.contains("/") && frac2.contains("/"))
			{
				String num1 = frac1.substring(0,frac1.indexOf("/"));
				String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
				String num2 = frac2.substring(0,frac2.indexOf("/"));
				String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
				int numerator1 = Integer.parseInt(num1); // Parses Numerator
				int denominator1 = Integer.parseInt(den1); // Parses Denominator
				int numerator2 = Integer.parseInt(num2); // Parses Numerator
				int denominator2 = Integer.parseInt(den2); // Parses Denominator
				if(operator.equals("+"))
					{ 
						int numerator3 = (numerator1 * denominator2) + (numerator2 * denominator1);
						int denominator3 = (denominator1 * denominator2);
						String frac3 =(numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if(operator.equals("-")){
						int numerator3 = (numerator1 * denominator2) - (numerator2 * denominator1);
						int denominator3 = (denominator1 * denominator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if(operator.equals("*")){
						int numerator3 = (numerator1 * numerator2);
						int denominator3 = (denominator1 * denominator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if (operator.equals("/")){
						int numerator3 = (numerator1 * denominator2);
						int denominator3 = (denominator1 * numerator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
			}
			if(!frac1.contains("/") && frac2.contains("/")){
				String num1 = frac1.substring(0,frac1.length());
				String num2 = frac2.substring(0,frac2.indexOf("/"));
				String den2 = frac2.substring(frac2.indexOf("/") + 1, frac2.length());
				int numerator1 = Integer.parseInt(num1); // Parses Numerator
				int numerator2 = Integer.parseInt(num2); // Parses Numerator
				int denominator2 = Integer.parseInt(den2); // Parses Denominator
				int denominator1 = 1; // whole number same denominator and numerator
				if(operator.equals("+"))
					{ 
						int numerator3 = (numerator1 * denominator2) + (numerator2 * denominator1);
						int denominator3 = (denominator1 * denominator2);
						String frac3 =(numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if(operator.equals("-")){
						int numerator3 = (numerator1 * denominator2) - (numerator2 * denominator1);
						int denominator3 = (denominator1 * denominator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if(operator.equals("*")){
						int numerator3 = (numerator1 * numerator2);
						int denominator3 = (denominator1 * denominator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if (operator.equals("/")){
						int numerator3 = (numerator1 * denominator2);
						int denominator3 = (denominator1 * numerator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
			}
			if(frac1.contains("/") && !frac2.contains("/"))
			{
				String num1 = frac1.substring(0,frac1.indexOf("/"));
				String den1 = frac1.substring(frac1.indexOf("/") + 1, frac1.length());
				String num2 = frac2.substring(0, frac2.length());
				int numerator1 = Integer.parseInt(num1); // Parses Numerator
				int denominator1 = Integer.parseInt(den1); // Parses Denominator
				int numerator2 = Integer.parseInt(num2); // Parses Numerator
				int denominator2 = 1; 
				if(operator.equals("+"))
					{ 
						int numerator3 = (numerator1 * denominator2) + (numerator2 * denominator1);
						int denominator3 = (denominator1 * denominator2);
						String frac3 =(numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if(operator.equals("-")){
						int numerator3 = (numerator1 * denominator2) - (numerator2 * denominator1);
						int denominator3 = (denominator1 * denominator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if(operator.equals("*")){
						int numerator3 = (numerator1 * numerator2);
						int denominator3 = (denominator1 * denominator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
					else if (operator.equals("/")){
						int numerator3 = (numerator1 * denominator2);
						int denominator3 = (denominator1 * numerator2);
						String frac3 = (numerator3 + "/" + denominator3);
						simpFrac(frac3, operator);
						return frac3;
					}
			}
				if(!frac1.contains("/") && !frac2.contains("/")){
					int operand1 = Integer.parseInt(frac1);
					int operand2 = Integer.parseInt(frac2);
					calcInt(operand1, operand2, operator);
				}
			
		return operator;
	}
	
	
	/**
	 * This method takes the simplified calculated fraction and turns it into a mixed number if needed
	 * 	then printing out the resultant
	 * @param frac4
	 * @param operator
	 * @return
	 */
	public static String toMixNumber(String frac4, String operator){
		String num4 = frac4.substring(0, frac4.indexOf("/"));
		String den4 = frac4.substring(frac4.indexOf("/") + 1, frac4.length());
		int numerator4 = Integer.parseInt(num4); // Parses Numerator
		int denominator4 = Integer.parseInt(den4); // Parses Denominator
		int numerator5 = numerator4 % denominator4;
		int denominator5 = denominator4;
		int mixed2 = (numerator4 - numerator5) / denominator4;
		numerator5 = Math.abs(numerator5);
		denominator5 = Math.abs(denominator5);
		if(mixed2 == 0){
			System.out.println(numerator5 + "/" + denominator5);
		}
		else if(numerator5 == 0){
			System.out.println(mixed2);
		}
		else{
		String result = mixed2 + "_" + numerator5 + "/" + denominator5;
		System.out.println(mixed2 + "_" + numerator5 + "/" + denominator5);
		return result;
		}
		return null;
	}
	
	/**
	 * This method takes the calculated fraction and simplifies it 
	 * 	then moving to the toMixNumber method
	 * @param frac3
	 * @param operator
	 * @return
	 */
	public static String simpFrac(String frac3, String operator){
		String num3 = frac3.substring(0, frac3.indexOf("/"));
		String den3 = frac3.substring(frac3.indexOf("/") + 1, frac3.length());
		int numerator3 = Integer.parseInt(num3); // Parses Numerator
		int denominator3 = Integer.parseInt(den3); // Parses Denominator
		int temp1 = numerator3;
	    int temp2 = denominator3; 
	    if(!(numerator3 == 0) && !(denominator3 == 0)){
	    	numerator3 = Math.abs(numerator3);
	    	denominator3 = Math.abs(denominator3);
	       while (numerator3 != denominator3){
	         if(numerator3 > denominator3)
	            numerator3 = numerator3 - denominator3;
	         else
	            denominator3 = denominator3 - numerator3;
	       }          
	      int n3 = temp1 / numerator3 ;
	      int n4 = temp2 / numerator3 ;
	      String frac4 = n3 + "/" + n4;
	      toMixNumber(frac4, operator);
	    }
	    else if(numerator3 == 0 && denominator3 != 0){
	    	System.out.print("0\n");
	    }
	    else if(numerator3 !=0 && denominator3 == 0){
	    	System.out.print("undefined\n");
	    }
	    else if(numerator3 == 0 && denominator3 == 0){
	    	System.out.print("0\n");
	    }
		return null;
	}
	
}