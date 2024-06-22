
package wk6;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Dijkstra extends Graph {

	public int distance[];
	public int parent[];
	private boolean closed[];

	public Dijkstra(String filePath) throws FileNotFoundException { // complete this constructor
		Graph g = IOHelper.readWeightedGraph(filePath);
		numVertices = g.numVertices;
		adjList = g.adjList;
		
	}

	public void execute(int source) { // complete this method
	
		boolean[] closed = new boolean[numVertices];
		distance = new int[numVertices];
		parent = new int[numVertices];
		for (int i =0; i < distance.length; i++){
			distance[i] = Integer.MAX_VALUE;
			parent[i] = -1;
			closed[i] = false;
		}
		distance[source] = 0;
		PriorityQueue<PriorityQueuePair> open = new PriorityQueue<>();
		open.add(new PriorityQueuePair(source, 0));

		while(!open.isEmpty()){
			PriorityQueuePair minElement = open.poll();
			int minVertex = minElement.item;
			if (closed[minVertex]) 
				continue; 
			closed[minVertex] = true;
			if (adjList.get(minVertex) != null)
			adjList.get(minVertex).forEach((adjEdge) ->{
				int adjVertex = adjEdge.dest;
				if (!closed[adjVertex]){
					int newDist = distance[minVertex] + adjEdge.weight;
					if (newDist < distance[adjVertex]){
						distance[adjVertex] = newDist;
						parent[adjVertex] = minVertex;
						open.add(new PriorityQueuePair(adjVertex, newDist));
					}
				}
			});
		}
	}
}
