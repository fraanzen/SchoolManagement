package se.ecutb.mattias;
import se.ecutb.mattias.model.Student;
import se.ecutb.mattias.model.Course;
import se.ecutb.mattias.data.CourseDaoList;
import se.ecutb.mattias.data.StudentDaoList;
import java.time.LocalDate;
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

        while(true){
            System.out.println("Press 1 to create new Course or Student. " +
                    "Press 2 to register and remove Student to/from Courses. "+
                    "\nPress 3 to find Student or Courses. "+
                    "Press 4 to edit Student and Courses. "+
                    "\nPress Q to exit.");
            String input = sc.nextLine();
            switch(input) {
                case "1":
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
                    break;
                case "2":
                    System.out.println("Do you want to register or remove Students to/from a Course? Press 1 to register and 2 to remove.");
                    String choice2 =  sc.nextLine();
                    if (choice2.equalsIgnoreCase("1")){
                        System.out.println("Choose a Student. Write the E-mail of the Student to register. ");
                        for (int i =1; i<5; i++){ System.out.println(StudentList.findById(i)); }
                        Student temp = StudentList.findByEmail(sc.nextLine());
                        System.out.println("Choose a Course. Write the ID of the Course. ");
                        for (int i =1; i<5; i++){ System.out.println(CourseList.findById(i)); }
                        CourseList.findById(sc.nextInt()).register(temp);
                    } else if (choice2.equalsIgnoreCase("2")){
                        System.out.println("Choose a Student. Write the E-mail of the Student to register. ");
                        for (int i =1; i<5; i++){ System.out.println(StudentList.findById(i)); }
                        Student temp = StudentList.findByEmail(sc.nextLine());
                        System.out.println("Choose a Course. Write the ID of the Course. ");
                        for (int i =1; i<5; i++){ System.out.println(CourseList.findById(i)); }
                        CourseList.findById(sc.nextInt()).unregister(temp);
                    }
                    break;
                case "3":
                    System.out.println("Find student or course? S for Student and C for Course.");
                    String choice3 = sc.nextLine();
                    if (choice3.equalsIgnoreCase("S")){
                        System.out.println("Finding Student. Write the name of the Student.");
                        String Studentnamn = sc.nextLine();
                        System.out.println(StudentList.findByName(Studentnamn));
                    } else if (choice3.equalsIgnoreCase("C")){
                        System.out.println("Finding Course. Write the name of the Course.");
                        String kursnamn = sc.nextLine();
                        System.out.println(CourseList.findByName(kursnamn));
                    }
                    break;

                case "4":
                    System.out.println("Do you want to edit a Student or a Course? S for Student and C for Course.");
                    String choice4 = sc.nextLine();
                    if (choice4.equalsIgnoreCase("S")){
                        System.out.println("What Student would you like to edit? Write the E-mail of the Student.");
                        for (int i =1; i<5; i++){ System.out.println(StudentList.findById(i)); }
                        Student temp = StudentList.findByEmail(sc.nextLine());
                        System.out.println("Enter new info for Student.");
                        System.out.println("Write a name. ");
                        String names = sc.nextLine();
                        System.out.println("Write an email.");
                        String emails = sc.nextLine();
                        System.out.println("Write an adress");
                        String adresss = sc.nextLine();
                        Student nyStudent = new Student(names, emails, adresss);
                        StudentList.deleteStudent(temp);
                        StudentList.saveStudent(nyStudent);
                        System.out.println("You created: "+nyStudent.toString());
                    } else if (choice4.equalsIgnoreCase("C")){
                        System.out.println("What Course would you like to edit? Write the ID of the Course.");
                        for (int i =1; i<5; i++){ System.out.println(CourseList.findById(i)); }
                        Course temp = CourseList.findById(sc.nextInt());
                        System.out.println("Enter new info for Course.");
                        System.out.println(" Write a name.");
                        sc.nextLine();
                        String namec = sc.nextLine();
                        System.out.println("Write the starting date.");
                        String timec = sc.nextLine();
                        LocalDate tidc = LocalDate.parse(timec);
                        System.out.println("Write the length of the course.");
                        String lengthc = sc.nextLine();
                        int längdc = Integer.parseInt(lengthc);
                        Course nyCourse = new Course(namec, tidc, längdc);
                        CourseList.removeCourse(temp);
                        CourseList.removeCourse(nyCourse);
                    }
                    break;
            }
            if (input.equalsIgnoreCase("q")){
                break;
            }
        }
    }
}
