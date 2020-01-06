package fracCalc;


import java.util.*;

public class FracCalc {

	public static void main(String[] args) 
    {
        int exit = 0;
        Scanner in = new Scanner(System.in);
        while (exit == 0)
        {
            System.out.println("Enter an equation: ");
            String input0 = in.nextLine();
            input0 = input0.toLowerCase();
            if (input0.equals("quit"))
            {
                exit++;
                System.out.println("End Program");
            }
            else
            {
                System.out.println(produceAnswer(input0));
            }
        }
        in.close();
        // TODO: Read the input from the user and call produceAnswer with an equation
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
        String inputSplit = input;
        int firstSpace = input.indexOf(" ");
        int operator;
        String plusPlace = "+ ";
        String minusPlace = "- ";
        String dividePlace = "/ ";
        String multiplyPlace = "* ";
        if (input.indexOf(plusPlace) != 1);
        {
            operator = input.indexOf("+");
        }
        if (input.indexOf(minusPlace) != -1)
        {
            operator = input.indexOf("-", 1);
        }
        if (input.indexOf(multiplyPlace) != -1)
        {
            operator = input.indexOf("*");
        }
        if (input.indexOf(dividePlace) != -1)
        {
            operator = input.indexOf(dividePlace);
        }
 
       
        String operand1 = inputSplit.substring(0, firstSpace);
        String operand2 = inputSplit.substring(operator + 2, input.length());
       
        int underscore1 = operand1.indexOf("_"); // Operand 1
        int divide1 = operand1.indexOf("/");
        String whole1 = "0";
        String numerator1 = "0";
        String denominator1 = "1";
        if (underscore1 == -1 && divide1 == -1) // If there is only a whole number
        {
            underscore1 = operand1.length();
            numerator1 = "0";
            denominator1 = "1";
            whole1 = operand1.substring(0, underscore1);
        }
        if (divide1 != -1 && underscore1 == -1) // If there is only a fraction
        {
           whole1 = "0";
           numerator1 = operand1.substring(0, divide1);
           denominator1 = operand1.substring(divide1 + 1, operand1.length());
        }
        if (divide1 != -1 && underscore1 != -1) // If there is both a fraction and whole number
        {
            whole1 = operand1.substring(0, underscore1);
            numerator1 = operand1.substring(underscore1 + 1, divide1);
            denominator1 = operand1.substring(divide1 + 1, operand1.length());
        }
       
        int underscore2 = operand2.indexOf("_"); // Operand 2
        int divide2 = operand2.indexOf("/");
        String whole2 = "0";
        String numerator2 = "0";
        String denominator2 = "1";
        if (underscore2 == -1 && divide2 == -1) // If there is only a whole number
        {
            underscore2 = operand2.length();
            numerator2 = "0";
            denominator2 = "1";
            whole2 = operand2.substring(0, underscore2);
        }
        if (divide2 != -1 && underscore2 == -1) // If there is only a fraction
        {
           whole2 = "0";
           numerator2 = operand2.substring(0, divide2);
           denominator2 = operand2.substring(divide2 + 1, operand2.length());
        }
        if (divide2 != -1 && underscore2 != -1) // If there is both a fraction and whole number
        {
            whole2 = operand2.substring(0, underscore2);
            numerator2 = operand2.substring(underscore2 + 1, divide2);
            denominator2 = operand2.substring(divide2 + 1, operand2.length());
        }
       
        int wholeFin, numeratorFin, denominatorFin;
        String wholeFinal = "0";
        String numeratorFinal = "0";
        String denominatorFinal = "1";
        if (input.indexOf(plusPlace) != 1); // Addition
        {
            wholeFin = Integer.parseInt(whole1) + Integer.parseInt(whole2);
                                                   
            wholeFinal = Integer.toString(wholeFin);
        }
        if (input.indexOf(minusPlace) != -1) // Subtraction
        {
            operator = input.indexOf("-", 1);
        }
        if (input.indexOf(multiplyPlace) != -1) // Multiplication
        {
            operator = input.indexOf("*");
        }
        if (input.indexOf(dividePlace) != -1) // Division
        {
            operator = input.indexOf(dividePlace);
        }
       
        return "whole:" + whole2 + " numerator:"  + numerator2 + " denominator:" + denominator2 + " operand1: " + operand1 + " operand2: " + operand2 + "\n" + " whole:" + whole1 + " numerator:"  + numerator1 + " denominator:" + denominator1;
        // TODO: Implement this function to produce the solution to the input
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
}