
package wk6;

import java.util.ArrayList;

public class UnionFind {

	private ArrayList<ArrayList<Integer>> representatives;

	public UnionFind(int initialNumSets) { // complete this constructor
		representatives = new ArrayList<>(initialNumSets);
		for (int x = 0; x < initialNumSets; x++)
			makeSet(x);
		
	}

	public void makeSet(int x) { // complete this method
		ArrayList<Integer> da = new ArrayList<>();
		da.add(x);
		representatives.add(da);
	}

	public ArrayList<Integer> find(int x) { // complete this method
     	for (ArrayList<Integer> set : representatives) {
            if (set.contains(x)) {
                return set;
            }
        }
        return null;
		//return representatives.get(x);
	}

	private void append(ArrayList<Integer> arg1, ArrayList<Integer> arg2) { // complete this method
		while (arg2.size() != 0){
			int x = arg2.get(arg2.size() - 1);
			arg2.remove(arg2.size() -1);
			representatives.set(x, arg1);
			arg1.add(x);                    //add x to the end of arg1
		}

	}

	public void doUnion(int x, int y) { // complete this method
			ArrayList<ArrayList<Integer>> da = new ArrayList<>();
		ArrayList<Integer> dax = find(x);
		ArrayList<Integer> day = find(y);
		if (!dax.equals(day)){
			if (dax.size() >= day.size()){
			append(dax,day);
			} else {
				append(day, dax);
			}
		}
	}
}
