import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DataSetUp {
    //this is a temporary(?) non-graphical way to input data to generate initial text files

    private int numCourses;
    private String[] courseNames;
    private String[] achieveNames;

    public DataSetUp() throws IOException {
        Scanner sc = new Scanner(System.in);



        File achieveFile = new File("C:\\Users\\jayiy\\Programming\\Projects\\AchievementManagingApp\\achievementDataTest.txt");
        PrintWriter achieveWriter = new PrintWriter(achieveFile);

        if(achieveFile.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already created");
        }

        System.out.print("How many achievements total (all courses)? ");
        int numAchieves = sc.nextInt();
        sc.nextLine();
        achieveNames = new String[numAchieves];

        for(int i = 0; i <numAchieves; i++){
            System.out.print("Name of achievement #" + (i+1) + "? ");
            String achieveName = sc.nextLine();
            System.out.print(achieveName + " point value? ");
            String achieveValue = sc.nextLine();

            if(i!=numAchieves-1){
                achieveWriter.println(achieveName + " " + achieveValue);
            }else{
                achieveWriter.print(achieveName + " " + achieveValue);
            }

            achieveNames[i] = achieveName + ": " + achieveValue;
        }

        achieveWriter.close();

        File studentFile = new File("C:\\Users\\jayiy\\Programming\\Projects\\AchievementManagingApp\\studentDataTest.txt");
        PrintWriter studentWriter = new PrintWriter(studentFile);

        if(studentFile.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already created");
        }

        File courseFile = new File("C:\\Users\\jayiy\\Programming\\Projects\\AchievementManagingApp\\courseDataTest.txt");
        PrintWriter courseWriter = new PrintWriter(courseFile);

        if(courseFile.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already created");
        }

        System.out.print("How many courses? ");
        numCourses = sc.nextInt();
        sc.nextLine();

        courseNames = new String[numCourses];

        for(int i = 0; i <numCourses; i++){
            System.out.print("Name of course #" + (i+1) + "? ");
            String courseName = sc.nextLine();
            courseNames[i] = courseName;

            if(i!=numCourses-1){
                courseWriter.println(courseName);
            }else{
                courseWriter.print(courseName);
            }
        }
        courseWriter.close();

        System.out.print("\nHow many students? ");
        int numStudents = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < numStudents; i++){
            System.out.print("Name of student? ");
            String studentName = sc.nextLine();

            int[] courses = new int[numCourses];
            for(int j = 0; j<numCourses; j++){
                System.out.print("\tIs " + studentName + " in class " + courseNames[j] + "? (y/n) ");
                String choice = sc.nextLine();
                if(choice.equals("y")){
                    courses[j] = 1;
                }else{
                    courses[j] = 0;
                }
            }

            StringBuilder entry = new StringBuilder();
            entry.append(studentName + " ");
            for(int k = 0; k< numAchieves; k++){
                entry.append("0 ");
            }
            entry.append("e ");
            for(int k = 0; k< courses.length-1; k++){
                entry.append(courses[k]+ " ");
            }
            entry.append(courses[courses.length-1]);
            if(i!=numStudents-1){
                studentWriter.println(entry.toString());
            }else{
                studentWriter.print(entry.toString());
            }
        }
        studentWriter.close();
    }

    public int getNumCourses() {
        return numCourses;
    }

    public String[] getCourseNames() {
        return courseNames;
    }

    public String[] getAchieveNames(){
        return achieveNames;
    }
}
