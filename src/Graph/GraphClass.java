package Graph;

import java.util.LinkedList;

class MyQueue1 {

	LinkedList<Integer> t;
	MyQueue1() {t = new LinkedList<Integer>();}
	boolean isEmpty() {return(t.isEmpty());}
	void enqueue(int x) {t.add(x);}
	int dequeue() {return(t.removeFirst());}
}

class Graph1 {
	int n, a[][];
	String[] label;
	int color[];
	private LinkedList<Integer> lk[];

	Graph1() {}

	public void setAMatrix(int b[][], int m) {
		n = m;
		a = new int[n][n];
		int i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				a[i][j] = b[i][j];
	}

	public void setLabel(String c[]) {
		label = c;
	}

	void dispAdj() {
		int i,j;
		System.out.print("\nThe adjacency matrix:");  
		for(i=0;i<n;i++) {
			System.out.println();
			for(j=0;j<n;j++) 
				System.out.printf("%5d",a[i][j]);
		}
	}

	void visit(int i) {
		System.out.print(label[i]+" ");
	}

	void depth(boolean [] visited,int i){
		visit(i);visited[i]=true;
		for(int j=0;j<n;j++) 
			if(!visited[j] && a[i][j]>0) depth(visited,j);
	}

	void depth(int k) {
		boolean [] visited = new boolean[n];
		int i,j;
		for(i=0;i<n;i++) 
			visited[i]=false;
		System.out.println("\n\nDepth-first traverse from the vertex " + label[k] + ":");
		depth(visited,k);
		System.out.println();
	}

	void breadth(int k) {
		MyQueue q = new MyQueue();
		boolean [] enqueued = new boolean[n];
		int i,j;
		for(i=0;i<n;i++) enqueued[i]=false;
		q.enqueue(k); enqueued[k] = true;
		int r;
		System.out.println("\nBreadth-first traverse from the vertex " + label[k] + ":");
		while(!q.isEmpty()) {
			r=q.dequeue(); visit(r);
			for(j=0;j<n;j++)
				if(!enqueued[j] && a[r][j]>0) {
					q.enqueue(j); enqueued[j]=true;
				}
		}
		System.out.println();
	}

	boolean isSafe(int v, int g[][], int color[], int c) {
		for ( int i = 0; i < n; i++)
			if (g[v][i] == 1 && c== color[i])
				return false;
		return true;
	}

	boolean graphColoringUtil(int g[][], int m,
			int color[], int v) {
		if ( v == n)
			return true;
		for ( int c = 1; c <= m; c++) {
			if (isSafe(v, g, color, c)) {
				color[v] = c;
				if (graphColoringUtil(g, m, color, v+1))
					return true;
				color[v] = 0;
			}
		}
		return false;
	}

	boolean graphColoring(int g[][], int m) {
		color = new int[n];
		for (int i = 0; i < n; i++)
			color[i] = 0;
		if (!graphColoringUtil(g, m, color, 0)) {
			System.out.println("Solution doesnt exits");
			return false;
		}
		printSolution(color);
		return true;
	}

	void printSolution(int color[]) {
		System.out.println("\nColor for the graph : " );
		for ( int i = 0; i < n; i++)
			System.out.println("Vertex " + label[i] + 
					" --> Color " + color[i]);
	}
}

class MyStack1 {
	LinkedList a;
	MyStack1() {a = new LinkedList();}
	boolean isEmpty() {return(a.isEmpty());}
	void push(int x) {
		a.add(new Integer(x));
	}
	int pop() {
		return((Integer) a.removeLast());
	}
}
class WGraph {
	int n, a[][];
	static int INF = 99;
	String []label;

	public WGraph() {}

	public void setWeight(int b[][], int m) {
		n = m;
		a = new int[n][n];
		int i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				a[i][j] = b[i][j];
	}

	void displayWeights() {
		int i,j;
		System.out.print("\nThe weighted matrix of the graph:");
		for(i=0;i<n;i++) {
			System.out.println();
			for(j=0;j<n;j++) 
				if(a[i][j]==INF)
					System.out.printf(" INF");
				else
					System.out.printf("%4d",a[i][j]);
		}
		System.out.println();
	}

	int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < n; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}

	public void setLabel(String c[]) {
		label = c;
	}

	void printSolution(int dist[], int m) {
		System.out.println("\nVertex\tDistance from Source");
		for (int i = 0; i < n; i++) {
			System.out.println("  " + label[i]+"\t\t"+dist[i]);
		}
	}

	void dijkstra(int g[][], int src) {
		int dist[] = new int[n];
		Boolean sptSet[] = new Boolean[n];
		for(int i = 0; i<n; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < n-1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for(int v = 0; v < n; v++)
				if(!sptSet[v] && g[u][v] != 0
				&& dist[u] != Integer.MAX_VALUE &&
				dist[u] + g[u][v] < dist[v])
					dist[v] = dist[u] + g[u][v];
		}
		printSolution(dist, n);
	}

	void printMST(int parent[], int m, int g[][]) {
		System.out.println("\n Edge\t\tWeight");
		for (int i = 1; i < n; i++)
			System.out.println(label[parent[i]] + " -> " + label[i] 
					+ "\t\t  " + g[i][parent[i]]);
	}

	void primMST(int g[][]) {
		int parent[] = new int[n];
		int key[] = new int[n];
		Boolean mstSet[] = new Boolean[n];

		for(int i = 0; i < n; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int c = 0; c < n -1; c++) {
			int u = minDistance(key, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < n; v++)
				if (g[u][v] != 0 && mstSet[v] == false
				&& g[u][v] < key[v]) {
					parent[v] = u;
					key[v] = g[u][v];
				}
		}
		printMST(parent, n, g);
	}
}
public class GraphClass {


	public static void main(String[] args) {
		
		Graph1 g = new Graph1();
		String c[] = {"A", "B", "C", "D", "E"};
		int [][] b = {
				{0,1,1,0,1},
				{1,0,1,0,0},
				{1,1,0,1,0},
				{0,0,1,0,0},
				{1,0,0,0,0},
		};
		g.setAMatrix(b, 5);
		g.setLabel(c);
		g.dispAdj();
		g.depth(0);
		g.breadth(1);
		g.graphColoring(b, 5);

		System.out.println("\n=================================================");

		WGraph wg = new WGraph();
		String d[] = {"A","B", "C", "D", "E", "F", "G", "H", "I"};
		int graph[][] = {
				{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
				{4, 0, 8, 0, 0, 0, 0, 11, 0}, 
				{0, 8, 0, 7, 0, 4, 0, 0, 2}, 
				{0, 0, 7, 0, 9, 14, 0, 0, 0}, 
				{0, 0, 0, 9, 0, 10, 0, 0, 0}, 
				{0, 0, 4, 14, 10, 0, 2, 0, 0}, 
				{0, 0, 0, 0, 0, 2, 0, 1, 6}, 
				{8, 11, 0, 0, 0, 0, 1, 0, 7}, 
				{0, 0, 2, 0, 0, 0, 6, 7, 0} 
		};
		wg.setLabel(d);
		wg.setWeight(graph, 9);
		wg.displayWeights();
		wg.dijkstra(graph, 0);
		wg.primMST(graph);
	}



}
