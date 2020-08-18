package com.prestige.algorithm;

public class Strip {

    public String stripWord(String words, int k){

        int right = k;

        if(k == words.length()){
            return words;
        }

        String c = String.valueOf(words.charAt(right+1));
        while(!c.equalsIgnoreCase(" ")){
            right = right - 1;
            c = String.valueOf(words.charAt(right+1));
        }

        return words.substring(0, right+1);
    }

    public static void main(String[] args) {

        Strip s = new Strip();
        System.out.println(s.stripWord("Codility we are coders", 14));
    }
}
