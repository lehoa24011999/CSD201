package Stack_And_Queue;

import java.util.ArrayList;
import java.util.EmptyStackException;

class Student{
	String id;
	String name;
	
	public Student(String id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " +this.id+ " "+"Name: "+this.name;
	}
	
}

class ObjectQueueNode{
	
	public Student info;
	public ObjectQueueNode next;
	

	public ObjectQueueNode(Student el){
		this (el, null);
	}
	public ObjectQueueNode(Student x , ObjectQueueNode ptr) {
		info = x; next = ptr;
	}
	
}

class ObjectQueue {
	
	protected ObjectQueueNode head, tail;
	
	public ObjectQueue() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head==null;
	}

    Student front() throws Exception
    { if(isEmpty()) throw new Exception();
      return(head.info);
    }

    public Student  dequeue () throws Exception{
    	if(isEmpty()) throw new Exception();
    	Student x = head.info;
	    if(head ==tail)
	    	head = tail = null;
	    else
	    	head = head.next;
	    
	    return x;
	  }
	 
    public void enqueue(Student x){ 
    	if(!isEmpty()) {
    		tail.next = new ObjectQueueNode(x);
			tail = tail.next;
    	}
    	else{
    		head = tail = new ObjectQueueNode(x);
        }
    }

	public void traverse() {
		int index = 0;
		for(ObjectQueueNode tmp = head; tmp!=null; tmp= tmp.next) {
			System.out.print(tmp.info +"("+index+")  ");
			index++;
		}
		
	}
	public void clear() {
		head = tail = null;
	}
	
	public void addToHead(Student x) {
		if(isEmpty()) head = null;
		head = new ObjectQueueNode(x, head);
		
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













class NodeObject{
	Student info;
	NodeObject next;
	
	public NodeObject(Student x, NodeObject p) {
		info = x; next = p;
	}
	public NodeObject(Student x) {
		this (x,null);
	}

}

class LinkedStackObject{
	NodeObject head;
	public LinkedStackObject() {
		head = null;
	}
	public boolean isEmpty() {
		return head==null;
	}
	public void push(Student x) {
		head =  new NodeObject(x, head);
	}
	public void pushMany(ArrayList<Student> listStudent) {
		for(Student stu: listStudent) {
			push(stu);
		}
	}
	Student top ()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return head.info;
	}
	Student pop()throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		Student result = head.info;
		head = head.next;
		return result;
	}
	void traverse() {
		NodeObject p = head;
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
	void reverse() {
		NodeObject re = head;
		while(re.next != null) {
			push(re.info);
			re = re.next;
		}
	}
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
	

public class Object_Queue_Stack {
	

	public static void main(String[] args) {
		
		System.out.println("########### Object Stack #################");
		ArrayList<Student> listStudent = new ArrayList<Student>();
		listStudent.add(new Student("de01", "Hoang"));
		listStudent.add(new Student("de03", "Ha"));
		listStudent.add(new Student("de02", "Khong"));
		listStudent.add(new Student("de05", "Do"));
		listStudent.add(new Student("de04", "Le"));
		LinkedStackObject l = new LinkedStackObject();
		
		
		l.pushMany(listStudent);
		l.traverse();
		l.push(new Student("de06", "Sao"));
		System.out.println("\nAfter pushing into linked_stack:");
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
		
		
		System.out.println("########### Object Queue #################\n");
		ObjectQueue q = new ObjectQueue();
		Student stu1 = new Student("de01", "Hieu");
		Student stu2 = new Student("de04", "Hi");
		Student stu3 = new Student("de02", "Hai");
		Student stu4 = new Student("de05", "Hoa");
		Student stu5 = new Student("de03", "Hung");
		q.enqueue(stu1);
		q.enqueue(stu2);
		q.enqueue(stu3);
		q.enqueue(stu4);
		q.enqueue(stu5);
		System.out.println("List Student:");
		q.traverse();
		System.out.println();
		System.out.println("\nAfter deleting from first(dequeuing): ");
		try {
			q.dequeue();
			q.traverse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("\nThe first element of list:");
		try {
			System.out.println(q.front());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("\nClearing:");
		q.clear();
	}
		
	
	

}
