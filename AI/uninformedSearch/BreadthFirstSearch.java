package uninformedSearch;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends Graph{
	
	private static int size;
	private static LinkedList<Integer>[] list;
	
	BreadthFirstSearch(int v) {
		super(v);
		size=getVertice();
		list=getAdjList();
	}
	
	public static void BFS(int v) {
		boolean[] visited = new boolean[size];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		while(!queue.isEmpty()) {
			int u = queue.poll();
			if(!visited[u]) {
				visited[u]=true;
				System.out.print(u + " ");
				for(int i : list[u]) {
					if(!visited[i]) {
						queue.offer(i);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		BreadthFirstSearch g = new BreadthFirstSearch(5);
		
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
		System.out.println("Iterative Breadth First Search: ");
		BFS(2);
		
	}

}


