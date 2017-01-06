import java.util.LinkedList;

/**
 * Lazy implementation of Prim's Algorithm on a Weighted, Directed Graph
 * 
 *
 */
public class PrimsMST {

	private double weight;			// total weight of MST
	private LinkedList<Edge> mst;	// edges in the MST
	private boolean[] marked;		// marked[v] = true if v on tree
	private PriorityQ<Edge> pq;		// edges with one endpoint in tree
	private WeightedGraph G;		// the Graph give to traverse

	/**
	 * Compute a minimum spanning tree of a weighted graph.
	 * @param G the weighted graph
	 * @param v the node to start from
	 */
	public PrimsMST(WeightedGraph G, int v) {
		assert v >= -1: "int v must be >= -1";
		assert v < G.V: "int v must not exceed number of vertices in G";
		
		
		mst = new LinkedList<>();
		pq = new PriorityQ<>();
		marked = new boolean[G.V];
		this.G = G;
		
		//deprecated start of lazy prim
		//only used if v == -1
		if(v == -1){
			for (int w = 0; w < G.V; w++){
				// run Prim from all vertices/nodes
				if (!marked[w]) lazyPrim(w);
			}
		}
		
		//start of fixed, readily used greedy prim
		prim(v);
		
	}
	
	/**
	 * Recursive implementation of Prim's Minimum Spanning Tree
	 * This is a greedy algorithm and may not always get the best result, but it will always 
	 * work in a way that returns an *almost* best result.
	 * @param s int source node to start span from
	 */
	private void prim(int s){
		if(marked[s]); //do nothing if node s already been visited
		else {
			primScan(s); //node is not marked, so add all edges to pq, set marked
			while(!pq.isEmpty()){
				Edge e = pq.pop(); //pop lowest weight edge
				if(!marked[e.w]){ //check if edge.w(destination node) is marked
					this.weight += e.weight; //if not, this is MST edge, add its weight to weight
					mst.add(e); //add edge to e
					prim(e.w); //recurse prim on that dest node
				}
			}
		}
	}
	
	/**
	 * Adds all edges from v to pq
	 * @param v source node
	 */
	private void primScan(int v){
		marked[v] = true;
		for (Edge e : G.adjw[v])
			if (!marked[e.w]) pq.add(e);
	}

	@Deprecated
	private void lazyPrim(int s) {
		scan(s);
		while (!pq.isEmpty()) {					// better to stop when mst has V-1 edges
			Edge e = pq.pop();					// smallest edge on pq
			int v = e.v, w = e.w;				// two endpoints
			assert marked[v] || marked[w];
			if (marked[v] && marked[w]) continue;// lazy, both v and w already scanned
			mst.add(e);							// add e to MST
			weight += e.weight;
			if (!marked[v]) scan(v);			// v becomes part of tree
			if (!marked[w]) scan(w);			// w becomes part of tree
		}
	}

	@Deprecated
	private void scan(int v) {
		assert !marked[v];
		marked[v] = true;
		for (Edge e : G.adjw[v])
			if (!marked[e.w]) pq.add(e);
	}

	/**
	 * Returns the edges in a minimum spanning tree (or forest).
	 * @return the edges in a minimum spanning tree (or forest) as
	 *    an iterable of edges
	 */
	public Iterable<Edge> edges() {
		return mst;
	}

	/**
	 * Returns the sum of the edge weights in a minimum spanning tree (or forest).
	 * @return the sum of the edge weights in a minimum spanning tree (or forest)
	 */
	public double weight() {
		return weight;
	}

	/**
	 * Returns new WeightedGraph using the mst linkedlist of edges
	 * @return WeightedGraph
	 */
	public WeightedGraph getPrimmedGraph() {
		WeightedGraph g = new WeightedGraph(G.V, mst);
		return g;
	}

}