/*
 * Question  8 : fibIt does not run slowly on the value of n=38 that I found made fib run slowly.
 * */

public class Question8 {

	public static long fibItHelper(long n,long a,long b) {
		if(n==0) //f(0;a,b) = a
			return 	a;
		else if(n==1) //f(1;a,b) = b
			return b;
		else 
			return fibItHelper(n-1,b,a+b); //f(n;a,b) = f(n-1;b,a+b)
	}
	
	public static void fitIt() {
		for(int i=1;i<=50;i++) {
			
			//function execution start time 
			long startTime = System.nanoTime();  //function execution start time
			 
			long a=0,b=1;
			
			long result = fibItHelper(i, a, b);
			
			//function execution stop time 
			long stopTime = System.nanoTime();   
			
			// calculate elapsed time - convert nanosecond to millisecond (1 millisecond = 1,000,000 nanoseconds)
			long elapsedTime = (stopTime-startTime)/1000000; 
			
			System.out.println("fib: " + i + " = " + result+ " Elasped Time(ms): "+ elapsedTime);
		}
	}
	
	public static void main(String args[]) {
		fitIt();
	}
}
