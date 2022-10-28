package uninformedSearch;

import java.util.*;

public class DepthFirstSearch extends Graph{
	
	private static int size;
	private static LinkedList<Integer>[] list;
	
	DepthFirstSearch(int v) {
		super(v);
		size=getVertice();
		list=getAdjList();
	}
	
	public static void iterativeDFS(int v) {
		boolean[] visited = new boolean[size];
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		while(!stack.isEmpty()) {
			int u = stack.pop();
			if(!visited[u]) {
				visited[u]=true;
				System.out.print(u + " ");
				for(int i : list[u]) {
					if(!visited[i]) {
						stack.push(i);
					}
				}
			}
		}
	}
	
	public static void recursiveDFS() {
		boolean[] visited = new boolean[size];
		for(int i=0; i<size; i++) {
			if(!visited[i]) {
				recursiveDFS(i, visited);
			}
		}
	}	
	public static void recursiveDFS(int i, boolean[] visited) {
		visited[i]=true;
		System.out.print(i + " ");
		for(int j : list[i]) {
			if(!visited[j]) {
				recursiveDFS(j, visited);
			}
		}
	}

	public static void main(String[] args) {
		
		DepthFirstSearch g = new DepthFirstSearch(5);
		
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(3, 4);
		g.addEdge(4, 0);
		
		System.out.println("Adjacent List: ");
		for(LinkedList<Integer> item : list) {
			System.out.println(item);
		}
		
		System.out.println();
		System.out.println("Iterative Depth First Search: ");
		iterativeDFS(2);
		
		System.out.println();
		System.out.println("Recursive Depth First Search: ");
		recursiveDFS();
	
	}

}

