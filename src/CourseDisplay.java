import javax.swing.*;
import java.awt.*;

public class CourseDisplay extends JPanel {
    private CourseData courseData;

    public CourseDisplay(CourseData cData){
        courseData = cData;
    }

    public CourseDisplay(){
        String[] names = {"Student1","Student2","Student3","Student4","Student5"};
        String[] achieves = {"Achieve1","Achieve2","Achieve3","Achieve4","Achieve5","Achieve6","Achieve7","Achieve8","Achieve9"};
        int[][] achieveQuantities = {
                {1,2,3,4,5,6,7,8,9},
                {9,8,7,6,5,4,3,2,1},
                {3,7,4,1,2,9,8,6,5},
                {6,5,4,8,9,7,3,2,1},
                {9,4,3,6,5,1,8,7,2}
        };

        JPanel headPanel = new JPanel();
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(names.length + 1,8));

        gridPanel.add(new JLabel("Names"));
        for(int i = 0; i < 8; i++){
            gridPanel.add(new JLabel(achieves[i]));
        }

        for(int i = 0; i < names.length; i++){
            gridPanel.add(new JLabel(names[i]));
            for(int j = 0; i < 8; i++){
                gridPanel.add(new IncDecPanel(achieveQuantities[i][j]));
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        CourseDisplay cd = new CourseDisplay();
        frame.add(cd);
    }
}
