package com.LJninse;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        String s=String.format("%tc" ,date);
        System.out.println(s);
    }
    }
