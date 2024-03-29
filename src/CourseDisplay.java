import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseDisplay extends JPanel {
    private CourseData courseData;
    private JButton next;
    private JButton previous;
    private JPanel gridPanel;
    private DisplayContainer container;
    private JLabel[] jScoreLabels;

    public CourseDisplay(CourseData cData, int startA, int endA, DisplayContainer dc){
        courseData = cData;
        container=dc;



        String courseName = cData.getCourseName();
        String[] names = cData.getNames();
        String[] achieves = cData.getAchieves();
        int[][] achieveQuantities = cData.getAchieveQuantities();
        //this.setLayout(new BoxLayout(this, 1));

        JPanel headPanel = new JPanel();
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(names.length + 1,endA - startA+1,24,10));

        jScoreLabels = new JLabel[names.length];

        gridPanel.add(new JLabel("Names"));
        for(int i = startA; i < endA; i++){
            JLabel jLabel = new JLabel();
            jLabel.setMinimumSize(new Dimension(60,20));
            jLabel.setPreferredSize(new Dimension(60,20));
            jLabel.setMaximumSize(new Dimension(60,20));
            jLabel.setText(achieves[i]);
            jLabel.setFont(new Font(jLabel.getFont().getFontName(),Font.PLAIN,10));
            gridPanel.add(jLabel);
        }
        gridPanel.add(new JLabel( "Total Pts"));

        for(int i = 0; i < names.length; i++){
            gridPanel.add(new JLabel(names[i]));
            for(int j = startA; j < endA; j++){
                gridPanel.add(new IncDecPanel(achieveQuantities[i][j],this,i,j));
            }
            JLabel jScoreLabel = new JLabel(String.valueOf(courseData.getCourse().getStudentsInCourse().get(i).getPoints()));
            gridPanel.add(jScoreLabel);
            jScoreLabels[i] = jScoreLabel;
        }

        this.add(gridPanel);
    }


    public CourseDisplay(int startA, int endA, DisplayContainer dc){
        container=dc;
        String courseName = "Course1";
        String[] names = {"Student1","Student2","Student3","Student4","Student5"};
        String[] achieves = {"Achieve1","Achieve2","Achieve3","Achieve4","Achieve5","Achieve6","Achieve7","Achieve8","Achieve9"};
        int[][] achieveQuantities = {
                {1,2,3,4,5,6,7,8,9},
                {9,8,7,6,5,4,3,2,1},
                {3,7,4,1,2,9,8,6,5},
                {6,5,4,8,9,7,3,2,1},
                {9,4,3,6,5,1,8,7,2}
        };
        //this.setLayout(new BoxLayout(this, 1));

        JPanel headPanel = new JPanel();
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(names.length + 1,endA - startA+1));

        gridPanel.add(new JLabel("Names"));
        for(int i = startA; i < endA; i++){
            gridPanel.add(new JLabel(achieves[i]));
        }
        gridPanel.add(new JLabel( "Total Pts"));

        for(int i = 0; i < names.length; i++){
            gridPanel.add(new JLabel(names[i]));
            for(int j = startA; j < endA; j++){
                gridPanel.add(new IncDecPanel(achieveQuantities[i][j],this,i,j));
            }
            gridPanel.add(new JLabel("their score"));
        }
        /*
        headPanel.add(new JLabel(courseName));
        JPanel buttonPanel = new JPanel();
        Dimension buttonSize = new Dimension(32,32);

        ImageIcon n = new ImageIcon("next.png");
        ImageIcon p = new ImageIcon("previous.png");

        buttonPanel.setLayout(new GridLayout(1,2));
        next = new JButton(n);
        previous = new JButton(p);

        buttonPanel.add(previous);
        buttonPanel.add(next);

        headPanel.add(buttonPanel);

        this.add(headPanel);


        this.add(gridPanel);
        */

    }

    private class FieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(next)){
                gridPanel = new JPanel();
                gridPanel.add(new JLabel("test"));
            }
            if(e.getSource().equals(previous)){

            }
        }
    }

    public void updateQuantity(int i, int j, int value){
        if (value<0){
            return;
        }

        int[][] data = courseData.getAchieveQuantities();
        data[i][j] = value;
        Student student = courseData.getCourse().getStudentsInCourse().get(i);
        student.getAchievements()[j].setQuantity(value);
        student.calculateScore();
        jScoreLabels[i].setText(String.valueOf(student.getPoints()));
    }


}
