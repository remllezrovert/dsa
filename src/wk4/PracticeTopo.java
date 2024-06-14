package wk4;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class PracticeTopo {
    public static int[] values = new int[8];
    public static boolean[] visited = new boolean[values.length];
    public static ArrayList<ArrayList<Integer>> adjList = new ArrayList();
    public static Queue<Integer> queue = new LinkedList();

    public static boolean BFS(int search) {
        while (queue.size() > 0) {

            int current = queue.poll();
            for (int i = 0; i < adjList.get(current).size(); i++) {
                int adjacentNode = adjList.get(current).get(i);
                if (values[adjacentNode] == search)
                    return true;

                if (visited[adjacentNode] == false) {
                    visited[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }

        return false;
    }

    public static boolean DFS(int search, int start) {

        for (int node : adjList.get(start)) {
            if (node == search)
                return true;
            if (!visited[node]) {
                if (DFS(search, node) == true)
                    return true;
            }
        }

        visited[start] = true;
        return false;

    }


    public static Stack<Integer> stack = new Stack<>();
    public static void addToStack(int start){
        for (int node : adjList.get(start)) {
            if (!visited[node]) {
                addToStack(node);
                stack.push(node);
            }

        }
        visited[start] = true;

    }

    public static ArrayList<Integer> topoSort(int start){
        addToStack(start);
        stack.push(start);
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) 
            ret.add(stack.pop());
        return ret;
    }


    public static void clear(){
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }

    }
    public static void main(String[] args) {
        for (int i = 0; i < values.length; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(1).add(4);
        adjList.get(2).add(5);
        adjList.get(3).add(6); 
        adjList.get(4).add(6);
        adjList.get(5).add(6);
        adjList.get(6).add(7);

        values = new int[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        queue.add(0);
        visited[0] = true;
        int searchValue = 5;
        System.out.println("BFS Value " + searchValue + " found: " + BFS(searchValue));
        clear();
        System.out.println("DFS Value " + searchValue + " found: " + DFS(searchValue, 0));
        clear();
        System.out.println(topoSort(0));
    }
}
