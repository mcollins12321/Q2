/**
 * 
 */
package main;

import java.util.Scanner;

/**
 * @author GE60
 *
 */
public class Tuition {

	/**
	 * 
	 */
	public Tuition() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double initialTuition; //initial tuition rate
		double perIncrease; //percentage that the tuition increases every year
		double repayAPR; //the interest rate on repayment
		double years; //how many years the user plans to take to repay the loan
		double p; //perIncrease converted to use for calculations with percentages
		double totalTuition; //the total cost of the tuition over 4 years accounted for annual tuition increases
		double emp; //equated monthly payment
		double r;// repayAPR divided by 1200
		double months;// how many months the user plans to take to repay the student loan
		
		Scanner input = new Scanner(System.in);
		System.out.print("What is the initial cost of your tuition annually?");
		initialTuition=input.nextDouble();
		System.out.print("What is the expected percentage increase of your tuition annually?");
		perIncrease=input.nextDouble();
		System.out.print("What is the fixed APR on your student loan?");
		repayAPR=input.nextDouble();
		System.out.print("In how many years to you want to pay off your student loan?");
		years=input.nextDouble();
		input.close();
		/*
		 * This whole section above, from Scanner input to input.close, gathers information from the user
		 * to use as values for the variables in the calculations
		 */
		
		months = years*12;
		p = (perIncrease/100) + 1;
		totalTuition = initialTuition + (initialTuition*p) + (initialTuition*Math.pow(p, 2)) + (initialTuition*Math.pow(p, 3));//Calculates the total tuition over 4 years given an annual percentage increase in tuition
		r = repayAPR/1200;//a variable in the emp formula, simply the interest rate divided by 1200
		emp = (totalTuition * r * Math.pow(1+r, months))/(Math.pow(1+r, months)-1);//calculates the equated monthly payment using a standard formula given the principle amount, the interest rate, and how long the loan should last
		
		System.out.println(String.format("The total cost of your tuition for a 4 year degree will be $%1$,.2f",totalTuition));
		System.out.println(String.format("You will have to pay $%1$,.2f monthly to pay off your student loan",emp));
	}

}
