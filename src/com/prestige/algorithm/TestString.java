package com.prestige.algorithm;

import java.util.Base64;

public class TestString {

    public static void main(String[] args) {

        String str = Base64.getDecoder().decode("iamprodfoxygreensecretguy2019".getBytes()).toString();
        System.out.println(str);
    }
}
