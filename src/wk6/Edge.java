
package wk6;

public class Edge {

	int src, dest, weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	public String toString() {
		return String.format("<%d, %d, %d>", src, dest, weight);
	}
}
