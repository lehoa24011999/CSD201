package Sort;

public class QuickSortHeadPivot {

	/* This function takes last element as pivot, 
	       places the pivot element at its correct 
	       position in sorted array, and places all 
	       smaller (smaller than pivot) to left of 
	       pivot and all greater elements to right 
	       of pivot */
	private static int partition1(int[] arr, int low, int high)
	{
		int left, right, pivot_item = arr[low];
		left = low;
		right = high;
		while(left <= right)
		{
			while(arr[left] <= pivot_item)
			{
				left++;
			}
			while(arr[right] > pivot_item)
			{
				right--;
			}
			if(left < right)
			{
				swap(arr, left, right);
			}
		}
		arr[low] = arr[right];
		arr[right] = pivot_item;
		return right;
	}
	private static void swap(int[] arr, int left, int right) {
		int temp= arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
		
	}
	int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high];  
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than or 
			// equal to pivot 
			if (arr[j] <= pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	      arr[] --> Array to be sorted, 
	      low  --> Starting index, 
	      high  --> Ending index */
	  void sort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is  
	              now at right place */
			int pi = partition1(arr, low, high); 
			System.out.println("patition is "+pi);
			// Recursively sort elements before 
			// partition and after partition 
			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	/* A utility function to print array of size n */
	 static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

	// Driver program 
	public static void main(String args[]) 
	{ 
		int arr[] = {10, 7, 8, 9, 1, 5}; 
		int n = arr.length; 

		QuickSortHeadPivot ob = new QuickSortHeadPivot(); 
		ob.sort(arr, 0, n-1); 

		System.out.println("sorted array"); 
		printArray(arr); 
	} 


}
