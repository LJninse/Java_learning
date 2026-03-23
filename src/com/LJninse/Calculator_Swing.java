package com.LJninse;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator_Swing extends JFrame {
    private JPanel contentPane;
    private JPanel displayPanel;            //显示面板
    private JPanel inputPanel;              //输入面版
    private JButton addbutton;              //符号按钮
    private JButton subbutton;
    private JButton mulbutton;
    private JButton divbutton;
    private JButton equalbutton;
    private JButton pointbutton;
    private JButton button1;                //数字按钮
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JTextField display;             //显示框
    private ActionListener insert =new Insert();
    private ActionListener command = new Command();
    private boolean start = true;
    private String lastCommand = "=";
    private double result = 0;

    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        Calculator_Swing calculator = new Calculator_Swing();
        calculator.setVisible(true);
        }
    public Calculator_Swing() {
        setTitle("计算器");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        inputPanel = new JPanel();
        inputPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
        inputPanel.setLayout(new GridLayout(4,4,5,5));
        contentPane.add(inputPanel,BorderLayout.CENTER);

        display=new JTextField(30);
        display.setFont( new Font( "微软雅黑",Font.PLAIN,15));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setColumns(13);

        displayPanel=new JPanel();
        displayPanel.setLayout(new BorderLayout(0,0));
        displayPanel.add(display);
        displayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.add(displayPanel,BorderLayout.NORTH);

        button7=new JButton("7");
        button7.addActionListener(insert);
        inputPanel.add(button7);

        button8=new JButton("8");
        button8.addActionListener(insert);
        inputPanel.add(button8);

        button9=new JButton("9");
        button9.addActionListener(insert);
        inputPanel.add(button9);

        divbutton=new JButton("/");
        divbutton.addActionListener(command);
        inputPanel.add(divbutton);

        button4=new JButton("4");
        button4.addActionListener(insert);
        inputPanel.add(button4);

        button5=new JButton("5");
        button5.addActionListener(insert);
        inputPanel.add(button5);

        button6=new JButton("6");
        button6.addActionListener(insert);
        inputPanel.add(button6);

        mulbutton=new JButton("*");
        mulbutton.addActionListener(command);
        inputPanel.add(mulbutton);

        button1=new JButton("1");
        button1.addActionListener(insert);
        inputPanel.add(button1);

        button2=new JButton("2");
        button2.addActionListener(insert);
        inputPanel.add(button2);

        button3=new JButton("3");
        button3.addActionListener(insert);
        inputPanel.add(button3);

        subbutton=new JButton("-");
        subbutton.addActionListener(command);
        inputPanel.add(subbutton);

        button0=new JButton("0");
        button0.addActionListener(insert);
        inputPanel.add(button0);

        pointbutton=new JButton(".");
        pointbutton.addActionListener(insert);
        inputPanel.add(pointbutton);

        equalbutton=new JButton("=");
        equalbutton.addActionListener(command);
        inputPanel.add(equalbutton);

        addbutton=new JButton("+");
        addbutton.addActionListener(command);
        inputPanel.add(addbutton);
        pack();
    }
    private class Insert implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            String text = display.getText();
            if (start) {
                display.setText("");
                start = false;
            }
            if (text.startsWith(".")) {
                display.setText("0" + display.getText() + input);
            } else if (text.startsWith("-0.") || text.startsWith("0.")) {
                display.setText(display.getText() + input);
            } else if (text.startsWith("-0")) {
                display.setText("-" + input);
            } else if (text.startsWith("0")) {
                display.setText(input);
            } else {
                display.setText(display.getText() + input);
            }
        }
    }
    private class Command implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }
    public void calculate(double x) {
        char operator = lastCommand.charAt(0);
        switch (operator) {
            case '+':
                result += x;
                break;
            case '-':
                result -= x;
                break;
            case '*':
                result *= x;
                break;
            case '/':
                result /= x;
                break;
            case '=':
                result = x;
                break;
        }
        display.setText("" + result);
    }

}
