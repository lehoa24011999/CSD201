package Practical2_4;

import java.util.Comparator;
import java.util.LinkedList;

import Practical1_4.Booking;
import Practical1_4.Bus;




class MyStackBooking{
	LinkedList<Object> a;
	MyStackBooking() {
		a = new LinkedList<Object>();
	}
	boolean isEmpty() {
		return(a.isEmpty());
	}
	void push(Object x){
		a.add(x);
	}
	Object pop(){
		return(a.removeLast());
	}
}
class MyQueueBooking{
	LinkedList<Object> a;
	MyQueueBooking() {
		a = new LinkedList<Object>();
	}
	boolean isEmpty() {
		return(a.isEmpty());
	}
	void enqueue(Object x){
		a.add(x);
	}
	Object dequeue(){
		return(a.removeFirst());
	}
}



class SortbyCodeBus1 implements Comparator<Booking> {

	@Override
	public int compare(Booking o1, Booking o2) {
		// TODO Auto-generated method stub
		return o1.getbCode().compareTo(o2.getbCode());
	} 
  
} 
class SortbyCodeCustomer1 implements Comparator<Booking> {

	@Override
	public int compare(Booking o1, Booking o2) {
		// TODO Auto-generated method stub
		return o1.getcCode().compareTo(o2.getcCode());
	} 
  
}
public class BSTBooking {

		public BookingNode root;
		public BSTBooking() {
			root=null;
		}
		//1. boolean isEmpty() -   return true if a tree is empty, return false otherwise.
		boolean isEmpty() {
			return(root==null);
		}
		//2.   void clear() - clear a tree.
		void clear() {
			root = null;
		}

		/*method of teacher*/
		//	BSTNode search(BSTNode p, int x){
		//		if(p==null) return(null);
		//		if(p.info==x) return(p);
		//		if(x<p.info) 
		//			return(search(p.left,x));
		//		else
		//			return(search(p.right,x));
		//	} 
		/* 3.   Node search(int x) - Search a node having value x.
		 Return a reference to that node if found, return null otherwise.*/
		int search(String x) {		
			BookingNode p = root;
			while(p != null) 
				if(x.compareTo(p.info.getbCode())==0) return 1;
				else if (x.compareTo(p.info.getbCode())<0) p = p.left;
				else p  = p.right;
			return 0;
		}
		void insert(Booking x){
			BookingNode q = new BookingNode(x);
			if(isEmpty()) {
				root=q;return;
			}
			BookingNode f, p; f=null;p=root;
			while(p!=null){
				if(p.info==x){
					//				System.out.println("The key "+x+" already exists, no insertion");
					return;
				}
				f=p;
				if(x.getbCode().compareTo(p.info.getbCode())<0) p=p.left; else p=p.right;
			}
			if(x.getbCode().compareTo(f.info.getbCode())<0) f.left=q;else f.right=q;
		}
		/*4.   void insert(int x) - check if the key x does not exists in a tree
		 *  then insert new node with value x into the tree.*/
		//	void insertMany(int [] a){
		//		for(int i=0;i<a.length;i++) insert(a[i]);
		//	}
		/*5.   void breadth() - traverse a tree.*/
		void breadth(){
			if(root == null) return;
			MyQueue q = new MyQueue();
			q.enqueue(root);
			BookingNode p;
			while(!q.isEmpty()){
				p = (BookingNode) q.dequeue();
				if(p.left != null)
					q.enqueue(p.left);
				if(p.right != null)
					q.enqueue(p.right);
				visit(p);
			}
		}

		void visit(BookingNode p){
			System.out.println(p.info + " ");
		}
		/*6.   void preorder(Node p) - recursive preorder traverse of a tree.*/
		void preOrder(BookingNode p){
			if(p==null) return;
			visit(p);
			preOrder(p.left);
			preOrder(p.right);
		}
		/*7.   void inorder(Node p) - recursive inorder traverse of a tree.*/
		LinkedList<BookingNode> listNode=new LinkedList<BookingNode>();
		public void inOrder(BookingNode p){
			if(p==null) return;
			inOrder(p.left);
			visit(p);
			listNode.add(p);
			inOrder(p.right);
		}

		public LinkedList<BookingNode> getListNode(){
			return listNode;
		}


		/*8.   void postorder(Node p) - recursive postorder traverse of a tree*/
		void postOrder(BookingNode p){
			if(p==null) return;
			postOrder(p.left);
			postOrder(p.right);
			visit(p);
		}
		/*9.   int count() - count and return number of nodes in the tree.
		 * */
		int count() {
			int c=0;
			if(root == null) return c;
			MyQueue q = new MyQueue();
			q.enqueue(root);
			c++;
			BookingNode p;
			while(!q.isEmpty()){
				p = (BookingNode) q.dequeue();
				if(p.left != null) {
					c++;
					q.enqueue(p.left);
				}
				if(p.right != null) {
					c++;
					q.enqueue(p.right);
				}

			}
			return c;
		}


		/*10. void dele(int x) - delete a node having value x. 
		 *Deleting by copying
		 * */
		void copyDele(String x){
			if(root==null){
				System.out.println(" The tree is empty, no deletion");
				return;
			}
			BookingNode f,p; // f will be the father of p
			p=root;f=null;
			while(p!=null){
				if(x.compareTo(p.info.getbCode())==0) break;//Found key x
				if(x.compareTo(p.info.getbCode())<0){
					f=p;p=p.left;
				}
				else{
					f=p;p=p.right;
				}
			}
			if(p==null){
				System.out.println(" The key " + x + " does not exist, no deletion");
				return;
			}
			if(p.left==null && p.right==null) {// p is a leaf BSTNode
				if(f==null) // The tree is one BSTNode
					root=null; 
				else{
					if(f.left==p)
						f.left=null;
					else
						f.right=null;
				}
				return;
			}

			if(p.left!=null && p.right==null) {// p has only left child
				if(f==null) // p is a root
					root=p.left; 
				else{
					if(f.left==p) // p is a left child
						f.left=p.left;
					else 
						f.right=p.left;
				}
				return;
			}

			if(p.left==null && p.right!=null) {if(f==null) // p has only right child
				root=p.right;// p is a root 
			else{
				if(f.left==p) // p is a left child
					f.left=p.right;
				else 
					f.right=p.right;
			}
			return;
			}

			if(p.left!=null && p.right!=null) {// p has both left and right children
				BookingNode rp; // p's key will be replaced by rp's one
				f=null;
				rp = p.left;
				while(rp.right!=null) {
					f=rp; rp = rp.right;
				}// Find the right most BSTNode on the left sub-tree
				p.info = rp.info;
				if(f==null) // rp is just a left son of p 
					p.left=rp.left;
				else
					f.right=rp.left;
			}
		}
		/*11. Node min() - find and return the node with minimum value in the tree.
		 * */
		//	int min() {
		//		int min = 0;
		//		if(root == null) return min;
		//		min = root.info;
		//		MyQueue q = new MyQueue();
		//		q.enqueue(root);
		//		BSTNode p;
		//		while(!q.isEmpty()){
		//			p = (BSTNode) q.dequeue();
		//			if(p.info < min) {
		//				min = p.info;
		//			}
		//			if(p.left != null) {
		//				q.enqueue(p.left);
		//
		//			}
		//			if(p.right != null) {
		//				q.enqueue(p.right);
		//			}
		//
		//		}
		//		return min;
		//	}
		//	/*12. Node max() - find and return the node with maximum value in the tree
		//	 */
		//	int max() {
		//		int max = 0;
		//		if(root == null) return max;
		//		max = root.info;
		//		MyQueue q = new MyQueue();
		//		q.enqueue(root);
		//		BSTNode p;
		//		while(!q.isEmpty()){
		//			p = (BSTNode) q.dequeue();
		//			if(p.info > max) {
		//				max = p.info;
		//			}
		//			if(p.left != null) {
		//				q.enqueue(p.left);
		//
		//			}
		//			if(p.right != null) {
		//				q.enqueue(p.right);
		//			}
		//
		//		}
		//		return max;
		//	}
		//
		//	/*13. int sum() - return the sum of all values in the tree. 
		//	 * */
		//	int sum() {
		//		int sum = 0;
		//		if(root == null) return sum;
		//		MyQueue q = new MyQueue();
		//		q.enqueue(root);
		//		BSTNode p;
		//		while(!q.isEmpty()){
		//			p = (BSTNode) q.dequeue();
		//			sum += p.info;
		//			if(p.left != null) {
		//				q.enqueue(p.left);
		//
		//			}
		//			if(p.right != null) {
		//				q.enqueue(p.right);
		//			}
		//
		//		}
		//		return sum;
		//	}
		//	/*14. int avg() - return the average of all values in the tree.
		//	 * */
		//	double average() {
		//		int avg = 0;
		//		int sum = 0;
		//		int c =0;
		//		if(root == null) return avg;
		//		MyQueue q = new MyQueue();
		//		q.enqueue(root);
		//		c++;
		//		BSTNode p;
		//		while(!q.isEmpty()){
		//			p = (BSTNode) q.dequeue();
		//			sum += p.info;
		//			if(p.left != null) {
		//				q.enqueue(p.left);
		//				c++;
		//			}
		//			if(p.right != null) {
		//				q.enqueue(p.right);
		//				c++;
		//			}
		//
		//		}
		//		avg = sum/c;
		//		return avg;
		//	}
		//	/*15.The height of a tree is the maximum number of  edges 
		//	 * on a path from the root to a leaf node (thus the height of a tree with root only is 0).
		//	 * Write a  function that returns the height of a binary tree.
		//	 * */
		//	int height() {
		//		int height = 0;
		//		if(root == null) return height;
		//		MyQueue q = new MyQueue();
		//		q.enqueue(root);
		//		height++;
		//		BSTNode p;
		//		while(!q.isEmpty()){
		//			p = (BSTNode) q.dequeue();
		//			if(p.left != null) {
		//				height++;
		//				q.enqueue(p.left);
		//			}
		//			if(p.right != null) {
		//				height++;
		//				q.enqueue(p.right);
		//			}
		//
		//		}
		//		height = (int) Math.ceil(Math.log(height)) + 1;
		//		return height;
		//	}

		//	int maxSumRootToLeaf() {return getMaxSumRootToLeaf(root);}
		//	int getMaxSumRootToLeaf(Node n) {
		//		if(n==null) return 0;
		//		int sl= n.info+getMaxSumRootToLeaf(n.left);
		//		int rl= n.info+getMaxSumRootToLeaf(n.right);
		//		return (sl>rl) ? sl:rl;
		//	

		//balancing tree
		//	void balance(ArrayList<BSTNode> a, int lower, int upper){
		//		if(lower>upper) return;
		//		int middle = (lower + upper)/2;
		//		int x = ((BSTNode) a.get(middle)).info;
		//		insert(x);
		//		balance(a,lower, middle-1);
		//		balance(a,middle+1,upper);
		//	}
		//	void balance(){
		//		a = new ArrayList<BSTNode>();
		//		inOrder2(root,a);
		//		int n = a.size();
		//		BSTree g = new BSTree();
		//		g.balance(a,0,n-1);
		//		root=g.root;
		//	}
		//	  void inOrder2(BSTNode p, ArrayList a)
		//	   {if(p==null) return;
		//	    inOrder2(p.left,a);
		//	    a.add(p);
		//	    inOrder2(p.right,a);
		//	   }


		
//		  void inOrder2(BusNode p, ArrayList<BusNode> a)
//		   {if(p==null) return;
//		    inOrder2(p.left,a);
//		    a.add(p);
//		    inOrder2(p.right,a);
//		   }
//		  void balance(ArrayList<BookingNode> a, int lower, int upper)
//		   {if(lower>upper) return;
//		    int middle = (lower + upper)/2;
//		    Bus x = ((BookingNode) a.get(middle)).info;
//		    insert(x);
//		    balance(a,lower, middle-1);
//		    balance(a,middle+1,upper);
//		   }
//		  void balance()
//		   {ArrayList<BookingNode> a = new ArrayList<BookingNode>();
//		    inOrder2(root,a);
//		    int n = a.size();
//		    BSTreeBus g = new BSTreeBus();
//		    g.balance(a,0,n-1);
//		    root=g.root;
//		   }

		public static void main(String [] args){
//			BSTreeBus t = new BSTreeBus();
//			int [] a = {1,10,14,5,7,83,34};


			//		
			//		while(input.hasNextInt()) {
			//			a[i]=input.nextInt();
			//			i++;
			//		}

			BSTreeBus t = new BSTreeBus();
		    System.out.println(" After inserting 3, 5, 1, 9, 8:");
//		    int [] a = {3,5,1,9,8};
		    t.insert(new Bus("sda", "sdfa", 112, 24, 5, 10));
		    t.balance();

		    System.out.println("\n Pre-order traverse:");
		    t.preOrder(t.root);
		    System.out.println("\n In-order traverse:");
		    t.inOrder(t.root);
	//
//			System.out.println("\nPre-order traverse:");
//			t.preOrder(t.root);  
//			System.out.println("\nIn-order traverse:");
//			t.inOrder(t.root);  
//			System.out.println("\nPost-order traverse:");
//			t.postOrder(t.root);  
//			System.out.println();  
//			System.out.println("breath traverse: ");
			t.breadth();
			//		t.copyDele(15);
			//		System.out.println("\nDeleting by copying (15): ");
			//		System.out.println("In-order traverse:");
			//		t.inOrder(t.root);
			//		System.out.println("\nAfter Searching (30):");
			//		System.out.println("\nBreadth-first traverse:");
			//		t.breadth();
			//
			//		System.out.println("\nNumber of nodes in the tree:");
			//		System.out.println(t.count());
			//		System.out.println("\nMIN of tree:");
			//		System.out.println(t.min());
			//		System.out.println("\nMAX of tree:");
			//		System.out.println(t.max());
			//		System.out.println("\nSum of tree:");
			//		System.out.println(t.sum());
			//		System.out.println("\nAvarage of tree:");
			//		System.out.println(t.average());


		}


}
