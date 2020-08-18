package com.prestige.algorithm;

/**
 * Created by prest on 6/6/2019.
 */
public class TestTwo {

    public int[] product(int[] input) {

        int[] output = new int[input.length];

        for(int i=0; i < input.length; i++){
            int prod = 1;
            for(int j=0; j < input.length; j++){

                if(j != i){
                    prod *= input[j];
                }
            }
            output[i] = prod;
        }

        return output;
    }

    public static void main(String[] args) {

        int[] input = new int[] { 3, 1, 6, 4 };

        TestTwo testTwo = new TestTwo();
        for (int x: testTwo.product(input)
             ) {
            System.out.println(x);
        }
    }
}
