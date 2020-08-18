package com.prestige.algorithm;

/**
 * Created by prest on 3/9/2019.
 */
public class BubbleSort {

    int[] unsorted;

    public BubbleSort(int[] unsorted) {
        this.unsorted = unsorted;
    }


    public int[] sort(){

        boolean madeAnySwitch;
        do{
            madeAnySwitch = false;

            for(int i=0; i<unsorted.length - 1; i++){

                if(unsorted[i] > unsorted[i+1]){
                    int tmp = unsorted[i + 1];
                    unsorted[i+1] = unsorted[i];
                    unsorted[i] = tmp;
                    madeAnySwitch = true;
                }
            }

        }while(madeAnySwitch);

        return unsorted;
    }


    public void printArray(int[] arr){

        for(int i=0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        int[] unsorted = {3,1,5,7,8,9};

        BubbleSort bubbleSort = new BubbleSort(unsorted);
        bubbleSort.printArray(bubbleSort.sort());

    }
}
