import java.util.ArrayList;

public class Course { //contains the students in a certain course
    private StudentList studentList;
    private String name;
    private int index;
    private ArrayList<Student> studentsInCourse;

    public Course(StudentList cStudentList, String sName, int sIndex){
        studentList = cStudentList;
        name = sName;
        index = sIndex;

        studentsInCourse = new ArrayList<>();

        for(int i = 0; i<studentList.getLength(); i++){ //goes through and grabs students from StudentList and enters them into course

            Student tempStudent = studentList.getStudent(i);
            if(tempStudent.getCourses()[index]){
                //if the student in the StudentList at i has a true value in its boolean array at the index of the course
                studentsInCourse.add(tempStudent);
            }
        }
    }

    @Override
    public String toString() {
        return name + " " + studentsInCourse.toString();
    }

    public int getNumStudents(){
        return studentsInCourse.size();
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public String[] getStudentNames(){
        String[] strArr = new String[studentsInCourse.size()];
        for(int i = 0; i< studentsInCourse.size(); i++){
            strArr[i] = studentsInCourse.get(i).getName();
        }
        return strArr;
    }

    public ArrayList<Student> getStudentsInCourse() {
        return studentsInCourse;
    }

    public String getName() {
        return name;
    }

    public void updateStudentData(){

    }
}
