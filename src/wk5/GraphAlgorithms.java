
package wk5;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgorithms extends Graph {
	public GraphAlgorithms(String filePath) throws FileNotFoundException {
		readUnweightedGraph(filePath);
	}

	public ArrayList<Integer> topoOrder() throws Exception { // complete this method
		int n = adjList.size();
		ArrayList<Integer> order = new ArrayList<>();
		Queue<Integer> vertexQ = new LinkedList();
		int[] indegree = new int[n];
		for ( int i = 0; i < n; i++){
			adjList.get(i).forEach((e) ->{
				int w = e.dest;
				indegree[w] = indegree[w] + 1;
			});
		}
		for ( int i = 0; i < n; i++){
			if (indegree[i] == 0)
				vertexQ.add(i);
		}

		while (vertexQ.size() > 0){
			int v = vertexQ.poll();
			order.add(v);
			adjList.get(v).forEach((e) ->{
				int w = e.dest;
				indegree[w]--;
				if (indegree[w] == 0)
					vertexQ.add(w);

			});

		}
		if (order.size() != n)
			order.clear();
		
			return order;
	}

	public ArrayList<Integer> bfs(int s) { // complete this method
		int n = adjList.size();
		ArrayList<Integer> level = new ArrayList<>();
		for (int i = 0; i < n; i++){
			level.add(Integer.MAX_VALUE);
		}

		Queue<Integer> vertexQ = new LinkedList();
		vertexQ.add(s);
		level.set(s, 0);
		while (vertexQ.size() > 0){
			int v = vertexQ.poll();
			adjList.get(v).forEach((e)->{
				int w = e.dest;
				if (level.get(w) == Integer.MAX_VALUE)
				{
				int d = level.get(v);
				level.set(w, d+1);
				vertexQ.add(w);
				}
			});
		}

	return level;
	}
}
