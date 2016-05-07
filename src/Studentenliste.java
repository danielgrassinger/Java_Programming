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
			case 2:{break;}
			case 3:{System.out.println("Hallo\n");break;}
			case 4:{printStudents();break;}
			case 5:{System.exit(0);break;}
			default: {break;}
			}
			
		}
	}
	
	//Option 1
	public static void addStudent(){
		Scanner input = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie dei Studenten-ID ein.");
		int ID = input.nextInt();
		Student student = new Student(ID);
		
		System.out.println("Bitte geben Sie den Namen des Studenten ein.");
		String name = input.nextLine();
		student.setName(name);
		
		System.out.println("Bitte geben Sie das Geburtsdatum ein.");
		String dateFormat = "dd.MM.yyyy";
		Date date = null;
		try {
			 date = new SimpleDateFormat(dateFormat).parse(input.nextLine());
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		student.setBirthdate(date);
		
		System.out.println("Bitte geben Sie die Anzahl der Prüfungen ein.");
		int numberOfExames = input.nextInt();
		student.setNumberOfExames(numberOfExames);
		
		System.out.println("Bitte geben Sie den Notendurchschnitt ein.");
		float grades = input.nextFloat();
		student.setGrades(grades);
		
		students.add(student);
		
	}
	
	//TODO Option 2
	
	//TODO Option 3
	
	//Option 4
	public static void printStudents(){
		for(Student student : students){
			System.out.printf("Student-ID: %d\n"
							 +"Name: %s\n", student.getID(),student.getName());
		}
	}
	

}
