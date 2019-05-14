package Stack_And_Queue;



class QueueNode{
	
	public int info;
	public QueueNode next;
	

	public QueueNode(int el){
		this (el, null);
	}
	public QueueNode(int x , QueueNode ptr) {
		info = x; next = ptr;
	}
	
}


public class Queue {
	
	protected QueueNode head, tail;
	
	public Queue() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head==null;
	}

    int front() throws Exception
    { if(isEmpty()) throw new Exception();
      return(head.info);
    }

    public Integer  dequeue () throws Exception{
    	if(isEmpty()) throw new Exception();
	    int x = head.info;
	    if(head ==tail)
	    	head = tail = null;
	    else
	    	head = head.next;
	    
	    return x;
	  }
	 
    public void enqueue(int x){ 
    	if(!isEmpty()) {
    		tail.next = new QueueNode(x);
			tail = tail.next;
    	}
    	else{
    		head = tail = new QueueNode(x);
        }
    }

	public void traverse() {
		int index = 0;
		for(QueueNode tmp = head; tmp!=null; tmp= tmp.next) {
			System.out.print(tmp.info +"("+index+")  ");
		}
		System.out.println();
		
	}
	public void clear() {
		head = tail = null;
	}
	
	public void addToHead(int x) {
		if(isEmpty()) head = null;
		head = new QueueNode(x, head);
		
	}
	
	public void realToBinary(double x, int k) {
		
		
		while(k>0) {
			x = x*2;
			if(x >= 1) {
				x = x-1;
				enqueue(1);
				k--;
			}else {
				enqueue(0);
				k--;
				continue;
			}
		}
		
		System.out.print(".");
		for(QueueNode tmp = head; tmp !=null; tmp = tmp.next)
			System.out.print(tmp.info+"");
	
		
	}
	
	public static void main(String[] args) throws Exception {
		
		
		
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(7);
		q.enqueue(5);
		q.enqueue(1);
		q.enqueue(2);
		System.out.println("List elements of Queue: ");
		q.traverse();
		System.out.println("\nAfter delete from first(dequeuing): ");
		q.dequeue();
		q.traverse();
		System.out.println("\nThe first element of list:");
		System.out.println(q.front());
		System.out.println("\nClear:");
		q.clear();
		System.out.println("\nThe real number less than 1 to binary: ");
		q.realToBinary(0.625, 3);// k is the limit time else go to infinite;
	
	}

}
