package dijkstra;

import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface, Integer> implements PiInterface {
	public Pi() {
		super();
	}

	/**
	 * @param vertexToFind
	 * @return int
	 */
	public int getValue(VertexInterface vertexToFind) {
		return this.get(vertexToFind);
	}

	/**
	 * @param vertexToModidfy
	 * @param value
	 */
	public void setValue(VertexInterface vertexToModidfy, Integer value) {
		this.put(vertexToModidfy, value);
	}
}
