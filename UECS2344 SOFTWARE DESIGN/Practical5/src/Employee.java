import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private String name;
	
	private List<Job> jobsAssigned;
	
	public Employee(String name) {
	this.name = name;
	jobsAssigned = new ArrayList<Job>();
	}
	
	public String getName() {
	return name;
	}
	
	public List<Job> getJobsAssigned(){
		return jobsAssigned;
	}
	
	public void assignJob(Job job){
		int size = jobsAssigned.size();
		boolean isAssigned = false;
		int i = 0;
		Job aJob;
		while (i<size && !isAssigned){
			aJob =jobsAssigned.get(i);
			if(aJob.getDescription().equals(job.getDescription()))
				isAssigned = true;
			else
				i++;
		}
		if(!isAssigned){
			jobsAssigned.add(job);
			job.assignEmployee(this);
		}
	}
}
