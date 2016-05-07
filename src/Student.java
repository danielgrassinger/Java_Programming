import java.util.Date;

public class Student {
	private String name;
	private Date birthdate;
	private int ID;
	private int numberOfExams;
	private float grades;

	// Constructor
	public Student(int ID){
		this.ID=ID;
	}
	

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Date getBirthdate(){
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate){
		this.birthdate = birthdate;
	}
	
	public int getID(){
		return ID;
	}
	
	//Disabled so ID cannot be changed
//	public void setID(int ID){
//		this.ID = ID;
//	}
	
	public int getNumberOfExames(){
		return numberOfExams;
	}
	
	public void setNumberOfExames(int numberOfExames){
		this.numberOfExams = numberOfExames;
	}

	public float getGrades(){
		return grades;
	}
	
	public void setGrades(float grades){
		this.grades = grades;
	}
}
