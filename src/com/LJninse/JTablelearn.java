package com.LJninse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTablelearn extends JFrame {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        JTablelearn jt = new JTablelearn();
        jt.setVisible(true);
    }
    public JTablelearn() {
        setTitle("表格.exe");
        setBounds(300,300,600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane jsp = new JScrollPane();
        add(jsp, BorderLayout.CENTER);
        String[] columnNames = {"编号","姓名","性别"};            //设定列
        String[][] tableValues = {{"1","仙贝","男"},{"2","坤坤子","女"},{"3","耄耋","猫"},{"4","滚木","女"}};//设定内容
        DefaultTableModel model = new DefaultTableModel(tableValues,columnNames);
        JTable table = new JTable(model);
        JTextField code = new JTextField("",10);
        JTextField name = new JTextField("",10);
        JTextField sex = new JTextField("",10);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置单选
        table.setAutoCreateRowSorter(true);
        table.addMouseListener(new MouseAdapter() { //选中表格事件
            @Override
            public void mouseClicked(MouseEvent e) {
                int SelectedRow = table.getSelectedRow();
                Object oa = table.getValueAt(SelectedRow,0);
                Object ob = table.getValueAt(SelectedRow,1);
                Object oc = table.getValueAt(SelectedRow,2);
                code.setText(oa.toString());
                name.setText(ob.toString());
                sex.setText(oc.toString());
            }
        });
        jsp.setViewportView(table);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        add(panel, BorderLayout.SOUTH);
        JLabel l1 =new JLabel("编号",10);
        panel.add(l1);
        panel.add(code);
        JLabel l2 =new JLabel("姓名",10);
        panel.add(l2);
        panel.add(name);
        JLabel l3 =new JLabel("性别",10);
        panel.add(l3);
        panel.add(sex);
        JButton addButton =new JButton("添加");
        addButton.addActionListener(e -> {
           String[] rowValues = {code.getText(),name.getText(),sex.getText()};
           model.addRow(rowValues);
        });
        panel.add(addButton);
        JButton updButton = new JButton("修改");
        updButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if(selectedRow!=-1){
                model.setValueAt(code.getText(),selectedRow,0);
                model.setValueAt(name.getText(),selectedRow,1);
                model.setValueAt(sex.getText(),selectedRow,2);
            }
        });
        panel.add(updButton);
        JButton delButton = new JButton("删除");
        delButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if(selectedRow!=-1){
                model.removeRow(selectedRow);
            }
        });
        panel.add(delButton);
    }
}
