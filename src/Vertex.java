import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vertex {

	String name;
	private List<Vertex> shortestRoute = new LinkedList<>();
	private Integer dist = Integer.MAX_VALUE;
	
	Map<Vertex, Integer> adjVertexes = new HashMap<>();

	public Vertex(String name) {
		this.name = name;
	}
	
	public void addDest(Vertex dest, int dist) {
		adjVertexes.put(dest, dist);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vertex> getShortestRoute() {
		return shortestRoute;
	}

	public void setShortestRoute(List<Vertex> shortestRoute) {
		this.shortestRoute = shortestRoute;
	}

	public Integer getDist() {
		return dist;
	}

	public void setDist(Integer dist) {
		this.dist = dist;
	}

	public Map<Vertex, Integer> getAdjVertexes() {
		return adjVertexes;
	}

	public void setAdjVertexes(Map<Vertex, Integer> adjVertexes) {
		this.adjVertexes = adjVertexes;
	}
	
}
