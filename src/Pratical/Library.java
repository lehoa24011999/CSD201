package Pratical;


class CrunchifyNode<V> {
	// instance variables
	private V element;
	private CrunchifyNode<V> next;

	// constructor first
	public CrunchifyNode() {
		this(null, null); 
	}

	public CrunchifyNode(V element, CrunchifyNode<V> next) {
		this.element = element;
		this.next = next;
	}

	public V getElement() {
		return element;
	}

	public CrunchifyNode<V> getNext() {
		return next;
	}

	public void setElement(V element) {
		this.element = element;
	}

	public void setNext(CrunchifyNode<V> next) {
		this.next = next;
	}

}

public class Library<V> {

	protected CrunchifyNode<V> head, tail;
	protected long size;

	// Empty list constructor first
	public  Library() {
		head = null;
		tail = null;
		size = 0;
	} 

	public void display()  {  
		CrunchifyNode<V> n = head;  
		while (n != null)  {  
			System.out.print(n.getElement()+" \n");  
			n = n.getNext();  
		}  
	}  

	// Method to add CrunchifyNodes to the list. Storage space for the CrunchifyNode is already allocated in the calling method
	public void addFirst(CrunchifyNode<V> CrunchifyNode) {
		// Set the tail only if this is the very first CrunchifyNode
		if (tail == null)
			tail = CrunchifyNode;
		CrunchifyNode.setNext(head); // Make next of the new CrunchifyNode refer to the head
		head = CrunchifyNode; // Give head a new value

		// change the size
		size++;
	} 

	// Add new CrunchifyNode after current CrunchifyNode, checking to see if we are at the tail
	public void addAfter(CrunchifyNode<V> currentCrunchifyNode, CrunchifyNode<V> newCrunchifyNode) {
		if (currentCrunchifyNode == tail)
			tail = newCrunchifyNode;
		newCrunchifyNode.setNext(currentCrunchifyNode.getNext());
		currentCrunchifyNode.setNext(newCrunchifyNode);

		// change the size
		size++;
	} 

	// Add new CrunchifyNode after the tail CrunchifyNode.
	public void addLast(CrunchifyNode<V> CrunchifyNode) {
		CrunchifyNode.setNext(null);
		tail.setNext(CrunchifyNode);
		tail = CrunchifyNode;
		size++;
	}

	// Methods to remove CrunchifyNodes from the list. (Unfortunately, with a single linked list. there is no way to remove last. Need a previous reference to do that.
	public CrunchifyNode<V> removeFirst() {
		if (head == null)
			System.err.println("Error:  Attempt to remove from an empty list");

		// save the one to return
		CrunchifyNode<V> temp = head;

		// do reference manipulation
		head = head.getNext();
		temp.setNext(null);
		size--;

		return temp;

	} 

	// Remove the CrunchifyNode at the end of the list. tail refers to this CrunchifyNode, but since the list is single linked, there is no way to refer to the CrunchifyNode before the tail CrunchifyNode. Need to traverse the list.
	public CrunchifyNode<V> removeLast() {
		// Declare local variables/objects
		CrunchifyNode<V> CrunchifyNodeBefore;
		CrunchifyNode<V> CrunchifyNodeToRemove;

		// Make sure we have something to remove
		if (size == 0)
			System.err.println("Error:  Attempt to remove fron an empty list");

		// Traverse through the list, getting a reference to the CrunchifyNode before the trailer. Since there is no previous reference.
		CrunchifyNodeBefore = getFirst();

		for (int count = 0; count < size - 2; count++)
			CrunchifyNodeBefore = CrunchifyNodeBefore.getNext();

		// Save the last CrunchifyNode
		CrunchifyNodeToRemove = tail;

		// Let's do the pointer manipulation
		CrunchifyNodeBefore.setNext(null);
		tail = CrunchifyNodeBefore;
		size--;

		return CrunchifyNodeToRemove;
	} 

	// Remove a known CrunchifyNode from the list. No need to search or return a value. This method makes use of a 'before' reference in order to allow list manipulation.
	public void remove(CrunchifyNode<V> CrunchifyNodeToRemove) {
		// Declare local variables/references
		CrunchifyNode<V> CrunchifyNodeBefore, currentCrunchifyNode;

		// Make sure we have something to remove
		if (size == 0)
			System.err.println("Error:  Attempt to remove fron an empty list");

		// Starting at the beginning check for removal
		currentCrunchifyNode = getFirst();
		if (currentCrunchifyNode == CrunchifyNodeToRemove)
			removeFirst();
		currentCrunchifyNode = getLast();
		if (currentCrunchifyNode == CrunchifyNodeToRemove)
			removeLast();

		// We've already check two CrunchifyNodes, check the rest
		if (size - 2 > 0) {
			CrunchifyNodeBefore = getFirst();
			currentCrunchifyNode = getFirst().getNext();
			for (int count = 0; count < size - 2; count++) {
				if (currentCrunchifyNode == CrunchifyNodeToRemove) {
					// remove current CrunchifyNode
					CrunchifyNodeBefore.setNext(currentCrunchifyNode.getNext());
					size--;
					break;
				}

				// Change references
				CrunchifyNodeBefore = currentCrunchifyNode;
				currentCrunchifyNode = currentCrunchifyNode.getNext();
			} 
		} 

	}

	// The gets to return the head and/or tail CrunchifyNodes and size of the list
	public CrunchifyNode<V> getFirst() {
		return head;
	}

	public CrunchifyNode<V> getLast() {
		return tail;
	}

	public long getSize() {
		return size;
	}


}
