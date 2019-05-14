package Assgnment11;

class SLLNode1<T> {
	
    T info;
    SLLNode1<T> next;
    
    public SLLNode1(T el, SLLNode1<T> p) {
        info = el;
        next = p;
    }
    
   }
public class String_SLL {
	
	
	SLLNode1<String> head;
    SLLNode1<String> tail;

    private boolean isEmptyList() {
        return head == null;
    }
    
    private boolean isExist(SLLNode1 p) {
        SLLNode1<String> node = head;
        while (node !=null) {
            if (p.info == node.info) {
                break;
            }
            node = node.next;
        }
        return node == p;
    }
    //void1
    public void addToHead(String x) {
        SLLNode1<String> node1 = new SLLNode1<String>(x, null);
        if (isEmptyList()) {
            head = node1;
            tail = head;
            return;
        }
        node1.next = head;
        head = node1;
    }

    //void2
    public void addToTail(String x) {
        SLLNode1<String> node1 = new SLLNode1<>(x, null);
        if (isEmptyList()) {
            head = node1;
            tail = head;
            return;
        }
        tail.next = node1;
        tail = node1;
    }

    //3
    public void addAfter(SLLNode1 p,String x) {
        if (isEmptyList()) {
            System.out.println("Empty list!");
        }
        else if (p == tail) {
            addToTail(x);
        }
        else {
            SLLNode1<String> node1 = new SLLNode1<>(x, null);
            node1.next = p.next;
            p.next = node1;
        }
    }
    
    //4
    public void traverse() {
        if (isEmptyList()) {
            return;
        }
        SLLNode1<String> node1 = head;
        int index = 0;
        while (node1 != null) {
            System.out.print(node1.info + " (" + index + ")   ");
            node1 = node1.next;
            index++;
        }
        System.out.println("");
    }

    //5
    public String deleteFromHead() {
        if (isEmptyList()) {
            return null;
        }
        String info = head.info;
        head = head.next;
        return info;
    }

    //6
    public String deleteFromTail() {
        if (isEmptyList()) {
            return null;
        }
        String info;
        if (head == tail) {
            info = head.info;
            head = null;
            return info;
        }
        SLLNode1<String> node = head;
        while (node.next != null && node.next != tail) {
            node = node.next;
        }
        info = node.info;
        node.next = null;
        tail = node;
        return info;
    }
    
    //7
    public String deleteAfter(SLLNode1 p) {
        if (isEmptyList() || p==tail) {
            return null;
        }
        String info;
        if (p.next == tail) {
            info = tail.info;
            deleteFromTail();
            return info;
        }
        SLLNode1<String> node = p.next;
        info = node.info;
        p.next = p.next.next;
        return info;
    }
    
    //8
    public void deleByVal(String x) {
        if(isEmptyList()) {
            return;
        }
        SLLNode1<String> node = head;
        SLLNode1<String> nodeBefore = null;
        while(node != null) {
            if(node.info.equals(x)) {
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
    public boolean search(String x) {
        if(isEmptyList()) {
            return false;
        }
        SLLNode1<String> node = head;
        while(node != null) {
            if(node.info.equals(x)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
    
    //10
    public int count() {
        if(isEmptyList()) {
            return 0;
        }
        SLLNode1<String> node = head;
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
	
	
    public static void main(String[] args) {
		String_SLL str = new String_SLL();
		str.addToHead("Buoc");
		str.addToHead("Buoc");
		str.addToTail("ngang");
		str.addToTail("ngang");
		System.out.println("After delete from head: ");
		str.deleteFromHead();
		str.traverse();
		System.out.println("After delete from tail: ");
		str.deleteFromTail();
		str.traverse();
		
		str.addToHead("bong");
		str.addToHead("xe");
		str.addToHead("ta");
		System.out.println("SLL is: ");
		str.traverse();
		System.out.println("Size of SLL is:");
		System.out.println(str.count());
		System.out.println("Search variable x ");
		if(str.search("xee")== true) {
			
			System.out.println("Found\n");
		}
		else {
			System.out.println("Not Found\n");
		}
		
		System.out.println("Delete with variable parameter");
		str.deleByVal("xe");
		str.traverse();
	}
	
	

}
