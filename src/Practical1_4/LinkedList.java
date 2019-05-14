package Practical1_4;


 class LinkedListNode <T>{
	T info;
	LinkedListNode <T> next;

	public LinkedListNode() {

		this (null, null);

	}
	public LinkedListNode(T el) {
		this(el, null);
	}

	public LinkedListNode(T el, LinkedListNode<T> ptr) {
		info = el; next = ptr;
	}

}

 public class LinkedList <T>{

	 LinkedListNode <T> head, tail;

	public LinkedList() {

		head = tail = null;

	}


	public boolean isEmpty() {

		return head == null;
	}

	public void addToHead(T el) {
		head = new LinkedListNode<T>(el, head);
		if(tail==null)

			tail=head;


	}
	public T delFromHead() {

		if(!isEmpty()) head = head.next;
		return null;

	}

	public void addMany(T a[]) {

		for(int i=0; i< a.length; i++)
			addToHead(a[i]);

	}



	public void traverse() {


		LinkedListNode<T> p = head;

		while(p!=null) {

			System.out.print(p.info+"\t" );
			p = p.next;

		}


	}
	public void addToTail(T el) {

		if(!isEmpty()) {

			tail.next = new LinkedListNode<T>(el);
			tail = tail.next;

		}else {
			head = tail = new LinkedListNode<T>(el);

		}

	}
	public T delFromTail() {

		if(isEmpty()) 
			return null;

		T el = tail.info;
		if(head == tail) 
			head = tail =  null;

		else {

			LinkedListNode<T> tmp;
			for(tmp = head ; tmp.next!=tail; tmp = tmp.next);
			tail = tmp;
			tail.next = null;

		}

		return el;	

	}
	public void clear() {
		head = tail = null;
	}


}
