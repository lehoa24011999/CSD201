package SortPratical;

import java.util.Comparator;
import java.util.LinkedList;

public class RunEmployee implements Comparator<Employee>{
	private static 	RunEmployee e=new RunEmployee();
	private static LinkedList<Employee> listEm=new LinkedList<Employee>();
	
	private void bubbleSortAscending(LinkedList<Employee> listEm) {
		for (int i = 0; i < listEm.size(); i++) {

			for (int j = 0; j < listEm.size() - i - 1; j++) {
				//	            	listEm.get(j) < listEm.get(j + 1)
				if (e.compare(listEm.get(j), listEm.get(j+1)) > 0) {
					Employee temp = listEm.get(j);
					listEm.set(j, listEm.get(j + 1));
					listEm.set(j + 1, temp);

				}
			}
		}
	}
	private void bubbleSortDecending(LinkedList<Employee> listEm) {

		for (int i = 0; i < listEm.size(); i++) {

			for (int j = 0; j < listEm.size() - i - 1; j++) {
				//	            	listEm.get(j) < listEm.get(j + 1)
				if (e.compare(listEm.get(j), listEm.get(j+1)) < 0) {
					Employee temp = listEm.get(j);
					listEm.set(j, listEm.get(j + 1));
					listEm.set(j + 1, temp);

				}
			}
		}
	}
	private void insertionDecending(LinkedList<Employee> listEm) {
				int n = listEm.size(); 
				for (int i=1; i<n; ++i) { 
					Employee key = listEm.get(i); 
					int j = i-1; 
					/* Move elements of arr[0..i-1], that are 
		               greater than key, to one position ahead 
		               of their current position */
					while (j>=0 && e.compare(listEm.get(j), key) < 0) { 
						listEm.set(j+1, listEm.get(j));
						j = j-1; 
					} 
					listEm.set(j+1, key);
	}
}
	private void insertionAscending(LinkedList<Employee> listEm) {
		int n = listEm.size(); 
		for (int i=1; i<n; ++i) { 
			Employee key = listEm.get(i); 
			int j = i-1; 
			/* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
			while (j>=0 && e.compare(listEm.get(j), key) > 0) { 
				listEm.set(j+1, listEm.get(j));
				j = j-1; 
			} 
			listEm.set(j+1, key);
	}
}
	private void selectionDecending(LinkedList<Employee>listEm) {
		int n = listEm.size();
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++){
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				//				arr[j] < arr[min_idx]
				if (e.compare(listEm.get(j), listEm.get(min_idx))>0)
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			Employee temp = listEm.get(min_idx);
			listEm.set(min_idx, listEm.get(i));
			listEm.set(i, temp);	
		}
	}
	private void selectionAscending(LinkedList<Employee>listEm) {
		int n = listEm.size();
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++){
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				//				arr[j] < arr[min_idx]
				if (e.compare(listEm.get(j), listEm.get(min_idx)) < 0)
					min_idx = j;

			// Swap the found minimum element with the first
			// element
			Employee temp = listEm.get(min_idx);
			listEm.set(min_idx, listEm.get(i));
			listEm.set(i, temp);	
		}
	}
	public static void main(String[] args) {
		RunEmployee r=new RunEmployee();
		listEm.add(new Employee("A05", "Tran Quang", (short) 7));
		listEm.add(new Employee("A03", "Nguyen An", (short) 7));
		listEm.add(new Employee("A01", "Truong Phung", (short) 5));
		listEm.add(new Employee("A04", "Pham Thi Lam", (short) 2));
		listEm.add(new Employee("A02", "Do Trung Ton", (short) 5));

		System.out.println("Elements before  sorting: ");
		for(Employee em: listEm) {
			System.out.println(em);
		}
		System.out.println();
//		r.bubbleSortDecending(listEm);
//		System.out.println("Elements After bubble sorting (in Descending order): ");
//
//		for(Employee em: listEm) {
//			System.out.println(em);
//		}
//		System.out.println();
//		//bubble sorting (in ascending order)
//		r.bubbleSortAscending(listEm);
//		System.out.println("Elements After bubble sorting (in Ascending order): ");
//		for(Employee em: listEm) {
//			System.out.println(em);
//		}
//		System.out.println();

//		System.out.println("Elements After selection sorting (in Descending order): ");
//		r.selectionDecending(listEm);
//		for(Employee em: listEm) {
//			System.out.println(em);
//		}
//		System.out.println();
//		
//		System.out.println("Elements After selection sorting (in Ascending order): ");
//		r.selectionAscending(listEm);
//		for(Employee em: listEm) {
//			System.out.println(em);
//		}
//		System.out.println();
		
		System.out.println("Elements After insertion sorting (in Descending order): ");
		r.insertionDecending(listEm);
		for(Employee em: listEm) {
			System.out.println(em);
		}
		System.out.println();
		
		System.out.println("Elements After insertion sorting (in Ascending order): ");
		r.insertionAscending(listEm);
		for(Employee em: listEm) {
			System.out.println(em);
		}
		System.out.println();
		
	}

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getId().compareToIgnoreCase(o2.getId());
	}



}
