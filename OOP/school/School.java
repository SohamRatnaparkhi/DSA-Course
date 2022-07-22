package OOP.school;

public class School {
    public static void main(String[] args) {

        Student student1  = new Student();
        // ? Dynamic memory allocation
        //! Left hand side = Compile time = Defination
        //! Right hand side = Run time = Initialized  

        student1.setName("Soham Ratnaparkhi");
        student1.setAge(17);
        student1.rollno = 36;

        System.out.println(student1);

        System.out.println("Name: " + student1.getName());
        System.out.println("Age: "+student1.getAge());
        System.out.println("Rollno.: "+student1.rollno);
    }
}
