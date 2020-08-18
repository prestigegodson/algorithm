package com.prestige.algorithm.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm that finds the sum of two indexes in an array,
 * that will match a target.
 */
public class SumTwoArray {

    public Integer[] sumTwoNumbers(Integer[] input, Integer target){

        Map<Integer, Integer> map = new HashMap();
        Integer[] indexes = new Integer[2];

        for(int i=0; i<input.length; i++){

            Integer val = map.get(target - input[i]);
            if(val == null){

                map.put(input[i], i);
            }else{
                indexes[0] = map.get(target - input[i]);
                indexes[1] = i;
                break;
            }
        }

        return indexes;
    }

    public static void main(String[] args) {

        Integer[] input = new Integer[]{1,2,3,4,5};
        Integer target = 8;

        SumTwoArray sumTwoArray = new SumTwoArray();
        Integer[] output = sumTwoArray.sumTwoNumbers(input, target);

        if(input[output[0]]+ input[output[1]] == target){
            System.out.println("Successful");
        }else{
            System.err.println("Failed");
            System.out.println("Expected 3 & 5, but got " + input[output[0]] + " & " + input[output[1]]);
        }
    }
}
