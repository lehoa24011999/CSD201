package Sort;

public class SelectionSort {
	void sort(int arr[]){
		int n = arr.length;
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++){
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
			System.out.println("Step "+i+", min element "+min_idx);
			printArray(arr);
		}
	}
	void sort1(int arr[]){
		int n = arr.length;
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++){
				// Find the minimum element in unsorted array
				int min_idx = i;
				for (int j = i+1; j < n; j++)
					if ((arr[j] < arr[min_idx]) )
						min_idx = j;

				// Swap the found minimum element with the first
				// element
				int temp = arr[min_idx];
				arr[min_idx] = arr[i];
				arr[i] = temp;
				System.out.println("Step "+i+", min element "+min_idx);
				printArray(arr);
		}
	}

	// Prints the array
	void printArray(int arr[]){
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	// Driver code to test above
	public static void main(String args[]){
		SelectionSort ob = new SelectionSort();
		int arr[] = {8,9,7,9,3,2,3,8,4,1};
		System.out.println("The first array: ");
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}
