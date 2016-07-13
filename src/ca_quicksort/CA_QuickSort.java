package ca_quicksort;

import java.util.Scanner;

public class CA_QuickSort {
    public static int[] intArr=null;
    public static int pivot=0;
    public static void printArray(){
    for (int i=0; i<intArr.length; i++){System.out.print(intArr[i]+" ");}
    System.out.println("");
    }
    
    public static int partitionArr(int left, int right, int pivot) {
        int leftPtr = left - 1; 
        int rightPtr = right + 1; 
        while (true) {
            while (leftPtr < right && intArr[++leftPtr] < pivot); 
            while (rightPtr > left && intArr[--rightPtr] > pivot); 
            if (leftPtr >= rightPtr) 
            {
                break; 
            } else   {swap(leftPtr, rightPtr);} swap(leftPtr, right);
        } 
        return leftPtr;         
            }
    
    public static void swap(int dex1, int dex2) {
        int temp;
        temp = intArr[dex1];
        intArr[dex1] = intArr[dex2];
        intArr[dex2] = temp;
    }
    
    public static void recQuickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            
            int pivot = intArr[right];

            int partition = partitionArr(left, right, pivot);
            System.out.println("left - " +left+" right - "+partition);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    public static void main(String[] args) {

        String str_input = "9 5 3 8 1 4 7 2 9 6";
        
        int size=0, item=0;
        
        Scanner scan=new Scanner(str_input);
        size=scan.nextInt();
        intArr=new int[size];
        for (int i=0; i<size; i++){intArr[i]=scan.nextInt();}
        printArray();
        int sum=0, avg=0;
        for (int q: intArr){sum+=q;} avg =sum/size;
        pivot=avg; System.out.println("pivot valus is "+pivot);
        int idx= partitionArr(0, size-1, pivot);
        System.out.println("index "+idx);
        recQuickSort(0, size-1);
        
        printArray();
        





    }

}
