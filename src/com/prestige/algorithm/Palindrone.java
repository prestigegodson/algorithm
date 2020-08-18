package com.prestige.algorithm;

/**
 * Created by prest on 10/21/2019.
 */
public class Palindrone {

    private static boolean check(String str){

        boolean isPalidrone = true;

        int left = 0;
        int right = str.length() - 1;
        while(left <= right){

            if(str.charAt(left) != str.charAt(right)){
                isPalidrone = false;
                break;
            }
            left++;
            right--;
        }

        return isPalidrone;
    }

    public static void main(String[] args) {

        System.out.println("Madam is palindrone : " + Palindrone.check("madam"));
    }
}
