package com.prestige.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by prest on 4/12/2019.
 */
public class SearchPattern {

    public static void main(String[] args) {

        List<String> linkedList = new LinkedList();
        linkedList.add("0");

        String words = "387??83";

        int searchIndex = -1;
        do{
            searchIndex = words.indexOf("?",searchIndex + 1);
            if(searchIndex != -1) {
                System.out.println(searchIndex);
            }
        }while(searchIndex != -1);

    }
}
