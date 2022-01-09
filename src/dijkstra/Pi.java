package dijkstra;

import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface, Integer> implements PiInterface {
	public Pi() {
		super();
	}

	public int getValue(VertexInterface vertexToFind) {
		return this.get(vertexToFind);
	}

	public void setValue(VertexInterface vertexToModidfy, Integer value) {
		this.put(vertexToModidfy, value);
	}
}
