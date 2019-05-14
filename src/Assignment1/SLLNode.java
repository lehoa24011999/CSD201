package Assignment1;

public class SLLNode <T>{
	T info;
	SLLNode <T> next;
	
	public SLLNode() {
	
		this (null, null);
		
	}
	public SLLNode(T el) {
		this(el, null);
	}
	
	public SLLNode(T el, SLLNode<T> ptr) {
		info = el; next = ptr;
	}

}

class SLL <T>{
	
	SLLNode<T> head, tail;
	
	public SLL() {
		
		head = tail = null;
		
	}
	
	
	public boolean isEmpty() {
		
		return head == null;
	}
	
	public void addToHead(T el) {
		
		head = new SLLNode<T>(el, head);
		
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

		
		SLLNode<T> p = head;
		
		while(p!=null) {
			
			System.out.print(p.info+"\t" );
			p = p.next;
			
		}
		
		
	}
	public void addToTail(T el) {
		
		if(!isEmpty()) {
			
			tail.next = new SLLNode<T>(el);
			tail = tail.next;
			
		}else {
			head = tail = new SLLNode<T>(el);
			
		}
		
	}
	public T delFromTail() {
		
		if(isEmpty()) 
			return null;
		
		T el = tail.info;
		if(head == tail) 
			head = tail =  null;

		else {
			
			SLLNode<T> tmp;
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
