package com.LJninse

import java.awt.BorderLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.border.EmptyBorder

class Calculator: JFrame() {
    private var displayPanel= JPanel()
    private var buttonPanel = JPanel()
    private var contentPanel = JPanel()
    private var display = JTextField()

    private var insert = Insert()
    private var command = Command()

    private var result = 0.0
    private var start: Boolean = true
    private var lastCommand = "="
    init {
        contentPanel.border = EmptyBorder(10, 10, 10, 10)
        contentPanel.layout = BorderLayout()
        contentPane=contentPanel

        display.isEditable = true
        display.columns = 20
        displayPanel.add(display)
        contentPanel.add(display,BorderLayout.NORTH)

        buttonPanel.layout = GridLayout(4,4,5,5)
        contentPanel.add(buttonPanel,BorderLayout.CENTER)

        val buttonConfigs = listOf(
            "7" to insert, "8" to insert, "9" to insert, "/" to command,
            "4" to insert, "5" to insert, "6" to insert, "*" to command,
            "1" to insert, "2" to insert, "3" to insert, "-" to command,
            "0" to insert, "." to command, "=" to command, "+" to command
        )

        for ((text, listener) in buttonConfigs) {
            val button = JButton(text)
            button.addActionListener(listener)
            buttonPanel.add(button)
        }

        pack()
    }
    fun calculate(x: Double) {
        val operator = lastCommand.get(0)
        when (operator) {
            '+' -> result += x
            '-' -> result -= x
            '*' -> result *= x
            '/' -> result /= x
            '=' -> result = x
        }
        display.text = "" + result
    }
    inner class Insert: ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            val input = e!!.getActionCommand()
            val text = display.getText()
            if (start) {
                display.setText("")
                start = false
            }
            if (text.startsWith(".")) {
                display.setText("0" + display.getText() + input)
            } else if (text.startsWith("-0.") || text.startsWith("0.")) {
                display.setText(display.getText() + input)
            } else if (text.startsWith("-0")) {
                display.setText("-" + input)
            } else if (text.startsWith("0")) {
                display.setText(input)
            } else {
                display.setText(display.getText() + input)
            }
        }
    }
    inner class Command:ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            val command = e!!.getActionCommand()
            if (start) {
                if (command == "-") {
                    display.setText(command)
                    start = false
                } else {
                    lastCommand = command
                }
            } else {
                calculate(display.getText().toDouble())
                lastCommand = command
                start = true
            }
        }
    }
}
fun main() {
    System.setProperty("sun.java2d.opengl", "true")
    val calculator = Calculator()
    calculator.isVisible = true
}
