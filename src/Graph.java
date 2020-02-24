import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph {

	private Set<Vertex> vertex = new HashSet<>();

	public void addVertex(Vertex vertex) {
		this.vertex.add(vertex);
	}

	public Set<Vertex> getVertex() {
		return vertex;
	}

	public Vertex getVertexByName(String name) {
		Vertex v = null;
		Iterator<Vertex> value = vertex.iterator();
		while (value.hasNext()) {
			Vertex current = (Vertex) value.next();
			if (current.name.contains(name)) {
				return current;
			}
		}
		return v;
	}
}
