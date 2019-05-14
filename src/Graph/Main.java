package Graph;

import java.util.LinkedList;

class MyQueue{
	LinkedList<Integer> t;
	MyQueue() {t = new LinkedList<Integer>();}
	boolean isEmpty() {return(t.isEmpty());}
	void enqueue(int x) {t.add(x);}
	int dequeue() {return(t.removeFirst());}
}
class Graph{
	int [][] a; int n;
	char [] v;
	Graph() {v = "ABCDEFGHIJKLMN".toCharArray();}
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
		int i,j;
		for(i=0;i<n;i++) visited[i]=false;
		System.out.println("\nDepth-first traverse from the vertex " + v[k] + ":");
		depth(visited,k);
		System.out.println();
	}
	void breadth(int k){
		MyQueue q = new MyQueue();
		boolean [] enqueued = new boolean[n];
		int i,j;
		for(i=0;i<n;i++) enqueued[i]=false;
		q.enqueue(k); enqueued[k] = true;
		int r;
		System.out.println("\nBreadth-first traverse from the vertex " + v[k] + ":");
		while(!q.isEmpty()){
			r=q.dequeue(); visit(r);
			for(j=0;j<n;j++)
				if(!enqueued[j] && a[r][j]>0) {
					q.enqueue(j); enqueued[j]=true;
				}
		}
		System.out.println();
	}
}
public class Main {
	public static void main(String [] args){
		Graph g = new Graph();
		int [][] b = {
				{0,1,1,0,1},
				{1,0,1,0,0},
				{1,1,0,1,0},
				{0,0,1,0,0},
				{1,0,0,0,0},
		};
		g.setData(b);
		g.dispAdj();
		g.depth(0);
		g.breadth(1);
		System.out.println();  
	}
}
