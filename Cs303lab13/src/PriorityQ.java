
import java.util.ArrayList;

/**
 * PriorityQueue Implementation specific for Prim's Algorithm
 * 
 * @param <T> extends Edge class
 */
public class PriorityQ<T extends Edge> {
	private ArrayList<T> under; //underlying data structure
	
	public PriorityQ(){
		under = new ArrayList<>();
	}
	/**
	 * Adds edge at specific position based on weight of edge.weight
	 * Should have used heap but whateva whateva I do what I want
	 * @param edge
	 */
	public void add(T edge){
		int i = 0;
		while(under.size() > 0 && under.get(i).weight < edge.weight && i < under.size()-1){
			i+=1;
		}
		under.add(i, edge);
	}
	/**
	 * Removes FIRST element in PQ
	 * @return T edge
	 */
	public T pop(){
		return under.remove(0);
	}
	
	public boolean isEmpty(){
		return under.isEmpty();
	}

}