import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayContainer extends JFrame {
    private JPanel courseDisplay;
    private JButton next;
    private JButton previous;
    private JPanel bigPanel;
    private CourseData courseData;
    private int size;
    private int currStart;
    private int maxIndex;

    public DisplayContainer(CourseData theCourseData){
        this.setVisible(true);
        bigPanel = new JPanel();

        courseData = theCourseData;
        currStart = 0;



        if(theCourseData.getAchSize()<7){
            size = theCourseData.getAchSize();
        }else{
            size = 7;
        }
        maxIndex = theCourseData.getAchSize()-size;

        courseDisplay = new CourseDisplay(theCourseData,0,size,this);

        JPanel headPanel = new JPanel();
        headPanel.add(new JLabel("courseName"));
        JPanel buttonPanel = new JPanel();
        Dimension buttonSize = new Dimension(32,32);

        ImageIcon n = new ImageIcon("next.png");
        ImageIcon p = new ImageIcon("previous.png");

        buttonPanel.setLayout(new GridLayout(1,2));
        FieldListener fl = new FieldListener();
        next = new JButton(n);
        previous = new JButton(p);
        next.addActionListener(fl);
        previous.addActionListener(fl);
        buttonPanel.add(previous);
        buttonPanel.add(next);

        headPanel.add(buttonPanel);

        bigPanel.add(headPanel);
        bigPanel.add(courseDisplay);

        this.add(bigPanel);
        this.pack();
    }

    private class FieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(next)){
                next();
            }
            if(e.getSource().equals(previous)){

            }
        }
    }

    public void next(){
        //System.out.println("check");

        if(currStart+size<maxIndex) {

            currStart += size;

            bigPanel = new JPanel();

            courseDisplay = new CourseDisplay(courseData, currStart, currStart + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel("courseName"));
            JPanel buttonPanel = new JPanel();
            ImageIcon n = new ImageIcon("next.png");
            ImageIcon p = new ImageIcon("previous.png");
            buttonPanel.setLayout(new GridLayout(1, 2));
            FieldListener fl = new FieldListener();
            buttonPanel.add(previous);
            buttonPanel.add(next);

            headPanel.add(buttonPanel);

            bigPanel.add(headPanel);
            bigPanel.add(courseDisplay);
            setContentPane(bigPanel);
            validate();
            this.pack();
        }else{

            currStart = maxIndex;

            bigPanel = new JPanel();

            courseDisplay = new CourseDisplay(courseData, currStart+1, maxIndex + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel("courseName"));
            JPanel buttonPanel = new JPanel();
            ImageIcon n = new ImageIcon("next.png");
            ImageIcon p = new ImageIcon("previous.png");
            buttonPanel.setLayout(new GridLayout(1, 2));
            FieldListener fl = new FieldListener();
            buttonPanel.add(previous);
            buttonPanel.add(next);

            headPanel.add(buttonPanel);

            bigPanel.add(headPanel);
            bigPanel.add(courseDisplay);
            setContentPane(bigPanel);
            validate();
            this.pack();
        }



    }
}
