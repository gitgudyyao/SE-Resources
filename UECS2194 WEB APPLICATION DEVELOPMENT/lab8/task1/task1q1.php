 <?php
 //Task 1 Q1
 /*
 1.Suppose that we need a simple web app that stores username, email address and gender of each user in a plain text file with the data for each user stored line by line while the attributes are tab-separated. Write a PHP script that reads the file and display a list of username, email address and gender in an HTML Table.
 */
 //read data from file
$fp = fopen("contacts.txt", "r") or die("Unable to open file!");

//Print the HTML table
echo "<table style='border: 1px'>";
echo "<tr><th>Username</th><th>Email</th><th>Gender</th></tr>"; //print table headings
// Output one line until end-of-file
while(!feof($fp)) {
  echo "<tr>";  //print a row of the table from each row of the file data
  $data = explode(' ', fgets($fp)); //split each line into individual parts delimited by space to form an array
  foreach($data as $d) //loop through the array and extract each individual parts
  {
	echo "<td>".$d."</td>";  //print individual table cell (column)
  }
  echo "</tr>";
}
echo "</table>";
fclose($fp); //close the file
?> 