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


    public IncDecPanel(int i){
        value = i;

        this.setLayout(new GridLayout(1,2));
        this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));


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

        Dimension labelSize = new Dimension(32,32);
        Dimension buttonSize = new Dimension(32,32);

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
            }
            if(e.getSource().equals(minus)){
                value--;
                jLabel.setText(String.valueOf(value));
            }
        }
    }

    public int getValue() {
        return value;
    }
}

