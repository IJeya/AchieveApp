import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TestingRunner {
    public static void main(String[] args) throws IOException {
        StudentList testSL = new StudentList("C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\studentDataTest.txt","C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\achievementDataTest.txt", DataGet.coursesGet("C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\courseDataTest.txt").length);
        //Course course = new Course(testSL, "Class", 0);
        //System.out.println(course.getStudentsInCourse());
        //DisplayContainer d = new DisplayContainer(new CourseData(course));
        CourseSelect courseSelect = new CourseSelect("C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\courseDataTest.txt", testSL);
    }
}


