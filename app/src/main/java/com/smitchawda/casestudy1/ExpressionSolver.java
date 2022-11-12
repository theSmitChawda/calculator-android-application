package com.smitchawda.casestudy1;
/**
 * The Expression Solver class has been created
 * to be integrate in the Project-2 of the
 * ENGI35749 Internet of Things Applications
 * Course of Sheridan College - Fall 2022.
 *
 * HOW TO USE:
 * In order to use this class effectively,
 *
 * 1. Create an object of the class and pass the
 * 	  solvable equation as a parameter for the
 *    constructor
 *
 * 2. Call the evaluate() method to get the answer.
 *    Please note that by calling this method, you
 *    are expecting a Double value.
 *
 * @author Smit Chawda
 * @version 0.0.7
 */

public class ExpressionSolver {
/*Variables*/
	private String eqn;
/*Logic variables*/
	private int positionPointer;
	private char ch;

/*Constructors*/
	/**
	 * Constructor for the class
	 */
	public ExpressionSolver(String eqn) {
		super();
		setEqn(eqn);
	}


/*Logic methods*/
 /*Common logic and side methods*/

	/**
	 * Moves the positionPointer to the next
	 * character in our eqn string
	 *
	 * NOTE: The spaces are ignored in this class
	 */
	private void nextChar() {
		if(++this.positionPointer < this.eqn.length())
		{
			if(this.eqn.charAt(positionPointer)==' ')
			{
				nextChar();
			}
			else
			{
				this.ch = this.eqn.charAt(positionPointer);
			}
		}
		else
		{
			this.ch = (char)-1;
		}
	}

	/**
	 * Initializes the positionPointer variable
	 * each time a equation is provided to this
	 * class (in form of a String)
	 */
	private void _initPositionPointer() {
		this.positionPointer = -1;
	}

	/**
	 * Checks if the passed argument character is
	 * synchronized with the current pointing character
	 */
	private boolean checkOpr(char charToCheck){
		if(this.ch == charToCheck) {
			nextChar();
			return true;
		}
		return false;
	}

 /*Equation Parsing functions*/

	private double percentOperations(double val, double answer){
		System.out.println("% detected");
		answer = answer/100.0;
		answer = val * answer;
		return answer;
	}
	/**
	 * This method collects the
	 * operands to be processed.
	 *
	 * Addition and Subtraction has been
	 * handled by the unary operator at
	 * the beginning of the method
	 * @return Double
	 */
	private double parseSingleFactor(double val) {
		if(checkOpr('+'))
		{
			return +parseSingleFactor(val);
		}
		if(checkOpr('-'))
		{
			return -parseSingleFactor(val);
		}
		double answer=0.0;
		int startingPosition = positionPointer;
		if((ch>='0' && ch<='9') || ch=='.' || ch=='%')
		{
			/*numbers detected*/
			while((ch>='0' && ch<='9') || ch=='.')
			{
				nextChar();
			}
			answer = Double.parseDouble(eqn.substring(startingPosition, positionPointer));
			if(ch=='%')
			{
				answer=percentOperations(val,answer);
				nextChar();
			}
		}
		else if(ch=='e')
		{
			/*Move inside the brackets*/
			while(!(ch>='0' && ch<='9'))
			{
				nextChar();
			}
			/*Find for the last ')' bracket and pass the
			 *String as in the new ExpressionSolver object*/
			String str="";
			while(!checkOpr(')')) {
				str = str + this.ch;
				nextChar();
			}
			answer = Math.exp(new ExpressionSolver(str).evaluate());
		}
		else
		{
			throw new RuntimeException("Unexpected: '" + (char)ch+"' character.");
		}
		return answer;
	}

	/**
	 * This method collects the operands
	 * and performs multiplication/division
	 * as mentioned in the equation.
	 *
	 * NOTE: addition and subtraction
	 * has been handled in the parseSingleFactor() method.
	 * @return Double
	 */
	private double parseDoubleFactors() {
		double answer = parseSingleFactor(0);
		while(true)
		{
			if(checkOpr('*'))
			{
				answer = answer * parseSingleFactor(answer);
			}
			else if(checkOpr('/'))
			{
				try {
					answer = answer / parseSingleFactor(answer);
				}
				catch(ArithmeticException e)
				{
					System.out.println("Wrong division found.");
					System.out.println("Check for division by zero");
					e.printStackTrace();
				}
			}
			else
			{
				return answer;
			}
		}
	}

	/**
	 * Performs addition/subtraction on the
	 * terms formed by the two methods below
	 * @return Double
	 */
	private double parseCombinedTerm() {
		double answer = parseDoubleFactors();
		while(true)
		{
			if(checkOpr('+'))
			{
				answer = answer+parseSingleFactor(answer);
			}
			else if(checkOpr('-'))
			{
				answer = answer - parseSingleFactor(answer);
			}
			else
			{
				return answer;
			}
		}
	}

	/**
	 * The main method of this class call this to start solving
	 * the given equation
	 *
	 * The logic will flow sequentially downwards
	 * @return a Double variable
	 */
	public double evaluate() {
		/*Jump pointer to the next char*/
		nextChar();
		double answer = parseCombinedTerm();
		return answer;
	}

/*Non-logic methods*/

	/**
	 * This method is used to set the equations
	 * @param eqn
	 */
	public void setEqn(String eqn) {
		this.eqn = eqn;
		_initPositionPointer();
	}
}