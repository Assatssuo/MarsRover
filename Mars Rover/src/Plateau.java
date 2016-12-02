import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plateau {

	private Rover[][] grid;
	private int wid;
	private int len;

	public int getWid() {
		return wid;
	}

	public int getLen() {
		return len;
	}

	public Plateau(int x, int y) {
		setGrid(new Rover[x][y]);
		wid = x;
		len = y;
	}

	public void setGrid(Rover[][] grid) {
		this.grid = grid;
	}

	public Rover[][] getGrid() {
		return grid;
	}

	public Rover addRover(int x, int y, char d){
		Rover rover = new Rover(d);
		grid[x][y] = rover;
		return rover;
	}	

}
