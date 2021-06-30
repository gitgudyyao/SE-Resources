
public class CountString {
	// Method functionality:
	// Given a String words containing a sequence of smaller strings, 
	// count the number of occurrences of the String strFind in words
			
	public int countWordInString(String words, String strFind) {
				
		int posStrToFind = words.indexOf(strFind);
		int wordCount = 0;
		while (posStrToFind != -1) {
			wordCount++;
			posStrToFind = words.indexOf(strFind, posStrToFind+1);		
		}
		return wordCount;
	}
}
