package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeSegment {
	private Location location;
	private int size;
	private NextDirection next;
	private Boolean head;

	public Boolean getHead() {
		return head;
	}

	public void setHead(Boolean head) {
		this.head = head;
	}

	public SnakeSegment(Location loc, int size) {
		this.location = loc;
		this.size = size;
	}

	public NextDirection getNext() {
		return next;
	}

	public void setNext(NextDirection next) {
		this.next = next;
	}

	public void setLocation(Location loc) {
		this.location = loc;
	}

	public Location getLocation() {
		return location;
	}

	public void draw(Graphics g) {
		g.setColor(Snake.SNAKE_COLOR);
		switch (next) {
		case NONE:
			g.fillRect(location.x * size, location.y * size, size - 1, size - 1);
			break;
		case NORTH:
			g.fillRect(location.x * size, location.y * size - 1, size - 1, size);
			break;
		case SOUTH:
			g.fillRect(location.x * size, location.y * size, size - 1, size);
			break;
		case EAST:
			g.fillRect(location.x * size - 1, location.y * size, size, size - 1);
			break;
		case WEST:
			g.fillRect(location.x * size, location.y * size, size, size - 1);
			break;
		default:
			break;
		}
		if (head != null && head) {
			g.setColor(Color.WHITE);
			g.fillOval(location.x * size + 10, location.y * size + 10, size - 20, size - 20);
			g.setColor(Color.BLACK);
			g.fillOval(location.x * size + 20, location.y * size + 20, size - 40, size - 40);
		}
	}
}
