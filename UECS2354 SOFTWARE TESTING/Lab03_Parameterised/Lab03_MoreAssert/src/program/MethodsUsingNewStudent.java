package program;
import java.util.ArrayList;

public class MethodsUsingNewStudent {
	// Given an array of Student objects, stuArray, this method 
	// locates the first Student object whose name variable 
	// starts with the string startStr and returns this object.
	// If no such Student object is found, the value null is returned.
	
	public NewStudent findStudentWithName(NewStudent[] stuArray, String startStr) {
		
		NewStudent stud = null;
		
		for (int i = 0; i < stuArray.length; i++) {
			if (stuArray[i].getName().startsWith(startStr)) {
				stud = stuArray[i];
				break;
			}
		}
		return stud;
	}
		
	// Given an array of Student objects, stuArray, this method 
	// locates all objects from this array whose age variable is 
	// more than the parameter ageLimit, and returns 
	// these objects in a second array.
	
	public NewStudent[] findOverAgedStudents(NewStudent[] stuArray, int ageLimit) {
		
		ArrayList<NewStudent> returnList = new ArrayList<NewStudent>();
		
		for (int i = 0; i < stuArray.length; i++) {
			if (stuArray[i].getAge() > ageLimit)
				returnList.add(stuArray[i]);
		}
			
		NewStudent[] arrReturn = new NewStudent[returnList.size()];
		arrReturn = returnList.toArray(arrReturn);
		return arrReturn;
	}	
}
