import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class CourseSelect extends JFrame {
    private String[] courseNames;
    private static StudentList theStudents;
    private static String currentCDFN;
    public CourseSelect(String courseDataFileName, StudentList studentList) throws IOException {
        JLabel headerLabel = new JLabel("Course Select: ");
        //headerLabel.setFont(new Font());
        currentCDFN = courseDataFileName;
        theStudents = studentList;
        courseNames = DataGet.coursesGet(courseDataFileName);
        this.setPreferredSize(new Dimension(420,600));
        JPanel coursePanel = new JPanel();
        //coursePanel.setPreferredSize(new Dimension(330,600));
        ActionListener aL = new buttonListener();
        coursePanel.setLayout(new BoxLayout(coursePanel,BoxLayout.PAGE_AXIS));
        coursePanel.add(headerLabel);
        for(int i = 0; i<courseNames.length; i++){
            NumeralButton jButton = new NumeralButton(i);
            jButton.setPreferredSize(new Dimension(330,100));
            jButton.setText(courseNames[i]);
            jButton.addActionListener(aL);
            coursePanel.add(jButton);
        }
        JButton QuitButton = new JButton("Quit");
        QuitButton.addActionListener(new QuitListener());
        coursePanel.add(QuitButton);
        coursePanel.add(Box.createRigidArea(new Dimension(110, 0)));
        JScrollPane jScrollPane = new JScrollPane(coursePanel);
        jScrollPane.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jScrollPane);
        this.setVisible(true);
        this.pack();
        this.setResizable(false);
    }

    private class buttonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            NumeralButton theButton = (NumeralButton)e.getSource();
            int i = theButton.getIndex();
            try{
                createDisplay(i);
            }catch(IOException io){

            }

        }
    }

    private class QuitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    private class NumeralButton extends JButton{
        private int index;
        private NumeralButton(int i){
            super();
            index = i;
        }

        public int getIndex() {
            return index;
        }
    }

    public void createDisplay(int i) throws IOException{
        CourseData courseData = new CourseData(new Course(theStudents, courseNames[i], i));
        DisplayContainer displayContainer = new DisplayContainer(courseData);
        this.setVisible(false);
    }

    public static String CurrentCDFN() {
        return currentCDFN;
    }

    public static StudentList CurrentSL(){
        return theStudents;
    }
}
