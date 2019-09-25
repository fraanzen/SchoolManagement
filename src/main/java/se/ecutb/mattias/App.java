package se.ecutb.mattias;

import se.ecutb.mattias.model.Student;
import se.ecutb.mattias.model.Course;
import se.ecutb.mattias.data.CourseDaoList;
import se.ecutb.mattias.data.StudentDaoList;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class App{
    public static void main( String[] args )
    {
        StudentDaoList StudentList = new StudentDaoList();
        CourseDaoList CourseList = new CourseDaoList();
        Course KursMall = new Course("CourseName", LocalDate.parse("2019-01-01"), 100);
        Student StudentMall = new Student("StudentName", "Email", "address");
        boolean exit = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to School Management.");
        while (exit){
            System.out.println("Press 1 to create new Course or Student. " +
                    "Press 2 to register and remove Student to/from Courses. "+
                    "Press 3 to find Student or Courses. "+
                    "Press 4 to edit Student and Courses. "+
                    "Press Q to exit.");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Q")){
                exit = false;
                break;
            } else if (input.equalsIgnoreCase("1")){
                System.out.println("Do you want to add a Student or a Course? S for Student and C for Course.");
                String choice = sc.next();
                if (choice.equalsIgnoreCase("S")){
                    System.out.println("Creating a new Student. Write a name. ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Write an email.");
                    String email = sc.nextLine();
                    System.out.println("Write an adress");
                    String adress = sc.nextLine();
                    Student nyStudent = new Student(name, email, adress);
                    StudentList.saveStudent(nyStudent);
                    System.out.println("You created: "+nyStudent.toString());
                } else if (choice.equalsIgnoreCase("C")){
                    System.out.println("Creating a Course. Write a name.");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Write the starting date.");
                    String time = sc.nextLine();
                    LocalDate tid = LocalDate.parse(time);
                    System.out.println("Write the length of the course.");
                    String length = sc.nextLine();
                    int längd = Integer.parseInt(length);
                    Course nyCourse = new Course(name, tid, längd);
                    CourseList.saveCourse(nyCourse);
                    System.out.println("You created: "+nyCourse);
                }
            } else if (input.equalsIgnoreCase("2")){
                System.out.println("Do you want to register or remove Students to/from a Course? Press 1 to register and 2 to remove.");
                String choice =  sc.nextLine();
                if (choice.equalsIgnoreCase("1")){
                    //register
                } else if (choice.equalsIgnoreCase("2")){
                    //unregister
                }
            } else if(input.equalsIgnoreCase("3")){
                //Find student or course
                System.out.println("Find student or course? S for Student and C for Course.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("S")){
                    System.out.println("Finding Student. Write the name of the Student.");
                    String Studentnamn = sc.nextLine();
                    System.out.println(StudentList.findByName(Studentnamn));
                } else if (choice.equalsIgnoreCase("C")){
                    System.out.println("Finding Course. Write the name of the course.");
                    String kursnamn = sc.nextLine();
                    System.out.println(CourseList.findByName(kursnamn));
                }

            } else if(input.equalsIgnoreCase("4")){
                System.out.println("Do you want to edit a Student or a Course? S for Student and C for Course.");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("S")){
                    //edit student
                } else if (choice.equalsIgnoreCase("C")){
                    //edit course
                }
            }else{
                System.out.println("Wrong input. Returning to main menu.");
            }
        }

    }

    /*
 Finally create a command line User Interface where you need to create functionality to:
• Create new Courses and Students
• Register and remove Students to/from Courses
• Finding Students and Courses in various ways
• Edit Students and Courses
     */
}



