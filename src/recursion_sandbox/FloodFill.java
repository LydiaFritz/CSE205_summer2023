package recursion_sandbox;

import java.util.Random;
import java.util.Scanner;

public class FloodFill {

	public static void main(String[] args) {
		FloodFill f = new FloodFill();
		f.showGrid();
		
		System.out.println("\n\nEnter a row and column: ");
		Scanner kb = new Scanner(System.in);
		int row = kb.nextInt();
		int col = kb.nextInt();
		f.processGuess(row, col);
		f.revealGrid();
	}
	
	
	public class Cell{
		public int row;
		public int col;
		public boolean revealed;
		public int liveNeighbors;
		public Cell(int r, int c) {
			row = r;
			col = c;
			revealed = false;
			liveNeighbors = 0;
		}
	}

	private Cell[][] grid = new Cell[10][10];

	public FloodFill() {
		randomizeGrid();
		setCells();
	}
	
	public void processGuess(int row, int col) {
		if(isValid(row, col)) {
			//see if it is a bomb
			if(grid[row][col].liveNeighbors == 9) {
				System.out.println("You lose!");
				revealGrid();
			}
			else {
				floodFill(row, col);
			}
		}
		
	}
	
	private void floodFill(int r, int c) {
		if(!isValid(r, c))return;
		else if(grid[r][c].revealed)return;
		else {
			//fill the neighbors
			grid[r][c].revealed = true;
			floodFill(r+1, c);
			floodFill(r, c+1);
			floodFill(r-1, c);
			floodFill(r, c-1);
		}
	}

	private void randomizeGrid() {
		Random rnd = new Random();
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				grid[row][col] = new Cell(row, col);
				if (rnd.nextDouble() < .13) {
					grid[row][col].liveNeighbors = 9; // a bomb
				} else
					grid[row][col].liveNeighbors = 0;
			}
		}
	}
	
	public void revealGrid() {
		System.out.print(" ");
		for (int i = 0; i < 10; i++)
			System.out.print("----");
		System.out.println();

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (grid[row][col].liveNeighbors == 9) {
					System.out.printf("| * ");
				} else {
					System.out.printf("| %d ", grid[row][col]);
				}
			}
			System.out.println("|");
		}

		for (int i = 0; i < 10; i++)
			System.out.print("----");
	}

	public void showGrid() {

		System.out.print(" ");
		for (int i = 0; i < 10; i++)
			System.out.print("----");
		System.out.println();

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if(grid[row][col].revealed)
					System.out.print("| " + grid[row][col].liveNeighbors);
				else
					System.out.print("| ? ");
			}
			System.out.println("|");
		}

		for (int i = 0; i < 10; i++)
			System.out.print("----");
	}

	private void setCells() {
		int bombNeighbor = 0;
		//count neighboring bombs for each cell
		for(int row = 0; row < 10; row++)
			for(int col = 0; col < 10; col++) {
				bombNeighbor = 0;
				
				if(grid[row][col].liveNeighbors == 9);
				
				else {
				//check all directions around this cell
				//NORTH
				if(isValid(row-1, col) && grid[row-1][col].liveNeighbors == 9) bombNeighbor++;
				//NORTHEAST
				if(isValid(row-1, col+1) && grid[row-1][col+1].liveNeighbors  == 9) bombNeighbor++;
				//EAST
				if(isValid(row, col+1) && grid[row][col+1].liveNeighbors  == 9) bombNeighbor++;
				//SE
				if(isValid(row+1, col+1) && grid[row+1][col+1].liveNeighbors  == 9) bombNeighbor++;
				//SOUTH
				if(isValid(row+1, col) && grid[row+1][col].liveNeighbors  == 9) bombNeighbor++;
				//SW
				if(isValid(row+1, col-1) && grid[row+1][col-1].liveNeighbors  == 9) bombNeighbor++;
				//W
				if(isValid(row, col-1) && grid[row][col-1].liveNeighbors  == 9) bombNeighbor++;
				//NW
				if(isValid(row-1, col-1) && grid[row-1][col-1].liveNeighbors  == 9) bombNeighbor++;
				grid[row][col].liveNeighbors  = bombNeighbor;
				}
				
			}
	}

	private boolean isValid(int row, int col) {
		return 0 <= row && row < 10 && 0 <= col && col < 10;
	}

}
