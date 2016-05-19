import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Student {
	static int IDcounter=0;
	
	private String name;
	private Date birthdate;
	private int ID;
	private float averageGrade;
	private int numberOfGrades;
	

	// Constructor
	public Student(){
		IDcounter++;
		this.ID = IDcounter;
	}
	
	// getter and setter
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
	
	public int getNumberOfExams(){
		return numberOfGrades;
	}
	
	public void setNumberOfExams(int numberOfGrades){
		this.numberOfGrades = numberOfGrades;
	}
	
	public float getAverageGrade(){
		return averageGrade;
	}
	
	public void setAverageGrade(float averageGrade){
		this.averageGrade = averageGrade;
	}
	
	@Override
	public String toString(){
		SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");
		
		return String.format(
				"Student-ID: %d\n"
				+ "Name: %s\n"
				+ "Geburtsdatum: %s\n"
				+ "Prüfungsanzahl: %d \n"
				+ "Notendurchschnitt: %f\n\n", 
				getID(),getName(),
				dateformat.format(getBirthdate()),
				getNumberOfExams(), getAverageGrade());
		
		
		
	}
}
