package q6.app;

public abstract class Lecturer {
	protected String name;
	protected int id;
	
	public Lecturer (String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return getName( ) + " " + getId( );
	}
	
	public abstract double salary();
}

class PartTimeLecturer extends Lecturer {
	private double teachingHour;
	
	public PartTimeLecturer() {
		super("", 0);
	}
	
	public PartTimeLecturer(int id) {
		super("", id);
	}
	
	public PartTimeLecturer(String name, int id, double teachingHour) {
		super(name, id);
		//this.teachingHour = teachingHour;
		setTeachingHour(teachingHour);
	}
	
	public void setTeachingHour(double teachingHour) {
		this.teachingHour = teachingHour;
	}
	
	public double getTeachingHour() {
		return teachingHour;
	}
	
	public String toString() {
		return "Name: " + name + "\nID: " + id + "\nTeaching Hours: " + getTeachingHour() + "\n";//teachingHour + "\n";
	}
	
	public double salary() {
		return teachingHour * 100.0;
	}
}