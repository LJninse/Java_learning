package com.LJninse;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        String Year=String.format("%tY" ,date);
        String Month=String.format("%tB" ,date);
        String Day=String.format("%td" ,date);
        System.out.println("今年是"+Year+"年");
        System.out.println("现在是"+Month);
        System.out.println("今天是"+Day+"号");
    }
    }
