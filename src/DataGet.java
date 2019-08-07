import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataGet {
    public static String[] achievesGet() throws IOException {
        File achieveFile = new File("C:\\Users\\jayiy\\Programming\\Projects\\AchieveApp\\achievementDataTest.txt");
        Scanner sc = new Scanner(achieveFile);
        ArrayList<String> tempList = new ArrayList<>();
        while(sc.hasNextLine()){
            tempList.add(sc.next() + " pts: " + sc.next());
            if(sc.hasNextLine()){
                sc.nextLine();
            }
        }
        String[] strArr = new String[tempList.size()];
        for(int i = 0 ; i< tempList.size(); i++){
            strArr[i] = tempList.get(i);
        }
        return strArr;
    }
}
