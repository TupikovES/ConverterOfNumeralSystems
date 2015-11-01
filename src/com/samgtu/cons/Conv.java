package com.samgtu.cons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.samgtu.cons.util.ConvertMethod.*;

/**
 * Created by x3mib_000 on 30.10.2015.
 */
public class Conv extends JFrame{
    private JPanel rootPanel;
    private JTextField inData;
    private JComboBox numeralIn;
    private JButton convert;
    private JTextArea outData;
    private JComboBox numeralOut;
    private JButton exit;
    private JLabel textIn;
    private JLabel textOut;
    private JLabel errMess;

    private ActionListener exitAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    };

    private KeyListener re = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int num = (int)inData.getText().toCharArray()[inData.getText().length() - 1];
            int max = 0;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 70)) {
                for (int i = 0; i < inData.getText().length(); i++) {
                    int next = 0;
                    if (num < 58)
                        next = (int)inData.getText().toCharArray()[i] - 48;
                    else
                        next = (int)inData.getText().toCharArray()[i] - 55;
                    if (max < next)
                        max = next;
                }

                numeralIn.removeAllItems();
                for (int i = max + 1; i <= 16; i++) {
                    numeralIn.addItem(i);
                }
                errMess.setText("");
            } else {
                numeralIn.removeAllItems();
                errMess.setText("Неверные данные");
            }
        }
    };
    private ActionListener rangeNumeral = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            int num = Integer.parseInt(inData.getText());
            Integer max = num % 10;
            for (int i = num; i > 0; i /= 10) {
                int next = i % 10;
                if (max < next)
                    max = next;
            }
            numeralIn.removeAllItems();
            for (int i = max + 1; i <= 10; i++) {
                numeralIn.addItem(i);
            }
            */

            String bufS = inData.getText();
            inData.setText(bufS.toUpperCase());

            //inData.setText(inData.getText().toUpperCase());
        }
    };

    private ActionListener convertNum = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*
            String t;
            int next = toDec(Integer.parseInt(inData.getText()), (int)numeralIn.getSelectedItem());
            t = "" + fromDec(next, (int)numeralOut.getSelectedItem());
            outData.setText(t);
            */

            outData.setText(fromDecNew(toDecNew(inData.getText(), (int)numeralIn.getSelectedItem()), (int)numeralOut.getSelectedItem()));
        }
    };

    public Conv() {
        exit.addActionListener(exitAction);
        inData.addActionListener(rangeNumeral);
        inData.addKeyListener(re);
        convert.addActionListener(convertNum);
        //inData.setText("0");
        for (int i = 2; i <= 16; i++) {
            numeralOut.addItem(i);
        }
        setContentPane(rootPanel);
        pack();
    }
}
