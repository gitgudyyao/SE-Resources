<?php
//Task 1 Q2
/*
2.Based on the simple web app in Question 1, write a PHP script that inserts the record of a user into the text file. The input shall be obtained via an HTML Form.
*/
if ($_SERVER["REQUEST_METHOD"] == "POST") {
	
	// declare variables and initialize to empty values
	$username = $email = $gender = "";
	
	//copy value to local variable from the form input
	$username = $_POST['username'];
	$email = $_POST['email'];
	$gender = $_POST['gender'];
	
	//Store into the file
	//open the file in append mode 'a' or 'a+'
	$fp = fopen('contacts.txt', 'a');//opens file in append mode 
	
	//Concatenate the content of the new input data to the end of the file
	fwrite($fp, "\n".$username." ".$email." ".$gender);  
	
	fclose($fp);  //close the file
  
echo "File appended successfully";

// Output the latest file content again
$fp = fopen("contacts.txt", "r") or die("Unable to open file!");

//Print the HTML table according to data retrieved from file
echo "<table style='border: 1px'>";
echo "<tr><th>Username</th><th>Email</th><th>Gender</th></tr>"; //print table headings
// Output one line until end-of-file
while(!feof($fp)) {
  echo "<tr>";  //print a row of the table from each row of the file data
  $data = explode(' ', fgets($fp)); //split each line into individual parts delimited by space to form an array
  foreach($data as $d) //loop through the array and extract each individual parts
  {
	echo "<td>".$d."</td>"; //print individual table cell (column)
  }
  echo "</tr>";
}
echo "</table>";

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




