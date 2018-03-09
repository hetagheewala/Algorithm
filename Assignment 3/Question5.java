/*
 * Implement quicksort so that the size of the stack is O(log n) regardless of running time. Hint:
Consider the order in which sub-problems are executed in the presence of tail-recursion. Your implementation
may not modify the partition algorithm.
*/

public class Question5 {
	
	public static int[] quicksort(int[] S, int startIndex, int endIndex) {
		int i = startIndex;
		int j = endIndex;
		int pivot = S[j];
		
		while(i<j) {
			
			while(S[i] < pivot) {
				i++;
			}
			
			while(S[j] > pivot) {
				j--;
			}
			
			//Swap : value found at lower index i is larger than upper index j value
			if(i<=j) {
				int t = S[i];
				S[i] = S[j];
				S[j] =t;
				i++;
				j--;
			}
			
			//Tail recursion
			if(startIndex < j)
				quicksort(S,startIndex,j);
			else if(i < endIndex)
				quicksort(S, i, endIndex);
					
		}
		
		return S; //Sorted array using quicksort
	}
	
	public static void main(String args[]) {
	
		int S[] = {40,27,8,20,12,30,3}; 
		S = quicksort(S,0,S.length-1);
		
		//Sorted Array
		System.out.println("\nSorted Array using quicksort: ");
		for(int t=0;t< S.length;t++) {
			System.out.println(S[t]);
		}		
	}
}
