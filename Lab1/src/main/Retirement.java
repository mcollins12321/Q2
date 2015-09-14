package main;
/**
 * 
 */

/**
 * Matt Collins & Vincent Fierro
 *
 */
import java.io.*;//a Java package that allows for input and output 
import java.util.Scanner;
import org.apache.poi.ss.formula.functions.FinanceLib; // methods for financial calculations. 
//Matt Collins & Vincent Fierro
public class Retirement {
	/**
	* @param args
	*/
	public static void main(String[] args) {
		/*
		double sem; //declare a decimal variable sem for Save Each Month
		int ytk; //declare an integer variable ytk for Years To Work
		double annRetSav; //declare a decimal variable  annRet for Annual Return for savings
		double saveNeed; //declare a decimal variable saveNeed for What you need saved
		int yearRetire; //declare and integer variable yearRetire for Years Retired
		double annRetRet; //declare a decimal variable annRetRet for Annual Return for returns/drawing
		double reqIn; //declare a decimal variable reqIn for Required Income
		double monthly; //declare a decimal variable monthly for Monthly SSI
		*/
		
		// VARIABLE DECLARATIONS
		int yrsWork; // years until retirement
		int yrsRetire; // years planned to be retired. 
		double savings; // amt that must be saved before retirement
		double reqIncome; // total monthly income required once retired
		double pmtIN; // amt saved each month while working
		double pmtOUT; // monthly payment provided by savings during retirement
		double pmtSSI; // monthly payment by Social Security
		double annRtnWorking; // return on investment while working
		double annRtnRetired; // return on investment while retired
		
		int pmtInterval = 12; // the annual frequency of payments; used in calculations. 
		double fv = 0; // future value of investments at the end of retirement; used in calculations
		double pv = 0; // present value of investments at the start of the saving period; used in calculations. 
		
		Scanner input = new Scanner(System.in); // Decl. & init. a Scanner.
		
		
		// RETRIEVING INPUT FROM THE USER
		System.out.print("How many more years do you plan on working?"); // prompt
		yrsWork = input.nextInt(); //read in the input
	    
		System.out.print("What is the expected annual return on your investment while working? \nPlease enter the value as a decimal. (No \"%\" symbol)"); 
	    annRtnWorking = input.nextDouble(); 
	    
	    System.out.print("How many years do you plan to be retired for?"); 
	    yrsRetire = input.nextInt(); 
	    
	    System.out.print("What is the expected annual return on your investment once retired? \nPlease enter the value as a decimal. (No \"%\" symbol)"); 
	    annRtnRetired = input.nextDouble(); 
	    
	    System.out.print("What is your required monthly income once retired?  $"); 
	    reqIncome = input.nextDouble(); 
	    
	    System.out.print("What will be your monthly social security payment? $"); 
	    pmtSSI = input.nextDouble(); 
	    
	    input.close();
	    
	    // CALCULATIONS
	    pmtOUT = reqIncome - pmtSSI; // determine required monthly retirement payment
	    savings = FinanceLib.pv((annRtnRetired / pmtInterval), (pmtInterval * yrsRetire), pmtOUT, fv, false); // calc amt needed at retirement
	    pmtIN = FinanceLib.pmt((annRtnWorking / pmtInterval), (pmtInterval * yrsWork), pv, savings, false); // calc payment during working life
	    savings *= -1; // due to the equation savings is returned as a negative number, this corrects that. 
	    
	    // OUTPUT 
	    System.out.print(String.format("To receive $ %1$,.2f every month of retirement you would need to save $ %2$,.2f" + 
	    		" every month while working, for a total of $ %3$,.2f at the point of retirement.",pmtOUT, pmtIN, savings)); 
	    
		}
}
