/* have a String produceAnswer(String input)
main method to have a scanner with user input
method reads one line of input and passes that into produceAnswer
produce answer breaks that into 3 new strings: first operand (fraction), operator[+-/*] and
second operand (fraction)
produceAnswer should return the second operand
main will print result in produceAnswer


*/


package fracCalc;


import java.util.*;

public class FracCalc {

	public static void main(String[] args) 
	{
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner userInput = new Scanner(System.in);
		System.out.println("");
		String equation = userInput.nextLine();
		while (!equation.contentEquals("quit")) {
			String secondOperand = produceAnswer(equation);
			System.out.println("" + secondOperand);
			equation = userInput.nextLine();
		}
		System.out.println("");
		
	}


	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	//      e.g. input ==> "1/2 + 3/4"
	//        
	// The function should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	public static String produceAnswer(String input)
	{ 
		// TODO: Implement this function to produce the solution to the input

		// get input from user
		/* have a String produceAnswer(String input)
			*main method to have a scanner with user input
			*		method reads one line of input and passes that into produceAnswer
			*		produce answer breaks that into 3 new strings: first operand (fraction), operator[+-/*] and
			*		second operand (fraction)
			*		produceAnswer should return the second operand
			*		main will print result in produceAnswer
			*		checkpoint1
			*
			* Checkpoint 2:  produceAnswer returns string with "whole: X numerator:Y denominator:Z"
			*   Take each operand and break it into substrings for whole,num, denom - based upon '_' '\'
			*       if '/' exists, use .indexOf, substring
			*       getOperWhole, getOperFrac, getOperNumer, getOperDenom  
			*       
		*/
		
		
		
		
		
		int firstSpace = input.indexOf(' ');
		String firstOperand = input.substring(0, firstSpace);
		int secondSpace = input.lastIndexOf(' ');
		String secondOperand = input.substring(secondSpace+1, input.length());
		String operator = input.substring(firstSpace+1, secondSpace);
		return secondOperand;
	}

	//make a sentinel loop until user types quit
	//main will call produceAnswer
	//both of the operands break into three variables (numerator, denominator, whole number)
	//produceAnswer() should return"whole:x numerator:y denominator:z"
	/* split fraction into 3 parts using if tests- if there is '_' behind= whole number; if no '/' then it is a whole
	 * if there is no fraction then numerator is 0 and denominator is 1
	 * if '/' then the numbers in front are numerator and behind are denominator
	 * if no whole number it will return whole: 0
	 */

	

}
