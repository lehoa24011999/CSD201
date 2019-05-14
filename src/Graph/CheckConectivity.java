package Graph;

import java.util.LinkedList;

//1    Create text files to store the adjancy matrix of a graph in Figure 1. Write the Graph class with  the following members:
//Data members:
//int [][] a  -  two dimentional array representing an adjancy matrix
//String [] label - label of vertices
//int n - number of vertices.
//Methods:
//void setAMatrix(int [][] b, int m) - set m to n and b matrix to adjancy matrix.
//void setLabel(String [] c) - set labels for vertices 
//and two methods for breadth first traverse and depth first traverse.

//2.   Write the WGraph class which contains weighted matrix and methods for Dijkstra shortest path algorithm.
//3.   Write the WGraph class which contains weighted matrix and methods for  finding  the minimum spanning tree  of  a graph.
//4.   Write the Graph class which contains adjacency matrix and methods for  assigning colors to vertices with the sequential coloring algorithm.
//

class MyStack{
	LinkedList<Integer> t;
	MyStack() {
		t = new LinkedList<Integer>();
	}
	boolean isEmpty() {
		return(t.isEmpty());
	}
	void push(int x) {
		t.add(x);
	}
	int pop() {
		return(t.removeLast());
	}
}

class MyQueueCheck{
	LinkedList<Integer> t;
	MyQueueCheck() {t = new LinkedList<Integer>();
	}
	boolean isEmpty() {
		return(t.isEmpty());
	}
	void enqueue(int x) {
		t.add(x);
	}
	int dequeue() {
		return(t.removeFirst());
	}
}
class GraphCheck{
	int [][] a; int n;
	char [] v;
	GraphCheck() {
		v = "ABCDEFGHIJKLMN".toCharArray();a=null;n=0;
	}
	void clear() {
		a=null;n=0;
	}
	void setData(int [][] b){
		n=b.length; a = new int[n][n];
		int i,j;
		for(i=0;i<n;i++)
			for(j=0;j<n;j++) a[i][j] = b[i][j];
	}
	void dispAdj(){
		int i,j;
		System.out.println("\nThe adjacency matrix:");  
		for(i=0;i<n;i++){
			System.out.println();
			for(j=0;j<n;j++) System.out.printf("%5d",a[i][j]);
		}
	}
	void visit(int i) {
		System.out.print(v[i]+" ");
	}

	void depth(boolean [] visited,int i){
		visit(i);visited[i]=true;
		for(int j=0;j<n;j++)
			if(!visited[j] && a[i][j]>0) depth(visited,j);
	}
	void depth(int k){
		boolean [] visited = new boolean[n];
		int i,j,r;
		r =1;
		for(i=0;i<n;i++) visited[i]=false;
		System.out.println("\nDepth-first traverse from the vertex " + v[k] + ":");
		System.out.println("\nDepth-first traverse for connected part " + r+":");
		depth(visited,k);
		for(i=0;i<n;i++){
			for(i=0;i<n;i++)
				if(!visited[i]){
					r++;
					System.out.println("\nDepth-first traverse for connected part " + r+":");
					depth(visited,i);
				}
		}
		System.out.println();
	}
	void breadth(int k) {// not complete yet
		MyQueueCheck q = new MyQueueCheck();
		boolean [] enqueued = new boolean[n];
		int i,j;
		for(i=0;i<n;i++) enqueued[i]=false;
		q.enqueue(k); enqueued[k] = true;
		int r;
		System.out.println("\nBreadth-first traverse from the vertex " + v[k] + ":");
		while(!q.isEmpty()){
			r=q.dequeue(); visit(r);
			for(j=0;j<n;j++)
				if(!enqueued[j] && a[r][j]>0)  {
					q.enqueue(j); enqueued[j]=true;
				}
		}
		System.out.println();
	}
	boolean isConnected(){
		MyStack s = new MyStack();
		boolean [] pushed = new boolean[n];
		int i,j,r;
		for(i=0;i<n;i++) pushed[i]=false;  
		s.push(0); pushed[0]=true;
		while(!s.isEmpty()){
			r=s.pop();
			for(i=0;i<n;i++)
				if(!pushed[i] && a[r][i]>0) {s.push(i);pushed[i]=true;}
		}
		for(i=0;i<n;i++) 
			if(!pushed[i]) return(false);
		return(true);
	} 
	int degree(int k){
		int j,s;
		s=0;
		for(j=0;j<n;j++)
			if(a[k][j]>0) s++;
		if(a[k][k]>0) s++;
		return(s);
	}
}
public class CheckConectivity {
	public static void main(String [] args){
		GraphCheck g = new GraphCheck();
		int [][] b = {
				{0,1,1,0,1},
				{1,0,1,0,0},
				{1,1,0,1,0},
				{0,0,1,0,0},
				{1,0,0,0,0},
		};
		g.setData(b);
		g.depth(0);
		g.breadth(1);
		int [][] c = 
			{
					{0,  0,  0,  0,  1,  1,  1,  0,  1},
					{0,  0,  0,  0,  0,  0,  1,  0,  1},
					{0,  0,  0,  0,  0,  0,  0,  1,  0}, 
					{0,  0,  0,  0,  0,  0,  0,  1,  0}, 
					{1,  0,  0,  0,  0,  1,  0,  0,  1},
					{1,  0,  0,  0,  1,  0,  0,  0,  1},
					{1,  1,  0,  0,  0,  0,  0,  0,  0},
					{0,  0,  1,  1,  0,  0,  0,  0,  0},
					{1,  0,  0,  0,  1,  1,  0,  0,  0}
			};
		GraphCheck h = new GraphCheck();
		h.clear();
		h.setData(c);
		h.depth(0);
		h.breadth(1);
		System.out.println("Is G is connected? " + g.isConnected());
		System.out.println("Is H is connected? " + h.isConnected());

		System.out.println("Degree of the vertex A in H is " + h.degree(0));
		System.out.println();  
	}


}
