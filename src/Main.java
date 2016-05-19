import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Student> students = new ArrayList<Student>();
	
	public static void main(String[] args) {
		String mainmenu = "---------- Hauptmen\u00fc: Was m\u00f6chten Sie tun? ----------------\n"
						+ "1: Studenten zur Liste hinzuf\u00fcgen -------------------------\n"
						+ "2: Studenten aus der Liste entfernen ----------------------\n"
						+ "3: Studenten ausw\u00e4heln und bearbeiten ---------------------\n"
						+ "4: Studenten ausgeben -------------------------------------\n"
						+ "5: Abbruch ------------------------------------------------\n";
		
		Scanner input = new Scanner(System.in);
				
		while(true){
			try{
				System.out.println(mainmenu);
				int option = input.nextInt();
				
				switch(option){
					case 1:{addStudent(); break;}
					case 2:{removeStudent();break;}
					case 3:{updateStudent();break;}
					case 4:{printStudents();break;}
					case 5:{System.exit(0);break;}
					default: {break;}
				}
			} catch(java.util.InputMismatchException exception){
				System.err.println("Bitte geben Sie eine g\u00fcltige Zahl ein!\n");
				System.err.flush();
			}
		}
	}
	
	//Option 1 insert student
	public static void addStudent(){
		Scanner input = new Scanner(System.in);
		
		//New student
		Student student = new Student();
		
		//Name
		while(true){
			try{
				System.out.println("Bitte geben Sie den Namen des Studenten ein.");
				String name = input.nextLine();
				student.setName(name);
				break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}
		}
		
		//Birthdate
		while(true){
			try{
		
				System.out.println("Bitte geben Sie das Geburtsdatum ein.");
				String dateFormat = "dd.MM.yyyy";
				Date date = null;
				
				date = new SimpleDateFormat(dateFormat).parse(input.nextLine());
				
				student.setBirthdate(date);
				break;
				
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}catch(ParseException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}
		}
		
		//Number of exams
		while(true){
			try{
		
				System.out.println("Bitte geben Sie die Anzahl der Pr\u00fcfungen ein.");
				int numberOfExames = Integer.parseInt(input.nextLine());
				student.setNumberOfExams(numberOfExames);
				break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}catch(NumberFormatException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}
		}
		//Grades
		while(true){
			try{
		
				System.out.println("Bitte geben Sie den Notendurchschnitt ein.");
				float grades = Float.parseFloat(input.nextLine());
				student.setAverageGrade(grades);
				break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}catch(NumberFormatException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}
		}
		
		students.add(student);
		//input.close();
		
	}
	
	//Option 2
	public static void removeStudent(){
		Scanner input = new Scanner(System.in);
		int ID = 0;
		
		//Student-ID
		while(true){
			try{
				System.out.println("Bitte geben Sie die Studenten-ID des Studenten ein, den Sie l\u00f6schen m\u00f6chten.");
				ID = Integer.parseInt(input.nextLine());
				break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}catch(NumberFormatException exception){
				System.err.println("Eingabe ung\u00fcltig!");
				System.err.flush();
			}
		}
		
		Student rStudent = null;
		for(Student student: students){
			if(student.getID()==ID){
				rStudent = student;
			}
		}
		if(rStudent!=null){
		students.remove(rStudent);
		}else{
			System.err.println("Es wurde kein Student mit dieser Matrikelnummer gefunden!");
		}
		//input.close();
	}
	
	// Option 3
	public static void updateStudent(){
		Scanner input = new Scanner(System.in);
		int ID = 0;
		
		//Student-ID
		while(true){
			try{
				System.out.println("Bitte geben Sie die Studenten-ID des Studenten ein, den Sie \u00e4ndern m\u00f6chten.");
				ID = Integer.parseInt(input.nextLine());
				break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}catch(NumberFormatException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}
		}
		Student changedStudent = null;
		int index = -1;
		
		for(Student student: students){
			if(student.getID()==ID){
				changedStudent = student;
				index=students.indexOf(student);
				break;				
			}
		}
		
		

		//Name
		while(true){
			try{
				System.out.println("Bitte geben Sie den Namen des Studenten ein.");
				String name = input.nextLine();
				if(!name.equals(""))
				changedStudent.setName(name);
				break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}
		}
		
		//Birthdate
		while(true){
			try{
				System.out.println("Bitte geben Sie das Geburtsdatum ein.");
				String dateFormat = "dd.MM.yyyy";
				Date date = null;
				String rawdate = input.nextLine();
				if(!rawdate.equals("")){
					date = new SimpleDateFormat(dateFormat).parse(rawdate);
					changedStudent.setBirthdate(date);
					break;
				}else break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}catch(ParseException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}
		}
		
		//Number of exams
		while(true){
			try{
				System.out.println("Bitte geben Sie die Anzahl der Pr\u00fcfungen ein.");
				String rawNumberOfExames = input.nextLine();
				if(!rawNumberOfExames.equals("")){
					int numberOfExames = Integer.parseInt(rawNumberOfExames);
					changedStudent.setNumberOfExams(numberOfExames);
					break;
				}else break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}catch(NumberFormatException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}
		}
		
		//Grades
		while(true){
			try{
				System.out.println("Bitte geben Sie den Notendurchschnitt ein.");
				String rawGrades = input.nextLine();
				if(!rawGrades.equals("")){
					float grades = Float.parseFloat(rawGrades);
					changedStudent.setAverageGrade(grades);
					break;
				}else break;
			}catch(java.util.InputMismatchException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}catch(NumberFormatException exception){
				System.err.println("Eingabe ung\u00fcltig!");
			}
		}
		
		
		students.set(index,changedStudent);
		//input.close();
		
	}
	
	//Option 4
	public static void printStudents(){
		
		
		//Print every student
		for(Student student : students){
			System.out.print(student.toString());
		}
	}
	

}
