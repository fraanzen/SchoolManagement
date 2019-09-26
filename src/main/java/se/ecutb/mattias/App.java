package se.ecutb.mattias;
import se.ecutb.mattias.model.Student;
import se.ecutb.mattias.model.Course;
import se.ecutb.mattias.data.CourseDaoList;
import se.ecutb.mattias.data.StudentDaoList;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static StudentDaoList StudentList = new StudentDaoList();
    public static CourseDaoList CourseList = new CourseDaoList();
    public static Student studJohan = new Student("Johan", "johansmail", "adress1");
    public static Student studJohn = new Student("John", "johnsmail", "adress2");
    public static Student studJonas = new Student("Jonas", "jonasmail", "adress3");
    public static Student studJonathan = new Student("Jonathan", "jonathansmail", "adress4");
    public static Student studJesper = new Student("Jesper", "jespersmail", "adress5");
    public static Student studErik = new Student("Erik", "eriksmail", "adress6");
    public static Course matte = new Course("Matte", LocalDate.parse("2019-01-01"), 10);
    public static Course svenska = new Course("Svenska", LocalDate.parse("2019-01-01"), 10);
    public static Course engelska = new Course("Engelska", LocalDate.parse("2019-01-01"), 10);

    public static void main( String[] args ) {
        StudentList.saveStudent(studErik);
        StudentList.saveStudent(studJohan);
        StudentList.saveStudent(studJohn);
        StudentList.saveStudent(studJonas);
        StudentList.saveStudent(studJonathan);
        StudentList.saveStudent(studJesper);
        CourseList.saveCourse(matte);
        CourseList.saveCourse(svenska);
        CourseList.saveCourse(engelska);


        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to School Management.");
        while (true){
            System.out.println("Press 1 to create new Course or Student. " +
                    "Press 2 to register and remove Student to/from Courses. "+
                    "\nPress 3 to find Student or Courses. "+
                    "Press 4 to edit Student and Courses. "+
                    "\nPress Q to exit.");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Q")){
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
                   System.out.println("Choose a Course. Write the name of the Course. ");
                        String kursnamn = sc.nextLine();
                   System.out.println(CourseList.findByName(kursnamn));
               // Course registerCourse = (Course) CourseList.findByName(kursnamn);
                //   System.out.println(registerCourse.getCourseName());
                   System.out.println("Choose a Student. Write the name of the Student to register. ");
                        String studentnamn = sc.nextLine();
                   System.out.println(StudentList.findByName(studentnamn));


                  //Student registerStudent = (Student) StudentList.findByName(studentnamn);
                  //registerCourse.register(registerStudent);
                  // System.out.println(registerCourse.getStudents());
               } else if (choice.equalsIgnoreCase("2")){
                   System.out.println("Choose a Course. Write the name of the Course. ");
                        String kursnamn = sc.nextLine();
                   System.out.println(CourseList.findByName(kursnamn));

                   System.out.println("Choose a Student. Write the name of the Student to unregister. ");
                         String Studentnamn = sc.nextLine();
                   System.out.println(StudentList.findByName(Studentnamn));

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

    public Course returnCourse(String name, String time, int length){
        List<Course> kursnamn = CourseList.findByName(name);
        Course tempcourse = new Course(name, LocalDate.parse(time), length);
        return tempcourse;
    }


    /*
 Finally create a command line User Interface where you need to create functionality to:
• Create new Courses and Students
• Register and remove Students to/from Courses
• Finding Students and Courses in various ways
• Edit Students and Courses
     */
}
