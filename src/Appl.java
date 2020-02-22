import java.util.HashSet;
import java.util.Set;

public class Appl {

	public static void main(String[] args) {
		Vertex nodeA = new Vertex("A");
		Vertex nodeB = new Vertex("B");
		Vertex nodeC = new Vertex("C");
		Vertex nodeD = new Vertex("D");
		Vertex nodeE = new Vertex("E");
		Vertex nodeF = new Vertex("F");

		nodeA.addDest(nodeB, 10);
		nodeA.addDest(nodeC, 15);

		nodeB.addDest(nodeD, 12);
		nodeB.addDest(nodeF, 15);
		nodeB.addDest(nodeA, 10);

		nodeC.addDest(nodeE, 10);
		nodeC.addDest(nodeA, 15);

		nodeD.addDest(nodeE, 2);
		nodeD.addDest(nodeF, 1);
		nodeD.addDest(nodeB, 12);

		nodeF.addDest(nodeE, 5);
		nodeF.addDest(nodeB, 15);
		nodeF.addDest(nodeD, 1);
		
		nodeE.addDest(nodeF, 5);
		nodeE.addDest(nodeC, 10);
		nodeE.addDest(nodeD, 2);

		Graph graph = new Graph();

		graph.addVertex(nodeA);
		graph.addVertex(nodeB);
		graph.addVertex(nodeC);
		graph.addVertex(nodeD);
		graph.addVertex(nodeE);
		graph.addVertex(nodeF);

//		graph = DijkstraAlgorithm.calShortestPath(graph, nodeA);
		DijkstraAlgorithm.calShortestPath(nodeA);
		
		Set<Vertex> vertexes = new HashSet<>();
		vertexes = graph.getVertex();
		for(Vertex vertex : vertexes) {
			System.out.println(nodeA.getName()+" to "+vertex.getName()+"->"+vertex.getDist());
		}
	}

}
