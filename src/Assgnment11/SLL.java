package Assgnment11;

import java.util.ArrayList;


class SLLNode<T> {
	
    T value;
    SLLNode<T> next;
    
    public SLLNode(T val, SLLNode<T> nxt) {
        value = val;
        next = nxt;
    }
   }


public class SLL {
	
	SLLNode<Integer> head;
    SLLNode<Integer> tail;

    private boolean isEmptyList() {
        return head == null;
    }
    
    private boolean isExist(SLLNode p) {
        SLLNode<Integer> node = head;
        while (node !=null) {
            if (p.value == node.value) {
                break;
            }
            node = node.next;
        }
        return node == p;
    }
    //void1
    public void addToHead(int x) {
        SLLNode<Integer> node1 = new SLLNode<>(x, null);
        if (isEmptyList()) {
            head = node1;
            tail = head;
            return;
        }
        node1.next = head;
        head = node1;
    }

    //void2
    public void addToTail(int x) {
        SLLNode<Integer> node1 = new SLLNode<>(x, null);
        if (isEmptyList()) {
            head = node1;
            tail = head;
            return;
        }
        tail.next = node1;
        tail = node1;
    }

    //3
    public void addAfter(SLLNode p,int x) {
        if (isEmptyList()) {
            System.out.println("Empty list!");
        }
        else if (p == tail) {
            addToTail(x);
        }
        else {
            SLLNode<Integer> node1 = new SLLNode<>(x, null);
            node1.next = p.next;
            p.next = node1;
        }
    }
    
    //4
    public void traverse() {
        if (isEmptyList()) {
            return;
        }
        SLLNode<Integer> node1 = head;
        int index = 0;
        while (node1 != null) {
            System.out.print(node1.value + " (" + index + ")   ");
            node1 = node1.next;
            index++;
        }
        System.out.println("");
    }

    //5
    public Integer deleteFromHead() {
        if (isEmptyList()) {
            return null;
        }
        int info = head.value;
        head = head.next;
        return info;
    }

    //6
    public Integer deleteFromTail() {
        if (isEmptyList()) {
            return null;
        }
        int info;
        if (head == tail) {
            info = head.value;
            head = null;
            return info;
        }
        SLLNode<Integer> node = head;
        while (node.next != null && node.next != tail) {
            node = node.next;
        }
        info = node.value;
        node.next = null;
        tail = node;
        return info;
    }
    
    //7
    public Integer deleteAfter(SLLNode p) {
        if (isEmptyList() || p==tail) {
            return null;
        }
        int info;
        if (p.next == tail) {
            info = tail.value;
            deleteFromTail();
            return info;
        }
        SLLNode<Integer> node = p.next;
        info = node.value;
        p.next = p.next.next;
        return info;
    }
    
    //8
    public void deleByVal(int x) {
        if(isEmptyList()) {
            return;
        }
        SLLNode<Integer> node = head;
        SLLNode<Integer> nodeBefore = null;
        while(node != null) {
            if(node.value == x) {
                break;
            }
            nodeBefore = node;
            node = node.next;
        }
        if(node == null) {
            return;
        }
        if(node == head) {
            head = head.next;
            return;
        }
        if(node == tail) {
            nodeBefore.next = null;
            tail = nodeBefore;
            return;
        }
        nodeBefore.next = node.next;
    }
    
    //9
    public SLLNode<Integer> search(int x) {
        if(isEmptyList()) {
            return null;
        }
        SLLNode<Integer> node = head;
        while(node != null) {
            if(node.value == x) {
                break;
            }
            node = node.next;
        }
        return node;
    }
    
    //10
    public int count() {
        if(isEmptyList()) {
            return 0;
        }
        SLLNode<Integer> node = head;
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    
    //11
    public void deleByPos(int i) {
        if(i < 0) {
            return;
        }
        if(isEmptyList()) {
            return;
        }
        i--;
        int index = 0;
        SLLNode<Integer> node = head;
        SLLNode<Integer> nodeBefore = null;
        while(node != null) {
            if(index == i) {
                break;
            }
            node = node.next;
            index++;
        }
        if(node == null) {
            return;
        }
        if(node == head) {
            head = head.next;
            return;
        }
        if(node == tail) {
            nodeBefore.next = null;
            tail = nodeBefore;
            return;
        }
        nodeBefore.next = node.next;        
    }
    
    //12
    public void sort() {
        SLLNode<Integer> i = head;
        while(i != null) {
            SLLNode<Integer> j = i.next;
            while(j != null) {
                if(i.value > j.value) {
                    int temp = i.value;
                    i.value = j.value;
                    j.value = temp;                  
                }
                j = j.next;
            }
            i = i.next;
        }
    }
    
    //13
    void deleNode(SLLNode p) {
        if(isEmptyList() || isExist(p) == false) {
            return;
        }
        
    }
    
    //14
    public int[] toArray() {
        ArrayList<Integer> arr = new ArrayList<>();
        SLLNode<Integer> i = head;
        while (i != null) {
            arr.add(i.value);
            i = i.next;
        }
        return arr.stream().mapToInt(a->a).toArray();
 
    }
    
    //15
    public static SLL merge(SLL listA, SLL listB) {
    	SLL newList = new SLL();
        newList.head = listA.head;
        newList.tail = listB.tail;
        listA.tail.next = listB.head;
        newList.sort();
        return newList;
    }
    
    //16
    public void addBefore(SLLNode p, int x) {
        if(isEmptyList()) {
            System.out.println("Empty list!");
        }
        if (p == head) {
            addToHead(x);
        }
        else {
            SLLNode node = head;
            while (node != p) {
                node = node.next;
            }
            SLLNode node1 = new SLLNode(x,p);
            node.next = node1;
        }
    }
    
    //18
    public int max() {
        int max = head.value;
        SLLNode<Integer> node = head;
        while (node != null) {
            if (node.value > max) {
                max = node.value;
            }
            node = node.next;
        }
        return max;
    }
    
    //19
    public int min() {
        int min = head.value;
        SLLNode<Integer> node = head;
        while (node != null) {
            if (node.value < min) {
                min = node.value;
            }
            node = node.next;
        }
        return min;
    }
    
    //20
    public int sum() {
        int sum = 0;
        SLLNode<Integer> tmp = head;
        while (tmp != null) {
            sum += tmp.value;
            tmp = tmp.next;
        }
        return sum;
    }
    
    //21
    public int avg() {
        int avg = sum() / count();
        return avg;
    }
    
    //22
    public boolean sorted() {
        int min = head.value;
        boolean check = true;
        SLLNode<Integer> node = head;
        while (node != null) {
            if (node.value < min) {
                check = false;
            }
        }
        return check;
    }
    
    //23
    public void insert(int x) {
        if (isEmptyList()|| x <= head.value) {
            addToHead(x);
            return;
        }
        if (x > tail.value) {
            addToTail(x);
            return;
        }
        SLLNode<Integer> node = head;
        while (node.value <= x) {
            node = node.next;
        }
        addBefore(node,x);
    }
    
    //24
    public void reverse() {
        SLLNode<Integer> reserve = head;
        SLLNode<Integer> i = head.next;
        while(i != null) {
            addToHead(i.value);
            i = i.next;
        }
        tail = reserve;
        tail.next = null;
    }
    

	public static <T> void main(String[] args) {
			
			SLL listA = new SLL();
			//number1 add to head
				listA.addToHead(19);
				listA.addToHead(24);
				listA.addToHead(1);

			
			System.out.println("After add to head: \n");
				listA.traverse();
				
			//number2 add to tail
				listA.addToTail(2);
				listA.addToTail(7);
				listA.addToTail(5);

			
			System.out.println("After add to tail: \n");
				listA.traverse();


			//number5 delete from a number
				listA.deleByVal(2);
				System.out.println("After deletet by variable x");
				listA.traverse();
				
			//number6 search with value x
				
				System.out.println("After sorting: ");
				listA.sort();
				listA.traverse();
				System.out.println("List after reversing: ");
				listA.reverse();
				listA.traverse();
				System.out.println("List after inserting: ");
				listA.insert(19);
				listA.traverse();

				System.out.println("Avarage of list is: "+ listA.avg());
				System.out.println("Min of list is: "+ listA.min());
				System.out.println("Sum of list is: "+ listA.sum());
				System.out.println("Max of list is: "+ listA.max());
				

				
				

	}
    

}
