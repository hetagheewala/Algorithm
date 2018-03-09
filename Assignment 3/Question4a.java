/*
 *
 * Question 4 (a) : Write a function sortedHasSum that takes a sorted array S of n numbers and another number x, and
returns a Boolean indicating whether or not there is a pair of numbers in S whose sum is x that is O(n).
Your implementation may not use a hash table (or any auxiliary data structure).
 */

import java.util.Scanner;

public class Question4a {
	private static Scanner scanner = new Scanner(System.in);
	
	public static boolean sortedHasSum(int[] S, int x) {
		
		int i=0;	//Array S start
		int j = S.length -1;	// Array S end

		while(i<j) {
			if(S[i] + S[j] == x) // pair of numbers found
				return true;
			else if (S[i] + S[j] < x) //pair sum is smaller than desire sum
				i++; 
			if (S[i] + S[j] > x) // pair sum is grater than desire sum
				j--;
		}
		return false;
	}
	
	public static void main(String args[]) {
		
		System.out.print( "Enter a value of sum X to find number pair: " );
		String input = scanner.nextLine();
		int sum = Integer.parseInt(input); // Entered sum
		int S[] = {3,8,12,20,27,30,40}; // sorted array
		 
		if(sortedHasSum(S,sum))
			 System.out.println("A pair of numbers is found in S whose sum is x");
		else
			System.out.println("A pair of numbers is not found in S whose sum is x");
	}
}
