package snake.objaects;

public class Snake {
// direction of motion of the snake
	public int direction = 0;
// length of snake
	public int length = 2;
// the maximum number of elements in a snake
	public int snakeX[] = new int[100];
	public int snakeY[] = new int[100];
// the initial location of our snake	
	public Snake(int x0, int y0, int x1, int y1) {
		snakeX[0] = x0;
		snakeY[0] = y0;
		snakeX[1] = x1;
		snakeY[1] = y1;
	}

	public void move() {
		// ???	
		for(int d = length; d > 0; d--) {
			snakeX[d] = snakeX[d-1];
			snakeY[d] = snakeY[d-1];
		}
// The direction of movement of our snake depends on the arrow		
		if (direction == 0) snakeY[0]--;
		if (direction == 1) snakeX[0]++;
		if (direction == 2) snakeY[0]++;
		if (direction == 3) snakeX[0]--;
	}
}
