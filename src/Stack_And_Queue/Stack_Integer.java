package Stack_And_Queue;

import java.util.EmptyStackException;


public class Stack_Integer {
	
	public static void main(String[] args) {
		int a[] = {2,6,7,8,1};
		
		LinkedStack l = new LinkedStack();
		System.out.println("List Integer Stack: ");
		l.pushMany(a);
		l.traverse();
		System.out.println("After push into linked_stack:");
		l.push(10);
		l.traverse();
		System.out.println("Top of linked_stack: \n");
		System.out.println(l.top());
		l.traverse();
		System.out.println("After pop:");
		l.pop();
		System.out.println("Value of top is:"+l.pop()+"\n");
		l.traverse();
		System.out.println("After clearing:");
		l.clear();
		l.traverse();
		System.out.print("Decimal to Binary: \n");
		l.decimalToBinary(10);

	}
		
	

}


class Node{
	int info;
	Node next;
	public Node(int x, Node p) {
		info = x; next = p;
	}
	public Node(int x) {
		this (x,null);
	}

}

class LinkedStack{
	Node head;
	public LinkedStack() {
		head = null;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void push(int x) {
		head =  new Node(x, head);
	}
	public void pushMany(int a[]) {
		for(int i=0; i<a.length; i++) {
			push(a[i]);
		}	
	}
	int top ()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return head.info;
	}
	int pop()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		int result = head.info;
		head = head.next;
		return result;
	}
	void traverse() {
		Node p = head;
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
//		Node re = head;
//		while(re.next != null) {
//			push(re.info);
//			re = re.next;
//		}
//	}
//	
	void decimalToBinary(int x) {
		
		while(x > 0) {
			push(x % 2);
			x = x / 2;
		}
		while(head != null) {
			System.out.print(head.info + "");
			head = head.next;
		}
		
	}
	
	
	
}

