package com.prestige.algorithm.dynamic_programming;

public class LevenshteinDistance {

    private final String str1;
    private final String str2;
    private Integer[][] matrix;

    public LevenshteinDistance(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        matrix = new Integer[str1.length()+1][str2.length()+1];
    }

    public Integer getDistance(){

        for(int i=0; i<str1.length() + 1; i++){
            for(int j=0; j<str2.length() + 1; j++){
                matrix[i][j] = j;
            }
            matrix[i][0] = i;
        }

        for(int row=1; row<str1.length() + 1; row++){
            for(int col=1; col<str2.length() + 1; col++){
                if(str1.charAt(row-1) == str2.charAt(col-1)){
                    matrix[row][col] = matrix[row-1][col-1];
                }else{
                    matrix[row][col] = Math.min(Math.min(matrix[row][col-1],matrix[row-1][col-1]),
                            matrix[row-1][col]) + 1;
                }
            }
        }

        return matrix[str1.length()][str2.length()];
    }

    public static void main(String[] args) {

        LevenshteinDistance distance = new LevenshteinDistance("kabana","kitana");
        System.out.println(String.format("Distance is = %s",distance.getDistance()));
    }
}
