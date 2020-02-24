import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Appl {

	public static void main(String[] args) {

		Vertex sourceVertex = null;
		List<String> alpha = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O");
		Graph graph = new Graph();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter total number of Vertexes: ");
		int vCount = scan.nextInt();

		for (int i = 0; i < vCount; i++) {
			Vertex v = new Vertex(alpha.get(i));
			graph.addVertex(v);
		}

		for (int i = 0; i < vCount; i++) {
			Vertex v1 = graph.getVertexByName(alpha.get(i));
			for (int j = i + 1; j < vCount; j++) {
				Vertex v2 = graph.getVertexByName(alpha.get(j));
				System.out.printf("Enter distance between " + alpha.get(i) + " and " + alpha.get(j) + ": ");
				int dist = scan.nextInt();
				if (dist != 0) {
					v1.addDest(v2, dist);
					v2.addDest(v1, dist);
				}

			}
			graph.addVertex(v1);
		}

		System.out.printf("EnterSource node(A or B or C...etc: ");
		String source = scan.next().toUpperCase();
		sourceVertex = graph.getVertexByName(source);
		if (sourceVertex != null) {
			DijkstraAlgorithm.calShortestPath(sourceVertex);

			Set<Vertex> vertexes = new HashSet<>();
			vertexes = graph.getVertex();
			System.out.println("The results are: ");
			for (Vertex vertex : vertexes) {
				System.out.println("Shortest distance from "+ sourceVertex.getName() + " to " + vertex.getName() + "->" + vertex.getDist());
			}
		}
	}

}
