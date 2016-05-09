import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Studentenliste {
	
	static ArrayList<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) {
		String mainmenu = "---------- Hauptmenü: Was möchten Sie tun? ----------------\n"
				+ "1: Studenten zur Liste hinzufügen -------------------------\n"
				+ "2:Studenten aus der Liste entfernen -----------------------\n"
				+ "3: Studenten auswäheln und bearbeiten ---------------------\n"
				+ "4: Studenten ausgeben -------------------------------------\n"
				+ "5: Abbruch ------------------------------------------------\n";
		
		Scanner input = new Scanner(System.in);
		
		Student student = new Student(1234);
		
		while(true){
			System.out.println(mainmenu);
			switch(input.nextInt()){
			case 1:{addStudent(); break;}
			case 2:{removeStudent();break;}
			case 3:{updateStudent();break;}
			case 4:{printStudents();break;}
			case 5:{System.exit(0);break;}
			default: {break;}
			}
			
		}
	}
	
	//Option 1 insert student
	public static void addStudent(){
		Scanner input = new Scanner(System.in);
		
		//Student-ID
		System.out.println("Bitte geben Sie die Studenten-ID ein.");
		int ID = Integer.parseInt(input.nextLine());
		Student student = new Student(ID);
		
		//Name
		System.out.println("Bitte geben Sie den Namen des Studenten ein.");
		String name = input.nextLine();
		student.setName(name);
		
		//Birthdate
		System.out.println("Bitte geben Sie das Geburtsdatum ein.");
		String dateFormat = "dd.MM.yyyy";
		Date date = null;
		try {
			 date = new SimpleDateFormat(dateFormat).parse(input.nextLine());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		student.setBirthdate(date);
		
		//Number of exams
		System.out.println("Bitte geben Sie die Anzahl der Prüfungen ein.");
		int numberOfExames = Integer.parseInt(input.nextLine());
		student.setNumberOfExames(numberOfExames);
		
		//Grades
		System.out.println("Bitte geben Sie den Notendurchschnitt ein.");
		float grades = Float.parseFloat(input.nextLine());
		student.setGrades(grades);
		
		students.add(student);
		
	}
	
	//Option 2
	public static void removeStudent(){
		Scanner input = new Scanner(System.in);
		
		//Student-ID
		System.out.println("Bitte geben Sie die Studenten-ID des Studenten ein, den Sie löschen möchten.");
		int ID = Integer.parseInt(input.nextLine());
		
		Student rStudent = null;
		for(Student student: students){
			if(student.getID()==ID){
				rStudent = student;
			}
		}
		students.remove(rStudent);
		
	}
	
	// Option 3
	public static void updateStudent(){
		Scanner input = new Scanner(System.in);
		
		//Student-ID
		System.out.println("Bitte geben Sie die Studenten-ID des Studenten ein, den Sie ändern möchten.");
		int ID = Integer.parseInt(input.nextLine());
		
		Student changedStudent = null;
		
		for(Student student: students){
			if(student.getID()==ID){
				changedStudent = student;
			}
		}
		students.remove(changedStudent);

		//Name
		System.out.println("Bitte geben Sie den Namen des Studenten ein.");
		String name = input.nextLine();
		if(!name.equals(""))
		changedStudent.setName(name);
		
		//Birthdate
		System.out.println("Bitte geben Sie das Geburtsdatum ein.");
		String dateFormat = "dd.MM.yyyy";
		Date date = null;
		String rawdate = input.nextLine();
		if(!rawdate.equals("")){
			try {
				
				 date = new SimpleDateFormat(dateFormat).parse(rawdate);
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			changedStudent.setBirthdate(date);
		}
		
		//Number of exams
		System.out.println("Bitte geben Sie die Anzahl der Prüfungen ein.");
		String rawNumberOfExames = input.nextLine();
		if(!rawNumberOfExames.equals("")){
			int numberOfExames = Integer.parseInt(rawNumberOfExames);
			changedStudent.setNumberOfExames(numberOfExames);
		}
		
		//Grades
		System.out.println("Bitte geben Sie den Notendurchschnitt ein.");
		String rawGrades = input.nextLine();
		if(!rawGrades.equals("")){
			float grades = Float.parseFloat(rawGrades);
			changedStudent.setGrades(grades);
		}
		
		students.add(changedStudent);
	}
	
	//Option 4
	public static void printStudents(){
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.mm.yyyy");
		
		//Print every student
		for(Student student : students){
			System.out.printf("Student-ID: %d\n"
							+ "Name: %s\n"
							+ "Geburtsdatum: %s\n"
							+ "Prüfungsanzahl: %d \n"
							+ "Notendurchschnitt: %f\n\n", 
							student.getID(),student.getName(),
							dateformat.format(student.getBirthdate()),
							student.getNumberOfExames(), student.getGrades());
		}
	}
	

}
