public class Student {

    private int points; //total points the student has
    private Achievement[] achievements; //an array containing the achievements the student has earned
    private String name; //name of student
    private boolean[] courses; //true/false array detailing the courses the student takes

    public Student(String sName, Achievement[] sAchievements, boolean[] sCourses){
        achievements = sAchievements;
        for(int i = 0; i<achievements.length; i++){ //goes through achievement array
            points += achievements[i].getValue() * achievements[i].getQuantity(); //gives points based on that achieve's value
        }
        name = sName;
        courses = sCourses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + " Points: " + points + " Courses: ");
        for(int i = 0; i< courses.length; i++){
            sb.append(courses[i] + " ");
        }
        return sb.toString();
    }

    public boolean[] getCourses() {
        return courses;
    }

    public String getName(){
        return name;
    }

    public Achievement[] getAchievements() {
        return achievements;
    }

    public void calculateScore(){
        points = 0;
        for(int i = 0; i<achievements.length; i++){ //goes through achievement array
            points += achievements[i].getValue() * achievements[i].getQuantity(); //gives points based on that achieve's value
        }
    }

    public int getPoints() {
        return points;
    }

    public String forTextFile(){
        StringBuilder sb = new StringBuilder();

        sb.append(name + " ");
        for (int i = 0; i < achievements.length; i++){
            sb.append(achievements[i].getQuantity() + " ");
        }
        sb.append("e ");

        for (int i = 0; i<courses.length;i++){
            if(i!=courses.length-1){
                if(courses[i]){
                    sb.append(1 + " ");
                }else{
                    sb.append(0 + " ");
                }
            }else{
                if(courses[i]){
                    sb.append(1);
                }else{
                    sb.append(0);
                }
            }
        }

        return sb.toString();
    }
}
