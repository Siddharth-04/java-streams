package bridgelabz.streams;

import java.io.*;

class Student{
    String rollNo;
    String name;
    double gpa;

    Student(String rollNo, String name, double gpa) {
        this.rollNo = rollNo;
        this.name = name;
        this.gpa = gpa;
    }
}
public class StoreAndRetrievePrimitiveData {

    public static void readData(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while(dis.available()>0){
                String rollNO = dis.readUTF();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll Number:" + rollNO + "Name : " + name + ", GPA : " + gpa);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeData(String filePath,Student student) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))){
            dos.writeUTF(student.rollNo);
            dos.writeUTF(student.name);
            dos.writeDouble(student.gpa);
            System.out.println("Written Successfully");
        }
        catch(IOException e){
            e.getMessage();
        }
    }

    public static void main(String[] args) {
        String inputFile = "D:\\8th sem\\bridgelabz.workspace\\java-streams\\src\\main\\java\\bridgelabz\\streams\\studentData.txt";
        Student student = new Student("101", "Siddharth", 9.9);
        writeData(inputFile,student);
        readData(inputFile);
    }
}
//Written Successfully
//Roll Number:101Name : Siddharth, GPA : 9.9