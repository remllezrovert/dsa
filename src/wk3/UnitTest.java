package wk3;

import wk3.MergeSortAndFriends;
import wk3.RotatedBinarySearch;
import java.util.ArrayList;

public class UnitTest{


public static void main(String [] args)
{
int[] A= {1,5,6,9,14,22,37,41};
int[] B= {2,5,12,13,22,33,39,40};

ArrayList<Integer> listA = new ArrayList<>();
ArrayList<Integer> listB = new ArrayList<>();
for(int i: A)
    listA.add(i);
for(int i: B)
    listB.add(i);
ArrayList<ArrayList<Integer>> C = new ArrayList<>();
C.add(listA);
C.add(listB);
System.out.println(MergeSortAndFriends.kWayMerge(C));
}
}