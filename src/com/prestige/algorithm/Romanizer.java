package com.prestige.algorithm;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by prest on 8/14/2019.
 */
public class Romanizer {


    /*
     * Complete the 'romanizer' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */


        public static List<String> romanizer(List<Integer> numbers) {
            // Write your code here

            List<String> nums = numbers.stream().map(num -> Romanizer.romanize(num)).collect(Collectors.toList());

            return nums;

        }

        public static String romanize(int num){

            int[]  decimalValue = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romanNumeral = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
            String romanized = "";

            for (int index = 0; index < decimalValue.length; index++) {
                while (decimalValue[index] <= num) {
                    romanized += romanNumeral[index];
                    num -= decimalValue[index];
                }
            }

            return romanized;
        }

        public static int searchPatt(String str){

            String pattern = "\\#";
            Pattern  p = Pattern.compile(pattern);
            Matcher matcher = p.matcher(str);
            int count = matcher.groupCount();

            return count;
        }


    public static void main(String[] args) {
        System.out.println(Romanizer.searchPatt("######876#"));
    }
}
