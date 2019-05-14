package Stack_And_Queue;

import java.util.EmptyStackException;

//String Queue
class StringQueueNode{
	
	public String info;
	public StringQueueNode next;
	

	public StringQueueNode(String el){
		this (el, null);
	}
	public StringQueueNode(String x , StringQueueNode ptr) {
		info = x; next = ptr;
	}
	
}


 class StringQueue {
	
	protected StringQueueNode head, tail;
	
	public StringQueue() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head==null;
	}

    String front() throws Exception
    { if(isEmpty()) throw new Exception();
      return(head.info);
    }

    public String  dequeue () throws Exception{
    	if(isEmpty()) throw new Exception();
    	String x = head.info;
	    if(head == tail)
	    	head = tail = null;
	    else
	    	head = head.next;
	    
	    return x;
	  }
	 
    public void enqueue(String x){ 
    	if(!isEmpty()) {
    		tail.next = new StringQueueNode(x);
			tail = tail.next;
    	}
    	else{
    		head = tail = new StringQueueNode(x);
        }
    }

	public void traverse() {
		int index = 0;
		for(StringQueueNode tmp = head; tmp!=null; tmp= tmp.next) {
			System.out.print(tmp.info +"("+index+")  ");
		}
		System.out.println();
	}
	public void clear() {
		head = tail = null;
	}
	
	public void addToHead(String x) {
		if(isEmpty()) head = null;
		head = new StringQueueNode(x, head);
		
	}

	
//	public void realToBinary(double x, int k) {
//		
//		
//		while(k>0) {
//			x = x*2;
//			if(x >= 1) {
//				x = x-1;
//				enqueue(1);
//				k--;
//			}else {
//				enqueue(0);
//				k--;
//				continue;
//			}
//		}
//		
//		System.out.print(".");
//		for(QueueNode tmp = head; tmp !=null; tmp = tmp.next)
//			System.out.print(tmp.info+"");
//	
//		
//	}
}
	
	
//String stack
class StringStackNode{
	String info;
	StringStackNode next;
	public StringStackNode(String x, StringStackNode p) {
		info = x; next = p;
	}
	public StringStackNode(String x) {
		this (x,null);
	}

}

class LinkedListStringStack{
	
	StringStackNode head;
	public LinkedListStringStack() {
		head = null;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void push(String x) {
		head =  new StringStackNode(x, head);
	}
	public void pushMany(String a[]) {
		for(int i=0; i<a.length; i++) {
			push(a[i]);
		}	
	}
	String top ()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return head.info;
	}
	String pop()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		String result = head.info;
		head = head.next;
		return result;
	}
	void traverse() {
		StringStackNode p = head;
		int index=0;
		while(p!=null) {
			System.out.println(p.info+" ("+index+") ");
			p = p.next;
			index++;
		}
	}
	void clear() {
		head = null;
	}
//	void reverse() {
//		StringStackNode re = head;
//		while(re.next != null) {
//			push(re.info);
//			re = re.next;
//		}
//	}
//	void decimalToBinary(int x) {
//		
//		while(x > 0) {
//			push(x % 2);
//			x = x / 2;
//		}
//		while(head != null) {
//			System.out.print(head.info + "");
//			head = head.next;
//		}
//		
//	}
}
	



public class String_Queue_Stack {

	public static void main(String[] args) {
		
		System.out.println("\n################ String Stack ############################\n");
		String a[] = {"hoa","hai","hung","ha","huong"};
		
		LinkedListStringStack l = new LinkedListStringStack();
		l.pushMany(a);
		l.traverse();
		l.push("hoang");
		System.out.println("\nAfter pushing into linked_stack:(String Stack)");
		l.traverse();
		
		
		System.out.println("\nTop of linked_stack:");
		System.out.println(l.top());
		l.traverse();
		System.out.println("\nAfter popping:");
		l.pop();
		l.traverse();
		System.out.println("\nAfter clearing:");
		l.clear();
		l.traverse();
	
		System.out.println("\n################ String Queue ############################\n");
		
		StringQueue q = new StringQueue();
		q.enqueue("An");
		q.enqueue("Khang");
		q.enqueue("Thinh");
		q.enqueue("Vuong");
		System.out.println("List of string queue:");
		q.traverse();
		
		try {
			System.out.println("\nAfter deleting from first(dequeuing):");
			q.dequeue();
			q.traverse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println("\nThe first element of list:");
			System.out.println(q.front());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Clear:");
		q.clear();


		
	}
		
	

}

