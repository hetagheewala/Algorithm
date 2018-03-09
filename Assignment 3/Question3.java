/*
 * Transform the tail-recursive binary search algorithm on arrays involving the two functions search and
searchHelp into a single imperative procedure search that performs the search using a while-loop. It should
take the same arguments and return the same results as the tail-recursive formulation in the notes.
 */

public class Question3 {

	public static boolean search(int[]a, int v, int l, int h) {
		
		int m;
		
		if(l > h) 								// FALSE if l>h
			return false;
		
		while(l<=h) {
			
			 m = (h+l)/2;
			
			 if(v == a[m])						// TRUE if v = a[m]
				 return true;
			 else if(v > a[m]) 					// searchHelp(a,v,m+1,h) if v > a[m]
				 l = m+1;
			 else if(v < a[m])					// searchHelp(a,v,l,m-1) if v < a[m]
				 h = m-1;
		}

		return false;
	}
	
	
	public static void main(String args[]) {
		
		int a[] = {3,8,12,20,27,30,40}; // sorted array
		int v = 8; // search 8 in array a
		int l = 0; 
		int h = a.length-1;
	
		if(search(a,v,l,h))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");
		
	}
}
