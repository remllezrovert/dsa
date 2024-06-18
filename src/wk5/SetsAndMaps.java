
package wk5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetsAndMaps {

	public static void bstSort(char[] arr, int len) { // complete this method
		TreeMap<Character, Integer> treeMap = new TreeMap<>();
		for (Character c: arr){
			if (!treeMap.containsKey(c)){ //first time so freq is 1
				treeMap.put(c,1);
			} else {
				treeMap.put(c,treeMap.get(c) + 1); //increase freq
			}


		}
		int counter = 0;
		for (Character c: treeMap.keySet()){
			for (int v = 0; v < treeMap.get(c); v++){ //place char into arr v times
				arr[counter] = c;
				counter++;
			}
		}


	}
	
	public static ArrayList<String> intersection(ArrayList<String> arg1, ArrayList<String> arg2) { // complete this method
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> common = new HashSet<String>();
		set1.addAll(arg1);
		arg2.forEach( (s) ->{
			if (set1.contains(s))
				common.add(s);
		});
		return new ArrayList<String>(common);


	}
}
