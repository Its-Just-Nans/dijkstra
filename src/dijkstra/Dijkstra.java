package dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface set) {
		int maxVal = Integer.MAX_VALUE;
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
		for (int j = 0; j < loopValue; j++) {
			// pour tout sommet y non encore dans A et successeur de pivot
			List<VertexInterface> listOfSuccessorOfPivotNotInA = new ArrayList<VertexInterface>();
			List<VertexInterface> listOfSuccessor = g.getSuccessorOf(pivot);
			for (VertexInterface y : listeSommets) {
				boolean isInSet = set.isIn(y);
				if (!isInSet) {
					boolean isASucessor = listOfSuccessor.contains(y);
					if (isASucessor) {
						listOfSuccessorOfPivotNotInA.add(y);
					}
				}
			}
			for (VertexInterface oneSuccessor : listOfSuccessorOfPivotNotInA) {
				// si pi(pivot) + p(pivot, y) < x(y)
				int valueToCheck = pi.getValue(pivot) + g.getWeight(pivot, oneSuccessor);
				int valueOfY = pi.getValue(oneSuccessor);
				if (valueToCheck < valueOfY) {
					// pi(y) <— pi(pivot) + p(pivot, y)
					pi.setValue(oneSuccessor, valueToCheck);
					// pere(y) <- pivot
					pere.setValue(oneSuccessor, pivot);
				}
			}
			// chercher, parmi les sommets non dans À
			List<VertexInterface> sommetsNotInA = new ArrayList<VertexInterface>();
			for (VertexInterface vertex : listeSommets) {
				boolean isInSet = set.isIn(vertex);
				if (!isInSet) {
					sommetsNotInA.add(vertex);
				}
			}
			// chercher un sommet y tel que z(y) soit minimum
			int minValue = maxVal;
			for (VertexInterface vertex : sommetsNotInA) {
				int valueOfVertex = pi.getValue(vertex);
				if (valueOfVertex < minValue) {
					// pivot <- y
					minValue = valueOfVertex;
					pivot = vertex;
				}
			}
			// A <— A u (pivot)
			set.addVertex(pivot);
		}
		return pere;
	}
}
