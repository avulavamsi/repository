import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {

//	public static Graph calShortestPath(Graph graph, Vertex sourceVertex) {
	public static void calShortestPath(Vertex sourceVertex) {

		sourceVertex.setDist(0);
		Set<Vertex> settledVertex = new HashSet<>();
		Set<Vertex> unsettledVertex = new HashSet<>();

		unsettledVertex.add(sourceVertex);

		while (unsettledVertex.size() != 0) {
			Vertex currentVertex = getCheapestVertex(unsettledVertex);
			unsettledVertex.remove(currentVertex);

			for (Map.Entry<Vertex, Integer> adj : currentVertex.getAdjVertexes().entrySet()) {
				if (!settledVertex.contains(adj.getKey())) {
					// System.out.println("Node: "+adj.getKey().getName()+" "+"Distance:
					// "+adj.getValue());
					Vertex adjvertex = adj.getKey();
					Integer cost = adj.getValue();
					Integer sourceCost = currentVertex.getDist();
					Integer totalCost = sourceCost + cost;
					if (totalCost < adjvertex.getDist()) {
						adjvertex.setDist(totalCost);
						List<Vertex> shortestRoute = new LinkedList<>();
						shortestRoute.add(currentVertex);
						adjvertex.setShortestRoute(shortestRoute);

						unsettledVertex.add(adj.getKey());
					}

				}

			}
			settledVertex.add(currentVertex);
		}

//		return graph;

	}

	private static Vertex getCheapestVertex(Set<Vertex> unsettledVertex) {

		Vertex cheapestVertex = null;

		int cheapestDist = Integer.MAX_VALUE;
		for (Vertex vertex : unsettledVertex) {
			int vertexDist = vertex.getDist();
			if (vertexDist < cheapestDist) {
				cheapestDist = vertexDist;
				cheapestVertex = vertex;
			}
		}

		return cheapestVertex;

	}

}
