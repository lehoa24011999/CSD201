package Assgnment11;



class DLLNode{
	int info;
	DLLNode next, prev;
	
	public DLLNode() {
		next =null;
		prev = null;
	}
	public DLLNode(int el) {
		info = el ; next = null; prev = null;
	}
	public DLLNode(int el , DLLNode n, DLLNode p) {
		info = el;
		next = n;
		prev = p;
	}
	
}

public class DLL {
	DLLNode head =null ,tail = null;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addHead(int x) {
		if(head != null) {
			head = new DLLNode(x, head, null);
			head.next.prev = head;
		}
		else {
			tail = head = new DLLNode(x);
		}
	}
	public void addTail(int x) {
		if(tail != null) {
			tail = new DLLNode(x, null, tail);
			tail.prev.next = tail;
		}
		else {
			head = tail = new DLLNode(x);
		}
	}

	public void clear() {
		head = tail = null;
	}
	public void traverse() {
//		
//		while(!isEmpty()) {
//			System.out.print(head.info+" ");
//			head = head.next;
//		}
		
		for(DLLNode tmp = head; tmp!=null; tmp = tmp.next) {
			System.out.print(tmp.info + " ");
			
		}
		
	}
	public Integer firstEl() {
		
		if(!isEmpty())
			return head.info;
		else return null;
		
	}
	public Integer delFromHead() {
		int t = head.info;
		if(!isEmpty()) {
			head = head.next;
			head.prev = null;
		}
		else if(head == tail) 
			head = tail = null;
		else return null;
		
		return t;
	}
	public Integer delFromTail() {
		if(isEmpty()) return null;
		int t = tail.info;
		if(head == tail) {
			head = tail = null;
		}
		else {
			tail = tail.prev;
			tail.next = null;
			
		}
		return t;
		
	}
	public boolean find(int x) {
		for(DLLNode tmp =head; tmp!=null; tmp = tmp.next) {
			if(tmp.info == x) {
				return true;
			}
		}
		return false;
		
	}
	
	
	
	public static void main(String[] args) {
		DLL d = new DLL();
		
		System.out.println("Initial list: ");
		d.addHead(10);
		d.addHead(12);
		d.addHead(1);
		System.out.println("After adding to head:\n ");
		d.addHead(8);
		d.addHead(3);
		d.traverse();
		System.out.println("\nAfter adding to tail: \n");
		d.addTail(23);
		d.traverse();
//		System.out.println("\nAfter clearing: \n");
//		d.clear();
//		d.traverse();
		System.out.println("\nThe first elements: \n");
		System.out.println(d.firstEl());
		System.out.println("\nAfter deleting from head list: \n");
		d.delFromHead();
		d.traverse();
		System.out.println("\nAfter deleting from tail list: \n");
		d.delFromTail();
		d.traverse();
		System.out.println("Google Searching: ");
		if(d.find(12)==true) {
			System.out.println("\nSeached\n");
		}
		else System.out.println("\nNot Found!\n");
		
		
		
		
	}
		
	
	

}
