package dijkstra;

import java.util.HashSet;

public interface ASetInterface {
	public void addVertex(VertexInterface v);

	public HashSet<VertexInterface> getSommets();

	public boolean isIn(VertexInterface sommets);
}