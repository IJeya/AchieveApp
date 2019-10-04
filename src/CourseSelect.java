import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CourseSelect extends JFrame {
    private String[] courseNames;
    private StudentList theStudents;
    public CourseSelect(String courseDataFileName, StudentList studentList) throws IOException {
        theStudents = studentList;
        courseNames = DataGet.coursesGet(courseDataFileName);

        JPanel coursePanel = new JPanel();
        ActionListener aL = new buttonListener();
        coursePanel.setLayout(new GridLayout(courseNames.length,1));
        for(int i = 0; i<courseNames.length; i++){
            NumeralButton jButton = new NumeralButton(i);
            jButton.setText(courseNames[i]);
            jButton.addActionListener(aL);
            coursePanel.add(jButton);
        }
        this.add(coursePanel);
        this.setVisible(true);
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
}
