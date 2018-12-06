package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color sc = new Color(85, 105, 250);
	public static final Color SNAKE_COLOR = sc;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		// 1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		// 2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		// 1. use a switch statement to check on the currentDirection
		// of the snake and calculate its next x and y position.
		int nextX;
		int nextY;
		switch (currentDirection) {
		case UP:
			nextX = getHeadLocation().x;
			nextY = getHeadLocation().y - 1;
			break;
		case DOWN:
			nextX = getHeadLocation().x;
			nextY = getHeadLocation().y + 1;
			break;
		case LEFT:
			nextX = getHeadLocation().x - 1;
			nextY = getHeadLocation().y;
			break;
		case RIGHT:
			nextX = getHeadLocation().x + 1;
			nextY = getHeadLocation().y;
			break;
		default:
			nextX = getHeadLocation().x;
			nextY = getHeadLocation().y;
		}
		// 2. Iterate through the SnakeSegments in reverse order
		// 2a. Update each snake segment to the location of the segment
		// in front of it.
		for (int i = snake.size() - 1; i > 0; i--) {
			snake.get(i).setLocation(snake.get(i - 1).getLocation());
		}
		// 3. set the location of the head to the new location calculated in
		// step 1
		Location next = new Location(nextX, nextY);
		head.setLocation(next);
		// 4. set canMove to true
		canMove = true;
	}

	public void setDirection(Direction d) {
		// 1. set the current direction equal to the passed in Direction only if
		// canMove is true.
		// set canMove equal to false.
		// make sure the snake cannot completely reverse directions.
		if (canMove == true) {
			switch (d) {
			case UP:
				if (!currentDirection.equals(Direction.DOWN)) {
					currentDirection = Direction.UP;
					canMove = false;
				}
				break;
			case DOWN:
				if (!currentDirection.equals(Direction.UP)) {
					currentDirection = Direction.DOWN;
					canMove = false;
				}
				break;
			case LEFT:
				if (!currentDirection.equals(Direction.RIGHT)) {
					currentDirection = Direction.LEFT;
					canMove = false;
				}
				break;
			case RIGHT:
				if (!currentDirection.equals(Direction.LEFT)) {
					currentDirection = Direction.RIGHT;
					canMove = false;
				}
				break;
			default:
				break;
			}
		}
	}

	public void reset(Location loc) {
		// 1. clear the snake
		snake.clear();
		// 2. set the location of the head
		head.setLocation(loc);
		currentDirection = Direction.RIGHT;
		// 3. add the head to the snake
		snake.add(head);
	}

	public boolean isOutOfBounds() {
		// 1. complete the method so it returns true if the head of the snake is
		// outsize of the window
		// and false otherwise
		if (getHeadLocation().x > 14 || getHeadLocation().y > 11 || getHeadLocation().x < 0
				|| getHeadLocation().y < 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isHeadCollidingWithBody() {
		// 1. complete the method so it returns true if the head is located
		// in the same location as any other body segment
		for (int i = snake.size() - 2; i < 0; i++) {
			if (snake.get(i).getLocation().equals(getHeadLocation())) {
				return true;
			}
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		// 1. complete the method so it returns true if the passed in
		// location is located on the snake
		for (int i = 0; i < snake.size(); i++) {
			if (snake.get(i).getLocation().equals(loc)) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		snake.get(snake.size() - 1).setNext(NextDirection.NONE);
		for (int i = snake.size() - 2; i >= 0; i--) {
			Location l1 = snake.get(i).getLocation();
			Location l2 = snake.get(i + 1).getLocation();
			if (l1.x == l2.x) {
				if (l1.y > l2.y) {
					snake.get(i).setNext(NextDirection.NORTH);
				} else {
					snake.get(i).setNext(NextDirection.SOUTH);
				}
			} else {
				if (l1.x > l2.x) {
					snake.get(i).setNext(NextDirection.EAST);
				} else {
					snake.get(i).setNext(NextDirection.WEST);
				}
			}
		}
		boolean first = true;
		for (SnakeSegment s : snake) {
			if (first) {
				s.setHead(true);
				first = false;
			}
			s.draw(g);
		}
	}
}
