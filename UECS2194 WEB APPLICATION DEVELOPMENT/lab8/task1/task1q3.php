<?php
//Task 1 Q3
/*
3.Rewrite the PHP scripts in Question 1 and Question 2 where the text file format is now using Comma-Separated Values (CSV).
*/

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	
	// declare variables and initialize to empty values
	$username = $email = $gender = "";
	
	//copy value to local variable from the form input
	$username = $_POST['username'];
	$email = $_POST['email'];
	$gender = $_POST['gender'];
	
	// To Write CSV File
	//open the csv file "contacts.csv"
	$fp = fopen("contacts.csv","a");
	
	$data = array($username, $email, $gender);	
	fputcsv($fp,$data);	//save data into csv file
	
	fclose($fp);  //close the file
  
echo "File appended successfully<br>"; //print message if successful

$fp = fopen("contacts.csv", "r"); //open the csv file "contacts.csv"

$printedtext = ""; //Initialize the string that is to be printed as output

// Output one line until end-of-file
while(!feof($fp))
{
	while ( ($data = fgetcsv($fp, 1024, " ") ) !== FALSE ) { //convert each line of the csv data as an array of data delimited by space " "	
		foreach($data as $d)
		{
			$printedtext .= $d;	
		}
		$printedtext .= "<br>"; //print a new line so that next lines of csv data will be printed on a new line
	}		
}
echo $printedtext;  //print out the whole data on the web page

fclose($fp); //close the file
	
}
else {
/*
The input shall be obtained via an HTML Form.
REQUEST_METHOD is GET, display the form.
*/
	include("include/_form.php"); //include the form HTML interface
}

?>




