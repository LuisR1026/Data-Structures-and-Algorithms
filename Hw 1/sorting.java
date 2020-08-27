import java.util.*;
public class hw1
{

    public static void main(String[] args) {
        //PART 1
        int[] randArray =newArray(5);
        int[] A = newArray(10000);
        int[] B = newArray(20000);
        int[] C = newArray(30000);
        int[] D = newArray(40000);
        int[] E = newArray(60000);
        int[] F = newArray(80000);
       
        System.out.println("   --------------ALGORITHM 1-------------\n");
       
        System.out.println("Original array:  " +Arrays.toString(randArray));
        mySort(randArray);
        System.out.println("Sorted array:  " +Arrays.toString(randArray));
       
        printResult(A.length, mySort(A), "millisecs");
        printResult(B.length, mySort(B), "millisecs");
        printResult(C.length, mySort(C), "millisecs");
        printResult(D.length, mySort(D), "millisecs");
        printResult(E.length, mySort(E), "millisecs");
        printResult(F.length, mySort(F), "millisecs");
       
        //PART 2
        int[] randArray2 = {3, 4, 8, 10, 15, 19};
       
        System.out.println("\n--------------ALGORITHM 2-------------");
        System.out.println("Array:  " +Arrays.toString(randArray2));
        System.out.println("Index of 15:  " +search(randArray2, 15));
        System.out.println("Index of 5:  " +search(randArray2, 5));
       
        printResult(A.length, timeSearch(A, (int)(Math.random()*100 + 1)), "nanosecs");
        printResult(B.length, timeSearch(B, (int)(Math.random()*100 + 1)), "nanosecs");
        printResult(C.length, timeSearch(C, (int)(Math.random()*100 + 1)), "nanosecs");
        printResult(D.length, timeSearch(D, (int)(Math.random()*100 + 1)), "nanosecs");
        printResult(E.length, timeSearch(E, (int)(Math.random()*100 + 1)), "nanosecs");
        printResult(F.length, timeSearch(F, (int)(Math.random()*100 + 1)), "nanosecs");
       
    }
   
    public static void printResult(int arraySize, long runTime, String unit){
        System.out.printf ("Size:  %-22d Run-time:  %d "+unit+"\n", arraySize, runTime);
    }
    //sorting step
    public static long mySort(int[] A) {
        int temp = 0;
        long start = 0;
        long end= 0;
        long runTime = 0;
       
        start = System.currentTimeMillis();//set start time
       
        for(int i = 0; i < A.length-1; i++){
            for(int j = i + 1; j < A.length; j++){
                if(A[i] > A[j]){
                    temp = A[j];
                    A[j]= A[i];
                    A[i]=temp;
                }
            }
        }
        end= System.currentTimeMillis();//end start time
        runTime = (end - start);
        return runTime;
    }
   
    /*public static int[] newArray (int size) {
            int[] A = new int[size];
            for (int i = 0; i < size; i++) {
                A[i] = (int)(Math.random()*100 + 1);
            }
            return A;
    }*/
   
    /*** PART 2 ***/
    public static long timeSearch(int[] A, int target) {
        int temp = 0;
        long start = 0;
        long end= 0;
        long runTime = 0;
       
        start = System.nanoTime();
        search(A, target);
        end= System.nanoTime();
       
        runTime = (end - start);
        return runTime;
    }
   
    public static int search(int[] A, int target) {
        return searchUtil(A, 0, A.length - 1, target);
    }
   
    //rescursion step
    public static int searchUtil(int[] A, int leftIndex, int rightIndex, int target) {
        if (leftIndex > rightIndex) {
            return -1;
        }
        int midIndex = (int)leftIndex + (rightIndex - leftIndex) / 2;
        int mid_val = A[midIndex];
   
        if (mid_val == target) {
            return midIndex;
        }       
        else if (mid_val < target) { //if less than, value is on the left
            return searchUtil(A, midIndex + 1, rightIndex, target);
        }
        else if (mid_val > target) {//if greater, value is on the right
            return searchUtil(A, leftIndex, midIndex - 1, target);
        }
        else {
            return -1;
        }
    }

}
