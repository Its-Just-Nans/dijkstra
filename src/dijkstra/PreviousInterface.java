package dijkstra;

public interface PreviousInterface {
	public VertexInterface getValue(VertexInterface vertex);

	public void setValue(VertexInterface vertex, VertexInterface vertexToReplace);
}
