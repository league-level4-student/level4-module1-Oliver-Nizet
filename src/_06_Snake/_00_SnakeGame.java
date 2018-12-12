package _06_Snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

// Go through the methods and complete the steps in this class
// and the Snake class

public class _00_SnakeGame implements ActionListener, KeyListener {
	public static final Color BORDER_COLOR = Color.WHITE;
	public static final Color bcl = new Color(148, 224, 78);
	public static final Color BACKGROUND_COLOR_LIGHT = bcl;
	public static final Color bcd = new Color(140, 218, 70);
	public static final Color BACKGROUND_COLOR_DARK = bcd;
	public static final Color fc = new Color(250, 42, 0);
	public static final Color FOOD_COLOR = fc;
	public static final int WIDTH = 15;
	public static final int HEIGHT = 12;
	public static final int WINDOW_SCALE = 50;
	public static final int WINDOW_WIDTH = WINDOW_SCALE * WIDTH;
	public static final int WINDOW_HEIGHT = WINDOW_SCALE * HEIGHT;

	private JFrame window;
	private JPanel panel;

	private Snake snake;

	private Timer timer;

	private Location foodLocation;

	public _00_SnakeGame() {
		snake = new Snake(new Location(WIDTH / 2, HEIGHT / 2));

		window = new JFrame("Snake");
		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setColor(BACKGROUND_COLOR_LIGHT);
				g2.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
				g2.setColor(BACKGROUND_COLOR_DARK);
				g2.fillRect(0, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(0, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(0, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(0, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(0, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(0, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE, 0, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE, WINDOW_SCALE * 2, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE, WINDOW_SCALE * 4, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE, WINDOW_SCALE * 6, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE, WINDOW_SCALE * 8, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE, WINDOW_SCALE * 10, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 2, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 2, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 2, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 2, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 2, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 2, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 3, 0, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 3, WINDOW_SCALE * 2, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 3, WINDOW_SCALE * 4, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 3, WINDOW_SCALE * 6, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 3, WINDOW_SCALE * 8, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 3, WINDOW_SCALE * 10, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 4, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 4, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 4, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 4, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 4, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 4, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 5, 0, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 5, WINDOW_SCALE * 2, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 5, WINDOW_SCALE * 4, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 5, WINDOW_SCALE * 6, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 5, WINDOW_SCALE * 8, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 5, WINDOW_SCALE * 10, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 6, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 6, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 6, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 6, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 6, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 6, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 7, 0, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 7, WINDOW_SCALE * 2, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 7, WINDOW_SCALE * 4, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 7, WINDOW_SCALE * 6, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 7, WINDOW_SCALE * 8, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 7, WINDOW_SCALE * 10, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 8, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 8, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 8, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 8, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 8, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 8, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 9, 0, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 9, WINDOW_SCALE * 2, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 9, WINDOW_SCALE * 4, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 9, WINDOW_SCALE * 6, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 9, WINDOW_SCALE * 8, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 9, WINDOW_SCALE * 10, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 10, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 10, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 10, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 10, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 10, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 10, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 11, 0, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 11, WINDOW_SCALE * 2, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 11, WINDOW_SCALE * 4, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 11, WINDOW_SCALE * 6, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 11, WINDOW_SCALE * 8, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 11, WINDOW_SCALE * 10, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 12, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 12, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 12, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 12, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 12, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 12, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 13, 0, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 13, WINDOW_SCALE * 2, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 13, WINDOW_SCALE * 4, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 13, WINDOW_SCALE * 6, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 13, WINDOW_SCALE * 8, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 13, WINDOW_SCALE * 10, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 14, WINDOW_SCALE, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 14, WINDOW_SCALE * 3, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 14, WINDOW_SCALE * 5, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 14, WINDOW_SCALE * 7, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 14, WINDOW_SCALE * 9, snake.BODY_SIZE, snake.BODY_SIZE);
				g2.fillRect(WINDOW_SCALE * 14, WINDOW_SCALE * 11, snake.BODY_SIZE, snake.BODY_SIZE);

				g2.setColor(FOOD_COLOR);
				g2.fillOval(foodLocation.x * WINDOW_SCALE, foodLocation.y * WINDOW_SCALE, Snake.BODY_SIZE,
						Snake.BODY_SIZE);
				snake.draw(g);
			}
		};

		panel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		window.add(panel);

		timer = new Timer(0, this);

		window.pack();
		window.addKeyListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		setFoodLocation();

		startGame();
	}

	public void startGame() {
		// 1. Save the instructions for the game in the following string
		// variable.
		String instructions = "Use the arrow keys to move and collect the food";

		String[] options = new String[] { "Expert", "Moderate", "Beginner" };
		int input = JOptionPane.showOptionDialog(null, instructions, "Snake", 0, -1, null, options, 0);

		String choice = options[input];

		// 2. Use a switch statement to determine which difficulty was chosen.
		// Use timer.setDelay(delay) with different numbers to change the speed
		// of the game. The smaller the number, the faster it goes.
		switch (input) {
		case 0:
			timer.setDelay(100);
			break;
		case 1:
			timer.setDelay(150);
			break;
		case 2:
			timer.setDelay(200);
			break;
		}
		// 3. start the timer
		timer.start();
		snake.feed();
		snake.feed();
	}

	public static void main(String[] args) {
		new _00_SnakeGame();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 1. Use a switch statement on e.getKeyCode()
		// to determine which key was pressed.
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			snake.setDirection(Direction.UP);
			break;
		case KeyEvent.VK_DOWN:
			snake.setDirection(Direction.DOWN);
			break;
		case KeyEvent.VK_LEFT:
			snake.setDirection(Direction.LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			snake.setDirection(Direction.RIGHT);
			break;
		case KeyEvent.VK_SPACE:
			snake.feed();
			break;
		default:
			break;
		}
		// if an arrow key is pressed, set the snake's
		// direction accordingly

		// if the space key is pressed, call the snake's feed method
	}

	private void setFoodLocation() {
		// 1. Create a new Location object that is set to a random location
		Random ran = new Random();
		int ranX = ran.nextInt(15);
		int ranY = ran.nextInt(12);
		Location loc = new Location(ranX, ranY);
		// 2. set the foodLocation variable equal to the Location object you
		// just created.
		// use the snake's isLocationOnSnake method to make sure you don't put
		// the food on the snake
		foodLocation = loc;
	}

	private void gameOver() {
		// 1. stop the timer
		timer.stop();
		// 2. tell the user their snake is dead
		JOptionPane.showMessageDialog(null, "Your Snake is Dead\nYour Score was " + (Snake.snake.size() - 3));
		// 3. ask them if they want to play again.
		String[] options = new String[] { "No", "Yes" };
		int a = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Snake", 0, -1, null, options, 0);
		// 4. if they want to play again
		// reset the snake and the food and start the timer
		// else, exit the game
		switch (a) {
		case 0:
			System.exit(0);
			break;
		case 1:
			Location s = new Location(7, 6);
			snake.reset(s);
			setFoodLocation();
			timer.start();
			snake.feed();
			snake.feed();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. update the snake
		snake.update();
		// 2. if the snake is colliding with its own body
		// or if the snake is out of bounds, call gameOver
		if (snake.isHeadCollidingWithBody() || snake.isOutOfBounds()) {
			gameOver();
		}
		// 3. if the location of the head is equal to the location of the food,
		// feed the snake and set the food location
		if (snake.getHeadLocation().equals(foodLocation)) {
			snake.feed();
			setFoodLocation();
		}
		// 4. call panel.repaint();
		panel.repaint();
	}
}
