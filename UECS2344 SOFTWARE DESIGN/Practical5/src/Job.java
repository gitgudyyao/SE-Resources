import java.util.ArrayList;
import java.util.List;

public class Job {
	private String description;
	
	private List<Employee> employeesAssigned;
	
	public Job(String description) {
	this.description = description;
	employeesAssigned = new ArrayList<Employee>();
	}
	
	public String getDescription() {
	return description;
	}
	
	public List<Employee> getEmployeesAssigned(){
		return employeesAssigned;
	}
	
	public void assignEmployee(Employee employee){
		int size = employeesAssigned.size();
		boolean isAssigned = false;
		int i = 0;
		Employee aEmployee;
		while (i<size && !isAssigned){
			aEmployee =employeesAssigned.get(i);
			if(aEmployee.getName().equals(employee.getName()))
				isAssigned = true;
			else
				i++;
		}
		if(!isAssigned){
			employeesAssigned.add(employee);
			employee.assignJob(this);
		}
	}
}
