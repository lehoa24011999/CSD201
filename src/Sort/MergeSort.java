package Sort;

public class MergeSort {
	public static void mergeSort(int[] a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);
		System.out.println("\nAfter calling mergesort both left and right");
		println(a);
		merge(a, l, r, mid, n - mid);
		System.out.println("\nAfter calling merge method");
		println(a);

		
	}

	public static void merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}
	public static void println(int a[]) {
		for(int i=0; i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
	}

	public static void main(String[] args) {
		int[] a = { 5, 1, 6, 3, 2, 4 };

		System.out.println("Given array:");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		mergeSort(a, a.length);
		System.out.println("\nSorted array: ");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
	}

}
