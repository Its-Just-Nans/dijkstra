package dijkstra;

public class Vertex implements VertexInterface {
	private String label;

	public Vertex() {

	}

	public Vertex(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return this.label;
	}
}
