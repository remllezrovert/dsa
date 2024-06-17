package wk4;
import java.util.LinkedList;
import java.util.Queue;
public class PracticeBFS {
 
    



    public static boolean[][] adjMatrix = new boolean[5][5];
    public static int[] values = new int[5];



    public static Queue<Integer> queue = new LinkedList();

    public static boolean BFS(int search){
        
        boolean marked[] = new boolean[values.length];
        int j = 0; 
        queue.add(0);
        while (queue.size() > 0 && j < adjMatrix[0].length){
            for (int i = 0; i < adjMatrix[j].length; i++){
                    if (values[i] == search)
                        return true;
                if (marked[i] == false){
                    queue.add(i);
                }
            }
            
            marked[queue.peek()] = true;
            queue.remove();
            j++;

        }
        return false;
    }



    public static boolean DFS(int search, boolean[][] marked, int x, int y){
        marked[x][y] = true;

        for (int i = 0; i < adjMatrix[x].length; i++){
            if (values[i] == search)
                return true;
            if (adjMatrix[x][i] == true && marked[x][i] == false){
                return DFS(search, marked, x, i);
            }
        }
        return false;
         

    }


    public static void main(String[] args){
        adjMatrix[0][1] = true;
        adjMatrix[0][2] = true;
        adjMatrix[1][2] = true;
        adjMatrix[2][3] = true;

        values[0] = 10;
        values[1] = 20;
        values[2] = 30;
        values[3] = 40;

        System.out.println(DFS(40,new boolean[5][5], 0, 1));
        System.out.println(BFS(30));
   
}
}
