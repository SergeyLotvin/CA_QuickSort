package ca_quicksort;

import java.util.Scanner;

public class CA_QuickSort {

    public static int[] intArr = null;
    public static boolean fs=true;
    public static int pivot=0;
    public static int fpivot=0, fpartition=0;

    public static void printArray() {
        for (int i = 0; i < intArr.length; i++) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println("");
    }

    public static int partitionArr(int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right+1;
        while (true) {
            while (leftPtr < right && intArr[++leftPtr] < pivot);
            while (rightPtr > 0 && intArr[--rightPtr] > pivot);
            if (leftPtr >= rightPtr) {
                System.out.println("break leftPtr " + leftPtr + " rightPtr " + rightPtr);
                break;
            } else {
                System.out.println("else leftPtr " + leftPtr + " rightPtr " + rightPtr);
                swap(leftPtr, rightPtr);
            }

        }
        swap(rightPtr, left);
        return leftPtr;
    }

    public static void swap(int dex1, int dex2) {
        int temp;
        temp = intArr[dex1];
        intArr[dex1] = intArr[dex2];
        intArr[dex2] = temp;
    }

    public static void recQuickSort(int left, int right) {
        printArray();
        if (right - left <= 0) { System.out.println("right - left = "+right+" - "+left);
            return;
        } else {

            if (fs) {pivot = intArr[left];} else{pivot = intArr[right-1];}
            System.out.println("left - " + left + " right - " + right + " pivot - " + pivot);
            int partition = partitionArr(left, right, pivot);  if (fs) {fpartition = partition; fs=false;}
            System.out.println("after partition partition is - " + partition);
            
            recQuickSort(left, partition -1); 
            //recQuickSort(partition+1, right); 
            System.out.println("fin");
        }
    }
    
     public static void recQuickSortR(int left, int right) {
        printArray();
        if (right - left <= 0) { System.out.println("SortR right - left = "+right+" - "+left);
            return;
        } else {

            if (fs) {pivot = intArr[right];fs=false;} else{pivot = intArr[left];}
            System.out.println("SortR left - " + left + " right - " + right + " pivot - " + pivot);
            int partition = partitionArr(left, right, pivot);
            System.out.println(" SortR after partition partition is - " + partition);            
           recQuickSortR(partition, right); 
           
        }
    }

    public static void quickSort() {
        recQuickSort(0, intArr.length - 1);
    }

    public static void main(String[] args) {

        String str_input = "10\n"
                + "38 23 9 19 113 5 42 85 71 112";

        int size = 0, item = 0;

        Scanner scan = new Scanner(str_input);
        size = scan.nextInt();
        intArr = new int[size];
        for (int i = 0; i < size; i++) {
            intArr[i] = scan.nextInt();
        }
        printArray();
        int sum = 0, avg = 0;
        for (int q : intArr) {
            sum += q;
        }
        avg = sum / size;
//pivot=avg; System.out.println("pivot valus is "+pivot);
//int idx= partitionArr(0, size-1, pivot);
//System.out.println("index "+idx);
        quickSort();

        System.out.print (" final left = ");printArray();
        System.out.println ("");
        System.out.println (" fpartition = "+fpartition+ " right "+(size-1));
        fs=true;
        recQuickSortR(fpartition, size-1);

    }

}
