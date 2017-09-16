package snake.objaects;

import core.snake.SnakeGame;

public class Snake {
	
	SnakeGame main;
// direction of motion of the snake
	public int direction = 0;
// length of snake on start
	public int length = 2;
// the maximum number of elements in a snake
	public int snakeX[] = new int[main.WIDTH*main.HEIGHT];
	public int snakeY[] = new int[main.WIDTH*main.HEIGHT];
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
// the direction of movement of our snake depends on the arrow		
		if (direction == 0) snakeY[0]--;
		if (direction == 1) snakeX[0]++;
		if (direction == 2) snakeY[0]++;
		if (direction == 3) snakeX[0]--;
		// the snake eats itself
		for(int d = length; d > 0; d--) {
			if((snakeX[0] == snakeX[d]) & (snakeY[0] == snakeY[d])) length = d;
		}
		
		if(snakeX[0] > main.WIDTH) snakeX[0] = 0;
		if(snakeX[0] < 0) snakeX[0] = main.WIDTH - 1;
		if(snakeY[0] > main.HEIGHT-1) snakeY[0] = 0;
		if(snakeY[0] < 0) snakeY[0] = main.HEIGHT - 1;
// minimum snake size
		if(length < 2) length = 2;
		
	}

}
