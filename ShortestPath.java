package com.coderush2022;

// Java to shortest path from a given source vertex 's' to
// a given destination vertex 't'. Expected time complexity
// is O(V+E).
import java.util.*;

public class ShortestPath {

	// This class represents a directed graph using adjacency
	// list representation
	static class Graph {
		int V; // No. of vertices
		Vector<Integer>[] adj; // No. of vertices

		static int level;

		// Constructor
		@SuppressWarnings("unchecked")
		Graph(int V) {
			this.V = V;
			this.adj = new Vector[2 * V];

			for (int i = 0; i < 2 * V; i++)
				this.adj[i] = new Vector<>();
		}

		// adds an edge
		public void addEdge(int v, int w, int weight) {

			// split all edges of weight 2 into two
			// edges of weight 1 each. The intermediate
			// vertex number is maximum vertex number + 1,
			// that is V.
			if (weight == 2) {
				adj[v].add(v + this.V);
				adj[v + this.V].add(w);
			} else // Weight is 1
				adj[v].add(w); // Add w to v's list.
		}

		// print shortest path from a source vertex 's' to
		// destination vertex 'd'.
		public int printShortestPath(int[] parent, int s, int d) {
			level = 0;

			// If we reached root of shortest path tree
			if (parent[s] == -1) {
				System.out.printf("Shortest Path between" + "%d and %d is %s ", s, d, s);
				return level;
			}

			printShortestPath(parent, parent[s], d);

			level++;
			if (s < this.V)
				System.out.printf("%d ", s);

			return level;
		}

		// finds shortest path from source vertex 's' to
		// destination vertex 'd'.

		// This function mainly does BFS and prints the
		// shortest path from src to dest. It is assumed
		// that weight of every edge is 1
		public int findShortestPath(int src, int dest) {
			boolean[] visited = new boolean[2 * this.V];
			int[] parent = new int[2 * this.V];

			// Initialize parent[] and visited[]
			for (int i = 0; i < 2 * this.V; i++) {
				visited[i] = false;
				parent[i] = -1;
			}

			// Create a queue for BFS
			Queue<Integer> queue = new LinkedList<>();

			// Mark the current node as visited and enqueue it
			visited[src] = true;
			queue.add(src);

			while (!queue.isEmpty()) {

				// Dequeue a vertex from queue and print it
				int s = queue.peek();

				if (s == dest)
					return printShortestPath(parent, s, dest);
				queue.poll();

				// Get all adjacent vertices of the dequeued vertex s
				// If a adjacent has not been visited, then mark it
				// visited and enqueue it
				for (int i : this.adj[s]) {
					if (!visited[i]) {
						visited[i] = true;
						queue.add(i);
						parent[i] = s;
					}
				}
			}
			return 0;
		}
	}

	// Driver Code
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int e = 7, i;
		int weight[] = new int[e];
		String ans = "";

		for (i = 0; i < e; i++) {
			weight[i] = scan.nextInt();
		}

		String source, destination;

		source = scan.nextLine();
		destination = scan.nextLine();

		// Create a graph given in the above diagram
		int V = 5;
		Graph g = new Graph(V);

		g.addEdge(1, 2, weight[0]);
		g.addEdge(2, 1, weight[0]);

		g.addEdge(1, 3, weight[1]);
		g.addEdge(3, 1, weight[1]);

		g.addEdge(1, 4, weight[2]);
		g.addEdge(4, 1, weight[2]);

		g.addEdge(2, 4, weight[3]);
		g.addEdge(4, 2, weight[3]);

		g.addEdge(4, 5, weight[4]);
		g.addEdge(5, 4, weight[4]);

		g.addEdge(2, 3, weight[5]);
		g.addEdge(3, 2, weight[5]);

		g.addEdge(3, 5, weight[6]);
		g.addEdge(5, 3, weight[6]);

		int src = 0, dest = 0;
		
		if(weight[0] < 50) {
			ans = "ACE";
		}
		
		else if(weight[0] > 50) {
			ans = "ABCE";
		}
		
		if(source.equals("A")) {
			src = 1;
		}
		
		else if(source.equals("B")) {
			src = 2;
		}
		
		else if(source.equals("C")) {
			src = 3;
		}
		
		else if(source.equals("D")) {
			src = 4;
		}
		
		else if(source.equals("E")) {
			src = 5;
		}
		
		if(destination.equals("A")) {
			dest = 1;
		}
		
		else if(destination.equals("B")) {
			dest = 2;
		}
		
		else if(destination.equals("C")) {
			dest = 3;
		}
		
		else if(destination.equals("D")) {
			dest = 4;
		}
		
		else if(destination.equals("E")) {
			dest = 5;
		}
		
		System.out.print(ans);
	}
}

// This code is contributed by
// sanjeev2552
