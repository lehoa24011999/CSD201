package Recursion;

class Node {
	int info;
	Node left, right;

	public Node(int x) {
		info = x;
		left = right = null;
	}
}
class BinaryTree {
	Node root;

	int size(Node node) {
		if (node == null)
			return 0;
		else
			return (size(node.left) + 1 + size(node.right));
	}
	int height(Node node) {
		if (node == null)
			return 0;
		else {
			int leftHeight = 1 + height(node.left);
			int rightHeight = 1 + height(node.right);

			return (leftHeight > rightHeight) ? leftHeight : rightHeight;
		}
	}
}
public class Recursion {

	static int p = 0, n;
	int sum (int n) {
		if (n == 0) 
			return 0;
		else
			return (n + sum(n-1));
	}
	int min (int a[], int n) {
		if (n==1)
			return a[0];

		return Math.min(a[n-1], min(a,n-1));
	}
	int findsum(int a[], int n) {
		if (n==1)
			return a[0];
		return (findsum(a,n-1)+a[n-1]);
	}
	int isPalindrome(char a[], int n) {
		if (n <= 1 )
			return 1;
		if (a[p] == a[n-1]) {
			p++;
			return isPalindrome(a,n-1);
		} else
			return 0;	
	}
	int search(int a[], int b, int e, int s) {
		if (b > e)
			return -1;
		int mid = (b + e) / 2;
		if (a[mid] == s)
			return mid;
		else if (a[mid] > s)
			return search(a, b, mid - 1, s);
		else
			return search(a, mid + 1, e, s);
	}
	int GCD (int a, int b) {
		if (b == 0)
			return a;
		return GCD(b,a % b);
	}
	int power(int x , int n) {
		if (n == 0)
			return 1;
		return x* power (x, n-1);
	}
	int fact(int n) {
		if (n <= 1)
			return 1;
		return n * fact(n-1);
	}
	int fib(int n) {
		if (n <=2)
			return 1;
		return (fib(n-1)+ fib(n-2));
	}
	double addReciprocals (int n) {
		if (n ==1)
			return 1;
		return 1.0/n + addReciprocals(n-1);
	}
	static int Stirling_Numbers(int n, int k) {
		if ((k == 0) && (n != 0))
			return 0;
		else if (k == n)
			return 1;
		else
			return Stirling_Numbers(n - 1, k - 1) + (n - 1) * Stirling_Numbers(n - 1, k);
	}

	public static void main(String[] args) {
		
		Recursion r = new Recursion();
		
		System.out.println(r.sum(2));
		int a[] = {5,4,3,2,6,8};
		System.out.println(r.min(a, a.length));

		
//		System.out.println(Stirling_Numbers(5, 3));
//
//
//		BinaryTree tree = new BinaryTree();
//		tree.root = new Node(1);
//		tree.root.left = new Node(2);
//		tree.root.right = new Node(3);
//		tree.root.left.left = new Node(4);
//		tree.root.left.right = new Node(5);
//
//		System.out.println("The size of binary tree is: " + tree.size(tree.root));
//		System.out.print("The height of binary tree is: " + tree.height(tree.root));
	}
}
