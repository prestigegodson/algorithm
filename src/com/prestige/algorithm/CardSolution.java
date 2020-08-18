package com.prestige.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by prest on 5/22/2019.
 */
public class CardSolution {

    Map<String, Integer> cardStrength = new HashMap();


    private boolean winRound(String alecCard, String bobCard){

        cardStrength.put("A",14);
        cardStrength.put("K",13);
        cardStrength.put("Q",12);
        cardStrength.put("J",11);
        cardStrength.put("T",10);
        cardStrength.put("9",9);
        cardStrength.put("8",8);
        cardStrength.put("7",7);
        cardStrength.put("6",6);
        cardStrength.put("5",5);
        cardStrength.put("4",4);
        cardStrength.put("3",3);
        cardStrength.put("2",2);

        if(cardStrength.get(alecCard) > cardStrength.get(bobCard)){
            return true;
        }

        return false;
    }

    public int solution(String A, String B) {
        // write your code in Java SE 8
        String[] alecDeck = A.split("");
        String[] bobDeck = B.split("");

        int deckLength = alecDeck.length;

        int alecWins = 0;

        for(int i=0; i<deckLength; i++){
            System.out.println(alecDeck[i] + " -  " + bobDeck[i]);
            boolean result = this.winRound(alecDeck[i], bobDeck[i]);

            if(result){
                alecWins++;
            }
        }

        return alecWins;
    }

    int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0 && i < n - 1) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1 && i > 0) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.max(r, count);
        }
        return result + r;
    }


    public static void main(String[] args) {

    }

}
