
package wk6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class IOHelper {

	public static Graph readWeightedGraph(String filePath) throws FileNotFoundException { // complete this method
		try {

			Scanner fileReader = new Scanner(new File(filePath));
			int numVertices = Integer.valueOf(fileReader.nextLine());
			Graph graph = new Graph();
		graph.numVertices = numVertices;
		graph.adjList = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i < numVertices; i++){
			graph.adjList.add(new ArrayList<Edge>()); //add a blank row to the adjlist
		}
		int src;
		int dest;
		int weight;

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
	} catch(Exception e) {
			System.out.println("file not found");

			e.printStackTrace();
			return null;
		}


	}
}
