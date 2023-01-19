
import java.io.File;
import java.util.*;

public class WeightedDirGraph {
	private int[][] adjMatrix;
	private int numVerts;
	
	public WeightedDirGraph(String fileName, int verts) {
		File f = new File(fileName);
		numVerts = verts;
		adjMatrix = new int[verts][verts];
		// rows outgoing 
		// cols incoming
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
	}

	private boolean allKnown(boolean[] known) {
		for(int i=0; i< known.length; i++) {
			if(!known[i]) {
				return false;
			}
		}
		return true;
	}
	
	private int minDistNode(int[] dist, boolean[] known) {
		int minDist = Integer.MAX_VALUE;
		int minID = -1;
		for(int i=0; i<dist.length; i++) {
			if(!known[i] && minDist>dist[i]) {
				minDist = dist[i];
				minID = i;
			}
		}
		return minID;
	}
	
	public int[] shortestPath(int curr) {	
		boolean[] known = new boolean[numVerts];
		int[] dist = new int[numVerts];
		int[] prev = new int[numVerts];
		for (int i = 0; i < numVerts; i++) {
			known[i] = false;
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;	
		}
		dist[curr] = 0;
		while(!allKnown(known)) {
			// curr set to unknown node with min distance
			curr = minDistNode(dist, known);
			known[curr] = true;
			// iterate over curr's outgoing connections
			for(int node =0; node<numVerts; node++) {
				// considering each neighbor 
				// node is the node 
				// adjMatrix[curr][node] weight edge connecting curr and node
				int edge = adjMatrix[curr][node];
				if(edge>0) {
					// determine if need to update dist & prev
					if(dist[curr] + edge < dist[node]) {
						dist[node] = dist[curr] + edge;
						prev[node] = curr;
					}
				}	
			}
		}
		return dist;
	}
	
	public static void main(String[] args) {
		WeightedDirGraph g = new WeightedDirGraph("wgraph.txt", 7);
		System.out.println(g);
		int[] dists = g.shortestPath(3);
		System.out.println(dists);
		for (int d: dists) System.out.println(d);
	}
}
