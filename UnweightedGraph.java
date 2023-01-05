import java.io.File;
import java.util.*;
// Topological Sort and Shortest Path

public class UnweightedGraph {
	private ArrayList<ArrayList<Integer>> inDegree;
	private ArrayList<ArrayList<Integer>> outDegree;
	private int[][] adjMatrix;
	private int numVerts;
	
	public UnweightedGraph(String fileName, int verts) {
		File f = new File(fileName);
		numVerts = verts;
		adjMatrix = new int[verts][verts];
		try {
			Scanner in = new Scanner(f);
			for (int i = 0; i < verts; i++) {
				for (int j = 0; j < verts; j++) {
					adjMatrix[i][j] = in.nextInt();
				}
			}
			in.close();
		}
		catch(Exception E) { System.out.println(E); }
		// making out degree
		outDegree = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < numVerts; i++) {
			ArrayList<Integer> ins = new ArrayList<Integer>();
			for (int j = 0; j < numVerts; j++) {
				if (adjMatrix[i][j] == 1) ins.add(j);
			}
			outDegree.add(ins);
		}
		inDegree = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < numVerts; i++) {
			ArrayList<Integer> ins = new ArrayList<Integer>();
			for (int j = 0; j < numVerts; j++) {
				if (adjMatrix[j][i] == 1) ins.add(j);
			}
			inDegree.add(ins);
		}
	}

	public void printInDegree() {
		for (int i = 0; i < numVerts; i++) {
			System.out.println((i) +": "+ inDegree.get(i));
		}
	}
	

	public ArrayList<Integer> topologicalSort(){
		
		
		
		
		
		return null;
	}
	
	
	public int[] shortestPath(int curr) {
		return null;
	}
	
	public static void main(String[] args) {
		UnweightedGraph g = new UnweightedGraph("graph.txt", 7);
		g.printInDegree();

	}
}
