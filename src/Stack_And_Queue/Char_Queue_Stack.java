package Stack_And_Queue;
import java.util.EmptyStackException;

class CharacterQueueNode{
	
	public Character info;
	public CharacterQueueNode next;
	

	public CharacterQueueNode(Character el){
		this (el, null);
	}
	public CharacterQueueNode(Character x , CharacterQueueNode ptr) {
		info = x; next = ptr;
	}
	
}

class CharacterQueue {
	
	protected CharacterQueueNode head, tail;
	
	public CharacterQueue() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head==null;
	}

    Character front() throws Exception
    { if(isEmpty()) throw new Exception();
      return(head.info);
    }

    public Character  dequeue () throws Exception{
    	if(isEmpty()) throw new Exception();
    	Character x = head.info;
	    if(head ==tail)
	    	head = tail = null;
	    else
	    	head = head.next;
	    
	    return x;
	  }
	 
    public void enqueue(Character x){ 
    	if(!isEmpty()) {
    		tail.next = new CharacterQueueNode(x);
			tail = tail.next;
    	}
    	else{
    		head = tail = new CharacterQueueNode(x);
        }
    }

	public void traverse() {
		int index = 0;
		for(CharacterQueueNode tmp = head; tmp!=null; tmp= tmp.next) {
			System.out.print(tmp.info +"("+index+")  ");
		}
		System.out.println();
		
	}
	public void clear() {
		head = tail = null;
	}
	
	public void addToHead(Character x) {
		if(isEmpty()) head = null;
		head = new CharacterQueueNode(x, head);
		
	}
//	
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





















class NodeCharStack{
	
	Character info;
	NodeCharStack next;
	public NodeCharStack(Character x, NodeCharStack p) {
		info = x; next = p;
	}
	public NodeCharStack(Character x) {
		this (x,null);
	}

}

class LinkedStackChar{
	
	NodeCharStack head;
	public LinkedStackChar() {
		head = null;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void push(Character x) {
		head =  new NodeCharStack(x, head);
	}
	public void pushMany(Character a[]) {
		for(int i=0; i<a.length; i++) {
			
			push(a[i]);
		}	
	}
	Character top ()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return head.info;
	}
	Character pop()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		Character result = head.info;
		head = head.next;
		return result;
	}
	void traverse() {
		NodeCharStack p = head;
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
//		NodeCharStack re = head;
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

public class Char_Queue_Stack {
	
	public static void main(String[] args) {
		
		
		System.out.println("########### Char Stack ###################\n");
		Character [] a = {'a','b', 'c','d','e'};
		LinkedStackChar l = new LinkedStackChar();
		l.pushMany(a);
		l.traverse();
		l.push('a');
		System.out.println("\nAfter pust into linked_stack: ");
		l.traverse();
		System.out.println("\nTop of linked_stack:");
		System.out.println(l.top());
		l.traverse();
		System.out.println("\nAfter popping:");
		System.out.println("\nValue is:"+l.pop());
		l.traverse();
		System.out.println("\nAfter clearing:");
		l.clear();
		l.traverse();
		
		
		
		System.out.println("############Char Queue##############");
		CharacterQueue q = new CharacterQueue();
		q.enqueue('a');
		q.enqueue('b');
		q.enqueue('c');
		q.enqueue('d');
		q.enqueue('e');
		System.out.println("\nList Characters: ");
		q.traverse();
		System.out.println("\nAfter delete from first(dequeuing): ");
		try {
			q.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		q.traverse();
		System.out.println("\nThe first element of list:");
		try {
			System.out.println(q.front());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nClear:");
		q.clear();

		

		
	}
		
	

}
