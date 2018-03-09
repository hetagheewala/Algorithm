/*
 * Question 3  : The time complexity of fibPow is O(log(n))
 * */

import java.util.Scanner;

public class Question3 {

	private static Scanner scanner = new Scanner(System.in);

	//Representation of L
	public static int[][] multiply(int[][] A, int[][] B){
		
		int c1 = A[0][0] * B[0][0] + A[0][1] * B[1][0];
		int c2 = A[0][0] * B[0][1] + A[0][1] * B[1][1];
		int c3 = A[1][0] * B[0][0] + A[1][1] * B[1][0];
		int c4 = A[1][0] * B[0][1] + A[1][1] * B[1][1];
		
		int [][] C = new int[][] {{c1,c2},{c3,c4}};
		return C;
	}
	
	//fib returns nth Fibonacci number
	public static int fib(int pow) {
		int[][] D = new int[][] {{1,1},{1,0}};
		int[][] E = new int[][] {{1,0},{0,0}};
		if(pow == 0) //Base case
			return 0;
		return multiply(fibPow(D, pow-1), E)[0][0]; //We require number at (0,0)
	}
	
	//fibPow using representation of L and power algorithm
	public static int[][] fibPow(int[][] D,int pow){

		if(pow ==0 || pow == 1) // Base case
			return D;
		else if(pow%2 == 0)
			return fibPow(multiply(D,D),pow/2);
		else if(pow%2 != 0)
			return multiply(D,fibPow(multiply(D,D),pow/2));
		else 
			return null;

	}
	
	public static void main(String args[]) {
		 System.out.print( "Enter a natural number n: " );
		 String input = scanner.nextLine();
		 int pow = Integer.parseInt(input); 
		 System.out.println(fib(pow));
	}

}
