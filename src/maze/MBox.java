package maze;

import dijkstra.VertexInterface;

public abstract class MBox implements VertexInterface {
	String label;
	String type;
	int X;
	int Y;

	public MBox(String type) {
		label = "case";
		this.type = type;
	}

	public MBox(String type, int x, int y) {
		label = "case" + x + ":" + y;
		this.type = type;
		this.X = x;
		this.Y = y;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLabel() {
		return this.label;
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

	public boolean isTraversable() {
		return true;
	}
}
