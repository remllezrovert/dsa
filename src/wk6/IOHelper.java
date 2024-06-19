
package wk6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOHelper {

	public static Graph readWeightedGraph(String filePath) throws FileNotFoundException { // complete this method
		Scanner fileReader = new Scanner(filePath);
		Graph graph = new Graph();
		int numVertices = Integer.valueOf(fileReader.nextLine());
		graph.numVertices = numVertices;
		graph.adjList = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < numVertices; i++){
			graph.adjList.add(null); //add a blank row to the adjlist
		}
		int src, dest, weight;

		while (fileReader.hasNext()){
		String[] line = fileReader.nextLine().split(" ");
		src = Integer.valueOf(line[0]);
		Edge edge = new Edge(
			src,
			Integer.valueOf(line[1]), 
			Integer.valueOf(line[2])
		);
		graph.adjList.get(src).add(edge);
		}
		fileReader.close();
		return graph;

	}
}
