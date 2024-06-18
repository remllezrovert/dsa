package wk4;
import java.util.Arrays;
import java.util.ArrayList;
public class MergeSortPractice{


    public static int binarySearch(int[] arr, int search){
        int max = arr.length - 1;
        int min = 0;
        int fence = arr.length / 2;
        while (min <= max) {

            fence = (max + min) / 2;
            if (arr[fence] == search)
                return fence;
            if (arr[fence] < search){
                min = fence + 1;
                System.out.println(arr[fence] + " < " + search);
            }
            else if (arr[fence] > search){
                max = fence + 1;
                System.out.println(arr[fence] + " > " + search);
            }
        }

        return -1;
    }

    public static int[] binaryMerge(int[] arr1, int[] arr2){
        int i1 = 0;
        int i2 = 0;
        int[] outArr = new int[arr1.length + arr2.length];
        //System.out.println("The lengths are: " + arr1.length + " " + arr2.length+ " " + outArr.length);

        for (int i = 0; i < outArr.length; i++){
            if (i1 < arr1.length &&(i2 >= arr2.length || arr1[i1] <= arr2[i2])){
                outArr[i] = arr1[i1];
                i1++;
            } else if (i2 < arr2.length){
                outArr[i] = arr2[i2];
                i2++;
            }
        }
        return outArr;
    }





    public static int[] mergeSort(int[] arr){
        //this bitch gotta be recursive
        

        int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] arr2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        for (int i : arr1)
            System.out.print(i + " ");
        System.out.print("     -     ");
        for (int i : arr2)
            System.out.print(i + " ");

        System.out.println("");

        if (arr1.length == 1 && arr2.length == 1){
            return binaryMerge(arr1, arr2);
        } else if (arr1.length == 1 && arr2.length > 1){
            return binaryMerge(arr1,mergeSort(arr2));
        } else if (arr2.length == 1 && arr1.length > 1){
            return binaryMerge(mergeSort(arr1), arr2);
        }
        return binaryMerge(mergeSort(arr1),mergeSort(arr2)
        );

    }

    public static void main(String[] args){
        int[] arr1 = {-14,-13,-1,1,2,3,4,5,6,7,8,9,11,13,14};
        int[] arr2 = {-15,-12,-2,1,2,3,4,5,6,7,8,9,12,14,16};
        int[] uno2 = {-15,-16};
        int[] unordered = {19,7, 23, 13, 2, 9, 1, 12, 17, 16, 15, 99, 8, -1, -43};
        System.out.println(binarySearch(arr1, 8));
        for ( int i :binaryMerge(arr1, arr2))
            System.out.print(i + " ");
        System.out.println("");
        for ( int i :mergeSort(unordered))
            System.out.print(i + " ");

    }

}