package Assignment1;

public class Test {

	public static void main(String[] args) {
		
		SLL<Integer> lList = new SLL<Integer>();
		
		Integer [] a = {3,5,6,2,5};
		 
		lList.addMany(a);
		lList.traverse();
		lList.addToHead(10);
		System.out.println("\nAfter add to head: \n");
		lList.traverse();
		
		lList.addToTail(6);
		System.out.println("\nAfter add to tail:\n");
		lList.traverse();
		
		lList.delFromHead();
		
		System.out.println("\nAfter delete from head:\n");
		lList.traverse();
		
		lList.delFromTail();

		System.out.println("\n After delete from tail: \n");
		lList.traverse();
		

		System.out.println();		
		
		
	}

}
