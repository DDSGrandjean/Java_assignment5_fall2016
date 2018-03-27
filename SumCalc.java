/**
 * COMI2510 - Advanced Java Programming
 * November 21st, 2016
 * 
 * Program design to take a number, and add every
 * number together up to and including the given
 * number.
 * 
 * @author Dylan Grandjean
 */
import javax.swing.JOptionPane;

public class SumCalc 
{
	//Field:
	static int num;		
	
	/**
	 * main method - get user input and call on
	 * other methods to process collected input.
	 * @param args - Array of String.
	 */
	public static void main (String[] args)
	{	
		String input;
		int result;
		boolean keepGoing = true;
		
		do
		{
			//Promt user for input
			input = JOptionPane.showInputDialog(null, "Enter a whole number higher than 0.", "AwSum App!", JOptionPane.QUESTION_MESSAGE);
		
			//Test for valid input
			while(!checkString(input))
					input = JOptionPane.showInputDialog(null, "Please, enter a whole number higher than 0.", "AwSum App!", JOptionPane.QUESTION_MESSAGE);
		
			//Sum up all numbers in a recursive method and
			//return the result
			result = sumUp(num, num);
		
			//Print result
			JOptionPane.showMessageDialog(null, String.format("The sum of every number between 0 and %d is equal to:\n %,d", num, result), "Result", JOptionPane.INFORMATION_MESSAGE);
			result = JOptionPane.showConfirmDialog(null, "Would you like to enter a different number?");
			if(result == 1 || result == 2)
				System.exit(0);
			
		} while(keepGoing);
	}
	
	/**
	 * checkString method - checks a string to assess its \
	 * contant and whether it can be converted to an int or not.
	 * @param in - user input.
	 * @return Whether the string can be converted or not.
	 */
	public static boolean checkString(String in)
	{
		try
		{
			//Handle closing or canceling
			if(in == null)
				System.exit(0);
			
			//Attempts to convert String to int
			num = Integer.parseInt(in);
			
			if(num < 0)
				return false;
			else
				return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	/**
	 * sumUp - sums up all the numbers between 0 and n.
	 * @param n - Number to sum up to.
	 * @param i - Sentinel value.
	 * @return The addition of all the numbers previously added up to each other.
	 */
	public static int sumUp(int n, int i)
	{
		int number = i;
		if(i == 0)
			number = i;
		else
			number += sumUp(n, i - 1);
		
		return number;
	} 
}
