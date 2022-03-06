package dijkstra;

import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {
	public Previous() {
		super();
	}

	/**
	 * @return String
	 */
	public String toString() {
		return this.toString();
	}

	/**
	 * @param vertexToFind
	 * @return VertexInterface
	 */
	@Override
	public VertexInterface getValue(VertexInterface vertexToFind) {
		return this.get(vertexToFind);
	}

	/**
	 * @param vertex
	 * @param vertexToLink
	 */
	@Override
	public void setValue(VertexInterface vertex, VertexInterface vertexToLink) {
		this.put(vertex, vertexToLink);
	}
}
