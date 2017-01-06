

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Random;

public class WeightedGraph extends Graph {

	public LinkedList<Edge>[] adjw;
	public Random ran;
	public HashMap<Double, Double> tree;


	/**
	 * Creates a new WeightedGraph with a LinkedList of Edges from PrimsMST
	 * @param V number of vertices
	 * @param lst LinkedList of Edges b/t vertices
	 */
	public WeightedGraph(int V, LinkedList<Edge> lst ){
		this.V = V;
		this.E = lst.size();

		//HashMap<Integer, Integer> verts = new HashMap<>();

		///internals
		//initialize adjw
		adjw = new LinkedList[V];
		for (int v = 0; v < V; v++) {
			adjw[v] = new LinkedList<>();
		}
		//initialize adjm(matrix), tree(edgeID checker), ran(pseudo random number generator)
		adjm = new int[V][V];
		tree = new HashMap<>();
		ran = new Random();

		//add all edges to graph
		for (Edge e: lst){
			this.addEdge(e.v, e.w, e.weight);
		}
	}
	
	/**
	 * Given way to created a Graph, made to use WeightedGraph data structures
	 * @param reader
	 * @throws IOException
	 */
	public WeightedGraph(BufferedReader reader) throws IOException {
		String line;
		line = reader.readLine();
		V = Integer.parseInt(line);
		line = reader.readLine();
		E = Integer.parseInt(line);
		//adjacency list w/ Edge objects
		adjw = new LinkedList[V];
		//Create new Random object for ID generation
		ran = new Random();
		//Create new Tree of ID's used to keep track
		tree = new HashMap<>();
		//Initialize adjacency matrix
		adjm = new int[V][V];

		for (int v = 0; v < V; v++) {
			adjw[v] = new LinkedList<>();
		}
		while ((line = reader.readLine()) != null) {
			int tempV1, tempV2;
			double w;
			StringTokenizer st = new StringTokenizer(line, " ");
			tempV1 = Integer.parseInt(st.nextToken());
			tempV2 = Integer.parseInt(st.nextToken());
			w = Double.parseDouble(st.nextToken());
			addEdge(tempV1, tempV2, w);
		}
	}

	/**
	 * Adds edge to WeightedGraph
	 * @param v int source node
	 * @param w int desination node
	 * @param weight double
	 */
	public void addEdge(int v, int w, double weight){
		//Adjw
		double edgeID = ran.nextDouble();
		//make sure no collisions

		while(tree.containsKey(edgeID)){
			edgeID = ran.nextDouble();
		}
		tree.put(edgeID, edgeID);

		Edge e1 = new Edge(v, w, weight, edgeID);
		
		this.adjw[v].add(e1);
		
		//adjacency matrix representation
		adjm[v][w] = 1;
	}

	@Override
	/**
	 * Fixed tostring method of super class to allow printing of edge weights and edgeIDs
	 * form:
	 * Vertice V: (Vertice W, Weight, ID.toHex)
	 */
	public String tostring()
	{
		String s = new String();
		s = "There are "+V+" vertices and "+E+" edges\n";
		for(int i=0;i<V;i++)
		{
			s = s+i+": ";
			for(int j = 0; j<adjw[i].size();j++)
			{
				s = s + "(" +adjw[i].get(j).w + ", "+ adjw[i].get(j).weight 
						+ ", "+ Double.toHexString(adjw[i].get(j).edgeID).substring(4, 
								10) + ")" + " ";
			}
			s = s+"\n";

		}
		return s;
	}



}
