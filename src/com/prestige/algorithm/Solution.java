package com.prestige.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

/**
    public String solution(String S, String C) {

        List<String> emails = new ArrayList<>();

        List<String> names = Arrays.asList(S.split(";"));
        names.stream().forEach(s -> {
            String[] fullname = s.trim().split(" ");
            String firstName = fullname[0].replace("-","").toLowerCase();
            String lastName = fullname[fullname.length - 1].replace("-","").toLowerCase();

            String domainName = C.concat(".com");

            String email = lastName.concat("_").concat(firstName).concat("@").concat(domainName);

            int count = 1;

            while(true){
                if(emails.contains(email)){
                    email = lastName.concat("_").concat(firstName).concat(count + "@").concat(domainName);
                }else {
                    break;
                }
                count++;
            }

            emails.add(email);
            System.out.println(email);
        });

        return String.join("; ", emails);
    }
 **/

    public int solution(int[] A) {
        //Triangle Solution
        // write your code in Java SE 8
        Arrays.sort(A);
        int p, q, r;

        for(int i=A.length -1; i > 1; i--){

            p = A[i];

            for(int j = i-1; j > 0; j--){

                q = A[j];

                for(int k = j-1; k >= 0; k--){

                    r = A[k];

                    if(p+q > r && q+r > p && p+r >q){
                        System.out.println(p + q + r);
                        return p + q + r;
                    }

                }

            }

        }

        return -1;
    }

    private boolean hasInterestingPoint(int h, int m, int s){
        Set<Integer> distinctNums = new HashSet<>();

        distinctNums.add(h/10);
        distinctNums.add(h%10);
        distinctNums.add(m/10);
        distinctNums.add(m%10);
        distinctNums.add(s/10);
        distinctNums.add(s%10);

        return distinctNums.size() <= 2 ? true : false;
    }

    public int solution(String S, String T) {
        // write your code in Java SE 8
        String[] startTime = S.split(":");
        String[] endTime = T.split(":");

        int startHour = Integer.parseInt(startTime[0]);
        int endHour = Integer.parseInt(endTime[0]);

        int startMin = Integer.parseInt(startTime[1]);
        int endMin = Integer.parseInt(endTime[1]);

        int startSec = Integer.parseInt(startTime[2]);
        int endSec = Integer.parseInt(endTime[2]);

        int interestingPoints = 0;

        while(!(startHour == endHour && startMin == endMin && startSec == endSec)){

            if(hasInterestingPoint(startHour, startMin, startSec)){
                interestingPoints++;
            }

            if(startSec == 60){
                startSec = 0;
                startMin += 1;
            }

            if(startMin == 60){
                startMin = 0;
                startHour += 1;

            }

            startSec++;

        }

        if(hasInterestingPoint(startHour, startMin, startSec)){
            interestingPoints++;
        }

        return interestingPoints;

    }

    public static void main(String[] args) {


        Solution solution = new Solution();
//        String emails = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
//        System.out.println(solution.solution(emails,"example"));
//        int[] n = new int[]{5, 10, 18, 7, 8, 3};
//        System.out.println(solution.solution(n));
        System.out.println(solution.solution("22:22:21", "22:22:23"));
    }
}