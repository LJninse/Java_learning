package com.LJninse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FakeSteam extends JFrame {
    public FakeSteam() {
        setResizable(false);
        setBounds(500,500,400,300);
        Container c= getContentPane();
        c.setLayout(null);
        JLabel Title=new JLabel("Staem");
        Title.setBounds(150,20,200,50);
        Title.setFont(new Font("微软雅黑",Font.BOLD,25));
        c.add(Title);
        JLabel name=new JLabel("请输入用户名");
        name.setBounds(30,70,80,30);
        c.add(name);
        JTextField jTextFiled=new JTextField();
        jTextFiled.setEditable(true);
        jTextFiled.setBounds(150,70,200,30);
        c.add(jTextFiled);
        JLabel password = new JLabel("请输入密码");
        password.setBounds(30,110,80,30);
        c.add(password);
        JPasswordField jPasswordField=new JPasswordField();
        jPasswordField.setBounds(150,110,200,30);
        c.add(jPasswordField);
        JButton passButton=new JButton("登录");
        passButton.setBounds(150,200,80,30);
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] passwordchar=jPasswordField.getPassword();
                String password=new String(passwordchar);
                String name=jTextFiled.getText();
                System.out.println(password);
                System.out.println(name);
                if (name.equals("114514")&&password.equals("1919810")) {
                    JOptionPane.showMessageDialog(FakeSteam.this, "登录成功", "登录成功", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(FakeSteam.this,"账号密码输入有误！","登录失败",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        c.add(passButton);
    }
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl" , "true");
        FakeSteam test=new FakeSteam();
        test.setVisible(true);
    }
}
