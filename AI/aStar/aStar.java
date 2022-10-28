package aStar;

import java.util.*;

public class aStar extends Graph{
	
	private static int mat[][];
	private static LinkedList<Integer>[] list;
	ArrayList<Integer> openList = new ArrayList<>();
	ArrayList<Integer> closedList = new ArrayList<>();

	aStar(int v) {
		super(v);
		mat = getAdjMatrix();
		list = getAdjList();
	}
	
	public void astar(int start, int goal, int[] h) {
		openList.add(start);
		int temp = 0;
		while(!openList.isEmpty()) {
			if(openList.size()==1) {
				temp = openList.remove(0);
				closedList.add(temp);
				if(temp==goal) {
					System.out.println("Success! Path is: ");
					System.out.println(closedList);
				}
				else {
					neighbours(temp);
				}
			}
			else {
				int n = temp;
				int min = 100;
				int f = 0;
				for(int item : openList) {
					if(!closedList.contains(item)) {
						f = h[item] + mat[item][temp];
						if(f<min) {
							min=f;
							n=item;
						}
					}
				}
				int index = openList.indexOf(n);
				temp = openList.remove(index);
				closedList.add(temp);
				openList.clear();
				if(temp==goal) {
					System.out.println("Success! Path is: ");
					System.out.println(closedList);
				}
				else {
					neighbours(temp);
				}
			}
		}
		if(!closedList.contains(goal)) {
			System.out.println("Path Not Found");
		}
	}

	private void neighbours(int temp) {
		for(int item : list[temp]) {
			openList.add(item);
		}
	}

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter number of nodes: ");
//		int n = sc.nextInt();
//		System.out.println("Enter number of edges: ");
//		int e = sc.nextInt();
//		
//		aStar g = new aStar(n);
//		
//		for(int i=0; i<e; i++) {
//			System.out.println("Enter source node: ");
//			int src = sc.nextInt();
//			System.out.println("Enter destination node: ");
//			int des = sc.nextInt();
//			System.out.println("Enter weight of edge between these two nodes: ");
//			int weight = sc.nextInt();
//			g.addEdge(src, des, weight);
//		}
		
		aStar g = new aStar(6);
		
		g.addEdge(0, 1, 4);
		g.addEdge(0, 2, 2);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 4, 1);
		g.addEdge(3, 5, 6);
		g.addEdge(4, 5, 1);
		
		int h[] = {0, 4, 2, 7, 2, 3};
		
		g.astar(0, 5, h);
		
	}

}
