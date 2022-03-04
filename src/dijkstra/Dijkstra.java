package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		int maxVal = Integer.MAX_VALUE;
		ASet set = new ASet();
		set.addVertex(r);
		PiInterface pi = new Pi();
		PreviousInterface pere = new Previous();
		VertexInterface pivot = r;
		pi.setValue(r, 0);
		List<VertexInterface> listeSommets = g.getSommets();
		// pour tout sommet de x différent de r
		for (VertexInterface unVertex : listeSommets) {
			if (unVertex != r) {
				pi.setValue(unVertex, maxVal);
			}
		}
		// pour j variant de 1 à n-1
		int loopValue = listeSommets.size() - 1;
		for (int j = 1; j <= loopValue; j++) {
			// pour tout sommet y non encore dans A et successeur de pivot
			List<VertexInterface> listOfSuccessor = g.getSuccessorOf(pivot);
			for (VertexInterface y : listeSommets) {
				boolean isInSet = set.isIn(y);
				if (!isInSet && listOfSuccessor.contains(y)) {
					// si pi(pivot) + p(pivot, y) < x(y)
					int valueToCheck = pi.getValue(pivot) + g.getWeight(pivot, y);
					if (valueToCheck < pi.getValue(y)) {
						// pi(y) <— pi(pivot) + p(pivot, y)
						pi.setValue(y, valueToCheck);
						// pere(y) <- pivot
						pere.setValue(y, pivot);
					}
				}
			}
			int minValue = maxVal;
			// chercher, parmi les sommets non dans À
			for (VertexInterface vertex : listeSommets) {
				if (!set.isIn(vertex)) {
					// chercher un sommet y tel que z(y) soit minimum
					int valueOfVertex = pi.getValue(vertex);
					if (valueOfVertex < minValue) {
						// pivot <- y
						minValue = valueOfVertex;
						pivot = vertex;
					}
				}
			}
			// A <— A u (pivot)
			set.addVertex(pivot);
		}
		return pere;
	}
}
