package core.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import snake.objaects.Apple;
import snake.objaects.Snake;

@SuppressWarnings("serial")
public class SnakeGame extends JPanel implements ActionListener{
// one step size
	public static final int SCALE = 32;
// the size of one square
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	public static final int SPEED = 5;
	
	// apple with random position
	Apple a = new Apple((int)(Math.random()*WIDTH), (int)(Math.random()*HEIGHT));
	// snake
	Snake s = new Snake(10, 10, 9, 10);
	// snake speed
	Timer t = new Timer(1000/SPEED, this);
	
	public SnakeGame() {
		t.start();
		addKeyListener(new Keyboard());
		setFocusable(true);
	}
	
	public void paint(Graphics g) {
// color of the playing field
		g.setColor(color(5, 50, 10));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
// lines color
		g.setColor(color(255, 216, 0));
// number of lines on the scale x
		for(int xx = 0; xx <= WIDTH*SCALE; xx+=SCALE) {
			g.drawLine(xx, 0, xx, HEIGHT*SCALE);
		}
// number of lines on the scale y
		for(int yy = 0; yy <= WIDTH*SCALE; yy+=SCALE) {
			g.drawLine(0, yy, WIDTH*SCALE, yy);
		}
// draw the very snake		
		for(int d = 0; d < s.length; d++) {
			g.setColor(color(200, 130, 50));
			g.fillRect(s.snakeX[d]*SCALE+1, s.snakeY[d]*SCALE+1, SCALE-1, SCALE-1);
		}
// we paint our apple		
		g.setColor(color(255, 0, 0));
		g.fillRect(a.posX*SCALE+1, a.posY*SCALE+1, SCALE-1, SCALE-1);
	}
	
	public Color color(int red, int green, int blue) {
		return new Color(red, green, blue);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
// size of the playing field
		f.setSize(WIDTH*SCALE+7, HEIGHT*SCALE+29);
		f.setLocationRelativeTo(null);
		f.add(new SnakeGame());
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s.move();
		if((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
			a.setRandomPosition();
			s.length++;
		}
		for(int k = 1; k < s.length; k++) {
			if((s.snakeX[k] == a.posX) & (s.snakeY[k] == a.posY)) {
				a.setRandomPosition();
				s.length++;
			}			
		}
		if((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
			a.setRandomPosition();
			s.length++;
		}
		repaint();		
	}
	
	private class Keyboard extends KeyAdapter {
		public void keyPressed(KeyEvent kEvt) {
			int key = kEvt.getKeyCode();
// transfer direction to our variable direction			
			if((key == KeyEvent.VK_UP) & s.direction != 2) s.direction = 0;
			if((key == KeyEvent.VK_RIGHT) & s.direction != 3) s.direction = 1;
			if((key == KeyEvent.VK_DOWN) & s.direction != 0) s.direction = 2;
			if((key == KeyEvent.VK_LEFT) & s.direction != 1) s.direction = 3;
		}
	}

}
