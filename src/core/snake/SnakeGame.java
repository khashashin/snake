package core.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import snake.objaects.Snake;

@SuppressWarnings("serial")
public class SnakeGame extends JPanel implements ActionListener{
// one step size
	public static final int SCALE = 32;
// the size of one square
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	public static final int SPEED = 5;

	Snake s = new Snake(10, 10, 9, 10);
	Timer t = new Timer(1000/SPEED, this);
	
	public SnakeGame() {
		t.start();
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
	}
	
	public Color color(int red, int green, int blue) {
		return new Color(red, green, blue);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
// size of the playing field
		f.setSize(WIDTH*SCALE+7, HEIGHT*SCALE+30);
		f.setLocationRelativeTo(null);
		f.add(new SnakeGame());
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		s.move();
		
		repaint();
		
	}

}
