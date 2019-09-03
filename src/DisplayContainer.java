import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class DisplayContainer extends JFrame {
    private JPanel courseDisplay;
    private JButton next;
    private JButton previous;
    private JPanel bigPanel;
    private CourseData courseData;
    private int size;
    private int currStart;
    private int maxIndex;
    private JButton quit;
    private int width, height;

    public DisplayContainer(CourseData theCourseData){
        this.setVisible(true);
        width = 1200;
        height = 700;
        this.setSize(width,height);
        bigPanel = new JPanel();
        bigPanel.setLayout(new BorderLayout());
        quit = new JButton("Quit");
        courseData = theCourseData;
        currStart = 0;
        boolean small = false;

        int whatSize = 6;

        if(theCourseData.getAchSize()<whatSize){
            size = theCourseData.getAchSize();
        }else{
            size = whatSize;
            small =true;
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
        quit.addActionListener(fl);
        //buttonPanel.add(previous);

        if(small){
            buttonPanel.add(next);
        }

        headPanel.add(quit);
        headPanel.add(buttonPanel);

        JScrollPane jScrollPane = new JScrollPane(courseDisplay);
        jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);



        headPanel.setSize(new Dimension(600,400));

        bigPanel.add(headPanel,BorderLayout.PAGE_START);
        bigPanel.add(jScrollPane,BorderLayout.CENTER);
        //bigPanel.setSize(new Dimension(1200,500));
        this.add(bigPanel);
        //this.pack();
        this.setVisible(true);
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
            if(e.getSource().equals(quit)){
                try{
                    quit();
                    System.out.println("in try");
                }catch (Exception ok){
                    System.out.println("ok");
                }
            }
        }
    }

    public void next(){

        if(!(currStart+2*size > maxIndex)) {
            this.setSize(width,height);
            currStart += size;

            bigPanel = new JPanel();bigPanel.setLayout(new BorderLayout());

            courseDisplay = new CourseDisplay(courseData, currStart, currStart + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            buttonPanel.add(previous);
            buttonPanel.add(next);
            headPanel.add(quit);
            headPanel.add(buttonPanel);

            JScrollPane jScrollPane = new JScrollPane(courseDisplay);
            jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);



            headPanel.setSize(new Dimension(600,400));

            bigPanel.add(headPanel,BorderLayout.PAGE_START);
            bigPanel.add(jScrollPane,BorderLayout.CENTER);
            setContentPane(bigPanel);
            validate();
            //this.pack();
            System.out.println(currStart);
        }else{
            this.setSize(width,height);
            currStart+=size;

            bigPanel = new JPanel();bigPanel.setLayout(new BorderLayout());

            courseDisplay = new CourseDisplay(courseData, currStart, maxIndex+1, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            buttonPanel.add(previous);
            //buttonPanel.add(next);
            headPanel.add(quit);
            headPanel.add(buttonPanel);

            JScrollPane jScrollPane = new JScrollPane(courseDisplay);
            jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);



            headPanel.setSize(new Dimension(600,400));

            bigPanel.add(headPanel,BorderLayout.PAGE_START);
            bigPanel.add(jScrollPane,BorderLayout.CENTER);
            setContentPane(bigPanel);
            validate();
            //this.pack();
        }



    }

    public void previous(){
        if(currStart-size>0) {
            this.setSize(width,height);
            currStart-=size;
            bigPanel = new JPanel();bigPanel.setLayout(new BorderLayout());

            courseDisplay = new CourseDisplay(courseData, currStart, currStart + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            buttonPanel.add(previous);
            buttonPanel.add(next);
            headPanel.add(quit);
            headPanel.add(buttonPanel);

            JScrollPane jScrollPane = new JScrollPane(courseDisplay);
            jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);



            headPanel.setSize(new Dimension(600,400));

            bigPanel.add(headPanel,BorderLayout.PAGE_START);
            bigPanel.add(jScrollPane,BorderLayout.CENTER);
            setContentPane(bigPanel);
            validate();
            //this.pack();
        }else{
            this.setSize(width,height);
            currStart = 0;
            bigPanel = new JPanel();bigPanel.setLayout(new BorderLayout());

            courseDisplay = new CourseDisplay(courseData, currStart, currStart + size, this);

            JPanel headPanel = new JPanel();
            headPanel.add(new JLabel(courseData.getCourseName()));
            JPanel buttonPanel = new JPanel();

            buttonPanel.setLayout(new GridLayout(1, 2));

            //buttonPanel.add(previous);
            buttonPanel.add(next);
            headPanel.add(quit);
            headPanel.add(buttonPanel);

            JScrollPane jScrollPane = new JScrollPane(courseDisplay);
            jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);



            headPanel.setSize(new Dimension(600,400));

            bigPanel.add(headPanel,BorderLayout.PAGE_START);
            bigPanel.add(jScrollPane,BorderLayout.CENTER);
            setContentPane(bigPanel);
            validate();
            //this.pack();
        }
    } // wait this all works im actually L9

    public void quit() throws IOException {
        courseData.getCourse().getStudentList().saveToFile();
        System.exit(0);
    }

}
