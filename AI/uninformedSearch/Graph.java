package uninformedSearch;

import java.util.*;

public class Graph {
	
	private int vertice;
	private int edge;
	private LinkedList<Integer>[] adjList;
	private int[][] adjMatrix;
	
	@SuppressWarnings("unchecked")
	Graph(int v) {
        this.vertice = v;
        this.edge = 0;
        this.adjList = new LinkedList[v];
        this.adjMatrix = new int[v][v];
        for(int i = 0; i < v; i++) {
        	this.adjList[i] = new LinkedList<Integer>();
        }
    }
	
	public void addEdge(int src, int des) {
		this.adjList[src].add(des);
		this.adjList[des].add(src);
		this.adjMatrix[src][des] = 1;
		this.adjMatrix[des][src] = 1;
		edge++;
	}
	
	public void addEdge(int src, int des, int weight) {
		this.adjList[src].add(des);
		this.adjList[des].add(src);
		this.adjMatrix[src][des] = weight;
		this.adjMatrix[des][src] = weight;
		edge++;
	}

	public LinkedList<Integer>[] getAdjList() {
		return adjList;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public int getVertice() {
		return vertice;
	}

	public int getEdge() {
		return edge;
	}
	
}
