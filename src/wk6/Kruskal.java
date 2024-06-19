
package wk6;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Kruskal extends Graph {

	public Kruskal(String filePath) throws FileNotFoundException { // complete this constructor
		Graph g = IOHelper.readWeightedGraph(filePath);
		numVertices = g.numVertices;
		adjList = g.adjList;

	}

public ArrayList<Edge> execute() { // complete this method
	ArrayList<Edge> edgeList = new ArrayList<>();
	edgeList.sort((e1, e2) -> {
	if (e1.weight == e2.weight)
		return Integer.compare(e1.dest, e2.dest);
	return e1.weight - e2.weight;
    });
	UnionFind objUF= new UnionFind(numVertices);
	ArrayList<Edge> da = new ArrayList<>();
	int numEdgesAdded = 0;
		for (Edge e : edgeList){
		int src = e.src;
		int dest = e.dest;
		if (objUF.find(src) != objUF.find(dest)){
			objUF.doUnion(src,dest);
			da.add(e);
			numEdgesAdded++;
			if (numEdgesAdded == numVertices - 1)
				break;
		}
	}
	return da;
}


		//what goes in here?);

}
