import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TestingRunner {
    public static void main(String[] args) throws IOException {
        StudentList testSL = new StudentList("C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\studentDataTest.txt","C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\achievementDataTest.txt", 1);
        Course course = new Course(testSL, "bruh", 0);
        System.out.println(course.getStudentsInCourse());
        DisplayContainer d = new DisplayContainer(new CourseData(course));

    }


}


