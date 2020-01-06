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
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter equation: ");
		String userInput = sc.nextLine();
		while (!userInput.equalsIgnoreCase("quit")){
			System.out.println(produceAnswer(userInput));
			System.out.print("Enter equation: ");
			userInput = sc.nextLine();
		}
	}
	


	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
	//      e.g. input ==> 
	//        
	// The function should return the result of the fraction after it has been calculated
	//      e.g. return ==> "1_1/4"
	public static String produceAnswer(String input) {
		String temp = input;
		String operand1 = temp.substring(0, temp.indexOf(' '));
		temp = temp.substring(temp.indexOf(' ') + 1);
		String operator = temp.substring(0, temp.indexOf(' ')); 
		temp = temp.substring(temp.indexOf(' ') + 1);
		String operand2 = temp;
		
		
		String oper2WholeComp = findWhole(operand2);
		String oper2Num = findNum(operand2);
		String oper2Denom = findDenom(operand2);
		
		String oper1WholeComp = findWhole(operand1);
		String oper1Num = findNum(operand1);
		String oper1Denom = findDenom(operand1);
		
		String chckPnt2Ans =  "whole:" + oper2WholeComp + " numerator:" + oper2Num +
				" denominator:" + oper2Denom + "\n" + "whole:" + oper1WholeComp + " numerator:" + oper1Num +
				" denominator:" + oper1Denom;
		return chckPnt2Ans;
	}

	public static String findWhole (String s) {
		// if mixed number (3_4/5) contains '_' then-
		if(s.contains("_")) {
			return s.substring(0, s.indexOf('_'));
		}
		// if plain fraction (3/7) will contain "/" then-
		else if(s.contains("/")) {
			return "0";
		}
		else return s;
	}
		
	
	public static String findNum(String s) {
		//if '_' is present then from "_" to "/" is numerator
		if(s.contains("_")) {
			return s.substring(s.indexOf('_') + 1, s.indexOf('/'));
		}
		//if no '_' then move on to '/'
		else if(s.contains("/")) {
			return s.substring(0, s.indexOf('/'));
		}
		//if no num return 0
		else {
			return "0";
		}
	}
	
	public static String findDenom (String s) {
		//if '/' is present then number following is denominator
		if(s.contains("/")) {
			return s.substring(s.indexOf("/") + 1);
		}
		//if no denom return 1
		else {
			return "1";
		}
	}

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
