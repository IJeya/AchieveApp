import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    private ArrayList<Student> studentArrayList;
    private int numCourses;
    private int numAchives;

    public StudentList(String fileName, String achieveFileName, int sNumCourses) throws IOException {
        File file = new File(fileName);
        File achieveData = new File(achieveFileName); //can change later

        studentArrayList = new ArrayList<>();



        Scanner scannerS = new Scanner(file);

        numCourses = sNumCourses;

        while(scannerS.hasNextLine()){
            ArrayList<Integer> valList = new ArrayList<>();

            boolean[] courses = new boolean[numCourses];

            String name = scannerS.next();

            while(scannerS.hasNext()){
                String z = scannerS.next();
                if(z.equals("e")){

                    for(int k = 0; k<courses.length; k++){
                        String tempString = scannerS.next();
                        if(tempString.equals("1")){
                            courses[k] = true;
                        }else{
                            courses[k] = false;
                        }
                    }

                    break;
                }else{
                    valList.add(Integer.parseInt(z));
                }
            }

            int[] tempArray = new int[valList.size()];
            for(int i = 0; i<tempArray.length; i++){
                tempArray[i] = valList.get(i);
            }

            numAchives = tempArray.length;
            Achievement[] achievementArr = new Achievement[tempArray.length];
            Scanner scannerA = new Scanner(achieveData);
            for(int j = 0; j < tempArray.length; j++){
                String aName = scannerA.next();
                int value = Integer.parseInt(scannerA.next());
                int quantity = tempArray[j];
                int index = j;
                achievementArr[j] = new Achievement(aName, value, quantity, index);
                if(scannerA.hasNext()){
                    scannerA.nextLine();
                }

                /*
                System.out.println(achievementArr[j]);
                System.out.println("\n" + j);
                for(int i = 0; i< tempArray.length; i++){
                    System.out.print( tempArray[i]);
                }
                System.out.println("\n");
                */

            }
            scannerA.close();
            /*
            System.out.println("check");
            */

            studentArrayList.add(new Student(name, achievementArr, courses));

            /*
            System.out.println(studentArrayList);
            System.out.println("check2");
            System.out.println(scannerS.hasNextLine());
            */

        }

        scannerS.close();

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<studentArrayList.size(); i++){
            sb.append(studentArrayList.get(i).toString() + "\n");
        }
        return sb.toString();
    }

    public int getLength(){
        return studentArrayList.size();
    }

    public Student getStudent(int index){
        return studentArrayList.get(index);
    }

    public int getNumAchives(){
        return numAchives;
    }

    public void saveToFile() throws IOException{
        File file = new File("C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\studentDataTest.txt");
        file.delete();
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(file);
        for(int i = 0; i<studentArrayList.size()-1; i++){
            printWriter.println(studentArrayList.get(i).forTextFile());
        }
        printWriter.print(studentArrayList.get(studentArrayList.size()-1).forTextFile());
        printWriter.close();
    }
}
