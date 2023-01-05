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
	
	private int nextNode(ArrayList<Integer> topo) {
		for(int i = 0; i < inDegree.size(); i++) {
			if(inDegree.get(i).size() == 0 && !topo.contains(i)) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Integer> topologicalSort(){
		ArrayList<Integer> topo = new ArrayList<Integer>();
		while(topo.size() < numVerts) {
			int curr = nextNode(topo);
			topo.add(curr);
			for(int i = 0; i < numVerts; i++) {
				if(inDegree.get(i).contains(curr)) {
					inDegree.get(i).remove((Integer) curr);
				}
			}
		}
		return topo;
	}
	public ArrayList<Integer> breadthFirstTraversal(){
		
		
		
		
	}
	public int[] shortestPath(int curr) {
		return null;
	}
	
	public static void main(String[] args) {
		UnweightedGraph g = new UnweightedGraph("graph.txt", 7);
		g.printInDegree();
		ArrayList<Integer> topo = g.topologicalSort();
		System.out.println(topo);

	}
}
