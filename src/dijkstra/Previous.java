package dijkstra;

import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {
	public Previous() {
		super();
	}

	public String toString() {
		return this.toString();
	}

	@Override
	public VertexInterface getValue(VertexInterface vertexToFind) {
		return this.get(vertexToFind);
	}

	@Override
	public void setValue(VertexInterface vertex, VertexInterface vertexToLink) {
		this.put(vertex, vertexToLink);
	}
}
