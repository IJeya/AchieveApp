//Jeya Iyadurai 2019

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IncDecPanel extends JPanel {
    private int value;
    private JLabel jLabel;
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
        jLabel = new JLabel(String.valueOf(value));


        plus = new JButton(p);
        minus = new JButton(m);
        //JButton plus = new JButton("+");
        //JButton minus = new JButton("-");

        Dimension labelSize = new Dimension(16,16);
        Dimension buttonSize = new Dimension(16,16);

        jLabel.setPreferredSize(labelSize);
        plus.setPreferredSize(buttonSize);
        minus.setPreferredSize(buttonSize);

        plus.addActionListener(fl);
        minus.addActionListener(fl);

        buttonPanel.add(plus);
        buttonPanel.add(minus);
        this.add(buttonPanel);
        this.add(jLabel);

    }
    private class FieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(plus)){
                value++;
                jLabel.setText(String.valueOf(value));
                courseDisplay.updateQuantity(student,achieve,value);
            }
            if(e.getSource().equals(minus)){
                if(value==0){
                    return;
                }
                value--;
                jLabel.setText(String.valueOf(value));
                courseDisplay.updateQuantity(student,achieve,value);
            }
        }
    }

    public int getValue() {
        return value;
    }
}

