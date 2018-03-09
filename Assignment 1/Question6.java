/*
 * Question  6 : fib running slow for the smallest n = 38.
 * */

public class Question6 {

	public static long fib(int n) {
		if(n==0) // F0 = 0
			return 	0;
		else if(n==1) // F1 = 1
			return 1;
		else //Fn = F(n-1)+F(n-2)
			return fib(n-1)+fib(n-2);
	}

	public static void main(String args[]) {
		for(int i=1;i<=50;i++) {
			
			//function execution start time 
			long startTime = System.nanoTime();  //function execution start time
			 
			long result = fib(i);
			
			//function execution stop time 
			long stopTime = System.nanoTime();   
			
			// calculate elapsed time - convert nanosecond to millisecond (1 millisecond = 1,000,000 nanoseconds)
			long elapsedTime = (stopTime-startTime)/1000000; 
			
			System.out.println("fib: " + i + " = " + result+ " Elasped Time(ms): "+ elapsedTime);
		}
	}
}