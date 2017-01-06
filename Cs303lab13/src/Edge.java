
public class Edge {

	//source node
	public final int v;
	//destination node
	public final int w;
	//weight of this edge
	public final double weight;
	//unique ID for this edge
	public final double edgeID;
	
	public Edge(int v, int w, double weight, double edgeID) {
		this.v = v;
		this.w = w;
		this.weight = weight;
		this.edgeID = edgeID;
	}

	/**
	 * Compares this.weight to other.weight
	 * @param e Other Edge object
	 * @return int: 0 for equal, 1 for this > that, -1 for that > this
	 */
	public int compare(Edge e) {
		if (this.weight == e.weight) return 0;
		else if (this.weight > e.weight) return 1;
		else return -1;
	}
}
