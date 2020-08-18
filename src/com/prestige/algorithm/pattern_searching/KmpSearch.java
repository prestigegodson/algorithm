package com.prestige.algorithm.pattern_searching;

/**
 * Created by prest on 8/2/2019.
 */
public class KmpSearch {

    private int[] computeLps(String pattern, int[] lps){

        int m = pattern.length();
        int i = 1;
        int len = 0;

        lps[0] = 0;

        while(i < m){

            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{

                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {

    }
}
