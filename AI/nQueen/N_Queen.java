package nQueen;

public class N_Queen {

	public static void main(String[] args) {
		
		int Board[][] = new int[4][4];
		
		nQueen(Board, 0);
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				System.out.print(Board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static boolean nQueen(int Board[][], int row) {
		if(row==4) {
			return true;
		}
		for(int col=0; col<4; col++) {
			if(isSafe(Board, row, col)) {
				Board[row][col]=1;
				if(nQueen(Board, row+1)) {
					return true;
				}
				Board[row][col]=0;
			}	
		}
		return false;
	}
	
	public static boolean isSafe(int Board[][], int row, int col) {
		
		for(int i=row; i>=0; i--) {
			if(Board[i][col]==1) {
				return false;
			}
		}
		
		for(int j=col; j>=0; j--) {
			if(Board[row][j]==1) {
				return false;
			}
		}
		
		for(int i=row, j=col; i>=0 && j<4; i--, j++) {
			if(Board[i][j]==1) {
				return false;
			}
		}
		
		for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
			if(Board[i][j]==1) {
				return false;
			}
		}

		return true;
	}

}