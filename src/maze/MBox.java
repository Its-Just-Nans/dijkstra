package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface {
	private String label;
	private String type;
	private int X;
	private int Y;

	public MBox(String type) {
		label = "case";
		this.type = type;
	}

	public MBox(String type, int x, int y) {
		this.type = type;
		this.X = x;
		this.Y = y;
		this.setLabel();
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel() {
		this.label = "case" + this.X + ":" + this.Y;
	}

	public String getType() {
		return this.type;
	}

	public String toString() {
		return this.label;
	}

	public int getX() {
		return this.X;
	}

	public int getY() {
		return this.Y;
	}

	public void setX(int newX) {
		this.X = newX;
		this.setLabel();
	}

	public void setY(int newY) {
		this.Y = newY;
		this.setLabel();
	}

	public boolean isTraversable() {
		return true;
	}
}
