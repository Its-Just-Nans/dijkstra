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

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return String
	 */
	public String getLabel() {
		return this.label;
	}

	public void setLabel() {
		this.label = "case" + this.X + ":" + this.Y;
	}

	/**
	 * @return String
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @return String
	 */
	public String toString() {
		return this.label;
	}

	/**
	 * @return int
	 */
	public int getX() {
		return this.X;
	}

	/**
	 * @return int
	 */
	public int getY() {
		return this.Y;
	}

	/**
	 * @param newX
	 */
	public void setX(int newX) {
		this.X = newX;
		this.setLabel();
	}

	/**
	 * @param newY
	 */
	public void setY(int newY) {
		this.Y = newY;
		this.setLabel();
	}

	/**
	 * @return boolean
	 */
	public boolean isTraversable() {
		return true;
	}
}
