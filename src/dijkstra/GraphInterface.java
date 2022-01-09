package dijkstra;

import java.util.List;

public interface GraphInterface {
	public List<VertexInterface> getSommets();

	public List<VertexInterface> getSuccessorOf(VertexInterface vertex);

	// public void addArrete(String name1, String name2);
	// public void removeArrete(String name, String label2);
	public int getWeight(VertexInterface src, VertexInterface dst);

	// public void addNode(String name);
	// public void removeNode(String name);
	// public List<VertexInterface> getNode(String name);
}
