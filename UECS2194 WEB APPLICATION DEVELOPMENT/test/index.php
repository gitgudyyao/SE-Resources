<?php 
  //creating connection to database
$con=mysqli_connect("test","root","","wad_ptest") or die(mysqli_error());

  //check whether submit button is pressed or not
if((isset($_POST['submit'])))
{
  //fetching and storing the form data in variables
$StaffNo = $con->real_escape_string($_POST['staffNo']);
$Name = $con->real_escape_string($_POST['name']);
$Phone = $con->real_escape_string($_POST['email']);
$comments = $con->real_escape_string($_POST['phone']);

  //query to insert the variable data into the database
$sql="INSERT INTO pp_rrrrrrr_staff (staffNo, name, email, phone) VALUES ('".$staffNo."','".$Name."', '".$Email."', '".$Phone."')";

  //Execute the query and returning a message
if(!$result = $con->query($sql)){
die('Error occured [' . $conn->error . ']');
}
else
   echo "Thank you! REEEEEEEEEEEEEEEEEEEE";
}

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
	// define variables and set to empty values
	$Name = $Email = $StaffNo = $Phone = "";
	$StaffNo  = "";
	
	if(is_empty(test_input($_POST['name'])))
	{
		$Name = "Name is empty";
	}
	else
	{
		$Name = test_input($_POST['name']);
	}
	if(is_empty(test_input($_POST['email'])))
	{
		$Email = "Email is empty";
	}
	else
	{
		$Email = test_input($_POST['email']);
	}
		
	if(isset($_POST['staffNo']))
	{		
		$StaffNo = test_input($_POST['staffNo']);
	}
	else
	{
		$StaffNo = "StaffNo is empty";
	}

		if(isset($_POST['phone']))
	{		
		$Phone = test_input($_POST['phone']);
	}
	else
	{
		$Phone = "Phone is empty";
	}

	
	echo "<h2>Your Input:</h2>";
echo $StaffNo;
echo "<br>";
echo $Name;
echo "<br>";
echo $Email;
echo "<br>";
echo $Phone;

}
else { //by default: GET
	/*
	REQUEST_METHOD is GET, display the form.
	*/
	include("_form.php");
}
?>