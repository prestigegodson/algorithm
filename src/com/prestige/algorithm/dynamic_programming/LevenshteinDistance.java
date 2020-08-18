package com.prestige.algorithm.dynamic_programming;

public class LevenshteinDistance {

    private final String str1;
    private final String str2;

    private int rowLength;
    private int columnLength;
    private Integer[][] matrix;

    public LevenshteinDistance(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;

        rowLength = str1.length();
        columnLength = str2.length();

        matrix = new Integer[rowLength+1][columnLength+1];
    }

    private Integer getDistance(){
        matrix[0][0] = 0;

        int row = 0;
        int column = 1;
        matrix[row][column] = 0;

        while(column <= columnLength){
            matrix[0][column] =  matrix[0][column - 1] + 1;
            column++;
        }

        row = 1;

        while(row <= rowLength){
            matrix[row][0] = matrix[row - 1][0] + 1;
            row++;
        }

        row = 1;
        column = 1;

        while(row <= rowLength){

            while(column <= columnLength){
                if(str1.charAt(row-1) == str2.charAt(column-1)){
                    matrix[row][column] = matrix[row-1][column-1];
                }else{
                    matrix[row][column] = Math.min(Math.min(matrix[row][column-1],matrix[row-1][column-1]),
                            matrix[row-1][column]) + 1;
                }
                column++;
            }
            column = 1;
            row++;
        }

        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[i].length;j++){
                if(j == 0) {
                    System.out.print(matrix[i][j]);
                    continue;
                }

                System.out.print("," + matrix[i][j]);

            }
            System.out.println("");
        }

        return matrix[rowLength][columnLength];
    }



    public static void main(String[] args) {

        LevenshteinDistance distance = new LevenshteinDistance("kabana","kitana");
        System.out.println(String.format("Distance is = %s",distance.getDistance()));
    }
}
