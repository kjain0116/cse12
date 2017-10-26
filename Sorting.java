/* 
* NAME: Kavita Jain
* PID: A10560035
* LOGIN: cs12uag
*/

package hw2;

/**
* Sorting compares the efficiency of shell sort vs. counting sort
* 
* @author Kavita Jain
* @version %I%, %G% 
* @since %G%
*/
public class Sorting {

	/**
	 * main method that runs benchmarking on shell sort and 
	 * counting sort
	 * @param args
	 */
	public static void main(String[] args) {
		
		int n = 2000;
		int[] array;
		
		for(int k = 5000; k <= 20000; k+= 500) {
			
			array = new int[n];
			
			for(int i = 0; i < array.length; i++) {
				array[i] = (int)(Math.random()*k);
			}
			
			array[(int)(Math.random()*(n-1))] = 0;
			array[(int)(Math.random()*(n-1))] = k;
			
			
			long totalTime = 0;
			int numberOfRuns = 1000;
			for(int j = 1; j <= numberOfRuns; j++) {
				
				long start = System.nanoTime();
				shellSort(array);
				long finish = System.nanoTime();
				totalTime += finish - start;
				
			}
			
			long avg = totalTime/numberOfRuns;
			System.out.println("For Shell Sort with k: "+k+ " the average time is "+avg);
			array = null;
			System.gc();
		}
		
		for(int k = 5000; k <= 20000; k+= 500) {
			
			array = new int[n];
			
			for(int i = 0; i < array.length; i++) {
				array[i] = (int)(Math.random()*k);
			}
			
			array[(int)(Math.random()*(n-1))] = 0;
			array[(int)(Math.random()*(n-1))] = k;
			
			
			long totalTime = 0;
			int numberOfRuns = 1000;
			for(int j = 1; j <= numberOfRuns; j++) {
				
				long start = System.nanoTime();
				countingSort(array, k + 1);
				long finish = System.nanoTime();
				totalTime += finish - start;
				
			}
			
			long avg = totalTime/numberOfRuns;
			System.out.println("For Counting Sort with k: "+k+ " the average time is "+avg);
			array = null;
			System.gc();
		}
		
	}
	
	/**
	 * implementation of counting sort
	 * used source:
	 * http://www.geeksforgeeks.org/counting-sort/
	 * @param arr is the integer array
	 * @param k is the maximum value found in the array
	 */
	public static void countingSort(int[] arr, int k) {
		
		int n = arr.length;
		 
        // The output character array that will have sorted arr
        int output[] = new int[n];
 
        // Create a count array to store count of inidividual
        // characters and initialize count array as 0
        int count[] = new int[k];
        for (int i=0; i<k; ++i)
            count[i] = 0;
 
        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];
 
        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=k-1; ++i)
            count[i] += count[i-1];
 
        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }
 
        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];
	}

	/**
	 * implementation of shell sort
	 * used sources:
	 * https://www.youtube.com/watch?v=pGhazjsFW28
	 * https://en.wikipedia.org/wiki/Shellsort
	 * @param arr is the integer array
	 */
	public static void shellSort(int[] arr) {
		
		int N = arr.length;
		
		int h = 1;
		while(h < N/3)
			h = 3*h + 1;
		
		while(h >= 1) {
			
			//h-sort the array
			for(int i = h; i < N; i++) {
				
				int temp = arr[i];
				int j;
				for(j = i;  j >= h && arr[j-h] > temp; j -= h) {
					
					arr[j] = arr[j-h];
				}
				
				arr[j] = temp;
				
			}
			
			h = h/3;
		}
	}
	
}
