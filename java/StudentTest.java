import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        int instruction,insnum;
        StudentList studentList = new StudentList();
        studentList.SETStudentList(1300);
        insnum=cin.nextInt();
        String number,name;
        Student student;
        int maths,English,science;
        for(int i=0;i<insnum;i++){
            instruction = cin.nextInt();
            switch (instruction){
                case 1:
                    number = cin.next();
                    name = cin.next();
                    maths = cin.nextInt();
                    English = cin.nextInt();
                    science = cin.nextInt();
                    student = new Student();
                    student.SETStudent(number, name);
                    student.enterMarks(maths, English, science);
                    if(studentList.add(student)) {
                        System.out.println("Add success");
                    }else{
                        System.out.println("Students already exist");
                    }
                    break;
                case 2:
                    number = cin.next();
                    if(studentList.remove(number)){
                        System.out.println("Delete success");
                    }else{
                        System.out.println("Students do not exist");
                    }
                    break;
                case 3:
                    number = cin.next();
                    maths = cin.nextInt();
                    English = cin.nextInt();
                    science = cin.nextInt();
                    if(studentList.updateItem(number, maths, English, science)){
                        System.out.println("Update success");
                    }else{
                        System.out.println("Students do not exist");
                    }
                    break;
                case 4:
                    number = cin.next();
                    student=studentList.getItem(number);
                        if(student!=null){
                            System.out.println("Student ID:" +student.getNumber()+"\n"+
                                                            "Name:" + student.getName()+"\n"+
                                                            String.format("Average Score:%.1f", student.calculateAverage()));
                        }else{
                            System.out.println("Students do not exist");
                        }
                    break;
                case 5:
                    if(studentList.isEmpty()){
                        System.out.println("List is empty");
                    }else{
                        System.out.println("List is not empty");
                    }
                    break;
                case 6:
                    System.out.println(studentList.getTotal());
                    break;
                default:
                    break;
            }
        }
        cin.close();
    }
}

class StudentList{
    private Student[] list;
    private int total;
    public void SETStudentList(int length){
        list=new Student[length];
        total=0;
    }
    public boolean add(Student stu){
        int i;
        for(i=0;i<list.length;i++){
            if(list[i]!=null&&list[i].getNumber().equals(stu.getNumber())){
                return false;
            }
        }
        for(i=0;i<list.length;i++){
            if(list[i]==null){
                list[i]=stu;
                total++;
                return true;
            }
        }
        return false;
    }
    public boolean remove(String number){
        for(int i=0;i<list.length;i++){
            if(list[i]!=null&&list[i].getNumber().equals(number)){
                list[i]=null;
                total--;
                return true;
            }
        }
        return false;
    }
    public boolean updateItem(String number, int math, int English, int science){
        for(int i=0;i<list.length;i++){
            if(list[i]!=null&&list[i].getNumber().equals(number)){
                list[i].enterMarks(math, English, science);
                return true;
            }
        }
        return false;
    }
    public boolean isEmpty(){
        if(total==0){
            return true;
        }else{
            return false;
        }
    }
    int getTotal(){
        return total;
    }
    Student getItem(String number){
        for(int i=0;i<list.length;i++){
            if(list[i]!=null&&list[i].getNumber().equals(number)){
                return list[i];
            }
        }
        return null;
    }
}
class Student{
    private String studentNumber;
    private String studentName;
    private int markForMaths;
    private int markForEnglish;
    private int markForScience;
    
    public void SETStudent(String number, String name){
        studentNumber=number;
        studentName=name;
        markForMaths=-1;
        markForEnglish=-1;
        markForScience=-1;
    }
    public String getNumber(){
        return studentNumber;
    }
    public String getName(){
        return studentName;
    }
    public void enterMarks(int markForMaths, int markForEnglish, int markForScience){
        this.markForMaths=markForMaths;
        this.markForEnglish=markForEnglish;
        this.markForScience=markForScience;
    }
    public int getMathsMark(){
        return markForMaths;
    }
    public int getEnglishMark(){
        return markForEnglish;
    }
    public int getScienceMark(){
        return markForScience;
    }
    public double calculateAverage(){
        return (markForMaths+markForEnglish+markForScience)/3.0;
    }
    public String toString(){
        return ("Student ID:"+studentNumber+"\n"+"Name:"+studentName+"\n"+"Math:"+markForMaths+"\n"+"English:"+markForEnglish+"\n"+"Science:"+markForScience+"\n"+"Average Score:"+String.format("%.1f", calculateAverage()));
    }
}