//Jeya Iyadurai 2019

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IncDecPanel extends JPanel {
    private int value;
    private JTextField jTextField;
    private JButton plus;
    private JButton minus;
    private CourseDisplay courseDisplay;
    private int student;
    private int achieve;


    public IncDecPanel(int i, CourseDisplay courseDisplay, int s, int a){
        value = i;
        student =s;
        achieve = a;

        this.courseDisplay = courseDisplay;
        this.setLayout(new GridLayout(1,2));
        this.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2));

        FieldListener fl = new FieldListener();

        ImageIcon p = new ImageIcon("plus.png");
        ImageIcon m = new ImageIcon("minus.png");
        jTextField = new JTextField(String.valueOf(value));


        plus = new JButton(p);
        minus = new JButton(m);
        //JButton plus = new JButton("+");
        //JButton minus = new JButton("-");

        Dimension labelSize = new Dimension(16,16);
        Dimension buttonSize = new Dimension(16,16);

        jTextField.setPreferredSize(labelSize);
        plus.setPreferredSize(buttonSize);
        minus.setPreferredSize(buttonSize);

        jTextField.addActionListener(fl);
        plus.addActionListener(fl);
        minus.addActionListener(fl);

        buttonPanel.add(plus);
        buttonPanel.add(minus);
        this.add(buttonPanel);
        this.add(jTextField);

    }
    private class FieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(plus)){
                value++;
                jTextField.setText(String.valueOf(value));
                courseDisplay.updateQuantity(student,achieve,value);
            }
            if(e.getSource().equals(minus)){
                if(value==0){
                    return;
                }
                value--;
                jTextField.setText(String.valueOf(value));
                courseDisplay.updateQuantity(student,achieve,value);
            }
            if(e.getSource().equals(jTextField)){
                try{
                    value = Integer.valueOf(jTextField.getText());
                    courseDisplay.updateQuantity(student,achieve,value);
                }catch (Exception e2){
                    jTextField.setText(String.valueOf(value));
                }
            }
        }
    }

    public int getValue() {
        return value;
    }
}

