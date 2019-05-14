package Sort;

public class QuickSort_PivotMiddle {
	private int array[];
	private int length;

	public void sort(int[] inputArr) {

		if (inputArr == null || inputArr.length == 0) {
			return;
		}
		this.array = inputArr;
		length = inputArr.length;
		quickSort(0, length - 1);
	}

	private void quickSort(int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which 
			 * is greater then the pivot value, and also we will identify a number 
			 * from right side which is less then the pivot value. Once the search 
			 * is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
			System.out.println("Step "+i+",pivot "+pivot);
			print(array);
			
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private void print(int input[]) {
		for(int i:input){
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}
	public static void main(String a[]){

		QuickSort_PivotMiddle sorter = new QuickSort_PivotMiddle();
		int[] input = {8,9,7,9,3,2,3,8,4,6};
		sorter.sort(input);
		System.out.println("Array sorted: ");
//		for(int i:input){
//			System.out.print(i);
//			System.out.print(" ");
//		}
		sorter.print(input);
	}

}
