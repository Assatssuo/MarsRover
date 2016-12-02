import java.awt.Point;
public class Rover {
	private char direction;

	public Rover(char d) {
		direction = d;
	}

	public void turn(char side) {

		if (side == 'L') {
			switch (getDirection()) {
			case 'N':
				setDirection('W');
				break;
			case 'W':
				setDirection('S');
				break;
			case 'S':
				setDirection('E');
				break;
			case 'E':
				setDirection('N');
				break;
			}
		} else {
			switch (getDirection()) {
			case 'N':
				setDirection('E');
				break;
			case 'W':
				setDirection('N');
				break;
			case 'S':
				setDirection('W');
				break;
			case 'E':
				setDirection('S');
				break;
			}
		}
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char d) {
		direction = d;
	}
	
	public void command(String c, Plateau plateau){
		char[] commands = c.toCharArray();
		
		for(int i = 0; i < commands.length; i++){
			if(commands[i]=='M'){
				move(this, plateau.getWid(), plateau.getLen(), plateau );
			}else{
				turn(commands[i]);
			}
			
		}
	}
	
	public void move(Rover r, int wid, int len, Plateau plateau){
		Rover[][] grid = plateau.getGrid();
		for(int i = 0; i < wid; i++){
			for(int j = 0; j < len; j++){
				if(grid[i][j] == r){
					switch (r.getDirection()) {
					case 'N':
						if(!(j == grid[0].length-1)){
							grid[i][j + 1] = r;
							grid[i][j] = null;
						}						
						break;
					case 'W':
						if(!(i == 0)){
							grid[i - 1][j] = r;
							grid[i][j] = null;
						}
						break;
					case 'S':
						if(!(j == 0)){
							grid[i][j - 1] = r;
							grid[i][j] = null;
						}						
						break;
					case 'E':
						if(!(i == grid.length-1)){
							grid[i + 1][j] = r;
							grid[i][j] = null;
						}						
						break;
					}
				}
			}
		}
	}
}
