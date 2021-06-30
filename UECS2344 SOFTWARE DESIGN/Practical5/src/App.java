import java.util.List;

public class App {
	public static void main(String [] args) {
		Employee sarah = new Employee("Sarah");
		
		Job job1 = new Job("Design");
		
		sarah.assignJob(job1);
		
		job1.assignEmployee(sarah);
		
		System.out.println("---Sarah’s Jobs");
		
		List<Job> sarahJobs = sarah.getJobsAssigned();
		
		for (Job job : sarahJobs)
		System.out.println(job.getDescription());
		
		System.out.println("---Job1 Employees");
		
		List<Employee> job1Emps = job1.getEmployeesAssigned();
		
		for (Employee emp : job1Emps)
		System.out.println(emp.getName());
		}
}
