package aStar;
import java.util.*;


public class puzzle8 {
	
	public static boolean equal(int[][] a, int[][] b) {
		if(a.length!=b.length) {
			return false;
		}
		else {
			for(int i=0; i<a.length; i++) {
					if(!Arrays.equals(a[i], b[i])) {
						return false;
					}
			}
			return true;
		}
	}
	
	public static void solve(int[][] start, int[][] goal) {
		int[][] next = start;
		try {
			
			if(equal(start, goal)) {
				System.out.println("Solved");
			}
			else{
				while(!equal(next, goal)) {
					//Find empty tile
					int x = 0;
					int y = 0;
					for(int i=0; i<3; i++) {
						for(int j=0; j<3; j++) {
							if(next[i][j]==0) {
								x=i;
								y=j;
							}
						}
					}
					//Find neighbors
					next = getNeighbour(next, goal, x, y);
				}
				System.out.println("Solved!");
			}
		}
		catch(StackOverflowError err) {
			System.out.println(err);
		}
		catch(Throwable th) {
			System.out.println(th);
		}
		
	}
	
	
	public static int calculateH(int[][] curr, int[][] goal) {
		int h=0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(curr[i][j]==goal[i][j]) {
					h++;
				}
			}
		}
		return h;
	}
	
	public static int[][] getNeighbour(int[][] curr, int[][] goal, int i, int j){
		
		int[][] _a = curr;
		int[][] _b = curr;
		int[][] _c = curr;
		int[][] _d = curr;
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		
		if(i>0) {
			//top
			a = calculateH(top(_a, i, j), goal);
		}
		if(i<2) {
			//bottom
			b = calculateH(bottom(_b, i, j), goal);
		}
		if(j>0) {
			//left
			c = calculateH(left(_c, i, j), goal);
		}
		if(j<2) {
			//right
			d = calculateH(right(_d, i, j), goal);
		}
		
		if(i==0 && j==1) {
			if(d > c && d > b)
	        {
	            return right(curr, i, j);
	        }
	        else if(c > b)
	        {
	            return left(curr, i, j);
	        }
	        else
	        {
	            return bottom(curr, i, j);
	        }
		}
		
		if(i==1 && j==2) {
			if(a > c && a > b)
	        {
	            return top(curr, i, j);
	        }
	        else if(c > b)
	        {
	            return left(curr, i, j);
	        }
	        else
	        {
	            return bottom(curr, i, j);
	        }
		}
		
		if(i==2 && j==1) {
			if(a > d && a > c)
	        {
	            return top(curr, i, j);
	        }
	        else if(d > c)
	        {
	            return right(curr, i, j);
	        }
	        else
	        {
	            return left(curr, i, j);
	        }
		}
		
		if(i==1 && j==0) {
			if(a > d && a > b)
	        {
	            return top(curr, i, j);
	        }
	        else if(d > b)
	        {
	            return right(curr, i, j);
	        }
	        else
	        {
	            return bottom(curr, i, j);
	        }
		}
		
		if(i==1 && j==1) {
			if (a > d) {
			    if (a > b && a > c) {
			        return top(curr, i, j);
			    } else {
			        if (b > c) {
			            return bottom(curr, i, j);
			        } else {
			            return left(curr, i, j);
			        }
			    }
			} else {
			    if (d > b && d > c) {
			        return right(curr, i, j);
			    } else {
			        if (b > c) {
			            return bottom(curr, i, j);
			        } else {
			            return left(curr, i, j);
			        }
			    }
			}
		}
		
		if(i==0 && j==0) {
			if(d > b) {
				return right(curr, i, j);
			}
			else {
				return bottom(curr, i, j);
			}
		}
		
		if(i==0 && j==2) {
			if(c > b) {
				return left(curr, i, j);
			}
			else {
				return bottom(curr, i, j);
			}
		}
		
		if(i==2 && j==0) {
			if(a > d) {
				return top(curr, i, j);
			}
			else {
				return right(curr, i, j);
			}
		}
		
		if(i==2 && j==2) {
			if(a > c) {
				return top(curr, i, j);
			}
			else {
				return left(curr, i, j);
			}
		}
		
		return curr;
	}
	
	public static int[][] top(int[][] curr, int i, int j){
		curr[i][j] = curr[i-1][j];
		curr[i-1][j] = 0;
		return curr;
	}
	public static int[][] bottom(int[][] curr, int i, int j){
		curr[i][j] = curr[i+1][j];
		curr[i+1][j] = 0;
		return curr;
	}
	public static int[][] left(int[][] curr, int i, int j){
		curr[i][j] = curr[i][j-1];
		curr[i][j-1] = 0;
		return curr;
	}
	public static int[][] right(int[][] curr, int i, int j){
		curr[i][j] = curr[i][j+1];
		curr[i][j+1] = 0;
		return curr;
	}
	
	
	public static void main(String[] args) {
		
		int[][] boardInit = {
				{2,8,3},
				{1,6,4},
				{7,0,5}
		};
		
		int[][] boardFinal = {
				{1,2,3},
				{8,0,4},
				{7,6,5}
		};
		
		solve(boardInit, boardFinal);
		
	}

}
