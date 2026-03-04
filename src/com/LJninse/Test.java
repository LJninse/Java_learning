package com.LJninse;
import java.util.Scanner;
public class Test {
    public static int getRandomInt() {
         return (int) (Math.random() * 100);
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.mainprogram();
    }
    private void mainprogram() {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入猜测的数字");
            int guess_number = input.nextInt();
            int randomNumber = getRandomInt();
            checkNumber(guess_number,randomNumber);
            continuecheck();
    }
    private void checkNumber(int number,int randomNumber) {
        Scanner input2 = new Scanner(System.in);
        while (true) {
            if (number<randomNumber) {
                System.out.println("你猜测的数字小了");
            }
            if (number>randomNumber) {
                System.out.println("你猜测的数字大了");
            }
            if (number==randomNumber) {
                System.out.println("恭喜你猜对了~");
                break;
            }
            number= input2.nextInt();
        }
    }
    private void continuecheck() {
        Scanner input3 = new Scanner(System.in);
         while (true) {
            System.out.println("是否继续游戏?(y/n)");
            String input = input3.next();
            switch (input) {
                case "y":
                    System.out.println("请输入猜测的数字");
                    int guess_number = input3.nextInt();
                    checkNumber(guess_number,getRandomInt());
                    break;
                case "n":
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误!");
                    break;
            }
        }
    }
}

