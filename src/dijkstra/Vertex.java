package dijkstra;

public class Vertex implements VertexInterface {
	private String label;

	public Vertex() {

	}

	public Vertex(String label) {
		this.label = label;
	}

	/**
	 * @return String
	 */
	@Override
	public String getLabel() {
		return this.label;
	}
}
