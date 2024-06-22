
package wk6;

public class PriorityQueuePair implements Comparable<PriorityQueuePair>{

	public int item;
	public int priority;
	
	public PriorityQueuePair(int item, int priority) {
		this.item = item;
		this.priority = priority;
	}

	public int compareTo(PriorityQueuePair other){
		return priority - other.priority;
	}
}
