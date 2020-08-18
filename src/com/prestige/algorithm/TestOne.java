package com.prestige.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TestOne {

     static Map<Integer, Integer> store = new HashMap();

    private static String repeatingNumbers(int[] array){

        for(int i=0; i<array.length; i++){
            if(store.containsKey(array[i])){
                int val = store.get(array[i]);
                store.put(array[i], val + 1);
            }else{
                store.put(array[i], 0);
            }
        }

        store = store.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));

        String str = store.keySet().stream().map(key -> {
            if(store.get(key) != 0){
                return String.valueOf(key);
            }
            return "";
        }).collect(Collectors.joining(" "));

        str = str.trim();

        if(str.length() == 0){
            return "0";
        }else{
            return str;
        }
    }

    public static void main(String[] args) {

        int[] inputs = new int[]{9 , 9, 1, 3, 1};
        String res = repeatingNumbers(inputs);
        System.out.println(res);
    }
}
