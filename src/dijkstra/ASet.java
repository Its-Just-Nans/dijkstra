package dijkstra;

import java.util.HashSet;

public class ASet extends HashSet<VertexInterface> implements ASetInterface {

	public ASet() {
		super();
	}

	public void addVertex(VertexInterface nouveauVertex) {
		this.add(nouveauVertex);
	}

	public boolean isIn(VertexInterface sommets) {
		for (VertexInterface element : this) {
			if (element == sommets) {
				return true;
			}
		}
		return false;
	}
}
