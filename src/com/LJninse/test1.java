package com.LJninse;

import java.util.Scanner;


    public class test1 {
        public static void main(String[] args) {
            test1 test = new test1();
            test.mainprogram();
        }
        private void mainprogram(){
            Scanner input = new Scanner(System.in);
            System.out.println("请输入数字1");
            double a = input.nextDouble();
            System.out.println("请输入运算符");
            String text = input.next();
            System.out.println("请输入数字2");
            double b = input.nextDouble();
            switch (text) {
                case "+":
                    System.out.println("相加结果为" + add(a, b));
                    break;
                case "-":
                    System.out.println("相减结果为" + sub(a, b));
                    break;
                case "*":
                    System.out.println("相乘结果为" + mul(a, b));
                    break;
                case "/":
                    if (b==0) {
                        while (b == 0) {
                            System.out.println("除数不可为0!,请重新输入数字2!");
                            b=input.nextDouble();
                        }
                    }
                    System.out.println("相除结果为"+div(a,b));
                    break;
                default:
                    System.out.println("您的运算符输入有误!");
                    break;
            }
        }
        private double add(double a, double b) {
            return a + b;
        }
        private double sub(double a, double b) {
            return a - b;
        }
        private double mul(double a, double b) {
            return a * b;
        }
        private double div(double a, double b){
            return a / b;
        }
    }

