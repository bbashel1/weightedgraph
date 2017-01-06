import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Driver {
public static void main(String[] args) {
		
		testTinyDG();
		testMediumDG();
		testLargeDG();
		testXtraLargeDG();
	}
	public static void testTinyDG() {
		FileReader r;
		try {
			System.out.println("\ntestTinyDG\n");
			r = new FileReader(new File("tinyDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
			System.out.println(g.tostring());
			System.out.println(g.tostringM());
			System.out.println("\nPrim's Minimum Spanning Tree:\n");
			
			long now = System.nanoTime();
			PrimsMST mst = new PrimsMST(g, 0);
			now = System.nanoTime() - now;
			
			System.out.println("Weight of MST == " + mst.weight() + "\n");
			g = mst.getPrimmedGraph();
			System.out.println(g.tostring());
			System.out.println(g.tostringM());
			
			System.out.println("Time taken: " + now/1000); //print in microseconds
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testMediumDG() {
		FileReader r;
		try {
			System.out.println("\nmediumDG\n");
			r = new FileReader(new File("mediumDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
			long now = System.nanoTime();
			PrimsMST mst = new PrimsMST(g, 0);
			now = System.nanoTime() - now;
			System.out.println("Weight of MST == " + mst.weight() + "\n");
			System.out.println("Time taken: " + now/1000); //print in microseconds
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testLargeDG() {
		FileReader r;
		try {
			System.out.println("\ntestLargeDG\n");
			r = new FileReader(new File("largeDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
			long now = System.nanoTime();
			PrimsMST mst = new PrimsMST(g, 0);
			now = System.nanoTime() - now;
			System.out.println("Weight of MST == " + mst.weight() + "\n");
			System.out.println("Time taken: " + now/1000); //print in microseconds
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void testXtraLargeDG() {
		FileReader r;
		try {
			System.out.println("\ntestXtraLargeDG\n");
			r = new FileReader(new File("XtraLargeDG.txt"));
			BufferedReader bf = new BufferedReader(r);
			WeightedGraph g = new WeightedGraph(bf);
			long now = System.nanoTime();
			PrimsMST mst = new PrimsMST(g, 0);
			now = System.nanoTime() - now;
			System.out.println("Weight of MST == " + mst.weight() + "\n");
			System.out.println("Time taken: " + now/1000); //print in microseconds
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
