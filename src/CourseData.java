import java.io.IOException;
import java.util.ArrayList;

public class CourseData {
    private String courseName;
    private String[] names;
    private String[] achieves;
    private int[][] achieveQuantities;
    private int achSize;

    CourseData(int placeholder){
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
        this.courseName = courseName;
        this.names = names;
        this.achieves = achieves;
        this.achieveQuantities = achieveQuantities;
    }

    public CourseData(Course course) throws IOException {
        courseName = course.getName();
        names = course.getStudentNames();
        achieves = DataGet.achievesGet();

        ArrayList<Student> slist = course.getStudentsInCourse();

        int[][] achQs = new int[names.length][achieves.length];

        for(int i = 0; i < names.length; i++){
            for(int j=0; j<achieves.length; j++){
                achQs[i][j] = slist.get(i).getAchievements()[j].getQuantity();
            }
        }

        achieveQuantities = achQs;
        achSize = achieves.length;

    }

    public int[][] getAchieveQuantities() {
        return achieveQuantities;
    }

    public String getCourseName() {
        return courseName;
    }

    public String[] getAchieves() {
        return achieves;
    }

    public String[] getNames() {
        return names;
    }

    public int getAchSize() {
        return achSize;
    }
}
