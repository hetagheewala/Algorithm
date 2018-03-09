/*
 * Question 4 (b) : Write a function hasSum that is O(n log(n)) that does the same thing when S is an arbitrary array of
numbers. Your implementation may not use a hash table (or any auxiliary data structure).
 */

import java.util.Scanner;
import java.util.Arrays;

public class Question4b {

	private static Scanner scanner = new Scanner(System.in);
	
	// to sort unsorted array with O(n log(n)) time complexity
	public static int[] mergeSort(int[] S) { 
		if(S.length > 1) {
			int n=S.length; 
		
			//Split array into two parts recursively
			int[] a = Arrays.copyOfRange(S, 0, (n+1)/2); 
			mergeSort(a);
			int[] b = Arrays.copyOfRange(S, (n+1)/2, n);
			mergeSort(b);
			
			//Sort and merge array
			int i=0,j=0,k=0;
			while(i < a.length && j < b.length) {
				// Compare both arrays values and place small value in original array S
				if(a[i] < b[j]) { 
					S[k] = a[i];
					i++;
				}else {
					S[k] = b[j];
					j++;
				}
			k++; //Index of array S 		
			}
			
			while(i < a.length) { //remaining values in array a
				S[k] = a[i];
				i++;
				k++;
			}
			
			while(j < b.length) { //remaining values in array b
				S[k] = b[j];
				j++;
				k++;
			}
		}
		return S; // Time complexity: O(n log(n))
	}
	
	public static boolean hasSum(int[] S, int x) {
		
		int i=0;	//Array S start
		int j = S.length -1;	// Array S end
		int[] sortedS = mergeSort(S);
		
		//Sorted Array
		System.out.println("\nSorted Array: ");
		for(int t=0;t< sortedS.length;t++) {
			System.out.println(sortedS[t]);
		}
		
		while(i<j) {
			if(sortedS[i] + sortedS[j] == x) // pair of numbers found
				return true;
			else if (sortedS[i] + sortedS[j] < x) //pair sum is smaller than desire sum
				i++; 
			if (sortedS[i] + sortedS[j] > x) // pair sum is grater than desire sum
				j--;
		}
		return false; // Time complexity: O(n)
	}
	
	public static void main(String args[]) {
		
		System.out.print( "Enter a value of sum X to find number pair: " );
		String input = scanner.nextLine();
		int sum = Integer.parseInt(input); // Entered sum
		int S[] = {40,27,8,20,12,30,3}; // unsorted array
		 
		if(hasSum(S,sum)) // Time complexity: O(n log(n))
			 System.out.println("\nA pair of numbers is found in S whose sum is x");
		else
			System.out.println("\nA pair of numbers is not found in S whose sum is x");
	}

}
