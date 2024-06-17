
package wk5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode(0);
	}

	private TrieNode locus(String str) { // complete this method
		TrieNode tmp = root;
		for (int i = 0; i < str.length(); i++){
			Character c = str.charAt(i);
			TrieNode v = tmp.edges.get(c); // v -> c
			if (v == null){

				return tmp;
			} else
			tmp = v;
		}

		return tmp;
	}

	public void insert(String str) { // complete this method
		TrieNode parent = locus(str);
		for (int i = parent.depth; i < str.length(); i++){
			Character c = str.charAt(i);
			TrieNode child = new TrieNode(i + 1);
			parent.edges.put(c, child);
			parent = child;
		}
	}

	public boolean search(String str) { // complete this method
		if (locus(str).depth == str.length()) {
			return true;
		} else {
			return false;
		}

	}

	public static TreeSet<String> intersection(ArrayList<String> arg1, ArrayList<String> arg2) { // complete this method
		Trie trie = new Trie();
		arg1.forEach((s) -> trie.insert(s + "$"));
		TreeSet<String> treeSet = new TreeSet<String>();
		arg2.forEach((s) -> {
			if (trie.search(s + "$")) treeSet.add(s);
		});
		return treeSet;
	}
}
