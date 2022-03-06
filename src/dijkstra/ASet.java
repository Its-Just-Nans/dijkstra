package dijkstra;

import java.util.HashSet;

public class ASet extends HashSet<VertexInterface> implements ASetInterface {

	public ASet() {
		super();
	}

	/**
	 * @param nouveauVertex
	 */
	public void addVertex(VertexInterface nouveauVertex) {
		this.add(nouveauVertex);
	}

	/**
	 * @param sommet
	 * @return boolean
	 */
	public boolean isIn(VertexInterface sommet) {
		return this.contains(sommet);
	}
}
