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



        if(theCourseData.getAchSize()<6){
            size = theCourseData.getAchSize();
        }else{
            size = 6;
        }
        maxIndex = theCourseData.getAchSize()-1;

        courseDisplay = new CourseDisplay(theCourseData,0,size,this);

        JPanel headPanel = new JPanel();
        headPanel.add(new JLabel(theCourseData.getCourseName()));
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
        //buttonPanel.add(previous);
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
                previous();
            }
        }
    }

    public void next(){

        if(!(currStart+2*size > maxIndex)) {

            currStart += size;

            bigPanel = new JPanel();

            courseDisplay = new CourseDisplay(courseData, currStart, currStart + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            buttonPanel.add(previous);
            buttonPanel.add(next);

            headPanel.add(buttonPanel);

            bigPanel.add(headPanel);
            bigPanel.add(courseDisplay);
            setContentPane(bigPanel);
            validate();
            this.pack();
            System.out.println(currStart);
        }else{

            currStart+=size;

            bigPanel = new JPanel();

            courseDisplay = new CourseDisplay(courseData, currStart, maxIndex+1, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            buttonPanel.add(previous);
            //buttonPanel.add(next);

            headPanel.add(buttonPanel);

            bigPanel.add(headPanel);
            bigPanel.add(courseDisplay);
            setContentPane(bigPanel);
            validate();
            this.pack();
        }



    }

    public void previous(){
        if(currStart-size>0) {
            currStart-=size;
            bigPanel = new JPanel();

            courseDisplay = new CourseDisplay(courseData, currStart, currStart + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            buttonPanel.add(previous);
            buttonPanel.add(next);

            headPanel.add(buttonPanel);

            bigPanel.add(headPanel);
            bigPanel.add(courseDisplay);
            setContentPane(bigPanel);
            validate();
            this.pack();
        }else{
            currStart = 0;
            bigPanel = new JPanel();

            courseDisplay = new CourseDisplay(courseData, currStart, currStart + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            //buttonPanel.add(previous);
            buttonPanel.add(next);

            headPanel.add(buttonPanel);

            bigPanel.add(headPanel);
            bigPanel.add(courseDisplay);
            setContentPane(bigPanel);
            validate();
            this.pack();
        }
    } // wait this all works im actually L9


}
