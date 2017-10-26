/*
 * Filename: hw2.c
 * Author: Kavita Jain
 * Userid: A10560035
 * Login: cs12uag
 * Description: implementation of bubble sort in C
 * Date: 7/17/17
 * Source of Help:http://people.cs.vt.edu/~shaffer/Book/JAVA3elatest.pdf
 */

#include <stdio.h>
 
/* function declaration */
/* Sorts the array passed as a parameter using bubble sort */
void bubbleSort(int[], int); 

/*
 * Function prototype: int main()
 * Description: Main driver function.
 * Parameters: None.
 * Side Effects: Read from stdin and print to stdout
 * Error Conditions: None.
 * Return Value: 0 indicating successful termination
 */
int main() {
  int n; //This is the array size. you will need more variables

  printf("Enter the number of elements that will be in the array:\n");
  
  //use scanf to get an input (size of the array) from a user 
  scanf("%d", &n);
  
  printf("Enter %d integer%s:\n", n, ((n == 1) ? "" : "s"));
  
  //Now read the numbers and store them to an array 
  int array[n];
  int i;
  for (i = 0; i < n; i++) {
	  scanf("%d", &array[i]);
  }

  bubbleSort(array, n);

  printf("The sorted array is:\n");
  printf("[");
  for(i = 0; i < n; i++) {
    if(i != 0) {
      printf(", ");
    }
    printf("%d",array[i]);
  }
  printf("]\n");

  return 0;
}
 
/*
 * Function prototype: int bubbleSort(int a[], int n)
 * Description: function to sort an array in non-decreasing order
 * Parameters: a - int[] -- the input array to be sorted
 *             n - int   -- the size of array
 * Side Effects: None.
 * Error Conditions: None.
 * Return Value: None.
 */
void bubbleSort(int a[], int n) {
	int i;
	int j;
	int temp;
	for (i = 0; i < n - 1; i++) {
		for (j = n - 1; j > i; j--) {
			if (a[j] < a[j - 1]) {
				temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}
	}
}
  

