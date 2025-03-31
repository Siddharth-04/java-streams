package bridgelabz.streams;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    int salary;

    Employee(int id,String name,String department,int salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}
public class Serialization {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1,"Siddharth"," Software Engineering",100000));
        employees.add(new Employee(1,"Ishaan"," Software Engineering",100000));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerealizeExamplle.txt"))){
            for(Employee e:employees){
                oos.writeObject(e);
            }

            System.out.println("Serialized Employees");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//Serialized Employees
